<%-- 
    Document   : a_timetable
    Created on : 11 Sep, 2019, 7:17:09 PM
    Author     : user
--%>
<%@page import="pojo.holidaydates"%>
<%@page import="pojo.user"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="hibernateconfig.HibernateUtil"%>
<%@page import="org.hibernate.Session"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.IOException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="org.hibernate.Session"%>
<%@page import="hibernateconfig.HibernateUtil"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FF Pre-School</title>
        <link rel="stylesheet" type="text/css" href="css/admin.css">
    </head>
    <body>
        <ul>
            <li><a href="holi.html">Insert New Fun</a></li>
        </ul>
        <div class="admin">
            <%
                Session s = HibernateUtil.openSession();
                try {
                    /* TODO output your page here. You may use following sample code. */
                    s.beginTransaction();
                    String hq = "from holidaydates";
                    Query q = s.createQuery(hq);
                    List l = q.list();
                    Iterator it = l.iterator();
                    out.println("<h2> Dates &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Description</h2>");
                    while(it.hasNext()){
                        holidaydates hol = (holidaydates)it.next();
                        out.println("<h2>"+hol.getDates()+"&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp "+hol.getDescription()+"</h2>");                        
                    }
                    
                }
                catch(Exception e){
                        out.print(e);
                        }
                    %>
        </div>
        <header>
            <div class="main">
                <div class="logo">
                    <img src="logo.jpg">
                </div>
            </div>    
        </header>
    </body>
</html>
