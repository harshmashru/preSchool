<!DOCTYPE HTML>
<html> 
    <head>
        <title> FF Pre-School </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/style2.css">
    </head>
    <body>
        <%
            Cookie ck = new Cookie("name","");
            ck.setMaxAge(0);
            response.addCookie(ck);
            %>
        <header>
            <div class="main">
                <div class="logo">
                    <img src="logo.jpg">
                </div>
                <ul>
                    <li><a href="index.html"> Home</a></li>
                    <li><a href="contact.html">Contact</a></li>
                    <li  class="active"><a href="#">LogIn</a></li>
                </ul>
            </div>
            <div class="login">
                <img src="user.png" class="user"> 
                <form action="./LogIn" method="POST">
                    <h1> LogIn </h1>
                    <input type="text" name="user" placeholder="Email ID" required>
                    <input type="password" name="pass" placeholder="Password" required>
                    <input type="submit" name="submit" value="LogIn"> 
                    <a href="fpassword.html"> Forget Password </a>
                </form>
            </div>
        </header>
    </body>
</html>