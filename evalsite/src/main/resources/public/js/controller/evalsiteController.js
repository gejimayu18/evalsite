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
			$scope.data.treats = {};
			$scope.data.outputtreats = {};
			$scope.data.toys = {};
			$scope.data.outputtoys = {};
			$scope.data.bones = {};
			$scope.data.outputbones = {};
			$scope.data.food = {};
			$scope.data.outputfood = {};
			$scope.data.noises = {};
			$scope.data.outputnoises = {};
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
			evalsiteRESTService.getBehaviors('treats/takingtreats').get(
					function (response) {
						$scope.data.treats.takingtreatsbehaviors = response.behaviorList;
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('treats/treatsused').get(
					function (response) {
						$scope.data.treats.treatsused = response.behaviorList;
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('treats/commands').get(
					function (response) {
						$scope.data.treats.commands = response.behaviorList;
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('resources/handused').get(
					function (response) {
						$scope.data.toys.hands = angular.copy(response.behaviorList);
						$scope.data.bones.hands = angular.copy(response.behaviorList);
						$scope.data.food.hands = angular.copy(response.behaviorList);
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('resources/interest').get(
					function (response) {
						$scope.data.toys.interest = angular.copy(response.behaviorList);
						$scope.data.bones.interest = angular.copy(response.behaviorList);
						$scope.data.food.interest = angular.copy(response.behaviorList);
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('toys').get(
					function (response) {
						$scope.data.toys.toysbehavior = angular.copy(response.behaviorList);
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('bones').get(
					function (response) {
						$scope.data.bones.bonesbehavior = angular.copy(response.behaviorList);
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('food/delivery').get(
					function (response) {
						$scope.data.food.delivery = angular.copy(response.behaviorList);
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('food/behaviors').get(
					function (response) {
						$scope.data.food.initialapproach = angular.copy(response.behaviorList);
						$scope.data.food.touchdog = angular.copy(response.behaviorList);
						$scope.data.food.touchbowl = angular.copy(response.behaviorList);
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('noises/initial').get(
					function (response) {
						$scope.data.noises.initialloudnoise = angular.copy(response.behaviorList);
						$scope.data.noises.initialscold = angular.copy(response.behaviorList);
						$scope.data.noises.initialknockatdoor = angular.copy(response.behaviorList);
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('noises/recover').get(
					function (response) {
						$scope.data.noises.recoverloudnoise = angular.copy(response.behaviorList);
						$scope.data.noises.recoverscold = angular.copy(response.behaviorList);
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('noises/stranger').get(
					function (response) {
						$scope.data.noises.stranger = angular.copy(response.behaviorList);
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
			$scope.form.objectContainsOther = function(dataContainsOther) {
				var containsOther = false;
				angular.forEach(dataContainsOther, function(data, key) {
					if ($scope.form.containsOther(data)) {
						containsOther = true;
						return;
					}
				});
				return containsOther;
			}
			
		}]);
}(window.angular));