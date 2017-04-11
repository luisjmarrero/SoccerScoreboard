/**
 * Created by Luis Marrero on 8/4/2017.
 */

(function(){
    'use strict';

    angular
        .module('app')
        .controller('PlayerController', PlayerController);

    PlayerController.$inject = ['$http', '$scope'];

    function PlayerController($http, $scope) {
        var pm = this;

        pm.players = [];
        pm.teams = [];
        pm.getAll = getAll;
        pm.getAllOrderedByTeam = getAllOrderedByTeam;
        pm.numbers = [];
        pm.fillNumbers = fillNumbers;
        pm.activePlayer = {};
        pm.changeActivePlayer = changeActivePlayer;
        pm.newPlayer = {};
        pm.team = {};
        pm.deletePlayer = deletePlayer;
        pm.search = "";
        pm.getTeams = getTeams;

        init();

        function init(){
            getAll();
            getTeams();
            fillNumbers();
        }

        function getAll(){
            var url = "/players/all";
            var gamePromise = $http.get(url);
            gamePromise.then(function(response){
                pm.players = response.data;
            });
        }

        function getAllOrderedByTeam(){
            // alert('got it!');
            var url = "/players/all/ordered/team";
            var gamePromise = $http.get(url);
            gamePromise.then(function(response){
                pm.players = response.data;
            });
        }
        
        function fillNumbers() {
            for (var i = 0; i <= 100; i++) {
                pm.numbers.push(i);
            }
        }

        function changeActivePlayer(index) {
            pm.activePlayer = index;
        }

        $scope.createPlayer = function (){
            var jsonObj = JSON.parse(pm.team);
            pm.newPlayer.team = jsonObj;
            var url = "/players/create";
            console.debug(pm.newPlayer);
            $http.post(url, pm.newPlayer).then(function(response){
                pm.players = response.data;
            });
        }

        function getTeams(){
            var url = "/teams/all";
            var gamePromise = $http.get(url);
            gamePromise.then(function(response){
                pm.teams = response.data;
            });
        }

        function deletePlayer(id){
            var isConfirmed = confirm("Seguro que desea borrar este juego?", false);
            if (isConfirmed) {
                var url = "/players/delete/" + id;
                $http.delete(url).then(function (response) {
                    pm.players = response.data;
                });
            } else {
                return false;
            }
        }

    }

})();