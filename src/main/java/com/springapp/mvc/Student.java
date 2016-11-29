/*
Used for Tutorial 14
package com.springapp.mvc;

import java.util.ArrayList;
import java.util.Date;

*//**
 * Created by jayson on 9/13/15.
 *//*
public class Student {

    private String studentName;
    private String studentHobby;
    private Long studentMobile;
    private Date studentDOB;
    private ArrayList<String> studentSkills;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentHobby() {
        return studentHobby;
    }

    public void setStudentHobby(String studentHobby) {
        this.studentHobby = studentHobby;
    }

    public Long getStudentMobile() {
        return studentMobile;
    }

    public void setStudentMobile(Long studentMobile) {
        this.studentMobile = studentMobile;
    }

    public Date getStudentDOB() {
        return studentDOB;
    }

    public void setStudentDOB(Date studentDOB) {
        this.studentDOB = studentDOB;
    }

    public ArrayList<String> getStudentSkills() {
        return studentSkills;
    }

    public void setStudentSkills(ArrayList<String> studentSkills) {
        this.studentSkills = studentSkills;
    }
}*/
//Used for tutorial 15
package com.springapp.mvc;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Date;

//Must import for bean validation. POM has been adjusted to require these dependencies.

/**
 * Created by jayson on 9/13/15.
 */
public class Student {

    //Looks for a number in the name, which would make it invalid, as explained in tutorial 20
    @Pattern(regexp = "[^0-9]*")
    private String studentName;

    //Validation annotation added in exercize 17. User annotations above the property declaration
    //to enforce the criteria when Spring MVC tries to add a form value to the model. In exerciese 18, we introduce
    //a custom error message, which is created by adding message to the annotation. You can also externalize the message.
    //In this case, the message is included in studentmessages.properties, and a references to that file has been added
    //to the dispatcher xml file.

    //In tutorial 21, a custom validator was added to ensure that the user enters a hobby that matches one of the predefined
    //hobbies. In order to do that, the IsValidHobby annotation interface was added, and the HobbyValidator, used by the
    //annotation at runtime was added. In order to accept "listOfValidHobbies," the parameter needs to be added to the
    //annotation interface class and the validator class needs to be adjusted to use the parameter during validation.

    //@Size(min = 1,max = 20, message = "You must enter a value between {min} and {max} characters for the Hobby field.")
    @Size(min = 1,max = 20) @IsValidHobby(listOfValidHobbies = "Golf|Video Games|TV")
    private String studentHobby;
    //The number has to be less than 2222
    @Max(2222)
    private Long studentMobile;
    //The DOB must be in the past.
    @Past
    private Date studentDOB;
    private ArrayList<String> studentSkills;
    private Address studentAddress;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentHobby() {
        return studentHobby;
    }

    public void setStudentHobby(String studentHobby) {
        this.studentHobby = studentHobby;
    }

    public Long getStudentMobile() {
        return studentMobile;
    }

    public void setStudentMobile(Long studentMobile) {
        this.studentMobile = studentMobile;
    }

    public Date getStudentDOB() {
        return studentDOB;
    }

    public void setStudentDOB(Date studentDOB) {
        this.studentDOB = studentDOB;
    }

    public ArrayList<String> getStudentSkills() {
        return studentSkills;
    }

    public void setStudentSkills(ArrayList<String> studentSkills) {
        this.studentSkills = studentSkills;
    }

    public Address getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(Address studentAddress) {
        this.studentAddress = studentAddress;
    }
}