package org.example.support;

import org.example.controller.Controller;
import org.example.controller.HomeController;
import org.example.controller.UserCreateController;
import org.example.controller.UserListController;

import java.util.HashMap;
import java.util.Map;

public class RequestMappingHandler {
    private Map<HandlerKey, Controller> mappings = new HashMap<>();

    void init(){
        mappings.put(new HandlerKey(RequestMethod.GET, "/"), new HomeController());
        mappings.put(new HandlerKey(RequestMethod.GET, "/users"), new UserListController());
        mappings.put(new HandlerKey(RequestMethod.POST, "/users"), new UserCreateController());
    }

    public Controller findHandler(HandlerKey key){
        return mappings.get(key);
    }
}
