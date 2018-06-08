<%@page import="main.java.controller.ItemController"%>
<%@ page import="java.util.List" %>
<%@ page import="main.java.model.Iteminfo" %>
<%@ page import="main.java.dao.ItemDao" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>物品列表</title>
</head>
<body>
    <h1>物品列表</h1>
    <h2>
        <a href="/new">Add New Item</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/list">List All Item</a>

    </h2>
<div align="center">
    <table border="1" cellpadding="5">
        <%
            ItemDao itemDao = new ItemDao();
            List<Iteminfo> iteminfo = itemDao.findAll();
        %>
        <tr style="color: #3333cc">
            <th><%
                for (Iteminfo i : iteminfo){
            %>
            <td><%= i %></td>
            <%
                }
            %>
            </th> </tr>
    </table>
</div>
</body>
</html>