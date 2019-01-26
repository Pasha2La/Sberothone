package sbt.data;

import org.apache.log4j.Logger;

import java.sql.Timestamp;

public class Account {

    private static final Logger logger = Logger.getLogger(Account.class);

    private String login;
    private String password;

    public Account() {
    }

    private Timestamp expireDate;

    public Account(String login, String password, Timestamp expireDate) {
        this.login = login;
        this.password = password;
        this.expireDate = expireDate;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) { this.login = login; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) { this.password = password; }

    public Timestamp getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Timestamp expireDate) {
        this.expireDate = expireDate;
    }
}
