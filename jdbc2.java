package firstjdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class jdbc2 {
	private static Connection connection;
	private static Statement statement;
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/advancedjava";
		String username="root";
		String password="root";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,username,password);
			statement=connection.createStatement();
			String sql="insert into `employeejdbc`"
					+ "(`id`,`name`,`email`,`dept`,`salary`) values"
					+ "(7,'aliya','aliya@gmail.com','TR',2345)";
			int i=statement.executeUpdate(sql);
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
