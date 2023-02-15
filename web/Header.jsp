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
    <body>
    <div class="container">
        <div class="image">
        <img src="Laptop logo.png" width="100%" height="100%"/>
        </div>
        <div class="rectangle">
         <a class="link" href="HOME.jsp"><i class="fa fa-home"></i>HOME</a>    
            <a class="link" href="Product.jsp"><i class="fa fa-laptop"></i>PRODUCTS</a>   
            <% 
                HttpSession s=request.getSession();
                if(s.getAttribute("email")==null){%>
          <a class="link" href="Registration.jsp"><i class="fa fa-id-badge"></i>REGISTRATION</a>
          <a class="link" href="LOGIN.jsp"><i class="fa fa-sign-in"></i>LOGIN</a>  
           <a class="l"><i class="fa fa-user-circle"></i>GUEST</a> 
           <%} else {%>
           <a class="link" href="Cart.jsp"><i class="fa fa-shopping-cart"></i>YOUR CART</a>  
           <a class="link" href="Orders.jsp"><i class="fa fa-check-circle-o"></i>YOUR ORDERS</a> 
           <a class="link" href="LogOutUser"><i class="fa fa-sign-out"></i>LOGOUT</a>    
           <a class="l"><i class="fa fa-user-circle-o"></i><%=s.getAttribute("name")%></a>
           <% }%>
            </div> 
        </div>
        </body>
</html>
