package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;

public final class admin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("<!DOCTYPE HTML>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title> FF Pre-School </title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/admin.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <!% \n");
      out.write("//                                LogIn lin = new  LogIn();\n");
      out.write("//                                Class.forName(\"com.mysql.jdbc.Driver\");\n");
      out.write("//                                Connection con = DriverManager.getConnection(\"jdbc:mysql://localhost:3306/preschool\", \"root\", \"\");\n");
      out.write("//                                Statement stmt = con.createStatement();\n");
      out.write("//                                ResultSet rs8 = stmt.executeQuery(\"select * from user where EmailAdd='\"+lin.nm+\"'\");\n");
      out.write("//                                //ResultSet rs8 = stmt.executeQuery(\"select * from user where EmailAdd='mrsjoy132@gmail.com'\");\n");
      out.write("//                                out.println(\"ID : \"+rs8.getString(2));\n");
      out.write("//                                out.println(\"Name : \"+rs8.getString(3));\n");
      out.write("//                                out.println(\"Email ID : \"+rs8.getString(4));\n");
      out.write("//                                out.println(\"Mobile number : \"+rs8.getString(5));\n");
      out.write("//                                out.println(\"Salary : \"+rs8.getString(7));\n");
      out.write("//                                \n");
      out.write("        %>\n");
      out.write("        <header>\n");
      out.write("            <div class=\"main\">\n");
      out.write("                <div class=\"logo\">\n");
      out.write("                    <img src=\"logo.jpg\">\n");
      out.write("                </div>\n");
      out.write("                <ul>\n");
      out.write("                    <li class=\"active\"><a href=\"#\">Dashboard</a></li>\n");
      out.write("                    <li><a href=\"#\">Time Table</a></li>\n");
      out.write("                    <li><a href=\"#\">Registration</a></li>\n");
      out.write("                    <li><a href=\"#\">LogOut</a></li>\n");
      out.write("                </ul>\n");
      out.write("                    \n");
      out.write("            </div>    \n");
      out.write("        </header>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
