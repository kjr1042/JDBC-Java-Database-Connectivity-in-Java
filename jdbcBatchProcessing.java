package firstjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class jdbcBatchProcessing {
	private static Connection connection;
	private static PreparedStatement pstmt;

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		String url="jdbc:mysql://localhost:3306/advancedjava";
		String username ="root";
		String password ="root";
		String sql="insert into `employeejdbc` (`id`,`name`,`email`,`dept`,`salary`)"
				+ " values(?,?,?,?,?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,username,password);
			pstmt =connection.prepareStatement(sql);
			
			String choice=null;
			do
			{
				System.out.println("Enter the id: ");
				pstmt.setInt(1, scan.nextInt());
				
				System.out.println("Enter the name: ");
				pstmt.setString(2, scan.next());
				
				System.out.println("Enter the email: ");
				pstmt.setString(3, scan.next());
				
				System.out.println("Enter the department: ");
				pstmt.setString(4, scan.next());
				
				System.out.println("Enter the salary: ");
				pstmt.setInt(5, scan.nextInt());
				
				pstmt.addBatch();
				
				System.out.println("Do you want to update details of more Employees(Yes/No)");
				choice=scan.next();
			}
			while(choice.equalsIgnoreCase("yes"));
			
		int ar[]=pstmt.executeBatch();
		
		for(int i:ar)
		{
			System.out.println(i);
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
