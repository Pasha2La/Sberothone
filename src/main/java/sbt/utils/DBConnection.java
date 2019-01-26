package sbt.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.ConnectionPoolDataSource;
import javax.sql.DataSource;
import javax.xml.crypto.Data;

/**
 * Created by durachenko-sv on 26.01.2019.
 */
@Configuration
public class DBConnection {

    @Value("${db.url}")
    private String url;

    @Value("${db.baseName}")
    private String baseName;

    @Value("${db.user}")
    private String user;

    @Value("${db.password}")
    private String password;

    @Value("${driver.class.name}")
    private String driverClassName;


    @Bean
    public HikariDataSource dataSource() {
        final HikariDataSource ds = new HikariDataSource();

        ds.setMaximumPoolSize(10);
        ds.setDriverClassName(driverClassName);
        ds.setJdbcUrl(url);
        ds.setUsername(user);
        ds.setPassword(password);
        return ds;
    }


}
