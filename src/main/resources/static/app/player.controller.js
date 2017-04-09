/**
 * Created by Luis Marrero on 8/4/2017.
 */

(function(){
    'use strict';

    angular
        .module('app')
        .controller('PlayerController', PlayerController);

    PlayerController.$inject = ['$http'];

    function PlayerController($http) {
        var pm = this;

        pm.players = [];
        pm.getAll = getAll;

        init();

        function init(){
            getAll();
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
    }
})();