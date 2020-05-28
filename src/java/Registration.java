import hibernateconfig.HibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.user;
import pojo.student;
import bean.admin;
import javax.servlet.RequestDispatcher;
public class Registration extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String eid = request.getParameter("eid");
        String mno = request.getParameter("mno");
        String password = request.getParameter("password");
        String fees = request.getParameter("fees");    
        float fee = Float.parseFloat(fees);
        String status = request.getParameter("status");
        Session session = HibernateUtil.openSession();
        Transaction transaction = null;
        try {
            if(!(mno.length()<10 || mno.length()>10)){
            /* TODO output your page here. You may use following sample code. */
            user ad = new user();
            int aid = (int)request.getAttribute("id");
            out.println(aid);
            transaction = session.beginTransaction();
            String hq = "insert into student(AID,SNAME,P_EmailAdd,P_Mobileno,Password,Fees,Status)values(?,?,?,?,?,?,?);";
            student std = new student();
            std.setAID(aid);
            std.setSNAME(name);
            std.setP_EmailAdd(eid);
            std.setP_Mobileno(mno);
            std.setPassword(password);
            std.setFees(fee);
            std.setStatus(status);
            std.setUse(ad);
            session.save(transaction);
            transaction.commit();
            out.println("Successfully entered!");
            }
            else{
                out.println("<font color='red'<br><center> Mobile number must be of 10 digits...!</center></font>");
                RequestDispatcher rd=request.getRequestDispatcher("registration.html");  
                rd.include(request, response);
            }
        }
        catch(Exception e){
            out.println(e);
        }
    }
}
