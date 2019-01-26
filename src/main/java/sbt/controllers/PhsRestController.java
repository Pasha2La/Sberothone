package sbt.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by durachenko-sv on 26.01.2019.
 */
@RestController
//ToDo filter
public class PhsRestController {
    private static final Logger logger = Logger.getLogger(PhsRestController.class);


    @RequestMapping("/login")
    public String login() {
        String token = null;
        return token;
    }

    /*@Autowired
    public PhsRestController() throws Exception {;}*/
}