package firstjdbc;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class firstprogram1 {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/advancedjava";
		String username="root";
		String password="root";
		Connection connection =null;
		Statement statement =null;
		ResultSet result =null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection= DriverManager.getConnection(url,username,password);
			statement =connection.createStatement();
			result = displayEmployee(statement);
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(connection, statement, result);
		}
	}

	private static ResultSet displayEmployee(Statement statement) throws SQLException {
		ResultSet result;
		result =statement.executeQuery("select * from employeejdbc");
		while(result.next())
		{
			System.out.println(
			result.getInt("id") +"," +
			result.getString("name") +"," +
			result.getString("email") +"," +
			result.getString("dept") +"," +
			result.getInt("salary"));
		}
		return result;
	}

	private static void close(Connection connection, Statement statement, ResultSet result) {
		try {
			if(result != null)
			{
				result.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(statement != null)
			{
				statement.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(connection != null)
			{
				connection.close();
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
