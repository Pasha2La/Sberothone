package sbt.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import sbt.dao.mapper.AccountMapper;
import sbt.dao.model.*;
import sbt.dao.repository.*;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
public class DaoImpl extends JdbcDaoSupport implements Dao {
    private static final Logger logger = Logger.getLogger(DaoImpl.class);

    @Autowired
    private DataSource hikariDataSource;

    @Autowired
    private AccountRepository accountRepository;
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
    @Autowired
    private CategoryRepository categoryRepository;


    /*
        logger.info("post construct");
        logger.error("post construct");
        logger.error("post construct",e );
     */

    @PostConstruct
    public void postConstruct() {
        setDataSource(hikariDataSource);

        example();

        //можно по id
        //accountRepository.deleteById(345L);

        //insert or update
        Account testAccount = new Account(
                "test",
                "pass",
                false,
                new Timestamp(Calendar.getInstance().getTimeInMillis())
        );
        accountRepository.save(testAccount);

        testAccount.setPassword("newPassword");
        accountRepository.save(testAccount);


        //delete
        accountRepository.delete(testAccount);


        Iterable<Account> accounts = accountRepository.findAll();

        for (Account account : accounts) {
            System.out.println(account);
        }

        Iterable<Receipt> receipts = receiptRepository.findAll();
        for (Receipt receipt : receipts) {
            System.out.println(receipt);
        }

        Iterable<Product> products = productRepository.findAll();
        for (Product product : products) {
            System.out.println(product);
        }

        Iterable<Category> categories = categoryRepository.findAll();
        for (Category category : categories) {
            System.out.println(category);
        }

        Iterable<AccountReceipt> accountReceipts = accountReceiptRepository.findAll();
        for (AccountReceipt accountReceipt : accountReceipts) {
            System.out.println(accountReceipt);
        }

        Iterable<ProductReceipt> productReceipts = productReceiptRepository.findAll();
        for (ProductReceipt productReceipt : productReceipts) {
            System.out.println(productReceipt);
        }

        Iterable<ReceiptCategory> receiptCategories = receiptCategoryRepository.findAll();
        for (ReceiptCategory receiptCategory : receiptCategories) {
            System.out.println(receiptCategory);
        }


    }

    @Override
    public List<Account> example() {
        String sql = "select * from sberfood_account where n_id = ?";
        List<Account> accounts = getJdbcTemplate().query(
                sql,
                new Object[]{1},
                new AccountMapper()

        );

        String sql1 = "select * from sberfood_account where n_id = 1";
        List<Account> accounts1 = getJdbcTemplate().query(
                sql1,
                (rs, rowNum) ->
                        new Account(
                                rs.getLong(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getBoolean(4),
                                rs.getTimestamp(5))


        );

        System.out.println(accounts);
        System.out.println(accounts1);

        return accounts;
    }

    public AccountRepository getAccountRepository() {
        return accountRepository;
    }

    public AccountReceiptRepository getAccountReceiptRepository() {
        return accountReceiptRepository;
    }

    public ProductReceiptRepository getProductReceiptRepository() {
        return productReceiptRepository;
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public ReceiptCategoryRepository getReceiptCategoryRepository() {
        return receiptCategoryRepository;
    }

    public ReceiptRepository getReceiptRepository() {
        return receiptRepository;
    }

    public CategoryRepository getCategoryRepository() {
        return categoryRepository;
    }
}
