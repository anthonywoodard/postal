'use strict';

angular.module('postalRoutes', [])
	.config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {
		$routeProvider
			// home page
			.when('/', {
				templateUrl: 'views/home.html',
				controller: 'PostalController'
			})
			.when('/states', {
				templateUrl: 'views/states.html',
				controller: 'StateController'
			})
			.when('/search', {
				templateUrl: 'views/search.html',
				controller: 'SearchController'
			})
			.when('/search/:zipcode', {
				templateUrl: 'views/search.html',
				controller: 'SearchController'
			});
		$locationProvider.html5Mode(false).hashPrefix('!');
	}]);