package sbt.dao;

import sbt.data.Account;
import sbt.data.LoginInfo;
import sbt.data.Service;
import sbt.data.Transfer;

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

    Service getService();
    boolean createService();
    boolean updateService();
    boolean deleteService();

    Transfer getTransfer();
    boolean createTransfer();
    boolean updateTransfer();
    boolean deleteTransfer();
}
