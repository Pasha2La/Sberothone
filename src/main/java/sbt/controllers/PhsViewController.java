package sbt.controllers;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sbt.auth.AuthService;
import sbt.dao.DaoImpl;
import sbt.dao.model.Account;
import sbt.data.BaseInfo;

import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * Created by durachenko-sv on 26.01.2019.
 */
@Controller
public class PhsViewController {
    private static final Logger logger = Logger.getLogger(PhsViewController.class);

    @Autowired
    AuthService authService;

    @Autowired
    DaoImpl dao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, Principal principal) {
        return "index";
    }

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public String auth(Model model, Principal principal) {
        return "auth";
    }

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String account(@CookieValue String jwt, Model model) {
        if(jwt==null) return "auth";
        try {
            authService.verifyJWT(jwt);

            JWSObject jwsObject = JWSObject.parse(jwt);
            String login = jwsObject.getPayload().toJSONObject().get("login").toString();
            Account user = dao.getAccountByLogin(login);
            model.addAttribute("userInfo", user);
            return "account";
        } catch (UnsupportedEncodingException | JOSEException | ParseException e) {
            logger.error("Error while access to account...", e);
            return "auth";
        }
    }

    @RequestMapping("/")
    public String getCategories(Model model) {
        model.addAttribute("productList", dao.getProductRepository().findAll());
        model.addAttribute("categoryList", dao.getCategoryRepository().findAll());
        return "index";
    }
}
