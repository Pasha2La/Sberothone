package sbt.data;

public class LoginInfo {

    private String login;
    private String password;

    public LoginInfo() {
    }

    public LoginInfo(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public String toString() {
        return "LoginInfo{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) { this.login = login; }

    public void setPassword(String password) { this.password = password; }
}
