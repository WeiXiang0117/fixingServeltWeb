import sun.misc.CharacterEncoder;
import sun.misc.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AskIp")
public class AskIp extends HttpServlet {
    private String askip;

    @Override
    public void init() throws ServletException{
        askip = "user's ip = ";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        String addr = req.getLocalAddr();
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.printf("<h1>" + askip + addr + "</h1>");
    }

    public void destroy() {
        super.destroy();
    }
}
