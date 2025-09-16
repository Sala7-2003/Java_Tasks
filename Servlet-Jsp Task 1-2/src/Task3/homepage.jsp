<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String favplace = request.getParameter("favplace");
    if (favplace != null) {
        Cookie c = new Cookie("favplace", favplace);
        c.setMaxAge(60*60*24*30); // 1 month
        response.addCookie(c);
    }
    String savedPlace = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("favplace")) {
                savedPlace = cookie.getValue();
                break;
            }
        }
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
    <h2>Welcome to Home Page</h2>
    <p>Your Favorite Place: <%= savedPlace %></p>
</body>
</html>
