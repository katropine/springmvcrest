<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout>
    <jsp:body>
        <h1>Yes!</h1>
        We are : ${name}
        <hr/>
        Spring MVC http://localhost:8080/springmvcrest/admin/springmvc/greeting/on<br>
        <code>com.katropine.admin.controllers.SpringmvcController</code><br>
        Spring Rest http://localhost:8080/springmvcrest/admin/springrest/test/777<br>
        <code>com.katropine.admin.controllers.SpringrestController</code><br>
        Jax-rs http://localhost:8080/springmvcrest/api/jaxrs (curl -i -H "Accept: application/json" "http://localhost:8080/springmvcrest/api/jaxrs")<br>
        <code>com.katropine.resources.JaxrsResource</code>
        <hr/> 
        Requires data in database
    </jsp:body>
</t:layout>