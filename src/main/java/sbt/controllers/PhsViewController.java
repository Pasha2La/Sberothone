package sbt.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sbt.dao.DaoImpl;
import sbt.data.BaseInfo;

import java.security.Principal;
import java.util.List;
import java.util.Map;

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
    public String account(Model model) {
        return "account";
    }

    @RequestMapping("/")
    public String getCategories(Model model) {
        model.addAttribute("productList", dao.getProductRepository().findAll());
        model.addAttribute("categoryList", dao.getCategoryRepository().findAll());
        return "index";
    }
}
