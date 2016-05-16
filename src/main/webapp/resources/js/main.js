var myApp = angular.module('myApp', []);

myApp.controller('loginController', function ($scope, $http, $window) {

    $scope.isLogin = true;
    $scope.loginShow = true;
    $scope.regShow = true;

    $scope.loginFormShow = function () {
        $scope.loginShow = false;
        $scope.regShow = true;
    };

    $scope.regFormShow = function () {
        $scope.regShow = false;
        $scope.loginShow = true;
    };

    // POST: -> /login
    $scope.loginClick = function (loginForm, login) {
        if (loginForm.$valid) {
            $http({
                method: 'POST',
                url: 'login',
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                data: 'username=' + login.username + '&password=' + login.password
            }).success(function (data) {                

                if (data == "USER"|| data == "ADMIN") {
                    $scope.isLogin = false;
                    $scope.loginShow = true;

                    // GET: -> /user
                    $http.get('/user', {
                        params: { username: login.username, password: login.password }
                    }).success(function (data) {
                        $scope.user = data;
                    }).error(function (data, status) {
                        console.log("код ответа: " + status);
                    });
                }else {
                    $window.alert("Not Account!!!  login:" + login.username);
                }
            }).error(function () {
                $scope.isLogin = true;

            });
        }
    };

    // POST: -> /register
    $scope.regClick = function (regForm, reg) {
        if (regForm.$valid) {
            $http({
                method: 'POST',
                url: 'register',
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                data: 'firstName=' + reg.firstName
                + '&lastName=' + reg.lastName
                + '&email=' + reg.email
                + '&sex=' + reg.sex
                + '&login=' + reg.login
                + '&password=' + reg.password
            }).success(function (data) {

                if (data == "STATUS_OK") {
                    $scope.isLogin = false;
                    $scope.loginShow = true;
                    $scope.regShow = true;
                }

                $http.get('user', {
                    params: { username: reg.login, password: reg.password }
                }).success(function (data) {
                    $scope.user = data;
                }).error(function (data, status) {
                    console.log("код ответа: " + status);
                });

            }).error(function () {
                $scope.regShow = true;
            });
        }
    };

    // Logout
    $scope.logout = function () {
        $scope.isLogin = true;
    };

});