'use strict';

angular.module('postalServices', ['ngResource'])
    .factory('States',  ['$resource', function ($resource) {
        return $resource('/api/states', {}, {
            query: {method: 'GET', isArray: true}
        });
    }])
    .factory('CityCount', ['$http', function ($http) {
        return $http({method: 'GET', url: '/api/states/cities/count'});            
    }])
    .factory('ZipCodes', ['$resource', function ($resource) {
        return $resource('/api/zip/:code', {}, {
            query: {method: 'GET', params: {code:'code'}, isArray: false}
        });
    }])
    .factory('Favorites', ['$window', function ($window) {
        function supports_html5_storage() {
            try {
                return 'localStorage' in $window && $window['localStorage'] !== null;
            } catch (e) {
                return false;
            }
        }
        
        if (!supports_html5_storage()) { return false; }
        
        var ls = $window['localStorage'];
        return {
            "add": function  (key, val) {                
                ls[key] = val;
            },
            "remove": function (key) {
                ls.removeItem(key);
            },
            "getAll": function () {               
                return ls;
            },
            "get": function (key) {
                return ls[key];
            },
            "isEmpty": function () {              
                return ls.length > 0;
            }
        }
    }]);    