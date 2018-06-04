import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Collections;
import java.util.stream.Collectors;

@WebServlet("/header")
public class Header extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException{
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();
        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("<head>");
        out.print("<title>Show Headers</title>");
        out.print("</head>");
        out.print("<body>");

        Collections.list(req.getHeaderNames())
                .forEach(name -> {
                    out.printf("%s: %s<br>",
                            name, req.getHeader(name));
                });

        out.print("</body>");
        out.print("</html>");
    }


}
