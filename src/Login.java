import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String passwd = request.getParameter("passwd");

        String page;
        if("caterpillar".equals(name) && "123456".equals(passwd)) {
            processCookie(request, response);
            page = "user";
        }
        else {
            page = "WEB-INF/login.html";
        }
        response.sendRedirect(page);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    private void processCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("user", "caterpillar");
        if("true".equals(request.getParameter("auto"))) {
            cookie.setMaxAge(7 * 24 * 60 * 60);
        }
        response.addCookie(cookie);
    }
}
