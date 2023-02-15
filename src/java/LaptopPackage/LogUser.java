package LaptopPackage;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class LogUser extends HttpServlet {
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        if(UserDao.validate(email,pass))
        {try {  HttpSession session = request.getSession();
                session.setAttribute("email", email);
                Connection con = (Connection) ConnectionProvider.getCon();
                Statement st = con.createStatement();
                ResultSet rs = (ResultSet) st.executeQuery("select * from user where Email_id='" + email + "'");
                while (rs.next()) {
                session.setAttribute("name",rs.getString(2)); 
                }
                response.sendRedirect("HOME.jsp");
                } catch (SQLException ex) {
                Logger.getLogger(LogUser.class.getName()).log(Level.SEVERE, null, ex);
            }}
        else{
       response.sendRedirect("L_User.jsp");
        }
        } }


