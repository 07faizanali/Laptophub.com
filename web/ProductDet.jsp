<%-- 
    Document   : ProductDet
    Created on : Jan 12, 2022, 6:24:39 PM
    Author     : SBC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import = "java.io.*,java.util.*,java.sql.*" %>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<% String str1=request.getParameter("pid"); 
   String single ="true";%>
<%! static int cart_id=1000; %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="Stylesheet" href="One.css" type="text/css">
         <link href='https://fonts.googleapis.com/css?family=Charmonman' rel='stylesheet'>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
      <title>PRODUCTS</title>
        </head>
    <body bgcolor="white">
        
         <%@include file="Header.jsp"%>
         
        <sql:setDataSource var="ss" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/laptopable?useSSL=false" user="root" password="root" />
        <sql:query dataSource= "${ss}" var="result">
              SELECT * from product where Product_id=<%= str1 %>;
        </sql:query>  
         <c:forEach var="row" items= "${result.rows}" >   
               <div class="profiles">
           <table height="800px" width="800px" border="0" class="profilet">
             <tr>
                        <th colspan="2"><h2><c:out value= "${row.Product_name}" /></h2></th>
                    </tr>
                    <tr>
                        <th colspan="2"><img src="${row.Image}" height="260px" width="330px"/></th>
                    </tr>    
                        
                    <tr>
                        <td colspan="1"> <b>BRAND:</b></td>
                        <td colspan="1"><c:out value= "${row.Brand}" /></td>
                    </tr> 
                    <tr>
                       <td colspan="1"> <b>PRICE:</b></td>
                       <td colspan="1">Rs.<c:out value= "${row.Price}" /></td>
                    </tr> 
                    <tr>
                       <td colspan="1"><b>RAM:</b></td>
                       <td colspan="1"><c:out value= "${row.Ram}" /></td>
                    </tr>
                    <tr>    
                       <td colspan="1"><b>ROM:</b></td>
                       <td colspan="1"><c:out value= "${row.Rom}" /></td>
                    </tr> 
                    <tr>
                         <td colspan="1"><b>DESCRIPTION:</b></td>
                         <td colspan="1"><c:out value= "${row.Description}" /></td>
                    </tr> 
                    <c:if test="${row.Quantity < 5}" > 
                    <tr>
                        <th colspan="2">OUT OF STOCK</th>
                    </tr>
                     </c:if>
                    </table>
                   </div>
                 <c:if test="${row.Quantity >= 5}" > 
                <form name="f1" action="AddCart" method="post" >
                <input type="hidden" name="id" value="<c:out value= "${row.Product_id}" />" />    
              <center><input type="submit" value="ADD TO CART" class="b1"/> </center>
               </form>
              <center><input type="submit" value="BUY NOW" class="b1" onclick="location.href='Payment.jsp?cart_id=<%=cart_id %>&product_id=<c:out value= "${row.Product_id}" />&amount=<c:out value= "${row.Price}" />&IssingleProduct=true'"/></center>
               </c:if>
              </c:forEach>
        <%@include file="Footer.jsp"%>
        </body>
</html>
