<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Item" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Item</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h2 {
            color: #2c3e50;
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 10px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th {
            background: #2c3e50;
            color: white;
            padding: 10px;
            text-align: left;
        }
        td {
            padding: 8px;
        }
        input[type="text"], input[type="number"] {
            width: 95%;
            padding: 5px;
        }
        input[type="submit"] {
            background: #27ae60;
            color: white;
            border: none;
            padding: 6px 12px;
            cursor: pointer;
            border-radius: 4px;
        }
        input[type="submit"]:hover {
            background: #219150;
        }
    </style>
</head>
<body>
    <h2>Update Item</h2>

    <table>
 

        <%
            Item item = (Item) request.getAttribute("selectedItem");
            if (item != null) {
        %>
      <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Price</th>
    <th>Detail</th>
    <th>Quantity</th>
    <th>Action</th> <!-- new column -->
</tr>

<tr>
    <form action="ItemController" method="post">
        <td>
            <%= item.getId() %>
            <input type="hidden" name="id" value="<%= item.getId() %>">
        </td>
        <td><input type="text" name="name" value="<%= item.getName() %>"></td>
        <td><input type="number" name="price" value="<%= item.getPrice() %>" step="0.01"></td>
        <td><input type="text" name="details" value="<%= item.getDetail() %>"></td>
        <td><input type="number" name="quantity" value="<%= item.getQuantity() %>"></td>
        <td>
            <input type="hidden" name="action" value="updateTable">
            <input type="submit" value="Update">
        </td>
    </form>
</tr>

        <%
            } else {
        %>
        <tr>
            <td colspan="6" style="text-align:center;">No item selected for update.</td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
