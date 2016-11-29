package com.springapp.mvc;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by jayson on 9/19/15.
 */
@Documented
@Constraint(validatedBy = HobbyValidator.class)
@Target( {ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsValidHobby {
    //This annotation will take a string that represents the list of values that are acceptable hobbies. The string will
    //be declared at design time. In this case, it is specified in the Student.java class. If we want to make this parameter
    //optional, we have to provide a default value, as displayed below.
    //String listOfValidHobbies();
    String listOfValidHobbies() default "Golf|Video Games|TV";

    //The @interface class type is specific to annotation interfaces.
    String message() default "Please provide a valid hobby. Acceptable hobbies are: Golf, Video Games, and TV";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default {};
}
