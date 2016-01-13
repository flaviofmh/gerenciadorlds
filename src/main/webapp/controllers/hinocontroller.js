var ldsApp = angular.module('ldsApp', ['ngRoute'])
	.config(function($routeProvider) {
		$routeProvider.when('/hinos', {
            templateUrl: 'hinos/listarHinos.html',
            controller: 'HinosListCtrl'
        });
		
		$routeProvider.when('/hinos/hinoform', {
            templateUrl: 'hinos/lancarHino.html',
            controller: 'HinoEditCtrl'
        });
		
		$routeProvider.otherwise({redirectTo: '/hinos'});
});

ldsApp.controller('HinosListCtrl', function ($scope, $http) {
	  $scope.nome = "Flávio Monteiro Honorato";
	  $scope.hinos = [];
	  $http.get('http://localhost:8080/gerenciadorlds/lds/hino/todoshinos').success(function(data) {
		  $scope.hinos = data;
	  });
	  
	  $scope.orderProp = 'numero';
});