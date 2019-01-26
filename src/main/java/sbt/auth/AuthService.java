package sbt.auth;

import com.auth0.jwt.algorithms.Algorithm;
import org.apache.log4j.Logger;
import com.auth0.jwt.JWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sbt.dao.model.Account;
import sbt.data.LoginInfo;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;

/**
 * @author
 */
@Service
public class AuthService {
    private static final Logger logger = Logger.getLogger(AuthService.class);

    @Value("${jwt.secret}")
    private String secret;

    public String authenticate(LoginInfo info) throws UnsupportedEncodingException {
        logger.info(String.format("Authenticate starting for user %s", info.getLogin()));
        Account user = new Account();

        user.setLogin("ololo");
        user.setPassword("olololololol");
        user.setExpireDate(new Timestamp(0));
        //ToDo request to DB for user Account

        String token = genJWT(user);
        return token;
    }

    private String genJWT(Account user) throws UnsupportedEncodingException {
        logger.info(String.format("Generating JWT token for user %s", user.getLogin()));
        String token = null;
        Algorithm algorithm = Algorithm.HMAC256(secret);
        token = JWT.create()
                .withClaim("login", user.getLogin())
                .withClaim("expireDate", user.getExpireDate())
                .sign(algorithm);
        return token;
    }
}
