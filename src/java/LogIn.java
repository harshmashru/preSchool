import hibernateconfig.HibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import hibernateconfig.HibernateUtil;
import pojo.user;
import pojo.student;
public class LogIn extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int flag=0;
            /* TODO output your page here. You may use following sample code. */
//            HibernateUtil hiber = new HibernateUtil();
            //request.getRequestDispatcher("link.html").include(request, response);
            String nm = request.getParameter("user");
            String pw = request.getParameter("pass");
            HttpSession s1 = request.getSession();
//            Session session = HibernateUtil.openSession();
//            s1.setAttribute("username", nm);
//            Session session2= HibernateUtil.openSession();
            try{
                Session session = HibernateUtil.openSession();
                Session session2= HibernateUtil.openSession();
                session.beginTransaction();
                session2.beginTransaction();
                //String hql = "from user";
                Query qu = session.createQuery("from user");
                List li = qu.list();
                Iterator  it = li.iterator();
                //Enumeration en = (Enumeration) li.iterator();
                //String hq2 = "from student";
                Query qu2 = session2.createQuery("from student");
                List li2 = qu2.list();
                Iterator  it2 = li2.iterator();
//                out.println(li);
//                out.println(li2);
                //Enumeration en2 = (Enumeration) li2.iterator();
                while(it2.hasNext()||it.hasNext()){
                    user u = (user)it.next();
//                    out.println(u.getEmailAdd());
//                    out.println(u.getPassword());
                    if(u.getEmailAdd().equals(nm) && u.getPassword().equals(pw)){
                        flag=1;
                        break;
                    }
//                    while(it2.hasNext()){
                    student s = (student)it2.next();
                    if(s.getP_EmailAdd().equals(nm) && s.getPassword().equals(pw)){
                            flag=2;
                            break;
                    }
                }
            switch (flag) {
                case 2:
                    {
                        s1.setAttribute("sname", nm);
                        //out.println("student loggedin!");
                        RequestDispatcher rd1 = request.getRequestDispatcher("./stdnt");
                        rd1.forward(request, response);
                        break;
                    }
                case 1:
                    {
                        //                    Cookie ck = new Cookie("name",nm);
//                    response.addCookie(ck);
                        s1.setAttribute("name", nm);
                        //out.println("admin loggedin!");
                        RequestDispatcher rd=request.getRequestDispatcher("./admin");
                        rd.forward(request, response);
                        break;
                    }
                default:
                    {
                        out.println("Invalid detail!");
                        RequestDispatcher rd=request.getRequestDispatcher("login.html");
                        rd.include(request, response);
                        break;
                    }
            }
            }
            catch(HibernateException e){
                out.println(e);
            }
            out.println("</body>");
            out.println("</html>");
    }
}
