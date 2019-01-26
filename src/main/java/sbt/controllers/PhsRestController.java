package sbt.controllers;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    private AuthService authService;

    @RequestMapping("/login")
    public String login(@RequestBody LoginInfo loginInfo, HttpServletResponse response) {
        try {
            String token = authService.authenticate(loginInfo);

            Cookie jwt = new Cookie("jwt", token);
            response.addCookie(jwt);
        } catch (Exception e) {
            logger.error("error while doing login...", e);
            return "{\"code\":500,\"error\":\"" + e.getMessage() + "\"}";
        }

        JSONObject resp = new JSONObject();
        resp.append("code", 200);
        return resp.toString();
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
}
