package com.springapp.mvc;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by jayson on 9/19/15.
 */
public class HobbyValidator implements ConstraintValidator<IsValidHobby, String> {
    private String listOfValidHobbies;

    @Override
    public void initialize(IsValidHobby isValidHobby) {
        //This function is called before the isValid function. This is where we need to initialize
        //custom parameters that have been added to the annotation. In this case, the initialize
        //function acts as a setter for the data members declared for this class.
        listOfValidHobbies = isValidHobby.listOfValidHobbies();
    }

    @Override
    public boolean isValid(String studentHobby, ConstraintValidatorContext constraintValidatorContext) {
        boolean returnVal = false;
        if ((studentHobby != null) && (studentHobby.matches(listOfValidHobbies))) {
            returnVal = true;
        }
        return returnVal;
    }
}