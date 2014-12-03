<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page session="true"%>
<t:layout>
    <jsp:body>
        <div id="master-loginform" class="master-loginform clearfix">
            <h1>Log in:</h1>
            <div>${message}</div>
            <form id="login" action="<c:url value="/j_spring_security_check"/>" method="post" role="form">
                <div class="form-group">
                    <label for="j_username">Username</label>
                    <input type="text" name="j_username" class="form-control" value="">
                </div>
                <div class="form-group">
                    <label for="j_password">Password</label>
                    <input name="j_password" type="password" class="form-control" value="">
                </div>
                <button type="submit" class="btn btn-primary">Sign up</button>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>
        </div>
    </jsp:body>
</t:layout>
