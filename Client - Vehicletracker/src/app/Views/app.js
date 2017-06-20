/**
 * Created by sneha on 6/17/2017.
 */
(function() {
    'use strict';
    angular.module('plunker', ['ngRoute']);


    angular.module('plunker')
        .config(moduleConfig);

    moduleConfig.$inject = ['$routeProvider'];

    function moduleConfig($routeProvider) {
        $routeProvider
            .when('/Vehicles', {
                templateUrl: 'Vehicles.tmpl.html',
                controller: 'CarController',
                controllerAs: 'carVm'
            })
            .when('/Readings', {
                templateUrl: 'Readings.tmpl.html',
                controller: 'Car1Controller',
                controllerAs: 'readingsVm'
            })
            .when('/Alerts', {
                templateUrl: 'Alerts.tmpl.html',
                controller :'alertController',
                controllerAs:' alertVm',
            })

            .when('/Readings/:vin', {
                templateUrl: 'app/views/readingsbyVin.html',
                controller: 'readingsByVin',
                controllerAs: 'readingsVm'
            })
            .otherwise({
                redirectTo: '/Vehicles'
            })

    }
})();