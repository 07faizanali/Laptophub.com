
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="Stylesheet" href="One.css" type="text/css">
         <link href='https://fonts.googleapis.com/css?family=Charmonman' rel='stylesheet'>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
      <title>HOME</title>
     </head>
    <body bgcolor="white">
        <%@include file="Header.jsp"%>
        
          <div >
              <form method="post" action="SearchPro.jsp">  
               <input type="hidden" name="id" value="" />        
              <input type="text" class="t1" name="search" placeholder="Search By Name..."/>
              <input type="submit" value="Search" class="t2"/>  
              </form>
              </div> 
  
 <marquee width="100%" direction="right" scrollamount="5" height="100%">
     <img class="image2"/>
     <img class="image3"/>
     <img class="image4"/>
   </marquee>
        <div class="steps">
                    <table border="0" height="100%" width="100%" class="cont">
                    <tr> <th colspan="4">Find a Suitable Laptop in 4 Easy Steps</th> </tr>
             
                    <tr> <th ><img src="user.png" height="120px" width="120px" class="png"/></th>
                        <th ><img src="search.png" height="120px" width="120px" class="png"/></th>
                        <th ><img src="order.png" height="120px" width="120px" class="png"/></th>
                        <th ><img src="receive.png" height="120px" width="120px" class="png"/></th> </tr>
                   
                    <tr><th>Register</th>
                        <th>Search</th>
                        <th>Order</th>
                        <th>Receive</th></tr>
              </table>
          </div>    
         <%@include file="Footer.jsp"%>
        </body>
</html>