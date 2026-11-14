package databaseapplivation;
import java.sql.*;
import java.util.*;

public class Week11program {
    
   static final String DB_URL = "jdbc:mysql://localhost:3306/cmrit";
   static final String USER = "root";
   static final String PASS = "";

   public static void main(String[] args) {
        
      // Open a connection
      try
      {
          Class.forName("com.mysql.jdbc.Driver");
      Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
         Scanner sc =new Scanner(System.in);
         System.out.println("entr choice"); 
         System.out.println("i:insert,u:update,d:delete,s:select"); 
         String ch=sc.next();
          switch(ch) {
              case "i":
              {     
            System.out.println("Inserting records into the table...");    
         String email="aaaab",pass="bbbbc",username="ccccd",address="eeeef";
         int phno=123;
         
        PreparedStatement ps=conn.prepareStatement("INSERT INTO login VALUES (?, ?,?, ?, ?)");
        ps.setString(1,email);  
        ps.setString(2,pass); 
        ps.setString(3,username);
        ps.setString(4,phno);
        ps.setInt(5,address);
        int i=ps.executeUpdate(); 
        
         System.out.println("Inserted records into the table..."); 
         break;
              }
              case "u":
              {
         String sql = "UPDATE login " +
            "SET username = 'yyyyy' WHERE phno in (123)";
         stmt.executeUpdate(sql);
         break;
              }
              case "d":
              {
         int result=stmt.executeUpdate("delete from login where phno=123");  
         System.out.println(result+" records affected"); 
         break;
              }
              case "s":
              {
         ResultSet rs=stmt.executeQuery("select * from login");  
         while(rs.next())  
         System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getInt(4)+"  "+rs.getString(5)); 
         break;
              }
          default:
          {
            System.out.println("enter correct choice");   
          }
          }
      } catch (Exception e) {
         e.printStackTrace();
      } 
   }
}