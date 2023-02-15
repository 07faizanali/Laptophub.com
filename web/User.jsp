<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="LaptopPackage.UserDao" %>

<% String str1=request.getParameter("im"); %>
<jsp:useBean id="obj" class="LaptopPackage.User" />
<jsp:setProperty property="*" name="obj" />
    <%int status1=UserDao.reg(obj); %>
    <% if(status1>0) {
     %>  
    <script>
     alert("REGISTER SUCCESSFULL!!!!");    
    window.open("L_User.jsp","_self");
    </script>
    <% 
    }else 
    { %>
    <script>
     alert("NOT VALID!!!!");  
     window.open("Registration.jsp","_self");
    </script>    
   <%
    } %>
    
