import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class NewFun extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession s3 = request.getSession();
        String id = s3.getAttribute("aid").toString();
        int aid= Integer.valueOf(id);
        String dt = request.getParameter("hdate");
        Date date1 = Date.valueOf(dt);
        String desc = request.getParameter("desc");
        try {
            /* TODO output your page here. You may use following sample code. */
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/preschool", "root","");
            PreparedStatement pst = con.prepareStatement("insert into holidaydates(AID,Dates,Description)values(?,?,?);");
            pst.setInt(1, aid);
            pst.setDate(2, date1);
            pst.setString(3, desc);
            int rs = pst.executeUpdate();
//            out.println("done");
            response.setContentType("text/html");
            request.getRequestDispatcher("a_timetable.jsp").include(request, response);
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Inserted!');");
            out.println("</script>");
        }
        catch(Exception e){
            out.println(e);
        }
    }
}
