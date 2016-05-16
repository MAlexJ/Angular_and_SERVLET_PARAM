<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<form ng-hide="regShow"  name="regForm">
    <br>
    <input type="text" ng-model="reg.firstName" placeholder="First Name" required="">
    <br>
    <br>
    <input type="text" ng-model="reg.lastName" placeholder="Last Name" required="">
    <br>
    <br>
    <input type="text" ng-model="reg.email" placeholder="Email" required="">
    <br>
    <br>
    <input type="text" ng-model="reg.sex" placeholder="Sex" required="">
    <br>
    <br>
    <input type="text" ng-model="reg.login" placeholder="Login" required="">
    <br>
    <br>
    <input type="text" ng-model="reg.password" placeholder="Password" required="">
    <br>
    <br>
    <button ng-click="regClick(regForm, reg)" class="btn">Submit</button>
</form>