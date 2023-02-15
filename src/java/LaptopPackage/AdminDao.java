package LaptopPackage;
import java.sql.*;
import java.util.Date;
import static LaptopPackage.Provider.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
public class AdminDao {
    private static Object Admindao;
    private static Connection getConnection(){
    Connection con=null;
    try{Class.forName(DRIVER);
            con=DriverManager.getConnection(CONNECTION_URL,USERNAME,PASSWORD);}
        catch(ClassNotFoundException | SQLException e){}
        return con;}
    
public static boolean validate(String name,String pass) 
    { boolean st = false;
        try {try(Connection con= AdminDao.getConnection())
           {PreparedStatement ps=con.prepareStatement("select * from admin where Admin_name=? and password=?");
            ps.setString(1, name);
            ps.setString(2, pass);
            ResultSet rs =ps.executeQuery();
            st = rs.next();}}
        catch(SQLException e) {}
        return st;} 
    
public static int addProducts(Products u)
    { 
    int status1=0;
    try{Connection con=ConnectionProvider.getCon();
       PreparedStatement ps;
        ps=con.prepareStatement("INSERT INTO Product VALUES(?,?,?,?,?,?,?,?,?)");
       ps.setString(1,u.getid());
         ps.setString(2,u.getname());
         ps.setString(3,u.getdesc());
         ps.setString(4,u.getim());
         ps.setString(5,u.getbr());
         ps.setString(6,u.getqua());
         ps.setString(7,u.getpr());
         ps.setString(8,u.getram());
         ps.setString(9,u.getrom());
         status1=ps.executeUpdate();}
    catch(SQLException e){} 
return status1;}
    
    
    
public static List<User> getAllUser(){
     List<User> list=new ArrayList();
     try{try(Connection con = AdminDao.getConnection()){
        Statement ps=con.createStatement();
         ResultSet rs=ps.executeQuery("select * from user");
         while(rs.next())
         {User u=new User();
         u.setemail(rs.getString(1));
         u.setn(rs.getString(2));
         u.setnum(rs.getString(3));
         u.setpass(rs.getString(4));
         u.setadd(rs.getString(5));
         u.setpin(rs.getString(6));
         u.setstate(rs.getString(7));
         list.add(u);
         }}}catch(SQLException ex){}
     return list;
        }
          
public static List<Products> getAllProducts(){
     List<Products> list=new ArrayList();
     try{try(Connection con = AdminDao.getConnection()){
        Statement ps=con.createStatement();
         ResultSet rs=ps.executeQuery("select * from product");
         while(rs.next())
         {Products u=new Products();
         u.setid(rs.getString(1));
         u.setname(rs.getString(2));
         u.setdesc(rs.getString(3));
         u.setim(rs.getString(4));
         u.setbr(rs.getString(5));
         u.setqua(rs.getString(6));
         u.setpr(rs.getString(7));
            u.setram(rs.getString(8));        
              u.setrom(rs.getString(9));
         list.add(u);
         } }}catch(SQLException ex){}
     return list;
        }
     
public static List<Payments> getAllPayments(){
     List<Payments> list=new ArrayList();
     try{try(Connection con = AdminDao.getConnection()){
        Statement ps=con.createStatement();
         ResultSet rs=ps.executeQuery("select * from payment");
         while(rs.next())
         {Payments u=new Payments();
         u.setpid(rs.getString(1));
         u.setmode(rs.getString(2));
         u.seteid(rs.getString(3));
         u.setcname(rs.getString(4));
         u.setcnum(rs.getString(5));
         u.setexp(rs.getString(6));
         u.setcvv(rs.getString(7));
         u.setamt(rs.getString(8));        
         u.setdate(rs.getString(9));
         list.add(u);
         }}}catch(SQLException ex){}
     return list;}
     
     
public static List<Orders> getAllOrders(){
     List<Orders> list=new ArrayList();
     try{
         try(Connection con = AdminDao.getConnection()){
        Statement ps=con.createStatement();
         ResultSet rs=ps.executeQuery("select * from orders");
         while(rs.next())
         {Orders u=new  Orders();
         u.setid(rs.getString(1));
         u.setproid(rs.getString(2));
         u.setadd(rs.getString(3));
         u.setqua(rs.getString(4));
         u.setdate(rs.getString(5));
         u.setpayid(rs.getString(6));
         list.add(u);
         }}}catch(SQLException ex){}
     return list;
        }
      
public static List<Feedbacks> getAllFeedbacks(){
     List<Feedbacks> list=new ArrayList();
     try{try(Connection con = AdminDao.getConnection()){
        Statement ps=con.createStatement();
         ResultSet rs=ps.executeQuery("select * from feedback");
         while(rs.next())
         {Feedbacks u=new  Feedbacks();
         u.setemail(rs.getString(1));
         u.setid(rs.getString(2));
         u.setn(rs.getString(3));
         u.setcom(rs.getString(4));
         list.add(u);}}}catch(SQLException ex){}
     return list;
        }
    
      
public static int deleteUser(String str)
    {int status=0;
     try{try(Connection con= AdminDao.getConnection())
         {PreparedStatement ps=con.prepareStatement("delete from user where Email_id=?");
         ps.setString(1,str);
         status=ps.executeUpdate();}
         }catch(SQLException e){}
         return status; }
     
public static int deleteProducts(int id)
    { int status=0;
     try{ try(Connection con= AdminDao.getConnection())
         {PreparedStatement ps=con.prepareStatement("delete from product where Product_id=?");
         ps.setInt(1,id);
         status=ps.executeUpdate();}
         }catch(SQLException e){}
         return status;}
      
public static int deletePayments(int id)
    {int status=0;
     try{try(Connection con= AdminDao.getConnection())
         {PreparedStatement ps=con.prepareStatement("delete from payment where Payment_id=?");
         ps.setInt(1,id);
         status=ps.executeUpdate();}
         }catch(SQLException e){}
         return status;}
      
    
public static int deleteOrders(int id)
    {int status=0;
     try{try(Connection con= AdminDao.getConnection())
         {PreparedStatement ps=con.prepareStatement("delete from orders where Order_id=?");
         ps.setInt(1,id);
         status=ps.executeUpdate();}
         }catch(SQLException e){}
         return status;}
      
public static int deleteFeedback(int id)
    {int status=0;
     try{try(Connection con= AdminDao.getConnection())
         {PreparedStatement ps=con.prepareStatement("delete from feedback where Feed_id=?");
         ps.setInt(1,id);
         status=ps.executeUpdate();}
         }catch(SQLException e){}
         return status;}
      
public static User getUserById(String email){
    User u=new User();
     try{try(Connection con = AdminDao.getConnection()){
        PreparedStatement ps=con.prepareStatement("select * from user where Email_id=?");
         ps.setString(1,email);
         ResultSet rs=ps.executeQuery();
         if(rs.next())
         {u.setemail(rs.getString(1));
         u.setn(rs.getString(2));
         u.setnum(rs.getString(3));
         u.setpass(rs.getString(4));
         u.setadd(rs.getString(5));
         u.setpin(rs.getString(6));
         u.setstate(rs.getString(7));
         }}}catch(SQLException ex){}
     return u;}
     
public static int updateUser(User u)
    {int status=0;
     try{try(Connection con= AdminDao.getConnection())
         {PreparedStatement ps=con.prepareStatement("update user set Name=?,Phone_no=?,Address=?,Pincode=?,State=?,Email_id=?,Password=? where Email_id=?");
         ps.setString(1,u.getn());
         ps.setString(2,u.getnum());
         ps.setString(3,u.getadd());
         ps.setString(4,u.getpin());
         ps.setString(5,u.getstate());
         ps.setString(6,u.getemail());
         ps.setString(7,u.getpass());
         ps.setString(8,u.getemail());
         status=ps.executeUpdate();}
         }catch(SQLException ex){}
         return status;
     }
     
     
     
public static Products getProductsById(String id){
    Products u=new Products();
     try{try(Connection con = AdminDao.getConnection()){
       PreparedStatement ps=con.prepareStatement("select * from product where Product_id=?");
         ps.setString(1,id);
         ResultSet rs=ps.executeQuery();
         if(rs.next())
         {u.setid(rs.getString(1));
         u.setname(rs.getString(2));
         u.setdesc(rs.getString(3));
         u.setim(rs.getString(4));
         u.setbr(rs.getString(5));
         u.setqua(rs.getString(6));
         u.setpr(rs.getString(7));
            u.setram(rs.getString(8));        
              u.setrom(rs.getString(9));}}}catch(SQLException ex){}
     return u;}
      
public static int updateProducts(Products u)
    {int status=0;
     try{try(Connection con= AdminDao.getConnection())
         {PreparedStatement ps=con.prepareStatement("update product set Product_id=?,Product_name=?,Description=?,Image=?,Brand=?,Quantity=?,Price=?,Ram=?,Rom=? where Product_id=?");
         ps.setString(1,u.getid());
         ps.setString(2,u.getname());
         ps.setString(3,u.getdesc());
         ps.setString(4,u.getim());
         ps.setString(5,u.getbr());
         ps.setString(6,u.getqua());
         ps.setString(7,u.getpr());
         ps.setString(8,u.getram());
         ps.setString(9,u.getrom());
         ps.setString(10,u.getid());
         status=ps.executeUpdate();
         }}catch(SQLException ex){}
         return status;}}
