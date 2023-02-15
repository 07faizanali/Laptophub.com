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
public class AddCart extends HttpServlet {
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           HttpSession session = request.getSession();
			if (session.getAttribute("email") == null) {
				response.sendRedirect("L_User.jsp");
                           }else {
				int prod_id = Integer.parseInt(request.getParameter("id"));
				int f_cart_id = 0;
				int quantity = 1;
				int price = 0;
				int total_amount = 0;
				String Product_name = "";
				String Email_id = "";
				Email_id = (String) session.getAttribute("email");
				Connection con = ConnectionProvider.getCon();
				Statement st = (Statement) con.createStatement();
				ResultSet rrs = (ResultSet) (st).executeQuery("SELECT * FROM cart WHERE Product_id ='" + prod_id + "'");
				while (rrs.next()) {
					quantity= (rrs.getInt(5))+1;
                                        System.out.println("A:"+quantity);
                                        f_cart_id = rrs.getInt(1);
                                        if(quantity >5)
                                        {response.sendRedirect("Cart.jsp");break;}
                                        total_amount = quantity * (rrs.getInt(6));
                                        int status = UserDao.UpdateAddCart(quantity, total_amount, f_cart_id);
					System.out.println("status value" + status);
					if (status > 0) {
						response.sendRedirect("Cart.jsp");
					}
					break;}
                                
				if (f_cart_id == 0) {
					ResultSet rs = (ResultSet) (st)
							.executeQuery("SELECT * FROM product WHERE Product_id ='" + prod_id + "'");
					while (rs.next()) {
						Product_name = rs.getString(2);
						price = rs.getInt(7);
						quantity = quantity;
						total_amount = price * quantity;
						int status = UserDao.AddCart(Email_id, Product_name, prod_id, quantity, price, total_amount);
						if (status > 0) {
							response.sendRedirect("Cart.jsp");
						}}}}
                        } catch (SQLException e) { }}}

 
