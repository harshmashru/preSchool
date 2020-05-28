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
<%@page import="javax.servlet.http.Cookie"%>
<%@page import="bean.admin"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title> FF Pre-School </title>
        <link rel="stylesheet" type="text/css" href="css/admin.css">
    </head>
    <body>
        <div class="admin">
        <% 
//            Cookie ck[] = request.getCookies();
//            String nm = ck[ck.length-1].getValue();
//            //out.println(nm);
//            Session session1= HibernateUtil.openSession();
//            try{
//                session1.beginTransaction();
//                String hq = "from user where EmailAdd='"+nm+"'";
//                Query qu = session1.createQuery(hq);
//                List li = qu.list();
//                Iterator it = li.iterator();
//                user u = (user)it.next();
//                out.println("<h2>ID : "+u.getAID() + "</h2>");
//                out.println("<h2>Name : "+u.getNAME()+ "</h2>");
//                out.println("<h2>Email ID : "+u.getEmailAdd()+ "</h2>");
//                out.println("<h2>Mobile number : "+u.getMobile_no()+ "</h2>");
//                out.println("<h2>Salary : "+u.getSalary()+ "</h2>");
//                out.println("<h2>Status : "+u.getStatus()+ "</h2>");
//            }
//            catch(Exception e){
//                System.out.println(e);
//            }                    
        %>
        <!jsp:useBean id="obj" class="bean.admin"/>
        <%
            user u = (user)request.getAttribute("use");
            out.println("<h2>ID : "+u.getAID() + "</h2>");
            out.println("<h2>Name : "+u.getNAME()+ "</h2>");
            out.println("<h2>Email ID : "+u.getEmailAdd()+ "</h2>");
            out.println("<h2>Mobile number : "+u.getMobile_no()+ "</h2>");
            out.println("<h2>Salary : "+u.getSalary()+ "</h2>");
            out.println("<h2>Status : "+u.getStatus()+ "</h2>");            
        %>
        <!jsp:useBean id="use" class="bean.admin" scope="request"/>
        <!jsp:getProperty name="use" property="AID"/>
        </div>
        <header>
            <div class="main">
                <div class="logo">
                    <img src="logo.jpg">
                </div>
                <ul>
                    <li class="active"><a href="#">Dashboard</a></li>
                    <li><a href="registration.html">Registration</a></li>
                </ul>
                <div class="date">
                <form action="./dates" method="POST">
                    <input type="submit" name="submit" value="HolidayDates"> 
                </form>
                </div>
                <form action="./LogOut" method="POST">
                    <input type="submit" name="submit" value="LogOut"> 
                </form>
            </div>    
        </header>
    </body>
</html>