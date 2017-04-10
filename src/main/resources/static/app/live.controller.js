/**
 * Created by Luis Marrero on 9/4/2017.
 */

(function () {
    'use strict';

    angular
        .module('app')
        .controller('LiveController', LiveController);

    LiveController.$inject = ['$http', '$scope', '$timeout'];

    function LiveController($http, $scope, $timeout) {
        var vm = this;

        vm.time = 0;
        vm.running = false;
        vm.start = start;
        vm.stop = stop;
        vm.change = change;
        vm.tick = tick;
        $scope.tickInterval = 1000; //ms
        $scope.minute = 1;

        init();

        function init() {

        }

        function start() {
            vm.time++;

        }

        function stop() {
            alert("hello!");
        }

        function change(val) {
            vm.running = val;
        }

        // FIXME
        function tick() {
            // if (vm.running == true)
            //     $scope.minute++;
            // $scope.clock = Date.now() // get the current time
            $timeout(tick, $scope.tickInterval); // reset the timer
        }

        // Start the timer
        $timeout(tick, $scope.tickInterval);
    }
})();