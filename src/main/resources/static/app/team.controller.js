/**
 * Created by Luis Marrero on 9/4/2017.
 */

(function(){
    'use strict';

    angular
        .module('app')
        .controller('TeamController', TeamController);

    TeamController.$inject = ['$http'];

    function TeamController($http) {
        var vm = this;

        vm.teams = [];
        vm.getAll = getAll;
        vm.search = "";

        init();

        function init(){
            getAll();
        }

        function getAll(){
            var url = "/teams/all";
            var gamePromise = $http.get(url);
            gamePromise.then(function(response){
                vm.teams = response.data;
            });
        }
    }
})();