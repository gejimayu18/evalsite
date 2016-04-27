/*global angular*/
(function (angular) {
	"use strict";
	angular.module("EvalsiteRESTService", ["ngResource"])
		.factory("evalsiteRESTService", ["$resource", function($resource) {
			var serviceURL = "rest",
			getBehaviors,
			getEval,
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
			
			getEval = function (id) {
				return $resource(
						serviceURL + "/behaviors/eval/" + id,
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
				getEval: getEval,
				submitEval: submitEval
			};
		}]);
}(window.angular));