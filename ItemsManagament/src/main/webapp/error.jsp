<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Error</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #667eea, #764ba2);
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .error-container {
            background: white;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 8px 25px rgba(0, 0, 0, 0.2);
            width: 400px;
            text-align: center;
        }

        .error-container h2 {
            color: #e74c3c;
            margin-bottom: 15px;
            font-size: 22px;
        }

        .error-message {
            background: #fdecea;
            color: #c0392b;
            border: 1px solid #f5c6cb;
            padding: 12px;
            border-radius: 6px;
            margin-bottom: 20px;
            font-size: 15px;
        }

        .error-container p {
            color: #333;
            margin-bottom: 20px;
            font-size: 14px;
        }

        .back-btn {
            display: inline-block;
            padding: 10px 20px;
            background: #667eea;
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 14px;
            cursor: pointer;
            text-decoration: none;
        }

        .back-btn:hover {
            background: #556cd6;
        }
    </style>
</head>
<body>
<div class="error-container">
    <h2>Oops! Something went wrong</h2>
    <div class="error-message">
        <%= request.getAttribute("err-msg") %>
    </div>
    <p>Please try again later or go back to the home page.</p>
    <a href="index.html" class="back-btn">Back to Home</a>
</div>
</body>
</html>
