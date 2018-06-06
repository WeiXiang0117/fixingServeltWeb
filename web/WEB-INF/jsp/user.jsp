<%@page import="java.util.List,main.java.model.Message" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>Gossip 微網誌</title>
<link rel='stylesheet' href='http://localhost:8080/css/member.css' type='text/css'>
</head>
<body>

    <div class='leftPanel'>
        <img src='http://localhost:8080/images/caterpillar.jpg' alt='Gossip 微網誌' /><br>
        <br>${requestScope.username} 的微網誌
    </div>
    <table border='0' cellpadding='2' cellspacing='2'>
        <thead>
            <tr>
                <th><hr></th>
            </tr>
        </thead>
        <tbody>

            <%
                List<Message> messages = (List<Message>) request.getAttribute("messages");
                for (Message message : messages) {
            %>
            
            <tr>
                <td style="vertical-align: top"> <%=message.getUsername()%> <br>
                    <%=message.getBalbal()%><br> <%=message.getLocalDateTime()%>
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