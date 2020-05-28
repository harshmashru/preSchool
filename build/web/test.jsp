<%-- 
    Document   : test
    Created on : 13 Sep, 2019, 11:18:23 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Cookie ck[] = request.getCookies();
            String nm = ck[ck.length-1].getValue();
            out.println(nm);
        %>
    </body>
</html>
