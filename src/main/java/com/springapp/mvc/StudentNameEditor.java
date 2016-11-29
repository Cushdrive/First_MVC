package com.springapp.mvc;

import java.beans.PropertyEditorSupport;

/**
 * Created by jayson on 9/18/15.
 */
public class StudentNameEditor extends PropertyEditorSupport {

    @Override
    /*Function will take a string and make sure the gender is indicated. If it isn't, it will default it.
    * This should be used when other property editors aren't already available.*/
    public void setAsText(String studentName) throws IllegalArgumentException {
        if(studentName.contains("Mr.") || studentName.contains("Ms.") || studentName.contains("Mrs.")) {
            setValue(studentName);
        }
        else {
            studentName = "Mr. " + studentName;
            setValue(studentName);
        }
    }
}
