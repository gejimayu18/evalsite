/*global angular*/
(function (angular) {
	"use strict";
	
	angular.module("EvalsiteController", ["EvalsiteRESTService"])
		.controller("EvalsiteController", ["$scope", "$filter", "evalsiteRESTService",
		function ($scope, $filter, evalsiteRESTService) {
			$scope.data = {};
			$scope.ui = {};
			$scope.searchfunc = {};
			$scope.form = {};
			$scope.data.pulldogbehaviors = {}; 
			$scope.data.outputpulldogbehaviors = {};
			$scope.form.commentWidth = 100;
			$scope.form.commentHeight = 4;
//			$scope.data.evalDate = $filter('date')(Date.now(), 'MM/dd/yyyy');
			$scope.data.evalDate = new Date(Date.now());
			
			evalsiteRESTService.getBehaviors('pull').get(
					function (response) {
						$scope.data.pulldogbehaviors = response.behaviorList;
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('walking').get(
					function (response) {
						$scope.data.walkingbehaviors = response.behaviorList;
					},
					function () {}
			);
			
			evalsiteRESTService.getBehaviors('sociability').get(
					function (response) {
						$scope.data.sociabilitybehaviors = response.behaviorList;
					},
					function () {}
			);
			
			$scope.form.containsOther = function(dataContainsOther) {
				var containsOther = false;
				angular.forEach(dataContainsOther, function(data, key) {
					if (data.name === 'other') {
						containsOther = true;
						return;
					}
				});
				return containsOther;
			}
			
		}]);
}(window.angular));