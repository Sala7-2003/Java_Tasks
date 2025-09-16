package task1;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class Task1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String fullname = request.getParameter("fullname");
        String age = request.getParameter("age");

        out.println("<html><body>");
        out.println("<h2>User Details</h2>");
        out.println("Full Name: " + fullname + "<br>");
        out.println("Age: " + age + "<br>");
        out.println("</body></html>");
    }
}
