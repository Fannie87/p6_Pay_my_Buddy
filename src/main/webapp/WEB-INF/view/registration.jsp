<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
    </head>
    <body>
        <h3>Create your accompt</h3>
        <form:form method="POST" 
          action="/registration-success" modelAttribute="registration">
             <table>
                <tr>
                    <td><form:label path="firstName">First Name</form:label></td>
                    <td><form:input path="firstName"/></td>
                </tr>
                <tr>
                    <td><form:label path="lastName">Last Name</form:label></td>
                    <td><form:input path="lastName"/></td>
                </tr>
                <tr>
                    <td><form:label path="mail">Mail</form:label></td>
                    <td><form:input path="mail"/></td>
                </tr>
                 <tr>
                    <td><form:label path="password">Password</form:label></td>
                    <td><form:input path="password"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>