package com.sample.login.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by juliusneria on 23/10/2017.
 */
@Controller
public class MainController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String homepage(){
        return "index";
    }

}