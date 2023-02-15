<%-- 
    Document   : L_User
    Created on : Jan 11, 2022, 7:34:55 PM
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
        <title>Login</title>
    </head>
     <body bgcolor="white">
      <%@include file="Header.jsp"%>
       <div class="choice">
            LOG IN
        </div>
         <div class="log">
      <form name="f2" action="LogUser" method="post">
               <table height="300px" width="790px" border="0" class="logt">
                <tr>
                           <th>EMAIL ID</th>
                           <td><input type="email" name="email" class="reg2" size="20" Placeholder="EMAIL ID" required="required"/></td>
                       </tr>
                        <tr>
                           <th>PASSWORD</th>
                           <td><input type="password" name="pass" class="reg2" size="20" Placeholder="PASSWORD" required="required"/></td>
                       </tr>
                       <tr>
                           <th colspan="2"><input type="submit" value="JOIN" class="b1"/></th>
                       </tr>
                       </table>
          </form>
         </div>
          <%@include file="Footer.jsp"%>
   </body>
</html>
