<%@page import="pojo.student"%>
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
<%@page import="javax.servlet.http.Cookie"%>

<!DOCTYPE html>
<html>
    <head>
        <!meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FF Pre-School</title>
        <link rel="stylesheet" type="text/css" href="css/student.css"/>
    </head>
    <body>
        <div class="student">
        <% 
//            Cookie ck[] = request.getCookies();
//            String nm = ck[ck.length-1].getValue();
//            //out.println(nm);
//            Session session1= HibernateUtil.openSession();
//            try{
//                session1.beginTransaction();
//                String hq = "from student where P_EmailAdd='"+nm+"'";
//                Query qu = session1.createQuery(hq);
//                List li = qu.list();
//                Iterator it = li.iterator();
//                student s = (student)it.next();
//                //out.println("<h2>ID : "+s.() + "</h2>");
//                out.println("<h2>Student Name : "+s.getSNAME()+ "</h2>");
//                out.println("<h2>Email ID : "+s.getP_EmailAdd()+ "</h2>");
//                out.println("<h2>Mobile number : "+s.getP_Mobileno()+ "</h2>");
//                out.println("<h2>Fees : "+s.getFees()+ "</h2>");
//                out.println("<h2>Status : "+s.getStatus()+ "</h2>");
//            }
//            catch(Exception e){
//                System.out.println(e);
//            }
            %>
            <%
                student s = (student)request.getAttribute("std");
                out.println("<h2>Student Name : "+s.getSNAME()+ "</h2>");
                out.println("<h2>Email ID : "+s.getP_EmailAdd()+ "</h2>");
                out.println("<h2>Mobile number : "+s.getP_Mobileno()+ "</h2>");
                out.println("<h2>Fees : "+s.getFees()+ "</h2>");
                out.println("<h2>Status : "+s.getStatus()+ "</h2>"); 
            %>
            </div>
            <header>
            <div class="main">
                <div class="logo">
                    <img src="logo.jpg">
                </div>
                <ul>
                    <li class="active"><a href="#">Dashboard</a></li>
                    <li><a href="#">Time Table</a></li>
                    <li><a href="#">Payment</a></li>
                    <li><a href="index.html">LogOut</a></li>
                </ul>  
            </div>    
        </header>
    </body>
</html>
