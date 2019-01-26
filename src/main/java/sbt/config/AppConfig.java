package sbt.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

@Configuration
@EnableJpaRepositories("sbt.dao.repository")
@EntityScan("sbt.dao.model")
@EnableTransactionManagement
public class AppConfig {

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

    @Value("${hibernate.dialect}")
    private String hibernateDialect;
    @Value("${hibernate.show_sql}")
    private String hibernateShowSql;
    @Value("${hibernate.format_sql}")
    private String hibernateFormatSql;
    @Value("${hibernate.id.new_generator_mappings}")
    private String newGeneratorMappings;


    @Bean
    public HikariDataSource hikariDataSource() {
        HikariDataSource ds = new HikariDataSource();

        ds.setDriverClassName(driverClassName);
        ds.setJdbcUrl(url);
        ds.setUsername(user);
        ds.setPassword(password);

        ds.setMaximumPoolSize(10);
        ds.setConnectionTestQuery("SELECT '1' as test_value");
        return ds;
    }

//    @Bean
//    public HikariDataSource dataSource() {
//        final HikariDataSource ds = new HikariDataSource();
//
//        ds.setDriverClassName(driverClassName);
//        ds.setJdbcUrl(url);
//        ds.setUsername(user);
//        ds.setPassword(password);
//
//        ds.setMaximumPoolSize(10);
//        ds.setConnectionTestQuery("SELECT '1' as test_value");
//        return ds;
//    }

    private Properties jpaProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", hibernateDialect);
        properties.put("hibernate.show_sql", hibernateShowSql);
        properties.put("hibernate.format_sql", hibernateFormatSql);
        properties.put("hibernate.id.new_generator_mappings", newGeneratorMappings);
        return properties;
    }

    @Bean(name="entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
        lcemfb.setJpaVendorAdapter(getJpaVendorAdapter());
        lcemfb.setDataSource(hikariDataSource());
        lcemfb.setPersistenceUnitName("myJpaPersistenceUnit");
        lcemfb.setPackagesToScan("sbt.dao");
        lcemfb.setJpaProperties(jpaProperties());
        return lcemfb;
    }
    @Bean(name="transactionManager")
    public PlatformTransactionManager txManager(){
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(
                getEntityManagerFactoryBean().getObject());
        return jpaTransactionManager;
    }

    @Bean
    public JpaVendorAdapter getJpaVendorAdapter() {
        JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        return adapter;
    }
}
