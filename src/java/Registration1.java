import bean.admin;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Registration1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession s3 = request.getSession();
        String id = s3.getAttribute("aid").toString();
        int aid= Integer.valueOf(id);
        String name = request.getParameter("name");
        String eid = request.getParameter("eid");
        String mno = request.getParameter("mno");
        String pass = request.getParameter("pass");
        String fees = request.getParameter("fees");    
        float fee = Float.parseFloat(fees);
        String status = request.getParameter("status");
//        out.println(id);
        try {
            if(!(mno.length()<10 || mno.length()>10)){
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet register</title>");            
            out.println("</head>");
            out.println("<body>");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/preschool", "root","");
            PreparedStatement pst = con.prepareStatement("insert into student(AID,SNAME,P_EmailAdd,P_Mobileno,Password,Fees,Status)values(?,?,?,?,?,?,?);");
            pst.setInt(1, aid);
            pst.setString(2, name);
            pst.setString(3, eid);
            pst.setString(4, mno);
            pst.setString(5, pass);
            pst.setFloat(6, fee);
            pst.setString(7, status);
            int rs = pst.executeUpdate();            
//RequestDispatcher rd = request.getRequestDispatcher("");
            //out.println("done");
            response.setContentType("text/html");
            request.getRequestDispatcher("registration.html").include(request, response);
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Registered!');");
            out.println("</script>");
//            RequestDispatcher rd = request.getRequestDispatcher("login.html");
//            rd.forward(request, response);
            out.println("</body>");
            out.println("</html>");
           }
            else{
                out.println("<font color='red'<br><center> Mobile number must be of 10 digits...!</center></font>");
                RequestDispatcher rd=request.getRequestDispatcher("registration.html");  
                rd.include(request, response);
            }
        }
        catch(Exception  e){
            out.println(e);
        }
    }
}
