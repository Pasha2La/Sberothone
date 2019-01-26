package sbt.data;

public class LoginInfo {

    private final String login;
    private final String password;

    public LoginInfo(final String login, final String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
