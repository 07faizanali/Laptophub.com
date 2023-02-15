package LaptopPackage;
import java.io.IOException;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Feedback extends HttpServlet {
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       try (PrintWriter out = response.getWriter()) {
          HttpSession session = request.getSession();
                        String id = request.getParameter("id");
			String name = request.getParameter("n");
			String feed = request.getParameter("feed");
                       int status = UserDao.addFeed(id,name,feed);
			if (status > 0) {
				response.sendRedirect("Feedback.jsp");
			} else {
				response.sendRedirect("HOME.jsp");}
			} catch (SQLException ex) {
            Logger.getLogger(Feedback.class.getName()).log(Level.SEVERE, null, ex);}}}
