/**
 * Created by Luis Marrero on 9/4/2017.
 */

(function () {
    'use strict';

    angular
        .module('app')
        .controller('LiveController', LiveController);

    LiveController.$inject = ['$http', '$scope'];

    function LiveController($http, $scope) {
        var vm = this;

        // $scope.extra = 0;
        // $scope.running = 1;
        vm.time = 0;
        vm.running = false;
        vm.start = start;
        vm.stop = stop;
        vm.change = change;

        init();

        // incrementTimer = function() {
        //     $scope.timer += 1;
        // };

        function init() {

        }

        function start() {
            vm.time++;

            // while($scope.running == 1) {
            //     setTimeout( function timer(){
            //         $scope.extra++;
            //     }, 1000 );
            // }
        }

        function stop() {
            alert("hello!");
            // for (var i=1; i<10; i++) {
            //     setTimeout( function timer(){
            //         alert("hello world");
            //     }, 1000 );
            // }
        }

        function change(val) {
            // if (vm.running == true)
            //     vm.running = true;
            // else
            vm.running = val;
        }

    }
})();