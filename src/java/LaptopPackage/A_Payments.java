package LaptopPackage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class A_Payments extends HttpServlet {
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
           List<Payments> list=AdminDao.getAllPayments();
              out.println("<table border='1' width=100% style='border-color:#0047AB; background-color:#b2d0f9;' >");
              out.println("<h2 style='text-decoration:none; color:#123C69;'>PAYMENTS<hr></h2>");
            out.println("<tr><th>Delete</th><th>PAYMENT ID</th><th>PAYMENT MODE</th><th>EMAIL ID</th><th>CARD NAME</th><th>CARD NUMBER</th><th>EXPIRY DATE</th><th>CVV NO</th><th>PAID AMOUNT</th><th>DATE</th></tr>");
           for(Payments u: list) {
               out.println("<tr><td><a class='link' href='A_PayDel?id="+u.getpid()+"'>Delete</a></td><td>"+u.getpid()+"</td><td>"+u.getmode()+"</td><td>"+u.geteid()+"</td><td>"+u.getcname()+"</td><td>"+u.getcnum()+"</td><td>"+u.getexp()+"</td><td>"+u.getcvv()+"</td><td>"+u.getamt()+"</td><td>"+u.getdate()+"</td></tr>");
           }  out.println("</table>");} }}
