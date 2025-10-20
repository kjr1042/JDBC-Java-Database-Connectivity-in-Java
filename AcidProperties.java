import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AcidProperties {

    public  static Scanner sc = new Scanner(System.in);

    public static Connection connection = null;
    public static PreparedStatement preparedStatement = null;

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/JdbcDemo";
        String userName = "postgres";
        String password = "root";

        try
        {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, userName, password);
            connection.setAutoCommit(false);
            transaction();
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw new RuntimeException(e);
        }

    }

    private static boolean isConfirm(int x,int y) {
        System.out.println("Do you want to confirm(yes/no)");
        String choice = sc.next();
        return choice.equalsIgnoreCase("yes") && x == 1 && y == 1;
    }

    public static void transaction() throws SQLException {
        System.out.println("Enter the sender");
        String sender = sc.next();

        System.out.println("Enter the receiver");
        String receiver = sc.next();

        System.out.println("Enter the amount");
        int amount = sc.nextInt();

        int x = updateBalance(sender, -amount);
        int y = updateBalance(receiver, amount);

        if(isConfirm(x,y))
        {
            connection.commit();
            System.out.println("Transaction Successful...");
        }
        else
        {
            connection.rollback();
            System.out.println("Transaction Failed...");
        }
    }

    public static int updateBalance(String user, int amount) throws SQLException {

        String sql = "update employee set salary = salary + ? where name = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,amount);
        preparedStatement.setString(2,user);
        return preparedStatement.executeUpdate();
    }

}
