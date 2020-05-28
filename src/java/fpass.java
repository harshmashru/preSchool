import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class fpass extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  {
            
            /* TODO output your page here. You may use following sample code. */
            String to = request.getParameter("user");
            String sub = "New Password - FF PreSchool";
            String msg = "http://localhost:8080/Pre_school/newpass.html";
            String admin = "mjoseph.0070@gmail.com";
            String pass = "mjoseph007";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/preschool", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from user");
            boolean log = true;
                while(rs.next()){
                    if(to.equals(rs.getString(4))){
                        log = false;
                        SendMail.send(to, sub, msg, admin, pass);
                        out.println("mail sent");
                        /*RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");  
                        rd.forward(request, response);*/
                        break;
                    }
                }
                rs.close();
                ResultSet rs2 = stmt.executeQuery("select * from student");
                while(rs2.next()){
                    if(to.equals(rs2.getString(4))){
                        log = false;
                        SendMail.send(to, sub, msg, admin, pass);
                        out.println("mail sent");
                        break;
                    }
                }
                if(log){
                    out.println("Invalid detail!");
            }
        }
        catch(ClassNotFoundException | SQLException e){
            out.println(e);
        }
    }
}
