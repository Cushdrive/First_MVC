<%--
  Created by IntelliJ IDEA.
  User: jayson
  Date: 9/13/15
  Time: 4:50 PM
  To change this template use File | Settings | File Templates.


<html>
<body>
    <h1>Congratulations, the system processed your request successfully.</h1>
    <h2>${msg}</h2>
</body>
</html>

Example used up to and including standard string model attribute annotations.
<html>
<body>
    <h1>${headerMessage}</h1>
    <h3>Congratulations, the system processed your request successfully.</h3>
    <h2>Details</h2>
    <table>
        <tr>
            <td>Student Name:</td>
            <td>${student1.studentName}</td>
        </tr>
        <tr>
            <td>Student Hobby:</td>
            <td>${student1.studentHobby}</td>
        </tr>
    </table>
</body>
</html>
--%>
<html>
<body>
<h1>${headerMessage}</h1>
<h3>Congratulations, the system processed your request successfully.</h3>
<h2>Details</h2>
<%-- student1 corresponds with the instance name that is established in the controller ModelAttribute for this page --%>
<table>
    <tr>
        <td>Student Name:</td>
        <td>${student1.studentName}</td>
    </tr>
    <tr>
        <td>Student Hobby:</td>
        <td>${student1.studentHobby}</td>
    </tr>
    <tr>
        <td>Student Mobile:</td>
        <td>${student1.studentMobile}</td>
    </tr>
    <tr>
        <td>DOB:</td>
        <td>${student1.studentDOB}</td>
    </tr>
    <tr>
        <td>Student Skills:</td>
        <td>${student1.studentSkills}</td>
    </tr>
    <tr>
        <td>Student Address:</td>
        <td>country: ${student1.studentAddress.country}
            state: ${student1.studentAddress.state}
            city: ${student1.studentAddress.city}
            street: ${student1.studentAddress.street}</td>
    </tr>
</table>
</body>
</html>