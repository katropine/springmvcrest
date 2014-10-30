<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@tag trimDirectiveWhitespaces="true"%><!DOCTYPE html>
<html>
    <head>
    <fmt:setLocale value="${language}"/>
    <title>SpringMVCRestJaxRs</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.css" media="screen" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/assets/css/main.css" media="screen" rel="stylesheet" type="text/css">
    <script src="${pageContext.request.contextPath}/assets/js/jquery-1.9.0.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
    
<div class="container">
    <jsp:doBody/>
</div>

</html>
