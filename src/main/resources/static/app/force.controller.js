/**
 * Created by Luis Marrero on 8/4/2017.
 */

(function(){
    'use strict';

    angular
        .module('app')
        .controller('LiveController', LiveController);

    LiveController.$inject = ['$http'];

    function LiveController($http) {
        var vm = this;

        vm.games = [];
        vm.getAll = getAll;

        init();

        function init(){

        }

    }
})();