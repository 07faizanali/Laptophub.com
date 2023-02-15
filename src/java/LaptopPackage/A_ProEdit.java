package LaptopPackage;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class A_ProEdit extends HttpServlet {
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
            
         out.println("<a class='link' href='A_Orders'>Orders</a>");    
         out.println("<a class='link' href='A_Feedbacks'>Feedbacks</a>");
          out.println("<a class='link' href='A_Out'>LogOut</a>");
         out.println("</div>"); 
           out.println("</div>"); 
           String sid=request.getParameter("id");
           Products u=AdminDao.getProductsById(sid);
           out.println("<form name=\"f1\" action=\"A_ProEdit2\" method=\"post\"  >\n" +
"          <div class=\"reg\">\n" +
"          <center>   \n" +
"           \n" +
"            <table height='580px' style='background-color: #b2d0f9;' width='900px' border='0' >\n" +
"            \n" +
"            <tr>\n" +             
"            <td>PRODUCT ID</td> \n" +
"            <td><input type=\"text\" name=\"id\"  class=\"reg2\"  id=\"id\" required=\"required\" value='"+u.getid()+"' /></td></tr>\n" +
"            \n" +
"            <tr>\n" +
        
"            <tr>\n" +
"            <td>PRODUCT NAME</td> \n" +
"            <td><input type=\"text\" name=\"name\"  class=\"reg2\"  id=\"name\" required=\"required\" value='"+u.getname()+"' /></td></tr>\n" +
"            \n" +
        
"            <tr>\n" +
"            <td>IMAGE</td>\n" +
"            <td><input type=\"text\" name=\"im\" id=\"im\" class=\"reg2\" required=\"required\" value='"+u.getim()+"' readonly/></td></tr>\n" +
"            \n" +
        
"            <tr>\n" +
"            <td>DESCRIPTION</td>\n" +
"            <td><textarea name=\"desc\" id=\"desc\" class=\"reg2\" required=\"required\" >"+u.getdesc()+"</textarea></td></tr>\n" +
"            \n" +
        
"            <tr>\n" +
"            <td>BRAND</td>\n" +
"            <td><input type=\"text\" name=\"br\" id=\"br\"  class=\"reg2\" required=\"required\" value='"+u.getbr()+"'/></td></tr>            \n" +
"            \n" +
        
"            <tr>\n" +
"            <td>QUANTITY</td>\n" +
"            <td><input type=\"text\" name=\"qua\" id=\"qua\"  class=\"reg2\"  required=\"required\" value='"+u.getqua()+"'/></td></tr>\n" +
"            \n" +
        
"            <tr>\n" +
"            <td>PRICE</td>\n" +
"            <td><input type=\"text\" name=\"pr\" class=\"reg2\" required=\"required\" value='"+u.getpr()+"' /></td></tr>\n" +
"            \n" +
        
"            <tr>\n" +
"            <td>RAM</td>\n" +
"            <td><input type=\"text\" name=\"ram\" id=\"ram\"  class=\"reg2\"  required=\"required\" value='"+u.getram()+"' /></td></tr>\n" +
"            \n" +
        
"            <tr>\n" +
"            <td>ROM</td>\n" +
"            <td><input type=\"text\" name=\"rom\" id=\"rom\"  class=\"reg2\"  required=\"required\" value='"+u.getrom()+"'/></td></tr>\n" +
"            \n" +
        
"            </table>\n" +
"            </center>\n" +
"          </div>\n" +
"       \n" +
"               <center><input type=\"submit\" value=\"SUBMIT\" class=\"b1\"/> </center>\n" +
"               </form>");out.println("</html>"); }}}
