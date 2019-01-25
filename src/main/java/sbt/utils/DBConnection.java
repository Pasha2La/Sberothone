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
    private static final String DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";


    public static Connection getInstance() throws SQLException {
        if (connection == null) {
            try {
                String host = PropertyProvider.getProperty("db.host");
                String dataBase = PropertyProvider.getProperty("db.baseName");
                String URL = "jdbc:sqlserver://" + host + ":1433;DatabaseName=" + dataBase;
                String USER =PropertyProvider.getProperty("db.user");
                String PASSWORD = PropertyProvider.getProperty("db.password");
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
