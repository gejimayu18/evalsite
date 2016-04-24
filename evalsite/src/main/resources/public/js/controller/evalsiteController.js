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
			$scope.form.commentWidth = 100;
			$scope.form.commentHeight = 4;
			$scope.form.mode = 'sociability';
			
			$scope.data.input = {};
			$scope.data.input.sociability = {};
			$scope.data.input.bh = {};
			$scope.data.input.bh.handling = {};
			$scope.data.input.resources = {};
			$scope.data.input.resources.treats = {};
			$scope.data.input.resources.toys = {};
			$scope.data.input.resources.bones = {};
			$scope.data.input.resources.food = {};
			$scope.data.input.noises = {};
			$scope.data.input.dolls = {};
			$scope.data.input.animaltest = {};
			$scope.data.input.recommendations = {};
			
			$scope.data.output = {};
			$scope.data.output.header = {};
			$scope.data.output.sociability = {};
			$scope.data.output.bh = {};
			$scope.data.output.bh.handling = {};
			$scope.data.output.resources = {};
			$scope.data.output.resources.treats = {};
			$scope.data.output.resources.toys = {};
			$scope.data.output.resources.bones = {};
			$scope.data.output.resources.food = {};
			$scope.data.output.noises = {};
			$scope.data.output.dolls = {};
			$scope.data.output.animaltest = {};
			$scope.data.output.recommendations = {};
			
			$scope.data.output.header.evalDate = new Date(Date.now());
			
			evalsiteRESTService.getBehaviors('pull').get(
					function (response) {
						$scope.data.input.sociability.pulldogbehaviors = angular.copy(response.behaviorList);
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('walking').get(
					function (response) {
						$scope.data.input.sociability.walkingbehaviors = angular.copy(response.behaviorList);
					},
					function () {}
			);
			
			evalsiteRESTService.getBehaviors('ignore').get(
					function (response) {
						$scope.data.input.sociability.ignorebehaviors = angular.copy(response.behaviorList);
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('backstrokes').get(
					function (response) {
						$scope.data.input.sociability.backstrokebehaviors = angular.copy(response.behaviorList);
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('engage').get(
					function (response) {
						$scope.data.input.sociability.engagebehaviors = angular.copy(response.behaviorList);
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('teethcheck').get(
					function (response) {
						$scope.data.input.bh.teethcheckbehaviors = angular.copy(response.behaviorList);
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('bodyhandling').get(
					function (response) {
						$scope.data.input.bh.handling.tailtug = angular.copy(response.behaviorList);
						$scope.data.input.bh.handling.earsl = angular.copy(response.behaviorList);
						$scope.data.input.bh.handling.earsr = angular.copy(response.behaviorList);
						$scope.data.input.bh.handling.pawsfrontl = angular.copy(response.behaviorList);
						$scope.data.input.bh.handling.pawsfrontr = angular.copy(response.behaviorList);
						$scope.data.input.bh.handling.pawsbackr = angular.copy(response.behaviorList);
						$scope.data.input.bh.handling.pawsbackl = angular.copy(response.behaviorList);
						$scope.data.input.bh.handling.pawsbackr = angular.copy(response.behaviorList);
						$scope.data.input.bh.handling.hugfront = angular.copy(response.behaviorList);
						$scope.data.input.bh.handling.hugside = angular.copy(response.behaviorList);
						$scope.data.input.bh.handling.pickup = angular.copy(response.behaviorList);
						$scope.data.input.bh.handling.eyecontact = angular.copy(response.behaviorList);
						$scope.data.input.bh.handling.overall = angular.copy(response.behaviorList);
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('treats/takingtreats').get(
					function (response) {
						$scope.data.input.resources.treats.takingtreatsbehaviors = response.behaviorList;
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('treats/treatsused').get(
					function (response) {
						$scope.data.input.resources.treats.treatsused = response.behaviorList;
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('treats/commands').get(
					function (response) {
						$scope.data.input.resources.treats.commands = response.behaviorList;
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('resources/handused').get(
					function (response) {
						$scope.data.input.resources.toys.hands = angular.copy(response.behaviorList);
						$scope.data.input.resources.bones.hands = angular.copy(response.behaviorList);
						$scope.data.input.resources.food.hands = angular.copy(response.behaviorList);
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('resources/interest').get(
					function (response) {
						$scope.data.input.resources.toys.interest = angular.copy(response.behaviorList);
						$scope.data.input.resources.bones.interest = angular.copy(response.behaviorList);
						$scope.data.input.resources.food.interest = angular.copy(response.behaviorList);
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('toys').get(
					function (response) {
						$scope.data.input.resources.toys.toysbehavior = angular.copy(response.behaviorList);
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('bones').get(
					function (response) {
						$scope.data.input.resources.bones.bonesbehavior = angular.copy(response.behaviorList);
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('food/delivery').get(
					function (response) {
						$scope.data.input.resources.food.delivery = angular.copy(response.behaviorList);
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('food/behaviors').get(
					function (response) {
						$scope.data.input.resources.food.initialapproach = angular.copy(response.behaviorList);
						$scope.data.input.resources.food.touchdog = angular.copy(response.behaviorList);
						$scope.data.input.resources.food.touchbowl = angular.copy(response.behaviorList);
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('noises/initial').get(
					function (response) {
						$scope.data.input.noises.initialloudnoise = angular.copy(response.behaviorList);
						$scope.data.input.noises.initialscold = angular.copy(response.behaviorList);
						$scope.data.input.noises.initialknockatdoor = angular.copy(response.behaviorList);
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('noises/recover').get(
					function (response) {
						$scope.data.input.noises.recoverloudnoise = angular.copy(response.behaviorList);
						$scope.data.input.noises.recoverscold = angular.copy(response.behaviorList);
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('noises/stranger').get(
					function (response) {
						$scope.data.input.noises.stranger = angular.copy(response.behaviorList);
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('dolls').get(
					function (response) {
						$scope.data.input.dolls.initialbaby = angular.copy(response.behaviorList);
						$scope.data.input.dolls.afterbaby = angular.copy(response.behaviorList);
						$scope.data.input.dolls.initialtoddler = angular.copy(response.behaviorList);
						$scope.data.input.dolls.aftertoddler = angular.copy(response.behaviorList);
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('animaltest/initialcat').get(
					function (response) {
						$scope.data.input.animaltest.initialcat = angular.copy(response.behaviorList);
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('animaltest/aftercat').get(
					function (response) {
						$scope.data.input.animaltest.aftercat = angular.copy(response.behaviorList);
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('animaltest/dogrecommendations').get(
					function (response) {
						$scope.data.input.animaltest.dogrecommendations = angular.copy(response.behaviorList);
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('animaltest/catrecommendations').get(
					function (response) {
						$scope.data.input.animaltest.catrecommendations = angular.copy(response.behaviorList);
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('recommendations/walker').get(
					function (response) {
						$scope.data.input.recommendations.walker = angular.copy(response.behaviorList);
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('recommendations/kids').get(
					function (response) {
						$scope.data.input.recommendations.kids = angular.copy(response.behaviorList);
					},
					function () {}
			);
			
			evalsiteRESTService.getBehaviors('recommendations/personality').get(
					function (response) {
						$scope.data.input.recommendations.personality = angular.copy(response.behaviorList);
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('recommendations/household').get(
					function (response) {
						$scope.data.input.recommendations.household = angular.copy(response.behaviorList);
					},
					function () {}
			);
			evalsiteRESTService.getBehaviors('recommendations/waivers').get(
					function (response) {
						$scope.data.input.recommendations.waivers = angular.copy(response.behaviorList);
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
			
			$scope.form.switchTo = function(newMode) {
				$scope.form.mode = newMode;
			}
			
			$scope.form.submit = function() {
				evalsiteRESTService.submitEval().save({},$scope.data.output)
				.$promise
				.then(function (response) {
					alert("Worked");
				}, function() {
					alert("didn't work");
				});
			}
		}]);
}(window.angular));