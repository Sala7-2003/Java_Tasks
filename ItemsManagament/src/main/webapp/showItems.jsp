<%@page import="java.util.Objects"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ page import = "java.util.List , model.Item" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Items in Inventory</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h2>Items in Inventory</h2>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Details</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
        <%
        // without this line 👇👇 if user logged out then pressed the backward arrow of the browser he would ba able to see items again but
        // this is not acceptable
        response.setHeader("cache-control", "no-cache , no-store , must-revalidate");
        
        // check user is logged in successfully
        
        if(session.getAttribute("isLoggedIn")!=(Object)true || session.getAttribute("isLoggedIn")==null)
        	response.sendRedirect("error.jsp");
        List <Item> Items = (List <Item>) request.getAttribute("items");
        if(Objects.nonNull(Items))
            for(Item item : Items){

        %>
            <tr>
                <td><%= item.getId() %></td>
                <td><%= item.getName() %></td>
                <td><%= item.getPrice() %></td>
                <td><%= item.getQuantity() %></td>
                <td><%= item.getDetail() %></td>
         
                <td>
		         <form action="ItemController" method="post" style="display:inline;">
	       	     <input type="hidden" name="action" value="showItem">
		         <input type="hidden" name="id" value="<%= item.getId() %>">
		         <button type="submit">Update</button>
	     	      </form>

                    <form action="ItemController" method="post" style="display:inline;">
                        <input type="hidden" name="id" value="<%= item.getId() %>">
                        <input type = "hidden" name="action" value ="remove">
                        <button type="submit" class="delete-btn">Delete</button>
                    </form>
                </td>
            </tr>
        <% }
        if(Items.isEmpty()) {
        	out.println("<p class='no-items'>No Items yet !</p>");
        }%>
   
    
        </tbody>
    </table>
    <form action="Logout" method="post" style="display:inline;">
    <button type="submit" class="logout-btn">Logout</button>
</form>
    

    <br>
    <a href="Add.html" class="add-btn">Add Item</a>
</body>
</html>
