package LaptopPackage;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class DelOrder extends HttpServlet {
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
         HttpSession session = request.getSession();
			if (session.getAttribute("email") == null) {
				response.sendRedirect("L_User.jsp");}
                        else {int prod_id = Integer.parseInt(request.getParameter("id"));
				String Email_id = "";
				Email_id = (String) session.getAttribute("email");
                              UserDao.removeOrder(prod_id);
				
						response.sendRedirect("Orders.jsp");}}} }
