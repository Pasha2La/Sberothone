package sbt.dao.model;

import org.apache.log4j.Logger;

import java.sql.Timestamp;

public class Account {

    private Long id;
    private String login;
    private String password;
    private Boolean isPayed;
    private Timestamp expireDate;

    public Account() {
    }

    public Account(Long id, String login, String password, Boolean isPayed, Timestamp expireDate) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.isPayed = isPayed;
        this.expireDate = expireDate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", isPayed=" + isPayed +
                ", expireDate=" + expireDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getPayed() {
        return isPayed;
    }

    public Timestamp getExpireDate() {
        return expireDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPayed(Boolean payed) {
        isPayed = payed;
    }

    public void setExpireDate(Timestamp expireDate) {
        this.expireDate = expireDate;
    }
}
