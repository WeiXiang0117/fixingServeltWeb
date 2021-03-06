package main.java.controller;

        import main.java.model.Message;
        import main.java.model.UserService;

        import java.io.IOException;
        import java.util.List;

        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebInitParam;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;


@WebServlet(
        urlPatterns={"/user/*"},
        initParams={
                @WebInitParam(name = "USER_PATH", value = "/WEB-INF/jsp/user.jsp")
        }
)
public class UserController extends HttpServlet {
    protected void doGet(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = getUsername(request);
        UserService userService = new UserService(username);

        List<Message> messages = userService.messages(username);

        request.setAttribute("messages", messages);
        request.setAttribute("username", username);

        request.getRequestDispatcher(getInitParameter("USER_PATH"))
                .forward(request, response);
    }

    private String getUsername(HttpServletRequest request) {
        return request.getPathInfo().substring(1);
    }
}
