package sbt;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import java.io.File;
import java.util.Properties;

/**
 * Created by durachenko-sv on 26.01.2019.
 */
@SpringBootApplication
@PropertySource("classpath:application.properties")
public class Application {

    @Value("log4j.properties")
    public void initLog4j(Properties props) {
        PropertyConfigurator.configure(props);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}