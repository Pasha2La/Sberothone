package sbt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

@Component
public class Dao extends JdbcDaoSupport {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void postConstruct() {
        setDataSource(dataSource);
        List<String> list = getJdbcTemplate().query(
                "SELECT '1' as test_value",
                (resultSet, i) -> resultSet.getString(1));

        for (String string : list) {
            if (string.equals("1"))
                System.out.println("GOOD DB CONNECTION");
        }
    }

}
