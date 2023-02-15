
package LaptopPackage;
import java.sql.*;
import java.util.Date;
import static LaptopPackage.Provider.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class UserDao {
    private static Object Userdao;
    private static Connection getConnection(){
    Connection con=null;
    try{
            Class.forName(DRIVER);
            con=DriverManager.getConnection(CONNECTION_URL,USERNAME,PASSWORD);}
        catch(ClassNotFoundException | SQLException e){}
        return con;}
    
public static boolean validate(String name,String pass) 
    {
        boolean st = false;
        try {
           try(Connection con= UserDao.getConnection())
           {PreparedStatement ps=con.prepareStatement("select * from user where Email_Id=? and Password=?");
            ps.setString(1, name);
            ps.setString(2, pass);
            ResultSet rs =ps.executeQuery();
            st = rs.next();}}
        catch(SQLException e) {}
        return st;                 
    } 
    
public static int reg(User u)
    { 
    int status1=0;
    try{ Connection con=ConnectionProvider.getCon();
       PreparedStatement ps;
        ps=con.prepareStatement("INSERT INTO User VALUES(?,?,?,?,?,?,?)");
       ps.setString(1,u.getemail());
          ps.setString(2,u.getn());
           ps.setString(3,u.getnum());
            ps.setString(4,u.getpass());
             ps.setString(5,u.getadd());
              ps.setString(6,u.getpin());
               ps.setString(7,u.getstate());
               status1=ps.executeUpdate();
    }catch(SQLException e){} 
return status1;
    }
    
public static int AddCart(String Email_id,String Product_name,int Product_id,int Quantity,int Price,int Total_Amount) throws SQLException {
    	int status =0;
    	Connection con = UserDao.getConnection();
    	PreparedStatement ps = con.prepareStatement("INSERT INTO cart(Email_id,Product_name,Product_id,Quantity,Price,Total_Amount) VALUES(?,?,?,?,?,?)");
    	ps.setString(1, Email_id);
    	ps.setString(2, Product_name);
    	ps.setInt(3, Product_id);
    	ps.setInt(4,Quantity );
    	ps.setInt(5, Price);
    	ps.setInt(6, Total_Amount);
    	status = ps.executeUpdate();
    	return status;}
  
public static int UpdateAddCart(int Quantity,int Total_Amount,int cart_id) throws SQLException {
    	int status =0;
    	Connection con = UserDao.getConnection();
    	PreparedStatement ps = con.prepareStatement("UPDATE cart SET Quantity=?,Total_Amount=? WHERE cart_id='"+cart_id+"'");
    	ps.setInt(1, Quantity);
    	ps.setInt(2, Total_Amount);
    	status = ps.executeUpdate();
         System.out.println("Dao Cart update " + cart_id);
    	return status;}
  
private static void updateProductQuantity(int product_id, int quantity) throws SQLException {
	int Quantity=0;
	Connection con =UserDao.getConnection();
	Statement st =con.createStatement();
	   ResultSet rs = st.executeQuery("SELECT * FROM product WHERE Product_id='"+product_id+"'");
	   if(rs.next()) { Quantity = rs.getInt(6);}
	   Quantity = Quantity-quantity;
	   PreparedStatement ps = con.prepareStatement("UPDATE product SET Quantity=? WHERE Product_id='"+product_id+"'");
       ps.setInt(1, Quantity);
       ps.executeUpdate();}
    
public static int removeProduct(int str)
  {int status=0;
     try{
         try(Connection con= UserDao.getConnection())
         {PreparedStatement ps=con.prepareStatement("delete from cart where Product_id=?");
         
         ps.setInt(1,str);
         status=ps.executeUpdate();
         }
         }catch(SQLException e){}
         return status;}
  
public static int payment(String Mode,String Email_id,String Card_no,String Card_name,
	String Expiry_date,String Cvv_no,int Paid_amount,boolean IssingleProduct,int product_id ) throws SQLException {
	int status =0;
	Connection con = UserDao.getConnection();
	String pattern = "dd/MM/yyyy HH:mm:ss";
	DateFormat df = new SimpleDateFormat(pattern);
	Date today = Calendar.getInstance().getTime();
	String Date = df.format(today);
	PreparedStatement ps = con.prepareStatement("INSERT INTO payment(Mode,Email_id,Card_no,Card_name,Expiry_date,Cvv_no,Paid_amount,Date) VALUES(?,?,?,?,?,?,?,?)");
	ps.setString(1, Mode);
	ps.setString(2, Email_id);
	ps.setString(3, Card_no);
	ps.setString(4, Card_name);
	ps.setString(5, Expiry_date);
	ps.setString(6, Cvv_no);
	ps.setInt(7, Paid_amount);
	ps.setString(8, Date);
	status = ps.executeUpdate();
	if(status>0) {if(IssingleProduct) {
            int Product_id=0;
			status = order(1,product_id,Email_id,Product_id);
		}else {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM cart WHERE Email_id='"+Email_id+"'");
		int quantity =0;
		int Product_id=0;
		   while(rs.next()) {
			quantity = rs.getInt(5);
			product_id = rs.getInt(4);
			status = order(quantity,product_id,Email_id,Product_id);}}}
        PreparedStatement pst=con.prepareStatement("DELETE FROM cart WHERE Email_id='"+Email_id+"'");
			pst.executeUpdate();
                       return status;}
  
public static int order(int Quantity,int Product_id,String Email_id,int cart) throws SQLException {
	   int status =0;
	   Connection con = UserDao.getConnection();
	   String pattern = "dd/MM/yyyy HH:mm:ss";
	   DateFormat df = new SimpleDateFormat(pattern);
	   Date today = Calendar.getInstance().getTime();
	   String Date = df.format(today);
	   Statement st = con.createStatement();
	   ResultSet rs = st.executeQuery("SELECT * FROM user WHERE Email_id='"+Email_id+"'");
	   String Address="";
	   int Payment_id =0;
	   if(rs.next())
	   {Address=rs.getString(5);}
	   Statement st1 = con.createStatement();
	   ResultSet rs1 = st1.executeQuery("SELECT MAX(Payment_id) FROM payment WHERE Email_id='"+Email_id+"'");
	   if(rs1.next()) {Payment_id = rs1.getInt(1); }
	   PreparedStatement ps = con.prepareStatement("INSERT INTO orders(Product_id,Address,Quantity,Date,Payment_id) VALUES(?,?,?,?,?)");
	   ps.setInt(1, Product_id);
	   ps.setString(2, Address);
	   ps.setInt(3, Quantity);
	   ps.setString(4, Date);
	   ps.setInt(5, Payment_id);
	   status = ps.executeUpdate();
	   if(status>0) {updateProductQuantity(Product_id,Quantity);}
	   return status;}

public static int removeOrder(int str)
    {int status=0;
     try{
         try(Connection con= UserDao.getConnection())
         {PreparedStatement ps=con.prepareStatement("delete from orders where Order_id=?");
         ps.setInt(1,str);
         status=ps.executeUpdate();
         }}catch(SQLException e){}
         return status;}
  
public static int addFeed(String Email_id,String Name,String Feed) throws SQLException {
    	int status =0;
    	Connection con = UserDao.getConnection();
    	PreparedStatement ps = con.prepareStatement("INSERT INTO feedback(Email_id,User_name,Comment) VALUES(?,?,?)");
    	ps.setString(1, Email_id);
    	ps.setString(2, Name);
    	ps.setString(3, Feed);
    	status = ps.executeUpdate();
    	return status;}}