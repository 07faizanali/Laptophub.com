package LaptopPackage;
import java.io.IOException;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class Pay extends HttpServlet {
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          HttpSession session = request.getSession();
			String email = (String) session.getAttribute("email");
			String cnumber = request.getParameter("cnum");
			String cname = request.getParameter("cname");
			String expireYY = request.getParameter("year");
			String expireMM = request.getParameter("month");
                        String expiry = expireMM + "/" + expireYY;
                        String cvv = request.getParameter("cvv");
			int amount = Integer.parseInt(request.getParameter("amount"));
			int product_id = Integer.parseInt(request.getParameter("product_id")); 
                        boolean IssingleProduct = Boolean.parseBoolean((request.getParameter("IssingleProduct")));
                        String mode = "Online Payment";
			int status = UserDao.payment(mode, email, cnumber, cname, expiry, cvv, amount, IssingleProduct, product_id);
			if (status > 0) {
				response.sendRedirect("Orders.jsp");
			} else {
				out.println("Cart.jsp");
			}
        } catch (SQLException e) {} }}


