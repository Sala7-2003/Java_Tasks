package service;

import model.User;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import javax.websocket.Session;

import controller.ItemController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/UserService")
public class UserService extends HttpServlet {

    @Resource(name = "jdbc/mydb")
    private DataSource ds;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    	resp.setHeader("cache-control", "no-cache , no-store , must-revalidate");
    	PrintWriter out = resp.getWriter();
        String userName = req.getParameter("uName");
        String password = req.getParameter("password");

        try (Connection connection = ds.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE UserName = ? AND Password = ?")) {

            ps.setString(1, userName);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                	HttpSession session = req.getSession();
                	session.setAttribute("isLoggedIn", true);
                	session.setAttribute("userName", userName);
                	
                	req.getRequestDispatcher("/ItemController?action=showItems").forward(req, resp);

                } else {
                	req.setAttribute("err-msg", "The User Credentials are Wrong !");
                    req.getRequestDispatcher("error.jsp").forward(req, resp);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


