package sbt.dao;

import sbt.dao.model.Account;
import sbt.data.LoginInfo;

import java.util.List;

public interface Dao {
    List<Account> example();
    Account getAccountByLogin(String login);
}
