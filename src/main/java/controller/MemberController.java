package main.java.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import main.java.model.Message;
import main.java.model.UserService;

@WebServlet(
    urlPatterns={"/member"},
    initParams={
        @WebInitParam(name = "MEMBER_PATH", value = "/WEB-INF/jsp/member.jsp")
    }
)
public class MemberController extends HttpServlet implements HttpSessionListener{

    protected void doGet(
            HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(
            HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(
                HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {
//        request.getSession();
//        String username = request.getAttribute("username").toString();
        UserService userService = new UserService(getUsername(request));
        List<Message> messages = userService.messages(getUsername(request));
        request.setAttribute("messages", messages);
        request.getRequestDispatcher(getInitParameter("MEMBER_PATH")).forward(request, response);
    }

    private String getUsername(HttpServletRequest request) {
        return (String) request.getSession().getAttribute("login");
    }
}
