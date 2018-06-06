package main.java.controller;

import java.io.IOException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    urlPatterns={"/logout"},
    initParams={
        @WebInitParam(name = "LOGIN_PATH", value = "/index")
    }
)
public class LogoutController extends HttpServlet {
    protected void doGet(
            HttpServletRequest request, HttpServletResponse response)
                          throws IOException {
        request.getSession().invalidate();
        response.sendRedirect(getInitParameter("LOGIN_PATH"));
    }
}
