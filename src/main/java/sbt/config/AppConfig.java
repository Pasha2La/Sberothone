package sbt.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public HikariDataSource dataSource(@Value("${db.url}") String url,
                                       @Value("${db.baseName}") String baseName,
                                       @Value("${db.user}") String user,
                                       @Value("${db.password}") String password,
                                       @Value("${driver.class.name}") String driverClassName) {
        final HikariDataSource ds = new HikariDataSource();

        ds.setMaximumPoolSize(10);
        ds.setDriverClassName(driverClassName);
        ds.setJdbcUrl(url);
        ds.setUsername(user);
        ds.setPassword(password);

        ds.setConnectionTestQuery("SELECT '1' as test_value");
        return ds;
    }
}
