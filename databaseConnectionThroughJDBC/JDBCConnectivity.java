package databaseConnectionThroughJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectivity
{
    /**
     * Creates connection to MySQL database 
     * @param userName username
     * @param password password
     * @param database database name
     * @return
     */
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
