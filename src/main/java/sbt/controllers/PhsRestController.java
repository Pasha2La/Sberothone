package sbt.controllers;

import com.nimbusds.jose.JOSEException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import sbt.auth.AuthService;
import sbt.dao.DaoImpl;
import sbt.data.BaseInfo;
import sbt.data.LoginInfo;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by durachenko-sv on 26.01.2019.
 */
@RestController
//ToDo filter
public class PhsRestController {
    private static final Logger logger = Logger.getLogger(PhsRestController.class);

    @Autowired
    private AuthService authService;

    @Autowired
    DaoImpl dao;

    @RequestMapping("/login")
    public String login(@RequestBody LoginInfo loginInfo, HttpServletResponse response) {
        try {
            String token = authService.authenticate(loginInfo);
            Cookie jwt = new Cookie("jwt", token);
            response.addCookie(jwt);
            JSONObject resp = new JSONObject();
            int code = 200;
            resp.append("code", code);
            return resp.toString();
        } catch (Exception e) {
            logger.error(String.format("Error while authenticating user: %s", loginInfo.getLogin()), e);
            return "{\"code\":500,\"error\":\"" + e.getMessage() + "\"}";
        }
    }

    @RequestMapping("/logout")
    public String logout(@RequestBody LoginInfo info, HttpServletResponse response) {
        try {
            String token = authService.authenticate(info);

            Cookie jwtRemove = new Cookie("jwt", token);
            jwtRemove.setMaxAge(0);
            response.addCookie(jwtRemove);
        } catch (Exception e) {
            logger.error("Can't logout user" + e.getMessage());
            return "{\"code\":500,\"error\":\"" + e.getMessage() + "\"}";
        }

        JSONObject resp = new JSONObject();
        resp.append("code", 200);
        return resp.toString();
    }

    @RequestMapping("/verifyToken")
    public String verifyToken(@CookieValue String jwt) {
        try {
            boolean b = authService.verifyJWT(jwt);
            if (b) {
                logger.info("Token is valid!");
                return "{\"code\":200}";
            } else {
                logger.info("Bad token!");
                return "{\"code\":500,\"error\":\"Bad token!\"}";
            }
        } catch (UnsupportedEncodingException | ParseException | JOSEException e) {
            logger.error(String.format("Error while verifying JWT: %s", jwt), e);
            return "{\"code\":500,\"error\":\"" + e.getMessage() + "\"}";
        }

    }

/*
    @RequestMapping("/")
    public String search(@RequestParam(value = "products") List<String> products,
                              @RequestParam(value = "categories") List<String> categories,
                              @RequestParam(value = "healthy") String healthy) {
        dao.getRec
    }
*/

    @RequestMapping("/")
    public BaseInfo getCategories() {
        return new BaseInfo(dao.getCategoryRepository().findAll(), dao.getProductRepository().findAll());
    }
}