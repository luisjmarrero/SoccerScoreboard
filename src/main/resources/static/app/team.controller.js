/**
 * Created by Luis Marrero on 9/4/2017.
 */

(function(){
    'use strict';

    angular
        .module('app')
        .controller('TeamController', TeamController);

    TeamController.$inject = ['$http', '$scope'];

    function TeamController($http, $scope) {
        var vm = this;

        vm.teams = [];
        vm.getAll = getAll;
        vm.search = "";
        vm.newTeam = {};
        vm.activeTeam = {};
        vm.deleteTeam = deleteTeam;
        vm.changeActiveTeam = changeActiveTeam;

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

        $scope.createTeam = function(){
            var url = "/teams/create";
            $http.post(url, vm.newTeam).then(function (response) {
                vm.teams = response.data;
            })
        }

        function deleteTeam(id){
            var isConfirmed = confirm("Seguro que desea borrar este equipo?", false);
            if (isConfirmed) {
                var url = "/teams/delete/" + id;
                $http.delete(url).then(function (response) {
                    vm.teams = response.data;
                });
            } else {
                return false;
            }
        }

        $scope.updateTeam = function(){
            var url = "/teams/create";
            $http.post(url, vm.activeTeam).then(function (response) {
                vm.teams = response.data;
            })
        }

        function changeActiveTeam(index) {
            // console.log(index);
            vm.activeTeam = index;
        }
    }
})();