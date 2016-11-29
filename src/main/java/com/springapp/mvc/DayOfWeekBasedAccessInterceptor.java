package com.springapp.mvc;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

/**
 * Created by jayson on 9/19/15.
 */
public class DayOfWeekBasedAccessInterceptor extends HandlerInterceptorAdapter {
    //This class is used to execute code before a MVC request is routed through the standard request handler in the controller.
    //The concept is introduced in tutorial 23. The class must extend HandlerInterceptorAdapter and override the preHandle.
    //The function has access to the response object and can add a custom response.

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean returnVal = false;
        Calendar cal = Calendar.getInstance();

        int dayOfWeek = cal.get(cal.DAY_OF_WEEK);

        if (dayOfWeek == 1) {
            response.getWriter().write("The website is closed on Sunday. Please try accessing later.");
        }
        else {
            returnVal = true;
        }
        return returnVal;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //Method is called after Spring MVC executes the request handler for the request
        System.out.println("HandlerInterceptorAdapter : postHandle method called for - " + request.getRequestURI().toString());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //Method is called after the response object is produced by the view for the request.
        System.out.println("HandlerInterceptorAdapter : afterCompletion method called for - " + request.getRequestURI().toString());
    }
}
