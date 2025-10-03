package service;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/Register")
public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Inject your JDBC DataSource (must match your context.xml / web.xml config)
    @Resource(name = "jdbc/mydb")
    private DataSource ds;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
        PrintWriter out = response.getWriter();

        // Get form parameters
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        if (userName == null || password == null || userName.isEmpty() || password.isEmpty()) {
            out.println("Error: Username or password is empty!");
            return;
        }

        try (Connection connection = ds.getConnection()) {
            // Insert user into database
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, password);

            int rows = ps.executeUpdate();

            if(rows > 0) {
            	System.out.println("Yess" + rows);
            	request.getRequestDispatcher("/ItemController?action=showItems").forward(request, response);
            }else {
            	request.setAttribute("err-msg", "Failed To Register Your Data !");
            	request.getRequestDispatcher("error.jsp").forward(request, response);
            }


        } catch (Exception e) {

        }
    }
}
