package sbt.dao;

import sbt.dao.model.Account;
import sbt.dao.model.Product;
import sbt.dao.model.Receipt;

import java.util.List;
import java.util.Optional;

public interface Dao {
    List<Account> example();


    void update(String sqlCommand);

    Account getAccountByLogin(String login);

    Optional<Receipt> getByIdReceipt(Long id);

    List<Receipt> getSortByView();

    List<Receipt> getAvailableReceipts(String healthy, String category);

    List<Receipt> getAvailableReceipts(List<Product> products);
}
