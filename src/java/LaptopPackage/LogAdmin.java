package LaptopPackage;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class LogAdmin extends HttpServlet {
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        if(AdminDao.validate(name,pass))
        {   
            HttpSession session = request.getSession();
            session.setAttribute("name", name);
            response.sendRedirect("LogAdminChoice");}
        else
        {response.sendRedirect("L_Admin.jsp");}}}
   
