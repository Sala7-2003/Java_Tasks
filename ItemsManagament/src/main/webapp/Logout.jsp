<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Logout</title>
        <link rel="stylesheet" href="css/logout.css">
    
</head>
<body>
    <div class="container">
        <div class="message-box">
            <h2><%= request.getAttribute("logoutMsg") %></h2>
        </div>
        <a href="index.html">Go to Home Page</a>
    </div>
</body>
</html>
