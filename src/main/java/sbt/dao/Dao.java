package sbt.dao;

import sbt.data.Account;
import sbt.data.LoginInfo;

import java.util.List;

public interface Dao {
    Account getAccount();

    boolean createAccount();

    boolean updateAccount();

    boolean deleteAccount();


    LoginInfo getLoginInfo();

    boolean createLoginInfo();

    boolean updateLoginInfo();

    boolean deleteLoginInfo();
}
