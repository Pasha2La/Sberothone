package sbt.data;

public class Account {

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
