/**
 * Created by sneha on 6/17/2017.
 */
(function() {
    'use strict';
    angular.module('plunker')
        .service('userService', userService);

    userService.$inject = ['$q', '$http'];

    function userService($q, $http) {
        var self = this;

        self.get = getVehicles;


        function getVehicles() {
            return $http.get('http://localhost:8081/api/Vehicles')
                .then(successFn, errorFn);
        }


        function successFn(response) {
            return response.data;
        }

        function errorFn(error) {
            return $q.reject(error);
        }
    }
})();