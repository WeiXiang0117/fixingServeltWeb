import sun.awt.SunHints;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet("/hello")
public class Hello extends HttpServlet {
    @Override
    protected void doGet(
            HttpServletRequest req, HttpServletResponse resp)
        throws IOException{
        resp.setContentType("text/html;charset=UTF-8");

        String name =Optional.ofNullable(req.getParameter("name"))
                .map(value -> value.replaceAll("<","&lt;"))
                .map(value -> value.replaceAll(">","&gt;"))
                .orElse("Guest");

        PrintWriter out = resp.getWriter();
        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("<head>");
        out.print("<title>Hello</title>");
        out.print("</head>");
        out.print("<body>");
        out.printf("<h1>Hello! %s!</h1>", name);
        out.print("</body>");
        out.print("</html>");
    }
}
