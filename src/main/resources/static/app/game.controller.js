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
        // vm.change = change;
        vm.lastGame = [];
        vm.getLastGame = getLastGame;
        vm.getLastPlays = getLastPlays;
        vm.getTeamLocalCurrent = getTeamLocalCurrent;
        vm.getTeamAwayCurrent = getTeamAwayCurrent;

        vm.saveGame = saveGame;
        vm.teamSelected = {};
        vm.newPlay = {};

        vm.newGame = {};
        vm.equalTeams = false;
        vm.manual = false;
        vm.ended = false;

        init();

        function init() {
            getAll();
            getPlayTypes();
        }

        function getPlayTypes() {
            var url = "/plays/types";
            var gamePromise = $http.get(url);
            gamePromise.then(function (response) {
                vm.playTypes = response.data;
            });
        }

        function getAll() {
            var url = "/games/all/ordered";
            var gamePromise = $http.get(url);
            gamePromise.then(function (response) {
                vm.games = response.data;
            });
        }

        function changeActiveGame(index) {
            vm.activeGame = index;
        }

        function removeGame(index) {
            var isConfirmed = confirm("Seguro que desea borrar este juego?", false);
            if (isConfirmed) {
                var url = "/games/delete/" + index.game_id;
                var gamePromise = $http.delete(url);
                gamePromise.then(function (response) {
                    vm.games = response.data;
                });
            } else {
                return false;
            }
        }

        function getPlays(game) {
            var url = "/plays/all/ordered/game/" + game.game_id;
            var gamePromise = $http.get(url);
            gamePromise.then(function (response) {
                vm.plays = response.data;
            });
        }

        function getTeamLocal(team) {
            var url = "/players/team/" + team.team_id;
            var gamePromise = $http.get(url);
            gamePromise.then(function (response) {
                vm.localPlayers = response.data;
            });
        }

        function getTeamAway(team) {
            var url = "/players/team/" + team.team_id;
            var gamePromise = $http.get(url);
            gamePromise.then(function (response) {
                vm.awayPlayers = response.data;
            });
        }

        function getLastGame() {
            var url = "/games/last";
            var gamePromise = $http.get(url);
            gamePromise.then(function (response) {
                vm.lastGame = response.data;
                vm.lastGame = JSON.stringify(vm.lastGame);
                vm.lastGame = JSON.parse(String(vm.lastGame));

                getLastPlays();
                getTeamLocalCurrent();
                getTeamAwayCurrent();
            });

        }

        function getLastPlays() {
            var url = "/plays/all/ordered/game/" + vm.lastGame.game_id;
            var gamePromise = $http.get(url);
            gamePromise.then(function (response) {
                vm.plays = response.data;
            });
        }

        function getTeamLocalCurrent() {
            var url = "/players/team/" + vm.lastGame.teamA.team_id;
            var gamePromise = $http.get(url);
            gamePromise.then(function (response) {
                vm.localPlayers = response.data;
            });
        }

        function getTeamAwayCurrent() {
            var url = "/players/team/" + vm.lastGame.teamB.team_id;
            var gamePromise = $http.get(url);
            gamePromise.then(function (response) {
                vm.awayPlayers = response.data;
            });
        }

        function saveGame() {
            var isConfirmed = confirm("Seguro que desea salir de esta pantalla?", false);
            if (isConfirmed) {
                $window.location.href = '/juegos';
            } else {
                return false;
            }
        }

        $scope.savePlay = function () {
            vm.newPlay.type = JSON.parse(vm.newPlay.type);
            vm.newPlay.player_a = JSON.parse(vm.newPlay.player_a);
            vm.newPlay.game = vm.lastGame;
            vm.newPlay.minute = $scope.timerWithTimeout / 60;
            console.log(vm.newPlay);
            var url = "/plays/create";
            $http.post(url, vm.newPlay).then(function (response) {
                vm.plays = response.data;
                getLastGame();
            });
        };

        $scope.createGame = function () {
            console.log(vm.newGame);
            vm.newGame.teamA = JSON.parse(vm.newGame.teamA);
            vm.newGame.teamB = JSON.parse(vm.newGame.teamB);

            var url = "/games/create";
            $http.post(url, vm.newGame).then(function (response) {
                vm.games = response.data;
            });

            $window.location.href = '/live';
            // }

        };

        $scope.validateTeams = function () {
            if (vm.newGame.teamA == vm.newGame.teamB)
                vm.equalTeams = true;
            else
                vm.equalTeams = false;
        }

        $scope.onloadFun = function () {
            getLastGame();
        };

        // function change(value) {
        //     vm.started = value;
        // }

        //timer with timeout
        $scope.timerWithTimeout = 0;
        $scope.turnSimutalte = 0;
        $scope.lastPlay = 0;

        $scope.startTimerWithTimeout = function () {
            vm.started = true;
            vm.manual = true;
            $scope.timerWithTimeout = 0;
            if ($scope.myTimeout) {
                $timeout.cancel($scope.myTimeout);
            }
            $scope.onTimeout = function () {
                if ($scope.timerWithTimeout < 5400) {
                    $scope.timerWithTimeout++;
                } else {
                    // alert('El partido ha terminado!');
                    vm.ended = true;
                    vm.manual = false;
                }
                $scope.myTimeout = $timeout($scope.onTimeout, 10);
            };
            $scope.myTimeout = $timeout($scope.onTimeout, 10);
        };

        $scope.simulate = function () {
            vm.started = true;
            $scope.timerWithTimeout = 0;
            if ($scope.myTimeout) {
                $timeout.cancel($scope.myTimeout);
            }
            $scope.onTimeout = function () {
                if ($scope.timerWithTimeout < 5400) {
                    $scope.timerWithTimeout++;

                    // select a random play
                    if ($scope.turnSimutalte == 0 && $scope.timerWithTimeout > ($scope.lastPlay + 300)) {
                        var ramdonPlayHome = {
                            team: vm.activeGame.teamA,
                            player_a: vm.localPlayers[Math.floor(Math.random() * vm.localPlayers.length)],
                            game: vm.lastGame,
                            minute: $scope.timerWithTimeout / 60,
                            local: true,
                            type: vm.playTypes[Math.floor(Math.random() * vm.playTypes.length)]
                        };

                        $scope.lastPlay = $scope.timerWithTimeout;

                        var url = "/plays/create";
                        $http.post(url, ramdonPlayHome).then(function (response) {
                            vm.plays = response.data;
                            getLastGame();
                        });

                        $scope.turnSimutalte = 1;
                    } else if ($scope.turnSimutalte == 1 && $scope.timerWithTimeout > ($scope.lastPlay + 300)) {
                        var ramdonPlayAway = {
                            team: vm.activeGame.teamB,
                            player_a: vm.awayPlayers[Math.floor(Math.random() * vm.awayPlayers.length)],
                            game: vm.lastGame,
                            minute: $scope.timerWithTimeout / 60,
                            local: false,
                            type: vm.playTypes[Math.floor(Math.random() * vm.playTypes.length)]
                        };

                        $scope.lastPlay = $scope.timerWithTimeout;

                        var url = "/plays/create";
                        $http.post(url, ramdonPlayAway).then(function (response) {
                            vm.plays = response.data;
                            getLastGame();
                        });

                        $scope.turnSimutalte = 0;
                    }


                } else {
                    // alert('El partido ha terminado!');
                    vm.ended = true;
                    vm.manual = false;
                }
                $scope.myTimeout = $timeout($scope.onTimeout, 10);
            };
            $scope.myTimeout = $timeout($scope.onTimeout, 10);
        }
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