/**
 * Created by sneha on 6/18/2017.
 */
(function() {
    'use strict';
    angular.module('plunker')
        .service('alertService', alertService);

    alertService.$inject = ['$q', '$http'];

    function alertService($q, $http) {
        var alertVm = this;

        alertVm.getAlerts = getAlerts;
       // alertVm.getAlertsByVin = getAlertsByVin;
      //  alertVm.getLatestAlerts = getLatestAlerts;

        function getAlerts() {
            return $http.get('http://localhost:8081/api/Alerts')
                .then(successFn, errorFn);
        }

        function getAlertsByVin(vin) {
            return $http.get('http://localhost:8081/api/Alerts/' + vin)
                .then(successFn, errorFn)
        }


        function successFn(response) {
            return response.data;
        }

    }
})();