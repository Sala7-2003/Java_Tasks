<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%
    HttpSession session1 = request.getSession();
    List<String> orders = (List<String>) session1.getAttribute("orders");
    if (orders == null) {
        orders = new ArrayList<>();
    }
    String food = request.getParameter("food");
    if (food != null && !food.trim().isEmpty()) {
        orders.add(food);
    }
    session1.setAttribute("orders", orders);
%>
<!DOCTYPE html>
<html>
<head>
    <title>All Orders</title>
</head>
<body>
    <h2>All Orders</h2>
    <ul>
        <% for(String item : orders) { %>
            <li><%= item %></li>
        <% } %>
    </ul>
    <a href="order.jsp">Add More</a>
</body>
</html>
