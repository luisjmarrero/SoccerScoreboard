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
        pm.getAll = getAll;
        pm.getAllOrderedByTeam = getAllOrderedByTeam;
        pm.numbers = [];
        pm.fillNumbers = fillNumbers;
        pm.activePlayer = {};
        pm.changeActivePlayer = changeActivePlayer;
        $scope.newPlayer = {};
        pm.team = {};
        pm.deletePlayer = deletePlayer;
        pm.getTeam = getTeam;
        pm.search = "";
        // pm.createPlayer = createPlayer;

        init();

        function init(){
            getAll();
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
            alert('got it!');
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

        // FIXME
        function changeActivePlayer(index) {
            pm.activePlayer = index;
        }

        $scope.createPlayer = function (){
            alert(pm.team);
            var url = "/players/create";
            $scope.newPlayer.team = pm.team;
            $http.post(url, $scope.newPlayer).then(function(response){
                pm.players = response.data;
            });
        }

        function getTeam(id) {
            var url = "/teams/" + id;
            $scope.newPlayer.team = $scope.team;
            $http.post(url, $scope.newPlayer).then(function(response){
                pm.players = response.data;
            });
        }

        function deletePlayer(id){
            var url = "/players/delete/" + id;
            $http.delete(url).then(function(response){
                pm.players = response.data;
            });
        }
    }

})();