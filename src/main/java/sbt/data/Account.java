package sbt.data;

import org.apache.log4j.Logger;

public class Account {
    private static final Logger logger = Logger.getLogger(Account.class);


    private int phoneNumber;

    private final String firstName;
    private final String secondName;
    private final String surname;

    private int balance;

    public Account(String firstName, String secondName, String surname) {
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
}
