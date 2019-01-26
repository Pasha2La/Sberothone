package sbt.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sbt.dao.DaoImpl;

import java.security.Principal;
import java.util.List;

/**
 * Created by durachenko-sv on 26.01.2019.
 */
@Controller
public class PhsViewController {
    private static final Logger logger = Logger.getLogger(PhsViewController.class);


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
    public String account(@RequestParam(value = "login") String login, Model model) {
        return "account";
    }

}
