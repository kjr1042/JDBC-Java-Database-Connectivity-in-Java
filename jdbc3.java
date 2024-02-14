package firstjdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class jdbc3 {
	private static Connection connection;
	private static Statement statement;

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/advancedjava";
		String username ="root";
		String password ="root";
		String sql="update `employeejdbc` set `salary`=`salary`+500 where `dept`='TR'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,username,password);
			statement=connection.createStatement();
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
