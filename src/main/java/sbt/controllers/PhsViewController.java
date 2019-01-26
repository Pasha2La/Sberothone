package sbt.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * Created by durachenko-sv on 26.01.2019.
 */
@Controller
public class PhsViewController {
    private static final Logger logger = Logger.getLogger(PhsViewController.class);


    /*@Autowired
    public PhsViewController() throws Exception { ;}*/

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, Principal principal) {
        return "index";
    }

}
