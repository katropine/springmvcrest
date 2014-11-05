<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout>
    <jsp:body>
        <h1>Yes!</h1>
        We are : ${name}
        <hr/>
        Spring MVC http://localhost:8080/springmvcrest/admin/springmvc/greeting/on<br>
        <code>com.katropine.admin.controllers.SpringmvcController</code><br>
        Jax-rs http://localhost:8080/springmvcrest/api/jaxrs (curl -i -H "Accept: application/json" "http://localhost:8080/springmvcrest/api/springrest/users")<br>
        <code>com.katropine.resources.SpringrestController</code>
        <hr/> 
        Requires data in database<br>
        <hr/>
        <br><br>
        <a href="<c:url value='/j_spring_security_logout' />">Logout</a>
    </jsp:body>
</t:layout>