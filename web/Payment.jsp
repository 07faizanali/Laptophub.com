<%-- 
    Document   : Payment
    Created on : Jan 13, 2022, 5:09:47 PM
    Author     : SBC
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
int amount=0;
int product_id=0;
int cart = Integer.parseInt(request.getParameter("cart_id"));
boolean IssingleProduct =false;
IssingleProduct = Boolean.parseBoolean(request.getParameter("IssingleProduct"));
if(IssingleProduct){
  product_id =Integer.parseInt(request.getParameter("product_id")); 
 amount= Integer.parseInt(request.getParameter("amount"));
}
else{amount =  Integer.parseInt(request.getParameter("amount"));}
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="Stylesheet" href="One.css" type="text/css">
         <link href='https://fonts.googleapis.com/css?family=Charmonman' rel='stylesheet'>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script>
        function upper()
       {var x = document.getElementById("cname").value;
           document.getElementById("cname").value = x.toUpperCase()  ;}
       function ok()
        {
         if(document.getElementById("cnum").value.length!==16)
               {  
                   alert("Card Number Incorrect(Write Without Spaces)");
                   document.getElementById("cnum").focus();
                   return false ;              
               } 
           else if(document.getElementById("cvv").value.length!==3)
               {  
                   alert("CVV Incorrect");
                   document.getElementById("cvv").focus();
                   return false ;              
               }    
            else
            {alert("Payment Success");return true;} }
  </script>    
  <title>PAYMENT</title>
   </head>
    <body bgcolor="white">
       <%@include file="Header.jsp"%>
         <% if(session.getAttribute("email")!=null){ %>
        <div class='sub1'>
          <center>   
          <form name="f1" action="Pay" method="post" onsubmit="return(ok())" >  
                <table height="600px" width="900px" border="1" class="subt">
                     <th colspan="4">CARD DETAILS:</th>
                     <tr>
                           <td colspan="2">AMOUNT</td>
                           <td colspan="2"><input type="text" name="amount" value="<%= amount%>" class="reg3" size="20" readonly/></td>
                      </tr>
                      <tr>
                           <td colspan="2">CARD NAME</td>
                           <td colspan="2"><input type="text" name="cname" id="cname" class="reg3" size="20" oninput="upper()" Placeholder="NAME" required="required"/></td>
                       </tr>
                       <tr>   
                           <td colspan="2">CARD NO.</td>
                           <td colspan="2"><input type="text" name="cnum" id="cnum" class="reg3" size="20"  Placeholder="NUMBER" required="required"/></td>
                       </tr>
                       <tr>
                           <td>EXPIRY DATE</td>
                           <td>
                           <select name='month' id='month' class="reg3" required="required" >
    <option value=''>Month</option>
    <option value='01'>January</option>
    <option value='02'>February</option>
    <option value='03'>March</option>
    <option value='04'>April</option>
    <option value='05'>May</option>
    <option value='06'>June</option>
    <option value='07'>July</option>
    <option value='08'>August</option>
    <option value='09'>September</option>
    <option value='10'>October</option>
    <option value='11'>November</option>
    <option value='12'>December</option>
                          </select> 
                           </td>
                           <td>
                               <select name='year' id='year' class="reg3" required="required">
    <option value=''>Year</option>
    <option value='22'>2022</option>
    <option value='23'>2023</option>
    <option value='24'>2024</option>
    <option value='25'>2025</option>
    <option value='26'>2026</option>
    <option value='27'>2027</option>
     </select>
                           </td>
                       </tr>
                       <tr>
                           <td>CVV</td>
                           <td><input type="password" name="cvv" id="cvv" class="reg3" size="20" Placeholder="CVV" required="required"/></td>
                       </tr>
                       <tr>
                            <th colspan="4"><input type="submit" value="PAY" class="b1"/></th>
                       </tr>
               </table>
              <input type="hidden" name="product_id" value=<%=product_id %>>
  <input type="hidden" name="IssingleProduct" value=<%=IssingleProduct %>>
          </form>
          </center>
        </div>
        <%}else{ %>
  <% response.sendRedirect("L_User.jsp"); %>
<%} %>
     <%@include file="Footer.jsp"%>
        </body>
</html>
