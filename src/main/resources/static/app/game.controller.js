/**
 * Created by Luis Marrero on 8/4/2017.
 *
 * Tus reales forces....
 */

(function(){
    'use strict';

    angular
        .module('app')
        .controller('GameController', GameController)
        .filter('mmss', mmss);

    GameController.$inject = ['$http', '$scope', '$timeout', '$window'];

    function GameController($http, $scope, $timeout, $window) {
        var vm = this;

        vm.playTypes = [];
        vm.getPlayTypes = getPlayTypes;
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
        vm.local = false;
        vm.started = false;
        vm.change = change;
        vm.lastGame = [];
        vm.getLastGame = getLastGame;
        vm.getLastPlays = getLastPlays;
        vm.getTeamLocalCurrent = getTeamLocalCurrent;
        vm.getTeamAwayCurrent = getTeamAwayCurrent;

        vm.saveGame = saveGame;
        vm.teamSelected = {};
        vm.newPlay = {};

        vm.newGame = {};

        init();

        function init(){
            getAll();
            getPlayTypes();
        }

        function getPlayTypes() {
            var url = "/plays/types";
            var gamePromise = $http.get(url);
            gamePromise.then(function(response){
                vm.playTypes = response.data;
            });
        }

        function getAll(){
            var url = "/games/all/ordered";
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
        }

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

        function getLastGame() {
            var url = "/games/last";
            var gamePromise = $http.get(url);
            gamePromise.then(function(response){
                // FORCE
                vm.lastGame = response.data;
                vm.lastGame = JSON.stringify(vm.lastGame);
                vm.lastGame = JSON.parse(String(vm.lastGame));

                getLastPlays();
                getTeamLocalCurrent();
                getTeamAwayCurrent();
            });


        }

        function getLastPlays(){
            var url = "/plays/all/ordered/game/" + vm.lastGame.game_id;
            var gamePromise = $http.get(url);
            gamePromise.then(function(response){
                vm.plays = response.data;
            });
        }

        function getTeamLocalCurrent(){
            var url = "/players/team/" + vm.lastGame.teamA.team_id;
            var gamePromise = $http.get(url);
            gamePromise.then(function(response){
                vm.localPlayers = response.data;
            });
        }

        function getTeamAwayCurrent(){
            var url = "/players/team/" + vm.lastGame.teamB.team_id;
            var gamePromise = $http.get(url);
            gamePromise.then(function(response){
                vm.awayPlayers = response.data;
            });
        }

        function saveGame(){
            var isConfirmed = confirm("Seguro que desea guardar este juego?", false);
            if(isConfirmed){
                $window.location.href = '/juegos';
            }else{
                return false;
            }
        }

        $scope.savePlay = function (){
            vm.newPlay.type = JSON.parse(vm.newPlay.type);
            vm.newPlay.player_a = JSON.parse(vm.newPlay.player_a);
            vm.newPlay.game = vm.lastGame;
            vm.newPlay.minute = $scope.timerWithTimeout/60;
            var url = "/plays/create";
            $http.post(url, vm.newPlay).then(function(response){
                vm.plays = response.data;
                getLastGame();
            });
        }

        $scope.createGame = function () {
            console.log(vm.newGame);
            vm.newGame.teamA = JSON.parse(vm.newGame.teamA);
            vm.newGame.teamB = JSON.parse(vm.newGame.teamB);

            var url = "/games/create";
            $http.post(url, vm.newGame).then(function(response){
                vm.games = response.data;
            });

            $window.location.href = '/live';

        }

        $scope.onloadFun = function() {
            getLastGame();
        }

        function change(value) {
            vm.started = value;
        }

        //timer with timeout
        $scope.timerWithTimeout = 0;
        $scope.startTimerWithTimeout = function () {
            $scope.timerWithTimeout = 0;
            if ($scope.myTimeout) {
                $timeout.cancel($scope.myTimeout);
            }
            $scope.onTimeout = function () {
                if ($scope.timerWithTimeout < 5400) $scope.timerWithTimeout++;
                $scope.myTimeout = $timeout($scope.onTimeout, 10);
            }
            $scope.myTimeout = $timeout($scope.onTimeout, 10);
        };
    }

    function mmss() {
        return function (time) {
            var sec_num = parseInt(time, 10);
            var minutes = Math.floor(sec_num / 60);
            var seconds = sec_num - (minutes * 60);

            if (minutes < 10) {
                minutes = "0" + minutes;
            }
            if (seconds < 10) {
                seconds = "0" + seconds;
            }
            var time = minutes + ':' + seconds;
            return time;
        }
    }
})();