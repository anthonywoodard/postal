'use strict';

google.load('visualization', '1', {packages:['corechart', 'geochart']});
google.setOnLoadCallback(function () {
    angular.bootstrap(document.body, ['postalApp']);
});
angular.module('postalControllers', ['postalServices'])
    .controller('PostalController', ['$scope', 'CityCount', 'Favorites', function ($scope, CityCount, Favorites) {
        $scope.ranges = [
            {value: 1, label: '1 - 5'},
            {value: 2, label: '6 - 10'},
            {value: 3, label: '11 - 15'},
            {value: 4, label: '16 - 20'}
        ];
        $scope.range = $scope.ranges[0];
        
        CityCount.success(function (data) {            
            var loadVisuals = function () {
                var startIndex = ($scope.range.value * 5) - 5;
                var endIndex = ($scope.range.value * 5);
                // Create the data table.
                var dataTable = new google.visualization.DataTable();
                dataTable.addColumn('string', 'State');
                dataTable.addColumn('number', 'Cities');                                                
                dataTable.addRows(data.slice(startIndex, endIndex));
                        
                // Instantiate and draw our chart, passing in some options.
                var columnChart = new google.visualization.ColumnChart(document.getElementById('chart_div'));
                columnChart.draw(dataTable, {'title':'States with the most cities'});                                                
            }
            $scope.loadVisuals = loadVisuals;
            loadVisuals();            
        });
    }])
    .controller('StateController', ['$scope', 'States', function ($scope, States) {
        $scope.states = States.query();
        $scope.orderProp = 'state';
        
        var loadGeo = function (state) {           
            // Create the data table.
            var dataTable = new google.visualization.DataTable();
            dataTable.addColumn('string', 'State');
            dataTable.addRows([[state]]);
            
            var geoChart = new google.visualization.GeoChart(document.getElementById('geoChart_div'));
            geoChart.draw(dataTable, {region: 'US', displayMode: 'markers', colorAxis: {colors: ['green', 'blue']}});
        }
        $scope.loadGeo = loadGeo;
        loadGeo('New York');
    }])
    .controller('SearchController', ['$scope', '$routeParams', 'ZipCodes', 'Favorites', function ($scope, $routeParams, ZipCodes, Favorites) {
        $scope.inFavorites = false;
        $scope.$watch('selectedZipCode', function (newValue, oldValue) {
            if (typeof newValue !== 'undefined' && newValue !== null) {     
                if (typeof Favorites.get(newValue.originalObject.state) !== 'undefined') {
                    $scope.inFavorites = true;
                } else {
                    $scope.inFavorites = false;
                }
            }
        });
        $scope.addFavorite = function (state, city) {           
            Favorites.add(state, city);
            $scope.inFavorites = true;
            $scope.isEmptyFavorites = Favorites.isEmpty();
        }        
        $scope.isEmptyFavorites = Favorites.isEmpty();                
        $scope.favorites = Favorites.getAll();
        $scope.removeFavorite = function (state) {
            if (typeof state !== 'undefined' && state !== null) {
                Favorites.remove(state);              
                $scope.inFavorites = (typeof Favorites.get(state) !== 'undefined');
            }            
            $scope.isEmptyFavorites = Favorites.isEmpty();
        } 
        
        if (typeof $routeParams === 'object' && $routeParams.hasOwnProperty('zipcode')) {            
            $scope.zipcodes = ZipCodes.get({code: $routeParams.zipcode}, function (zipcode) {
               console.log(zipcode) 
            });
        }
    }]);