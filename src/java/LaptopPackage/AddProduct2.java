package LaptopPackage;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class AddProduct2 extends HttpServlet {
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
         String id=request.getParameter("id");
            String name=request.getParameter("name");
            String image=request.getParameter("im");
            String desc=request.getParameter("desc");
            String br=request.getParameter("br");
            String qua=request.getParameter("qua");
            String pr=request.getParameter("pr");
           String ram=request.getParameter("ram");
           String rom=request.getParameter("rom");
       Products e=new Products();
            e.setid(id);
            e.setname(name);
            e.setim(image);
            e.setdesc(desc);
            e.setbr(br);
            e.setqua(qua);
            e.setpr(pr);
            e.setram(ram);
            e.setrom(rom);
           int s=AdminDao.addProducts(e);
            if(s>0)
            {response.sendRedirect("A_Products");}
            else
            {response.sendRedirect("A_Products");}
            }}}