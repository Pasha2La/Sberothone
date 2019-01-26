package sbt.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import sbt.data.Account;
import sbt.data.LoginInfo;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Repository
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
        setDataSource(dataSource);

    }

    @Override
    public Account getAccount() {
        return null;
    }

    @Override
    public boolean createAccount() {
        return false;
    }

    @Override
    public boolean updateAccount() {
        return false;
    }

    @Override
    public boolean deleteAccount() {
        return false;
    }

    @Override
    public LoginInfo getLoginInfo() {
        return null;
    }

    @Override
    public boolean createLoginInfo() {
        return false;
    }

    @Override
    public boolean updateLoginInfo() {
        return false;
    }

    @Override
    public boolean deleteLoginInfo() {
        return false;
    }
}
