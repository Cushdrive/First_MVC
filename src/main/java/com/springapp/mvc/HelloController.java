/* //Example without using spring annotations.
package com.springapp.mvc;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController extends AbstractController {

    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //The HelloPage constructor parameter will let the Front Controller know which class will generate the
        //html for the given model, which is welcomeMessage in this case.
        ModelAndView modelandview = new ModelAndView("HelloPage");
        modelandview.addObject("welcomeMessage","Hello and welcome to the first spring mvc app.");

        return modelandview;
    }
}

//Example using spring annotations.
package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//Annotation identifies this as a controller. The class does not need to extend any controller classes or implement
//any specific interfaces.
@Controller
//By specifying the annotation below, all mappings within this class will be relative to the path below. e.g.,
//.../greet/FirstSpringMVC/hi
@RequestMapping("/greet")
public class HelloController {

    //The annotation allows the pattern to be established here instead of in the servlet.xml file
    @RequestMapping("/FirstSpringMVC/welcome")
    public ModelAndView helloWorld() {
        //The HelloPage constructor parameter will let the Front Controller know which class will generate the
        //html for the given model, which is welcomeMessage in this case.
        ModelAndView modelandview = new ModelAndView("HelloPage");
        modelandview.addObject("welcomeMessage","Hello and welcome to the first spring mvc app.");

        return modelandview;
    }

    @RequestMapping("/FirstSpringMVC/hi")
    public ModelAndView hiWorld() {
        //The HelloPage constructor parameter will let the Front Controller know which class will generate the
        //html for the given model, which is welcomeMessage in this case.
        ModelAndView modelandview = new ModelAndView("HelloPage");
        modelandview.addObject("welcomeMessage","Hi World!");

        return modelandview;
    }
}*/

//Example using path variables
package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

//Annotation identifies this as a controller. The class does not need to extend any controller classes or implement
//any specific interfaces.
@Controller
public class HelloController {

    //The annotation allows the pattern to be established here instead of in the servlet.xml file
    //Curly braces allow parts of the pattern to be variable. e.g., /FirstSpringMVC/welcome/countryName/benderj4
    @RequestMapping("/FirstSpringMVC/welcome/{countryName}/{userName}")
    public ModelAndView helloWorld(@PathVariable Map<String,String> pathVars) {

    /* //You can use a parameter Map as used above, or expand them out to individual parameters as seen below
    public ModelAndView helloWorld(@PathVariable("userName") String name,
                                   @PathVariable("countryName") String country) {

    //The PathVariable annotation above allows you to refer to the url parameter.
        ModelAndView modelandview = new ModelAndView("HelloPage");
        modelandview.addObject("welcomeMessage","Hello and welcome to the first spring mvc app, " + name +
                " from " + country + ".");
    */

        String country = pathVars.get("countryName");
        String name = pathVars.get("userName");

        //The PathVariable annotation above allows you to refer to the url parameter.
        ModelAndView modelandview = new ModelAndView("HelloPage");
        modelandview.addObject("welcomeMessage","Hello and welcome to the first spring mvc app, " + country +
                " from " + name + ".");

        return modelandview;
    }

}