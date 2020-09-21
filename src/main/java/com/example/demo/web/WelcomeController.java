package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;


@RestController
public class WelcomeController {

    private static final Logger LOG = Logger.getLogger(WelcomeController.class.getName());

    @RequestMapping(path="/{course}", produces={"application/json"})
    public ModelAndView welcome(@PathVariable("course") String course) {
        
        ModelAndView model = new ModelAndView("index");
        String message = "Today's (" + new Date() +") class is on " + course;
        model.addObject("message", message);
        LOG.log(Level.INFO, message);
        return model;
    }
}
