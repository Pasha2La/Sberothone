package sbt.controllers;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import sbt.auth.AuthService;
import sbt.data.LoginInfo;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by durachenko-sv on 26.01.2019.
 */
@RestController
//ToDo filter
public class PhsRestController {
    private static final Logger logger = Logger.getLogger(PhsRestController.class);

    @Autowired
    AuthService authService;

    @RequestMapping("/login")
    public String login(@RequestBody LoginInfo loginInfo, HttpServletResponse response) {
        try {
            String token = authService.authenticate(loginInfo);
            Cookie jwt = new Cookie("jwt", token);
            response.addCookie(jwt);
            JSONObject resp = new JSONObject();
            resp.append("code", 200);
            return resp.toString();
        } catch (Exception e) {
            logger.error(String.format("Error while authentication user %s", loginInfo.getLogin()), e);
            return String.format("{\"code\":500,\"error\":\"%s\"}", e.getMessage());
        }
    }
}