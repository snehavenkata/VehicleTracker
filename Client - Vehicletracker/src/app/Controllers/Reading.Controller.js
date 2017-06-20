/**
 * Created by sneha on 6/18/2017.
 */
(function(){
    'use strict';
    angular.module('plunker')
        .controller('readingsController',readingsController);

    readingsController.$inject = ['readingsService'];

    function readingsController(readingsService){

        var readingsVm = this;

        readingsService.getall()
            .then(function(readings){
                readingsVm.readings = readings;
            }, function (error){
                console.log(error);
            })
    }

})();


(function(){
    'use strict';
    angular.module('plunker')
        .controller('readingsByVin',readingsByVin);

    readingsByVin.$inject = ['$scope','readingsService','$routeParams','$location'];

    function readingsByVin($scope,readingsService,$routeParams,$location) {
        var readingsVm = this;

        readingsService.getByVin($routeParams.vin)
            .then(function (readings) {
                readingsVm.readings = readings;
            }, function (error) {
                console.log(error);
            });

        readingsVm.vinValue = $routeParams.vin;
    }
    })();