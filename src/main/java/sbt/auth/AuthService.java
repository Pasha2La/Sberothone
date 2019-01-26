package sbt.auth;

import com.auth0.jwt.algorithms.Algorithm;
import org.apache.log4j.Logger;
import com.auth0.jwt.JWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sbt.data.Account;
import sbt.data.LoginInfo;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;

@Service
public class AuthService {
    private static final Logger logger = Logger.getLogger(AuthService.class);

    @Value("${jwt.secret}")
    private String secret;

    public String authenticate(LoginInfo info) throws UnsupportedEncodingException {
        logger.info("authenticating...");
        Account user = new Account();

        user.setLogin("ololo");
        user.setPassword("olololololol");
        user.setExpireDate(new Timestamp(0));
        //ToDo request to DB for user Account

        String token = null;
        token = genJWT(user);
        return token;
    }

    private String genJWT(Account user) throws UnsupportedEncodingException {
        logger.info("generating JWT token...");
        String token = null;
        Algorithm algorithm = Algorithm.HMAC256(secret);
        token = JWT.create()
                .withClaim("login", user.getLogin())
                .withClaim("expireDate", user.getExpireDate())
                .sign(algorithm);
        return token;
    }
}
