package LaptopPackage;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class A_PayDel extends HttpServlet {
@Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String str=request.getParameter("id");
        int id=Integer.parseInt(str);
        AdminDao.deletePayments(id);
       response.sendRedirect("A_Payments");
        }}
