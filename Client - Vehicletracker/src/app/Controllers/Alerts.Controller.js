/**
 * Created by sneha on 6/18/2017.
 */
(function(){
    'use strict';
    angular.module('plunker')
        .controller('alertController',alertController);

    alertController.$inject = ['alertService'];

    function alertController(alertService) {

        var alertVm = this;

        alertService.getAlerts()
            .then(function (alerts) {
                alertVm.alerts = alerts;
            }, function (error) {
                console.log(error);
            });


    }
})();


