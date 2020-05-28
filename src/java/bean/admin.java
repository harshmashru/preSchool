package bean;
import hibernateconfig.HibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;
import pojo.user;
public class admin extends HttpServlet {
        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
//        Cookie ck[] = request.getCookies();
//            String nm = ck[0].getValue();
            HttpSession s2 = request.getSession();
            HttpSession s3 = request.getSession(false);
            String nm = s3.getAttribute("name").toString();
            //out.println(nm);
        Session session1= HibernateUtil.openSession();
        try {
            session1.beginTransaction();
            String hq = "from user where EmailAdd='"+nm+"'";
            Query qu = session1.createQuery(hq);
            List li = qu.list();
            Iterator it = li.iterator();
            user u = (user)it.next();
            ///int aid = u.getAID();
            int id = u.getAID();
            request.setAttribute("use", u);
            s2.setAttribute("aid", id);
            RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
            rd.forward(request, response);
            //user u = (user)it.next();
            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e){
            out.println(e);
        }
    }
}