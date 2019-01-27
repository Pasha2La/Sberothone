package sbt.auth;

import com.auth0.jwt.algorithms.Algorithm;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACVerifier;
import org.apache.log4j.Logger;
import com.auth0.jwt.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sbt.dao.Dao;
import sbt.dao.model.Account;
import sbt.data.LoginInfo;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;

@Service
public class AuthService {
    private static final Logger logger = Logger.getLogger(AuthService.class);

    @Autowired
    private Dao dao;

    @Value("${jwt.secret}")
    private String secret;

    public String authenticate(LoginInfo info) throws UnsupportedEncodingException {
        logger.info(String.format("Starting authenticating of user: %s", info.getLogin()));
        Account user = dao.getAccountByLogin(info.getLogin());
        String token = genJWT(user);
        return token;
    }

    private String genJWT(Account user) throws UnsupportedEncodingException {
        logger.info(String.format("Generating JWT token for user: %s", user.getLogin()));

        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create()
                .withClaim("login", user.getLogin())
                .withClaim("expireDate", user.getExpireDate())
                .sign(algorithm);
    }

    public boolean verifyJWT(String jwt) throws UnsupportedEncodingException, ParseException, JOSEException {
        logger.info("Verifying JWT token ");
        JWSObject jwsObject = JWSObject.parse(jwt);
        JWSVerifier verifier = new MACVerifier(secret);
        return jwsObject.verify(verifier);
    }
}
