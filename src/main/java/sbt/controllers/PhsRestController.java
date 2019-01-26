package sbt.controllers;

import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by durachenko-sv on 26.01.2019.
 */
@RestController
//ToDo filter
public class PhsRestController {
    private static final Logger logger = Logger.getLogger(PhsRestController.class);

    @Autowired
    public PhsRestController() throws Exception {

    }

    @RequestMapping("/login")
    public String login(@RequestParam(value = "login") String loginStr,
                        @RequestParam(value = "password") String passwordStr) {
        String token = null;
        return token;
    }
}