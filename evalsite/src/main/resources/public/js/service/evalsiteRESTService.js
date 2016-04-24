/*global angular*/
(function (angular) {
	"use strict";
	angular.module("EvalsiteRESTService", ["ngResource"])
		.factory("evalsiteRESTService", ["$resource", function($resource) {
			var serviceURL = "rest",
			getBehaviors,
			submitEval;
			
			getBehaviors = function (type) {
				return $resource(
						serviceURL + "/behaviors/" + type,
						null,
						{
							get: {method: "GET"}
						}
				);
			};
			
			submitEval = function() {
				return $resource(
						serviceURL + "/behaviors/submit",
						null,
						{
							save: {method: "POST"}
						}
				);
			};
			
			return {
				getBehaviors: getBehaviors,
				submitEval: submitEval
			};
		}]);
}(window.angular));