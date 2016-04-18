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
			$scope.data.outputbh = {};
			$scope.data.inputbh = {};
			$scope.form.commentWidth = 100;
			$scope.form.commentHeight = 4;
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
			
			evalsiteRESTService.getBehaviors('ignore').get(
					function (response) {
						$scope.data.ignorebehaviors = response.behaviorList;
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('engage').get(
					function (response) {
						$scope.data.engagebehaviors = response.behaviorList;
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('teethcheck').get(
					function (response) {
						$scope.data.teethcheckbehaviors = response.behaviorList;
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('bodyhandling').get(
					function (response) {
						$scope.data.inputbh.tailtug = angular.copy(response.behaviorList);
						$scope.data.inputbh.earsl = angular.copy(response.behaviorList);
						$scope.data.inputbh.earsr = angular.copy(response.behaviorList);
						$scope.data.inputbh.pawsfrontl = angular.copy(response.behaviorList);
						$scope.data.inputbh.pawsfrontr = angular.copy(response.behaviorList);
						$scope.data.inputbh.pawsbackr = angular.copy(response.behaviorList);
						$scope.data.inputbh.pawsbackl = angular.copy(response.behaviorList);
						$scope.data.inputbh.pawsbackr = angular.copy(response.behaviorList);
						$scope.data.inputbh.hugfront = angular.copy(response.behaviorList);
						$scope.data.inputbh.hugside = angular.copy(response.behaviorList);
						$scope.data.inputbh.pickup = angular.copy(response.behaviorList);
						$scope.data.inputbh.eyecontact = angular.copy(response.behaviorList);
						$scope.data.inputbh.overall = angular.copy(response.behaviorList);
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