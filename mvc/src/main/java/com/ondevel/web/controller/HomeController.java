package com.ondevel.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author danielpo
 *         Date: 7/24/13
 *         Time: 11:28 AM
 */
@Controller
class HomeController {
    /**
     * Home controller.
     *
     * @param model - the model from UI
     * @return - the name of the view
     */
    @RequestMapping("/hello1")
    public String hello(final Model model) {
        model.addAttribute("hello", "my hello");

        return "index";
    }

    /**
     * Method returns a json serialized list.
     *
     * @return - the list
     */
    @RequestMapping("/hello")
    @ResponseBody
    public List<String> sayHello() {
        List<String> l = new ArrayList<String>();
        l.add("1234");
        l.add("ffgd");
        //ResponseEntity
        return l;
    }
}
