<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%-- Used for all examples up to and including the model attribute annotation.
  Created by IntelliJ IDEA.
  User: jayson
  Date: 9/13/15
  Time: 4:50 PM
  To change this template use File | Settings | File Templates.

<html>
<body>
    <h1> STUDENT ADMISSION FORM FOR ENGINEERING COURSES</h1>
    <form action="/submitAdmissionForm.html" method="POST" >
        <p>
            Name : <input type="text" name="studentName" />
        </p>
        <p>
            Hobby : <input type="text" name="studentHobby" />
        </p>
        <input type="submit" value="Submit" />
    </form>
</body>
</html>

Used for class level model attribute annotation
<html>
<body>
<h1>${headerMessage}</h1>
<h3> STUDENT ADMISSION FORM FOR ENGINEERING COURSES</h3>
<form action="/submitAdmissionForm.html" method="POST" >
    <p>
        Name : <input type="text" name="studentName" />
    </p>
    <p>
        Hobby : <input type="text" name="studentHobby" />
    </p>
    <input type="submit" value="Submit" />
</form>
</body>
</html>--%>

<html>
<body>
<h1>${headerMessage}</h1>
<h3> STUDENT ADMISSION FORM FOR ENGINEERING COURSES</h3>

<%-- errors, used below, is from a custom taglib and will display spring binding errors, if present.
    student1 refers to the ModelAttribute annotation instance in the controller method.--%>
<form:errors path="student1.*" />

<form action="/submitAdmissionForm.html" method="POST" >
    <table>
        <tr>
            <td>Name</td><td><input type="text" name="studentName"></td>
        </tr>
        <tr>
            <td>Hobby</td><td><input type="text" name="studentHobby"></td>
        </tr>
        <tr>
            <td>DOB</td><td><input type="text" name="studentDOB"></td>
        </tr>
        <tr>
            <td>Mobile Number</td><td><input type="text" name="studentMobile"></td>
        </tr>
        <tr>
            <td>Skills</td><td><select name="studentSkills" multiple>
                                    <option value="Java Core">Java Core</option>
                                    <option value="Spring Core">Spring Core</option>
                                    <option value="Spring MVC">Spring MVC</option>
                                    </select> </td>
        </tr>
    </table>

    <table>
        <tr>
            <td>Address:</td>
        </tr>
        <tr>
            <%-- In order to reference a model with an address property user-defined property
            type, you must refer to the instance name within the model and then the property name
            within the user defined class --%>
            <td>country: <input type="text" name="studentAddress.country"/> </td>
            <td>State: <input type="text" name="studentAddress.state"/> </td>
            <td>City: <input type="text" name="studentAddress.city"/> </td>
            <td>Street: <input type="text" name="studentAddress.street"/> </td>
        </tr>
    </table>

    <input type="submit" value="Submit" />
</form>
</body>
</html>