package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import javax.sql.DataSource;

import model.Item;
import service.ServiceImplementation;


@WebServlet("/ItemController")
public class ItemController extends HttpServlet {
	

	@Resource(name = "jdbc/mydb" )
	private DataSource ds ; 

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");

	    
	    String uAction = request.getParameter("action");
	    if (uAction == null) 
	    	showAllItems ( request , response);

	    
	    switch(uAction) {
	    case "add":
	    	addItems(request , response);
	    	break;
	    case "updateTable":
	    	updateItems( request , response);
	    	break;
	    case "remove" :
	    	removeItem(request , response);
	    	break;
	    case "showItem":
	    	showItem(request , response);
	    	break;
	    case "showItems":
	    	showAllItems ( request , response);
	    	break;
	    	default :
//	    		showAllItems ( request , response);
	    		  request.getRequestDispatcher("error.jsp").include(request, response);
	    }
		

	    try {
			Connection connection = ds.getConnection();
			Statement statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    
	}


	private void showItem(HttpServletRequest request, HttpServletResponse response) {
		try {
			ServiceImplementation sItem = new ServiceImplementation(ds);
			Item item = sItem.getItemById(Long.parseLong(request.getParameter("id")));
			request.setAttribute("selectedItem", item);
			request.getRequestDispatcher("update-item.jsp").forward(request, response);
		} catch (Exception e) {
		}	

		
	}


	private void showAllItems(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ServiceImplementation sItem = new ServiceImplementation(ds);

		
		 List<Item> items = sItem.showAllItems();
		 request.setAttribute("items", items);
		 request.getRequestDispatcher("showItems.jsp").forward(request, response);
		
	}


	private void removeItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceImplementation sItem = new ServiceImplementation(ds);
		
		long id = Long.parseLong(request.getParameter("id"));
		
		if(sItem.removeItem(id)==true)
			showAllItems(request, response);
		else {
			request.setAttribute("err-msg", "This Item Couldn't be Deleted");
            request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
	}


	private void updateItems(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceImplementation sItem = new ServiceImplementation(ds);
		
		Long id = Long.parseLong(request.getParameter("id"));
		String details = request.getParameter("details");
		int price = Integer.parseInt(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String name = request.getParameter("name");
		
		
		Item item = new Item();
		item.setDetail(details);
		item.setPrice(price);
		item.setQuantity(quantity);
		item.setName(name);
		item.setId(id);
		
		HttpSession session = request.getSession();
		if(session.getAttribute("isLoggedIn")==(Object) true) {
			sItem.updateItem(item);
	    		showAllItems(request, response);
			}else {

				request.setAttribute("err-msg", "Can not Update the data of this Item as you are logged out");
			    request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		
	}


	private void addItems(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceImplementation sItem = new ServiceImplementation(ds);

		
		String details = request.getParameter("details");
		int price = Integer.parseInt(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String name = request.getParameter("name");
		
		Item item = new Item();
		item.setDetail(details);
		item.setPrice(price);
		item.setQuantity(quantity);
		item.setName(name);
		HttpSession session = request.getSession();
		
		// check you are logged in for adding items accessability
    	if(session.getAttribute("isLoggedIn")==(Object) true) {
		   sItem.addItem(item);
    		showAllItems(request, response);
		}else {

			request.setAttribute("err-msg", "Can not add Items as you are logged out");
		    request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}


}
