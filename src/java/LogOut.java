import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class LogOut extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LogOut</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet LogOut at " + request.getContextPath() + "</h1>");
            //request.getRequestDispatcher("link.html").include(request, response);    
            HttpSession session=request.getSession();  
            session.invalidate();
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.forward(request, response);
            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e){
            out.println(e);
        }
    }

}
