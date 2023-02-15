package LaptopPackage;
import java.sql.*;
import static LaptopPackage.Provider.*;
public class ConnectionProvider {
    private static Connection con;
    static{
        try{
            Class.forName(DRIVER);
            con=DriverManager.getConnection(CONNECTION_URL,USERNAME,PASSWORD);}
        catch(ClassNotFoundException | SQLException e){}
    }
    public static Connection getCon()
    {return con;}}
