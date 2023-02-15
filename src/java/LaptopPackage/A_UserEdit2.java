package LaptopPackage;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class A_UserEdit2 extends HttpServlet {
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
         String name=request.getParameter("n");
            String num=request.getParameter("num");
            String add=request.getParameter("add");
            String pin=request.getParameter("pin");
            String state=request.getParameter("state");
            String email=request.getParameter("email");
            String pass=request.getParameter("pass");
            User e=new User();
            e.setn(name);
            e.setnum(num);
            e.setadd(add);
            e.setpin(pin);
            e.setstate(state);
            e.setemail(email);
            e.setpass(pass);
            int s=AdminDao.updateUser(e);
            if(s>0)
            {response.sendRedirect("A_User");}
            else
            {response.sendRedirect("A_User");}
            }}}
