package sbt.data;

import org.apache.log4j.Logger;

public class Account {
    private static final Logger logger = Logger.getLogger(Account.class);


    private int phoneNumber;

    private final String login;
    private final String password;
    private final String firstName;
    private final String secondName;
    private final String surname;

    private int balance;

    public Account(String login, String password, String firstName, String secondName, String surname) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.secondName = secondName;
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getSurname() {
        return surname;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int getBalance() {
        return balance;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
