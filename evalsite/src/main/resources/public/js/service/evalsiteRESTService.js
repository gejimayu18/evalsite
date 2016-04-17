/*global angular*/
(function (angular) {
	"use strict";
	angular.module("EvalsiteRESTService", ["ngResource"])
		.factory("evalsiteRESTService", ["$resource", function($resource) {
			var serviceURL = "rest",
			getBehaviors;
			
			getBehaviors = function (type) {
				return $resource(
						serviceURL + "/behaviors/" + type,
						null,
						{
							get: {method: "GET"}
						}
				);
			};
			
			return {
				getBehaviors: getBehaviors
			};
		}]);
}(window.angular));