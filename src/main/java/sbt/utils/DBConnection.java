package sbt.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

/**
 * Created by durachenko-sv on 26.01.2019.
 */
public class DBConnection {

    private static Connection connection = null;
    private static String URL = "jdbc:sqlserver://chenko-server.database.windows.net:1433;DatabaseName=MyDataBase";
    private static final String DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String USER = "chenko";
    private static final String PASSWORD = "8x725#32250";

    public static Connection getInstance() throws SQLException {
        if (connection == null) {
            try {
                Class.forName(DRIVER_CLASS);
                DriverManager.registerDriver(new SQLServerDriver());
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
