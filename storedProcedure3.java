package firstjdbc;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.*;

public class storedProcedure3 {
	public static Connection connection;
	public static CallableStatement prepareCall;


	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		String url="jdbc:mysql://localhost:3306/advancedjava";
		String username ="root";
		String password ="root";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,username,password);
			prepareCall=connection.prepareCall("{call display_emp(?)}");
			prepareCall.setInt(1, scan.nextInt());
			prepareCall.execute();
			ResultSet result =prepareCall.getResultSet();
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
