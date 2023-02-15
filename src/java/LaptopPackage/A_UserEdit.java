package LaptopPackage;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class A_UserEdit extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        HttpSession session = request.getSession();  
        String user = (String)session.getAttribute("name");
        String name=user.toUpperCase();
        out.println("<html><head>"); 
        out.println("<title>"); 
         out.println("ADMIN"); 
        out.println("</title>"); 
        out.println("<link rel='Stylesheet' href='One.css' type='text/css'/>"); 
        out.println("</head>"); 
        out.println("<body bgcolor=\"white\">\n" +
"        \n" +
"           <div class='container'> \n" +
"          <div class='image'>\n" +
"              <img src=\"Laptop logo.png\" width=\"100%\" height=\"100%\"/>\n" +
"          </div>"
                );
         out.println("<div class='rectangle'>");
         out.println("<a class='link' href='A_User'>Users</a>");
         out.println("<a class='link' href='A_Products'>Products</a>");    
         out.println("<a class='link' href='A_Payments'>Payments</a>");    
         out.println("<a class='link' href='A_Cart'>Carts</a>");    
         out.println("<a class='link' href='A_Orders'>Orders</a>");    
         out.println("<a class='link' href='A_Feedbacks'>Feedbacks</a>");
          out.println("<a class='link' href='A_Out'>LogOut</a>");
         out.println("</div>"); 
           out.println("</div>"); 
           String sid=request.getParameter("id");
           User u=AdminDao.getUserById(sid);
           out.println("<form name=\"f1\" action=\"A_UserEdit2\" method=\"post\"  >\n" +
"          <div class=\"reg\">\n" +
"          <center>   \n" +
"           \n" +
"            <table height='580px' style='background-color: #b2d0f9;' width='900px' border='0' >\n" +
"            \n" +
"            <tr>\n" +
"            <td>NAME</td> \n" +
"            <td><input type=\"text\" name=\"n\"  class=\"reg2\" Placeholder=\"NAME\" id=\"n\" required=\"required\" value='"+u.getn()+"' /></td></tr>\n" +
"            \n" +
"            <tr>\n" +
"            <td>PHONE NUMBER</td>\n" +
"            <td><input type=\"number\" name=\"num\" id=\"num\" class=\"reg2\" Placeholder=\"NUMBER\" required=\"required\" value='"+u.getnum()+"'/></td></tr>\n" +
"\n" +
"            <tr>\n" +
"            <td>ADDRESS</td>\n" +
"            <td><textarea name=\"add\" id=\"add\" class=\"reg2\" Placeholder=\"ADDRESS\" required=\"required\" >"+u.getadd()+"</textarea></td></tr>\n" +
"            \n" +
"            <tr>\n" +
"            <td>PIN CODE</td>\n" +
"            <td><input type=\"number\" name=\"pin\" id=\"pin\"  class=\"reg2\" Placeholder=\"PIN CODE\" required=\"required\" value='"+u.getpin()+"'/></td></tr>            \n" +
"            \n" +
"            <tr>\n" +
"            <td>STATE</td>\n" +
"            <td><input type=\"text\" name=\"state\" id=\"state\"  class=\"reg2\" Placeholder=\"STATE\" required=\"required\" value='"+u.getstate()+"'/></td></tr>\n" +
"            \n" +
"            <tr>\n" +
"            <td>EMAIL ID</td>\n" +
"            <td><input type=\"email\" name=\"email\" class=\"reg2\" Placeholder=\"EMAIL ID\" required=\"required\" value='"+u.getemail()+"' readonly/></td></tr>\n" +
"            \n" +
"            <tr>\n" +
"            <td>PASSWORD</td>\n" +
"            <td><input type=\"password\" name=\"pass\" id=\"pass\"  class=\"reg2\" Placeholder=\"NUMBER\" required=\"required\" value='"+u.getpass()+"' readonly/></td></tr>\n" +
"            \n" +
"            <tr>\n" +
"            <td>CONFIRM PASSWORD</td>\n" +
"            <td><input type=\"password\" name=\"cpass\" id=\"cpass\"  class=\"reg2\" Placeholder=\"NUMBER\" required=\"required\" value='"+u.getpass()+"' readonly/></td></tr>\n" +
"            \n" +
"            </table>\n" +
"            </center>\n" +
"          </div>\n" +
"       \n" +
"               <center><input type=\"submit\" value=\"SUBMIT\" class=\"b1\"/> </center>\n" +
"               </form>");out.println("</html>");}}}
