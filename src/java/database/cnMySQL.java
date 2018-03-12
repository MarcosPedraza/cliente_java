/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author root
 */
public class cnMySQL {
    Connection connection = null;
    static cnMySQL instance = null;
    public cnMySQL() throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddatos","root","Mike9593");
    
    }
    public static cnMySQL getInstance() throws Exception
    {
        if(instance == null)
        {
            instance = new cnMySQL();
        }
        return instance;
    }
   // @override
    public void finalize() throws Exception
    {
        if(connection.isClosed())
        {
            connection = null;
            connection.isClosed();
        }
    }
    public Connection getConnection()
    {
        return connection;
    }
}
