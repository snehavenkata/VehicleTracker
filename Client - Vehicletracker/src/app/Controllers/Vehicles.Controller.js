(function() {
    'use strict';
    angular.module('plunker')
        .controller('CarController', CarController);

    CarController.$inject = ['userService'];

    function CarController(userService) {
        var carVm = this;

        userService.get().then(function(response) {
            carVm.Vehicles = response;
        }, function(error) {
            console.log(error);
        });


    }
})();