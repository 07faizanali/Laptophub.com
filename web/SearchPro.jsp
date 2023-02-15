<%-- 
    Document   : SearchPro
    Created on : Jan 12, 2022, 10:42:04 PM
    Author     : SBC
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import = "java.io.*,java.util.*,java.sql.*" %>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<% String search=request.getParameter("search"); %>  
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="Stylesheet" href="One.css" type="text/css">
         <link href='https://fonts.googleapis.com/css?family=Charmonman' rel='stylesheet'>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
      <title>PRODUCTS</title>
     </head>
    <body>
        <%@include file="Header.jsp"%>
        <sql:setDataSource var="ss" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/Laptopable?useSSL=False" user="root" password="root" />
        <sql:query dataSource= "${ss}" var="result">
              SELECT Product_id,Product_name,Price,Image FROM PRODUCT where Product_name Like "%<%= search %>%";
        </sql:query> 
         <div>
              <form method="post" action="SearchPro.jsp">  
               <input type="hidden" name="id" value="" />        
              <input type="text" class="t1" name="search" placeholder="Search By Name..."/>
              <input type="submit" value="Search" class="t2"/>  
              </form>
              </div>  
            <div class="Profiles2">
             <c:forEach var="row" items= "${result.rows}" >
                 
             <form method="post" action="ProductDet.jsp">
                   <button type="submit">  
                   <input type="hidden" name="pid" value="${row.Product_id}" /> 
                   <img src="${row.Image}" height="210px" width="270px"/><br>
                   <c:out value= "${row.Product_name} "/><br><br>
                   Rs. <c:out value= "${row.Price} "/>
                  </button>
             </form>
                   </c:forEach>
           </center>
        </div>  </body>
</html>
