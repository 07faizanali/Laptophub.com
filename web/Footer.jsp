<%-- 
    Document   : Header
    Created on : Jan 11, 2022, 11:22:23 PM
    Author     : SBC
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*" %>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="Stylesheet" href="One.css" type="text/css">
         <link href='https://fonts.googleapis.com/css?family=Charmonman' rel='stylesheet'>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
     </head>
    <div class="footer">
         <font size="3px" >
            <% 
                HttpSession sess=request.getSession();
                if(sess.getAttribute("email")==null){%>
             <a class="links" href="AboutUs.jsp">About Us</a>  
            <a class="links" href="ContactUs.jsp">Contact Us</a>
            <%} else {%>
            <a class="links" href="AboutUs.jsp">About Us</a>  
            <a class="links" href="ContactUs.jsp">Contact Us</a>
            <a class="links" href="Feedback.jsp">Feedback</a><br>
            <% }%>
             @2022 Laptophub.com. All Rights Reserved
             </font></div></html>
