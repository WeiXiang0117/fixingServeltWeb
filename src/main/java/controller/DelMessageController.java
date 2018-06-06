package main.java.controller;

import main.java.model.UserService;

import java.io.IOException;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
    urlPatterns={"/del_message"}, 
    initParams={
        @WebInitParam(name = "MEMBER_PATH", value = "member")
    }
)
public class DelMessageController extends HttpServlet {
    protected void doPost(
            HttpServletRequest request, HttpServletResponse response) throws IOException {

        String millis = request.getParameter("millis");
        
        if(millis != null) {
            UserService userService = new UserService(getUsername(request));
            userService.deleteMessage(getUsername(request), millis);
        }
        
        response.sendRedirect(getInitParameter("MEMBER_PATH"));
    }
    
    private String getUsername(HttpServletRequest request) {
        return (String) request.getSession().getAttribute("login");
    }
}
