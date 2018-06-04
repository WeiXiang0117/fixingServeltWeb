import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import java.util.stream.IntStream;

@WebServlet("/search")
public class Search extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("</head>");
        out.println("<body>");
        results(out);
        pages(request, out);

        out.println("</body>");
        out.println("</html>");

    }

    private  void results(PrintWriter out){
        out.println("<ul>");
        IntStream.rangeClosed(1, 10)
                .forEach(i -> out.printf("<li>搜尋結果 %d</li>%n", i));
        out.println("</ul>");
    }

    private void pages(HttpServletRequest request, PrintWriter out){
        String page = Optional.ofNullable(request.getParameter("page"))
                .orElse("1");

        int p = Integer.parseInt(page);
        IntStream.rangeClosed(1, 10)
                .forEach(i -> {
                    if (i == p){
                        out.println(i);
                    }
                    else {
                        out.printf("<a href='search?page=%d'>%d</a>%n", i, i);
                    }
                });
    }


}
