package sbt.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import sbt.dao.model.*;
import sbt.dao.repository.*;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

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
