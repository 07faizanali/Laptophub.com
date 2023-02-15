<%-- 
    Document   : Cart
    Created on : Jan 13, 2022, 12:24:55 PM
    Author     : SBC
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import = "java.io.*,java.util.*,java.sql.*" %>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<%@page import ="LaptopPackage.UserDao" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="Stylesheet" href="One.css" type="text/css">
         <link href='https://fonts.googleapis.com/css?family=Charmonman' rel='stylesheet'>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
      <title>CART</title>
    </head>
    <body>
        <%@include file="Header.jsp"%>
       <% 
    if(session.getAttribute("email")!=null){ %>
       <div class="choice">
           YOUR CART
        </div>
<div class="cart">
<table height="85px" width="1100px" border="1" class="profilet">   
            <thead>
                <th>Image</th> 
                <th>Name</th>
                <th>Quantity</th>
                <th>Price</th>
                </thead> 
        <sql:setDataSource var="ss" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/laptopable?useSSL=false" user="root" password="root" />
        <sql:query dataSource= "${ss}" var="result">
              SELECT * FROM cart where Email_id = '<%=session.getAttribute("email")%>';
        </sql:query> 
        <c:forEach var="row" items= "${result.rows}" > 
        <c:set var="amount" value="${row.Total_Amount + amount}" /> 
        <c:set var="cart_id" value="${row.Cart_id}" />
        <sql:setDataSource var="rs" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/laptopable?useSSL=false" user="root" password="root" />
             <sql:query dataSource= "${rs}" var="res">
              SELECT * FROM product where Product_id=<c:out value= "${row.Product_id}" />;
             </sql:query> 
             <c:forEach var="r" items= "${res.rows}" > 
             <tr>
                 <th><img src="${r.Image}" height="100px" width="140px"/></th>
                 <th><c:out value= "${row.Product_name}" /></th>
                 <th><c:out value= "${row.Quantity}" /></th>
                 <th><c:out value= "${row.Price}" /></th>
                 <th>
                     <c:if test="${row.Quantity <= 4}" > 
                 <form name="f1" action="AddCart" method="post">
                <input type="hidden" name="id" value="<c:out value= "${row.Product_id}" />" />    
                <center><input type="submit" value="Add One More"/> </center>
                </form>
                     </c:if>
                     <c:if test="${row.Quantity == 5}" > 
                     You Can't Add More
                     </c:if>
                <br><br>
                <form name="f1" action="DelCart" method="post">
                <input type="hidden" name="id" value="<c:out value= "${row.Product_id}" />" />    
                <center><input type="submit" value="Remove Product"/> </center>
                </form>
                 </th>
              </tr>
             </c:forEach>
             </c:forEach>
             <tfoot>
             <tr>
                 <td colspan="2">  Total Amount to be Paid :</td>
                 <th colspan="2"> <c:out value="${amount}"/></th>
           
             </tr>
              <tr>
              <th colspan="5"><a class="links" href="Payment.jsp?amount=<c:out value="${amount}"/>&cart_id=<c:out value= "${cart_id}"/>">BUY NOW </a></th>
              </tr>
            </tfoot>
           </table></div>
              <%} else{ %>
  <div class="empty-cart">
  <div class="choice">
           EMPTY CART
        </div>
      <center>
          <a class="links"href="Product.jsp">Continue Shopping</a></center>>
  </div>
  <%} %>
  <%@include file="Footer.jsp"%>
    </body>
</html>
