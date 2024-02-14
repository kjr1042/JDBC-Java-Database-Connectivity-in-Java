package firstjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class jdbcPreparedStatement1 {
	private static Connection connection;
	private static PreparedStatement pstmt;

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		String url="jdbc:mysql://localhost:3306/advancedjava";
		String username ="root";
		String password ="root";
		String sql="update `employeejdbc` set `salary` = `salary` + ? where `dept` = ?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,username,password);
			pstmt =connection.prepareStatement(sql);
			System.out.println("Enter the salary: ");
			pstmt.setInt(1, scan.nextInt());
			System.out.println("Enter the Department: ");
			pstmt.setString(2, scan.next());
			int i =pstmt.executeUpdate();
			System.out.println(i);
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
