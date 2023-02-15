<%-- 
    Document   : ContactUs
    Created on : Jan 11, 2022, 5:13:47 PM
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
      <title>ContactUs</title>
    </head>
    <body bgcolor="white">
      <%@include file="Header.jsp"%>
      <div class="Con">
             <table border="0" height="100%" width="100%" class="Cont">
                     <tr><th>ADDRESS</th>
                        <th>PHONE NO.</th>
                        <th>EMAIL ID</th> </tr>
                <tr><th><img src="address.png" height="120px" width="120px" class="png"/></th>
                        <th><img src="phone.png" height="120px" width="120px" class="png"/></th>
                        <th><img src="email.png" height="120px" width="120px" class="png"/></th></tr>
                    <tr><th>Rz597/313,Gali NO-6b,Geetanjali Park, </br>
                            West Sagarpur,</br>
                           New Delhi-110046</th>
                        <th>
                            9389658008,
                            9990891895
                        </th>
                        <th>
                            007faizanali@gmail.com
                        </th> </tr>
                   </table>
            </div>
        <%@include file="Footer.jsp"%>
        </body>
</html>
