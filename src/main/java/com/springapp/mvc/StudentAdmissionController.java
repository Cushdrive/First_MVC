/* Example using standard String type for msg to be handed to the AdmissionSuccess form.
package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


//Annotation identifies this as a controller. The class does not need to extend any controller classes or implement
//any specific interfaces.
@Controller
public class StudentAdmissionController {

    @RequestMapping(value="/admissionForm.html", method = RequestMethod.GET)
    public ModelAndView getAdmissionForm() {

        ModelAndView modelandview = new ModelAndView("AdmissionForm");
        return modelandview;
    }

    @RequestMapping(value="/submitAdmissionForm.html", method = RequestMethod.POST)
    public ModelAndView submitAdmissionForm(@RequestParam(value="studentName", defaultValue="Dummy") String name,
                                            @RequestParam(value="studentHobby", defaultValue="Golf") String hobby) {

        ModelAndView modelandview = new ModelAndView("AdmissionSuccess");
        modelandview.addObject("msg", "Accepted the following information: Name = " + name + " Hobby = " + hobby);

        return modelandview;
    }

}

Example using standard ModelAttribute annotation.
package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class StudentAdmissionController {

    @RequestMapping(value="/admissionForm.html", method = RequestMethod.GET)
    public ModelAndView getAdmissionForm() {

        ModelAndView modelandview = new ModelAndView("AdmissionForm");
        return modelandview;
    }

    @RequestMapping(value="/submitAdmissionForm.html", method = RequestMethod.POST)
    public ModelAndView submitAdmissionForm(@ModelAttribute("student1") Student student1) {
        //The ModelAttribute above prevents the need to write all of the parameters individually and assign them to
        //variables, as seen below. The name in the object has to be the same as the name in the jsp page form.
        //Student student = new Student();
        //student.setStudentName(name);
        //student.setStudentHobby(hobby);

        ModelAndView modelandview = new ModelAndView("AdmissionSuccess");
        modelandview.addObject("headerMessage", "College of Engineering.");
        //modelandview.addObject("student1",student);

        return modelandview;
    }

}

//Used for tutorials 13 and 14, which introduce ModelAttributes, custom user types in models, and BindingResults
package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class StudentAdmissionController {

    //Using this annotation, you can add attributes that will be shared across all request methods as if you added
    //them manually like modelandview.addObject("headerMessage","College of Engineering.");
    @ModelAttribute
    public void commonRequestObjectAttributes(Model modelParam) {
        modelParam.addAttribute("headerMessage","College of Engineering");
    }

    @RequestMapping(value="/admissionForm.html", method = RequestMethod.GET)
    public ModelAndView getAdmissionForm() {

        ModelAndView modelandview = new ModelAndView("AdmissionForm");
        //modelandview.addObject("headerMessage","College of Engineering.");
        return modelandview;
    }

    @RequestMapping(value="/submitAdmissionForm.html", method = RequestMethod.POST)
    public ModelAndView submitAdmissionForm(@ModelAttribute("student1") Student student1, BindingResult result) {
        //The ModelAttribute above prevents the need to write all of the parameters individually and assign them to
        //variables, as seen below. The name in the object has to be the same as the name in the jsp page form.
        //Student student = new Student();
        //student.setStudentName(name);
        //student.setStudentHobby(hobby);
        //The BindingResult parameter, shown above, allows you to include binding exceptions into the model for
        //display to the client. This parameter has to be placed immediately after the annotation.
        ModelAndView modelAndView;
        if (result.hasErrors()) {
            modelAndView = new ModelAndView("AdmissionForm");
        }
        else {
            modelAndView = new ModelAndView("AdmissionSuccess");
            //modelandview.addObject("headerMessage", "College of Engineering.");
            //modelandview.addObject("student1",student);
        }

        return modelAndView;
    }

}*/

//Used for tutorials 15
package com.springapp.mvc;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

//Must be added to support form validation
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class StudentAdmissionController {

    //Using this annotation, you can customize the binding behavior when the form is submitted. In this case to explicitly
    //exclude the mobile number. This means that the mobile number will not be added to the model on submit. Also adding a
    //custom date type. Property Editor classes, e.g. CustomDateEditor, are used by spring to complete binding. Spring has
    //many default property editors, but also allows you to create your own, as demonstrated with StudentNameEditor.
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields(new String[] {"studentMobile"});
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy****MM****dd");
        binder.registerCustomEditor(Date.class,"studentDOB",new CustomDateEditor(dateFormat,false));
        binder.registerCustomEditor(String.class,"studentName",new StudentNameEditor());
    }

    //Using this annotation, you can add attributes that will be shared across all request methods as if you added
    //them manually like modelandview.addObject("headerMessage","College of Engineering.");
    @ModelAttribute
    public void commonRequestObjectAttributes(Model modelParam) {
        modelParam.addAttribute("headerMessage","College of Engineering");
    }

    @RequestMapping(value="/admissionForm.html", method = RequestMethod.GET)
    public ModelAndView getAdmissionForm() {

        ModelAndView modelandview = new ModelAndView("AdmissionForm");
        //modelandview.addObject("headerMessage","College of Engineering.");
        return modelandview;
    }

    @RequestMapping(value="/submitAdmissionForm.html", method = RequestMethod.POST)
    public ModelAndView submitAdmissionForm( @Valid @ModelAttribute("student1") Student student1, BindingResult result) {
        //The @Valid annotation is necessary if validation annotations have been added in the model to enforce
        //certain constraints.
        //The ModelAttribute above prevents the need to write all of the parameters individually and assign them to
        //variables, as seen below. The name in the object has to be the same as the name in the jsp page form.
        //Student student = new Student();
        //student.setStudentName(name);
        //student.setStudentHobby(hobby);
        //The BindingResult parameter, shown above, allows you to include binding exceptions into the model for
        //display to the client. This parameter has to be placed immediately after the annotation.
        ModelAndView modelAndView;
        if (result.hasErrors()) {
            modelAndView = new ModelAndView("AdmissionForm");
        }
        else {
            modelAndView = new ModelAndView("AdmissionSuccess");
            //modelandview.addObject("headerMessage", "College of Engineering.");
            //modelandview.addObject("student1",student);
        }

        return modelAndView;
    }

}