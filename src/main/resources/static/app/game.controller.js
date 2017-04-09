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
        vm.activeGame = {};
        vm.changeActiveGame = changeActiveGame;
        vm.removeGame = removeGame;
        vm.plays = [];
        vm.getPlays = getPlays;
        vm.localPlayers = [];
        vm.getTeamLocal = getTeamLocal;
        vm.awayPlayers = [];
        vm.getTeamAway = getTeamAway;
        vm.search = "";

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

        function changeActiveGame(index) {
            vm.activeGame = index;
        }

        function removeGame(index) {
            var isConfirmed = confirm("Seguro que desea borrar este juego?", false);
            if(isConfirmed){
                var url = "/games/delete/" + index.game_id;
                var gamePromise = $http.delete(url);
                gamePromise.then(function(response){
                    vm.games = response.data;
                });
            }else{
                return false;
            }
        };

        function getPlays(game){
            var url = "/plays/all/ordered/game/" + game.game_id;
            var gamePromise = $http.get(url);
            gamePromise.then(function(response){
                vm.plays = response.data;
            });
        }

        function getTeamLocal(team){
            var url = "/players/team/" + team.team_id;
            var gamePromise = $http.get(url);
            gamePromise.then(function(response){
                vm.localPlayers = response.data;
            });
        }

        function getTeamAway(team){
            var url = "/players/team/" + team.team_id;
            var gamePromise = $http.get(url);
            gamePromise.then(function(response){
                vm.awayPlayers = response.data;
            });
        }

    }
})();