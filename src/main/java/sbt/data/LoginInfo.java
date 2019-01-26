package sbt.data;

import org.apache.log4j.Logger;

public class LoginInfo {
    private static final Logger logger = Logger.getLogger(LoginInfo.class);


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
