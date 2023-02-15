<%-- 
    Document   : Feedback
    Created on : Jan 14, 2022, 8:09:10 PM
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
         function ok()
        {
            if(document.f1.feed.value.length>="150")
            {alert("Enter FEEDBACk");return false;}
            else
            {alert("SUBMITTED!!!");return true;}}
        </script>
        <title>FEEDBACK</title>
      </head>
    <body bgcolor="white">
      <%@include file="Header.jsp"%>
        <div class="feed">
           <form name="f1" action="Feedback" method="post" onsubmit="return(ch())" >
              <table height="600px" width="650px" border="0" class="logt">
                <tbody> 
                        <tr>
                            <th colspan="4">HOW WAS YOUR EXPERIENCE ??</th>   
                        </tr>    
                        <tr>
                            <td colspan="2">EMAIL_ID</td>
                            <td colspan="2"><input type="text" name="id" class="reg2" value="<%= session.getAttribute("email")%>" size="20"  required="required"/></td>
                        </tr> 
                       <tr>
                            <td colspan="2">NAME</td>
                            <td colspan="2"><input type="text" name="n" class="reg2" value="<%= session.getAttribute("name")%>" size="20"  required="required"/></td>
                        </tr> 
                        <tr>
                           <td colspan="2">Some More Suggestions...</td>
                           <td colspan="2"><textarea name="feed" rows="8" cols="50" class="reg2"></textarea></td>
                        </tr>
                                        
                        <tr><th colspan="4"><input type="submit" value="SUBMIT" class="b1"/></th></tr>
                       </tbody>
               </table>
           </form>
        </div>
        <%@include file="Footer.jsp"%>
        </body>
</html>
