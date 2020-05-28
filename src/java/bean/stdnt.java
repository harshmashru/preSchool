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
import pojo.student;
public class stdnt extends HttpServlet {
    public static int sid;
        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //out.println("stdnt loggedIn !");
//        Cookie ck[] = request.getCookies();
//        String nm = ck[0].getValue();
        HttpSession s2 = request.getSession();
        String nm = s2.getAttribute("sname").toString();
        Session session1= HibernateUtil.openSession();
        try {
            session1.beginTransaction();
            String hq = "from student where P_EmailAdd='"+nm+"'";
            Query qu = session1.createQuery(hq);
            List li = qu.list();
            Iterator it = li.iterator();
            student s = (student)it.next();
            sid = s.getSID();
            ///int aid = u.getAID();
            request.setAttribute("std", s);
            RequestDispatcher rd = request.getRequestDispatcher("student.jsp");
            rd.forward(request, response);
            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e){
            out.println(e);
        }
    }
}
