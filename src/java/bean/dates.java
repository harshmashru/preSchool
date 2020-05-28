package bean;
import hibernateconfig.HibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import pojo.holidaydates;
public class dates extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Session s = HibernateUtil.openSession();
        try {
            /* TODO output your page here. You may use following sample code. */
            s.beginTransaction();
            String hq = "from holidaydates";
            Query q = s.createQuery(hq);
            List l = q.list();
            Iterator it = l.iterator();
            holidaydates hol = null;
            while(it.hasNext()){
                hol = (holidaydates)it.next();
            }
            request.setAttribute("date", hol);
            //out.println("Done");
            RequestDispatcher rd = request.getRequestDispatcher("a_timetable.jsp");
            rd.forward(request, response);
        }
        catch(Exception e){
            out.println(e);
        }
    }
}
