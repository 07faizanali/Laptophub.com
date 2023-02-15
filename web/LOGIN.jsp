<%-- 
    Document   : LOGIN
    Created on : Jan 11, 2022, 6:53:58 PM
    Author     : SBC
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="Stylesheet" href="One.css" type="text/css">
        <link href='https://fonts.googleapis.com/css?family=Charmonman' rel='stylesheet'>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>LOGIN</title>
    </head>
    <body bgcolor="white">
        <%@include file="Header.jsp"%>
        <div class="choice">
            LOG IN
        </div>
        <div class="choice2">
      <center>
       <a class="linkp" href="L_User.jsp"><img src="User.jpg" height="300px" width="200px" /></a>
           &nbsp;&nbsp;
           &nbsp;&nbsp;
        <a class="linkp" href="L_Admin.jsp"><img src="Admin.jpg" height="300px" width="200px" /></a>
       </center>
       </div>
       <%@include file="Footer.jsp"%>
        
    </body>
</html>

