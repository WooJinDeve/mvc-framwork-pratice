package org.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardController implements Controller{

    private final String forwardUri;

    public ForwardController(String forwardUri) {
        this.forwardUri = forwardUri;
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        return forwardUri;
    }
}
