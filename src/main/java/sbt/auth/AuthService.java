package sbt.auth;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Verification;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.PlainJWT;
import org.apache.log4j.Logger;
import com.auth0.jwt.JWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sbt.dao.model.Account;
import sbt.data.LoginInfo;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.ParseException;

@Service
public class AuthService {
    private static final Logger logger = Logger.getLogger(AuthService.class);

    @Value("${jwt.secret}")
    private String secret;

    public String authenticate(LoginInfo info) throws UnsupportedEncodingException {
        logger.info("Authenticating...");
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
        logger.info("Generating JWT token...");
        String token = null;
        Algorithm algorithm = Algorithm.HMAC256(secret);
        token = JWT.create()
                .withClaim("login", user.getLogin())
                .withClaim("expireDate", user.getExpireDate())
                .sign(algorithm);
        return token;
    }

    public boolean verifyJWT(String jwt) throws UnsupportedEncodingException, ParseException, JOSEException {
        logger.info("Verifying JWT token...");
        JWSObject jwsObject = JWSObject.parse(jwt);
        JWSVerifier verifier = new MACVerifier(secret);
        return jwsObject.verify(verifier);
    }
}
