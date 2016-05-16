<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!-- Login -->
<form ng-hide="loginShow" name="loginForm">
    <br>
    <input type="text" ng-model="login.username" placeholder="username" required="">
    <br>
    <br>
    <input type="password" ng-model="login.password" placeholder="password" required="">
    <br>
    <br>
    <button ng-click="loginClick(loginForm, login)" class="btn">Submit</button>
</form>