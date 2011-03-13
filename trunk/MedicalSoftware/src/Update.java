package MedicalSoftware;

import java.sql.*;
import java.util.Properties;

public class Update
{
 private static final String dbClassName = "com.mysql.jdbc.Driver";


 private static final String CONNECTION =
                         "jdbc:mysql://127.0.0.1/medical";

 public static void main(String[] args) throws
                            ClassNotFoundException,SQLException, InstantiationException, IllegalAccessException
 {
	 String dbdriver = "org.gjt.mm.mysql.Driver";
   System.out.println(dbClassName);
   Class.forName(dbdriver).newInstance(); 
   Properties p = new Properties();
   p.put("user","root");
   p.put("password","miniserver");

   // Now try to connect
   Connection c = DriverManager.getConnection(CONNECTION,p);

   System.out.println("It works!");
   c.close();
   }
}