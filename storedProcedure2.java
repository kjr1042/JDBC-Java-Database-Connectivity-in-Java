package firstjdbc;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.*;
public class storedProcedure2 {
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
			prepareCall=connection.prepareCall("{call count_emp_sal(?)}");
			prepareCall.setInt(1, scan.nextInt());
			
			prepareCall.registerOutParameter(1, Types.INTEGER);
			prepareCall.execute();
			int i=prepareCall.getInt(1);
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
