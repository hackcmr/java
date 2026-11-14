package databaseapplivation;

import java.sql.*;
import java.util.Scanner;

public class Week11program {
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cmrit", "root", "");
        Statement stmt = conn.createStatement();
        Scanner sc = new Scanner(System.in);

        System.out.println("i:insert, u:update, d:delete, s:select");
        switch (sc.next()) {
            case "i":
                PreparedStatement ps = conn.prepareStatement("INSERT INTO login VALUES (?, ?, ?, ?, ?)");
                ps.setString(1, "aaaab");
                ps.setString(2, "bbbbc");
                ps.setString(3, "ccccd");
                ps.setInt(4, 123);
                ps.setString(5, "eeeef");
                ps.executeUpdate();
                break;

            case "u":
                stmt.executeUpdate("UPDATE login SET username = 'yyyyy' WHERE phno = 123");
                break;

            case "d":
                stmt.executeUpdate("DELETE FROM login WHERE phno = 123");
                break;

            case "s":
                ResultSet rs = stmt.executeQuery("SELECT * FROM login");
                while (rs.next()) {
                    System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4) + " " + rs.getString(5));
                }
                break;

            default:
                System.out.println("Invalid choice");
        }
    }
}
