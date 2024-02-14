package firstjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class jdbcPreparedStatement {
	private static Connection connection;
	private static PreparedStatement pstmt;
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		String url="jdbc:mysql://localhost:3306/advancedjava";
		String username ="root";
		String password ="root";
		String sql ="select * from `employeejdbc` where `dept`=?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,username,password);
			pstmt =connection.prepareStatement(sql);
			System.out.println("Enter the Department: ");
			pstmt.setString(1,scan.next());
			ResultSet result=pstmt.executeQuery();
			
			while(result.next())
			{
				System.out.println(
				result.getInt("id") +"," +
				result.getString("name") +"," +
				result.getString("email") +"," +
				result.getString("dept") +"," +
				result.getInt("salary"));
			}
		} 
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
