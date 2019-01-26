package sbt.utils;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by durachenko-sv on 26.01.2019.
 */
@Configuration
public class DBConnection {
    private static final Logger logger = Logger.getLogger(DBConnection.class);


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
