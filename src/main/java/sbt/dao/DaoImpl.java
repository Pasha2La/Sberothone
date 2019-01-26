package sbt.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

@Component
public class DaoImpl extends JdbcDaoSupport implements Dao {
    private static final Logger logger = Logger.getLogger(DaoImpl.class);

    @Autowired
    private DataSource dataSource;

    /*
        logger.info("post construct");
        logger.error("post construct");
        logger.error("post construct",e );
     */

    @PostConstruct
    public void postConstruct() {
        logger.error("post construct");

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
