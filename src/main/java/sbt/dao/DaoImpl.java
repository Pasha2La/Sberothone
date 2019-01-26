package sbt.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import sbt.dao.repository.*;
import sbt.data.LoginInfo;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Repository
public class DaoImpl extends JdbcDaoSupport implements Dao {
    private static final Logger logger = Logger.getLogger(DaoImpl.class);

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AccountRepository account;
    @Autowired
    private AccountReceiptRepository accountReceiptRepository;
    @Autowired
    private ProductReceiptRepository productReceiptRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ReceiptCategoryRepository receiptCategoryRepository;
    @Autowired
    private ReceiptRepository receiptRepository;


    /*
        logger.info("post construct");
        logger.error("post construct");
        logger.error("post construct",e );
     */

    @PostConstruct
    public void postConstruct() {
        setDataSource(dataSource);
    }


}
