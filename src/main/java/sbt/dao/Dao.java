package sbt.dao;

import sbt.dao.model.Account;

import java.util.List;

public interface Dao {
    List<Account> example();

    void update(String sqlCommand);
}
