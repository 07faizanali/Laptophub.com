<%-- 
    Document   : Orders
    Created on : Jan 14, 2022, 3:48:33 PM
    Author     : SBC
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*" %>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<!DOCTYPE html>
<% String name = (String)session.getAttribute("name");%>
<% String email = (String)session.getAttribute("email");%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="Stylesheet" href="One.css" type="text/css">
         <link href='https://fonts.googleapis.com/css?family=Charmonman' rel='stylesheet'>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
      <title>ORDERS</title>
   </head>
    <body bgcolor="white">
        <%@include file="Header.jsp"%>
        <div class="choice">
           YOUR ORDERS
        </div>
        <div class="cart">
        <table height="85px" width="1100px" border="1" class="profilet">
      <thead>
      <th>Order_Id</th>
      
      <th>User</th>
      <th>Product_Name</th>
      <th>Quantity</th>
      <th>Amount</th>
      <th>Date</th>
      <th>Cancel Orders</th>
      </thead>
        <sql:setDataSource var="ss" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/laptopable?useSSL=false" user="root" password="root" />
        <sql:query dataSource= "${ss}" var="result1">
              SELECT * FROM orders;
        </sql:query> 
        <c:forEach var="row" items= "${result1.rows}" >      
       <sql:setDataSource var="rs" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/laptopable?useSSL=false" user="root" password="root" />
       <sql:query dataSource= "${rs}" var="result2">
       SELECT * FROM payment where Payment_id=<c:out value= "${row.Payment_id}" />;
        </sql:query> 
        <c:forEach var="r" items= "${result2.rows}" > 
        <c:if test= "${r.Email_id == email }" >     
         <sql:setDataSource var="sr" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/laptopable?useSSL=false" user="root" password="root" />
       <sql:query dataSource= "${sr}" var="result3">
       SELECT * FROM product where Product_id=<c:out value= "${row.Product_id}" />;
       </sql:query> 
       <c:forEach var="s" items= "${result3.rows}"> 
           
        <tr>
                 <th><c:out value= "${row.Order_id}" /></th>
                 <th> <%= name%> </th>
                 <th><c:out value= "${s.Product_name}" /></th>
                 <th><c:out value= "${row.Quantity}" /></th>
                 <th><c:out value= "${s.Price}" /></th>
                 <th><c:out value= "${row.Date}" /></th>
                 <th>
                <form name="f1" action="DelOrder" method="post">
                <input type="hidden" name="id" value="<c:out value= "${row.Order_id}" />" />    
                <center><input type="submit" value="Cancel Order"/> </center>
                </form>
                 </th>
            </tr>
             </c:forEach>
             </c:if>
             </c:forEach>
             </c:forEach>
        </table>
        </div>
     <%@include file="Footer.jsp"%>
        </body>
</html>