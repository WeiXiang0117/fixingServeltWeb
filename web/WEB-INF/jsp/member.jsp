<%@page import="java.util.*,java.time.*" contentType="text/html;charset=UTF-8"%>
<%@ page import="model.Message" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>微網誌</title>
    <link rel="stylesheet" href="css/member.css" type="text/css">
</head>
<body>
<div class="leftPanel">
    <img src="images/caterpillar.jpg" alt="Gossip 微網誌"><br>
    <br> <a href="logout">登出 ${sessionScope.login}</a>
</div>
<form method="post" action="new_message">
    分享新鮮事......<br>
    <%
        String preBlaBla = request.getParameter("blabla");
        if (preBlaBla != null) {
    %>
    訊息要 140 字以內<<br>
    <%
        }
    %>
    <textarea cols="60" rows="4" name="blabla">${param.blabla}</textarea>
    <<br>
    <button type="submit">送出</button>
</form>
<table border="0" cellpadding="2">
    <thead>
    <tr>
        <th><hr></th>
    </tr>
    </thead>
    <tbody>


    <%
        List<Message> messages = (List<Message>) request.getAttribute("messages");
        for(Message message : messages) {
    %>

    <tr>
        <td style='vertical-align: top;'><%= message.getUsername() %><br>
            <%= message.getBalbal() %><br> <%= message.getLocalDateTime() %>
            <form method='post' action='del_message'>
                <input type='hidden' name='millis' value='<%= message.getMillis()  %>'>
                <button type='submit'>刪除</button>
            </form>
            <hr>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<hr>
</body>
</html>