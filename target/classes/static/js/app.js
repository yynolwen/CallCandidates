var app = angular.module('app', ['ngRoute','ngResource']);
app.config(function($routeProvider){
    $routeProvider
        .when('/users',{
            templateUrl: '/views/java.html',
            controller: 'PersonInfoController as pinfo'
        })
        .when('/roles',{
            templateUrl: '/views/angularjs.html',
            controller: 'PersonInfoController as pinfo'
        })
        .when('/',{
            templateUrl: 'index.html',
            controller: 'PersonInfoController as pinfo'
        })
        .otherwise(
            { redirectTo: '/'}
        );
});

