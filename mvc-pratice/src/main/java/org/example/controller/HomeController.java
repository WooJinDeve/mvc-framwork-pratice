package org.example.controller;

import org.example.annotation.Controller;
import org.example.annotation.RequestMapping;
import org.example.support.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        return "home";
    }
}
