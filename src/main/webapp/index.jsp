<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html ng-app="myApp">
<head>
    <title>MyWebApp</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


    <style>
        <%@include file="/resources/css/bootstrap.min.css" %>
    </style>


    <script>
        <%@include file="/resources/js/angular.min.js" %>
    </script>

    <script>
        <%@include file="/resources/js/main.js" %>
    </script>

</head>

<body ng-controller="loginController">

<div class="container">

    <h2>Forms</h2>
    <div ng-show="isLogin">

        <button class="btn btn-info" ng-click="loginFormShow()">Login</button>
        <button class="btn btn-info" ng-click="regFormShow()">Registration</button>

        <jsp:include page="loginForm.jsp" flush="true"/>
        <jsp:include page="registerForm.jsp" flush="true"/>
    </div>

    <div ng-hide="isLogin">
        <button ng-click="logout()" class="btn btn-danger">Logout</button>
        <br>
        <br>
        <h4>Welcome {{user}}</h4>

    </div>

</div>

<script>
    <%@include file="/resources/js/jquery.min.js" %>
</script>
<script>
    <%@include file="/resources/js/bootstrap.min.js" %>
</script>

</body>
</html>
