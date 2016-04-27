/*global angular*/
(function (angular) {
	"use strict";
	angular.module("evalsite", ["ngRoute", "EvalsiteController", "isteven-multi-select"])
		.config(["$routeProvider", "$locationProvider", function ($routeProvider) {
			$routeProvider
				.when("/ui", {
					templateUrl: "partials/ui.html",
					controller: "EvalsiteController"
				})
				.when("/ui/:id", {
					templateUrl: "partials/ui.html",
					controller: "EvalsiteController"
				})
				.otherwise({redirectTo: "/ui/"});
		}]);
}(window.angular));