package main.java.controller;

import main.java.model.UserService;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
    urlPatterns={"/login1"},
    initParams={
        @WebInitParam(name = "SUCCESS_PATH", value = "member"),
        @WebInitParam(name = "ERROR_PATH", value = "/WEB-INF/jsp/index.jsp")
    }
)
public class LoginController extends HttpServlet {

    protected void doPost(
            HttpServletRequest request, HttpServletResponse response)
                            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserService userService = new UserService(username);

        if(userService.login(username, password)) {
            if(request.getSession(false) != null) {
                request.changeSessionId();
            }
            request.getSession().setAttribute("login", username);
            response.sendRedirect(getInitParameter("SUCCESS_PATH"));
        } else {
            request.setAttribute("errors", Arrays.asList("登入失敗"));
            request.getRequestDispatcher(getInitParameter("ERROR_PATH"))
                   .forward(request, response);
        }

    }
}
