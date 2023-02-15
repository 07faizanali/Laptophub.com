<%-- 
    Document   : Registration
    Created on : Jan 11, 2022, 5:50:04 PM
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
        <script>
     function validate()
     {
     { if(document.getElementById("pin").value.length!=6||document.getElementById("pin").value[0]!=1)
          {alert("Pincode Incorrect");
           document.getElementById("pin").focus();
            return false;}
        else if(document.getElementById("num").value.length!=10||document.getElementById("num").value[0]<6)
             {  alert("Phone Number Incorrect");
              document.getElementById("num").focus();
              return false ;  }             
          else if(document.getElementById("cpass").value != document.getElementById("pass").value)     
               {  alert("Password Not Matching");
                   document.getElementById("cpass").focus();
                   return false ;  }
             else
            {return true;} }}
      function upper()
       {   var x = document.getElementById("n").value;
           document.getElementById("n").value = x.toUpperCase()  ;
           
           var z = document.getElementById("state").value;
           document.getElementById("state").value = z.toUpperCase()  ; }
       </script>
        <title>REGISTRATION</title>
    </head>
    <body>
     <%@include file="Header.jsp"%>
         <div class="choice">
            REGISTRATION
        </div>
        <form name="f1" action="User.jsp" method="post" onsubmit="return validate()" >
          <div class="reg">
          <center>   
           <table border="0" height="580px" width="900px" class="regt" >
            <tr>
            <td>NAME</td> 
            <td><input type="text" name="n"  class="reg2" Placeholder="NAME" id="n" required="required" oninput="upper()"/></td></tr>
            <tr>
            <td>PHONE NUMBER</td>
            <td><input type="number" name="num" id="num" class="reg2" Placeholder="NUMBER" required="required"/></td></tr>
           <tr>
            <td>ADDRESS</td>
            <td><textarea name="add" id="add" class="reg2" Placeholder="ADDRESS" required="required" ></textarea></td></tr>
            <tr>
            <td>PIN CODE</td>
            <td><input type="number" name="pin" id="pin"  class="reg2" Placeholder="PIN CODE" required="required"/></td></tr>            
            <tr>
            <td>STATE</td>
            <td><input type="text" name="state" id="state"  class="reg2" Placeholder="STATE" required="required" oninput="upper()"/></td></tr>
            <tr>
            <td>EMAIL ID</td>
            <td><input type="email" name="email" class="reg2" Placeholder="EMAIL ID" required="required"/></td></tr>
            <tr>
            <td>PASSWORD</td>
            <td><input type="password" name="pass" id="pass"  class="reg2" Placeholder="NUMBER" required="required" /></td></tr>
            <tr>
            <td>CONFIRM PASSWORD</td>
            <td><input type="password" name="cpass" id="cpass"  class="reg2" Placeholder="NUMBER" required="required" /></td></tr>
            </table>
            </center>
          </div>
       <center><input type="submit" value="JOIN" class="b1"/> </center>
               </form>
      <center>
             <input type="submit" value="LOGIN" class="b1" onclick="location.href='L_User.jsp'"/>
               <br>
               <font size="2px" color="black">
               <u>IF ALREADY REGISTERED</u>
               </font>
             </center>
             <font size="2px" color="black">
        <ul type="disc">
            Note:
            <li>By Clicking On Join You Accept Our Terms&Conditions.</li>
            <li>You Also Accept Our Privacy Policy.</li>
            <li>All The Charges Non-Refundable.</li>
        </ul>
    </font>
   <%@include file="Footer.jsp"%></body>
</html>
