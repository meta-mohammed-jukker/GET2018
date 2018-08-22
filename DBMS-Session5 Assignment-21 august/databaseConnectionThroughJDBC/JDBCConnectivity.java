package databaseConnectionThroughJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectivity
{
    public static Connection getMysqlConnection(String userName, String password, String database) 
    {
        Connection connection = null;
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/" + database;
            
            connection = DriverManager.getConnection(url, userName, password);
        } 
        catch (ClassNotFoundException e) 
        {
            e.printStackTrace();
            System.exit(1);
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
            System.exit(2);
        }
        return connection;
    }
}