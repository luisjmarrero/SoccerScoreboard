/**
 * Created by Luis Marrero on 8/4/2017.
 */

(function(){
    'use strict';

    angular
        .module('app')
        .controller('GameController', GameController);

    GameController.$inject = ['$http', '$window', '$scope'];

    function GameController($http, $window, $scope) {
        var vm = this;

        vm.games = [];
        vm.getAll = getAll;

        init();

        function init(){
            getAll();
        }

        function getAll(){
            var url = "/games/all";
            var gamePromise = $http.get(url);
            gamePromise.then(function(response){
                vm.games = response.data;
            });
        }

        // $scope.openForm = function openForm() {
        //
        //     alert('works!');
        //
        //
        //
        //
        // };


    }
})();