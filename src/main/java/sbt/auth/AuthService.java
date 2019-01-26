package sbt.auth;

import com.auth0.jwt.algorithms.Algorithm;
import org.apache.log4j.Logger;
import com.auth0.jwt.JWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sbt.data.Account;
import sbt.data.LoginInfo;

import java.io.UnsupportedEncodingException;

@Service
public class AuthService {
    private static final Logger logger = Logger.getLogger(AuthService.class);

    @Value("${jwt.secret}")
    private String secret;

    public String authenticate(LoginInfo info) {
        logger.info("authenticating...");
        Account user = null;

        //ToDo request to DB for user Account

        String token = null;

        return token;
    }

    public String genJWT(Account user) {
        logger.info("generating JWT token...");
        String token = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            token = JWT.create()
                    .withClaim("login", user.getLogin())
                    .withClaim("FirstName", user.getFirstName())
                    .withClaim("SecondName", user.getSecondName())
                    .withClaim("Surname", user.getSurname())
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            logger.error("error while generating JWT token:", e);
            e.printStackTrace();
        }
        return token;
    }
}
