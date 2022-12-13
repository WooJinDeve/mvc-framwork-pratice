package org.example.support;

import org.example.controller.Controller;
import org.example.support.adapter.HandlerAdapter;
import org.example.support.adapter.SimpleControllerHandlerAdapter;
import org.example.support.view.JspViewResolver;
import org.example.support.view.View;
import org.example.support.view.ViewResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(DispatcherServlet.class);
    private RequestMappingHandler requestMappingHandler;
    private List<HandlerAdapter> handlerAdapters;
    private List<ViewResolver> viewResolvers;

    @Override
    public void init() throws ServletException {
        requestMappingHandler = new RequestMappingHandler();
        requestMappingHandler.init();

        handlerAdapters = List.of(new SimpleControllerHandlerAdapter());
        viewResolvers = Collections.singletonList(new JspViewResolver());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("[DispatcherServlet] service started");

        try {
            Controller handler = requestMappingHandler.findHandler(new HandlerKey(RequestMethod.valueOf(request.getMethod()), request.getRequestURI()));
            String vueName = handler.handleRequest(request, response);

            HandlerAdapter handlerAdapter = handlerAdapters.stream()
                    .filter(ha -> ha.support(handler))
                    .findFirst()
                    .orElseThrow(() -> new ServletException("No adapter for handler [ " + handler + " ]"));

            ModelAndView modelAndView = handlerAdapter.handle(request, response, handler);

            for (ViewResolver viewResolver : viewResolvers) {
                View view = viewResolver.resolveView(modelAndView.getViewName());
                view.render(modelAndView.getModel(), request, response);
            }
        }catch (Exception e){
            log.error("exception : [{}]", e.getMessage());
        }
    }
}
