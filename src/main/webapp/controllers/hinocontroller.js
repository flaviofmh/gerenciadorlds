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
		
		$routeProvider.when('/hinos/edit/:hinoId', {
            templateUrl: 'hinos/lancarHino.html',
            controller: 'HinoEditCtrl'
        });
		
		$routeProvider.otherwise({redirectTo: '/hinos'});
});

ldsApp.controller('HinosListCtrl', function ($scope, $http) {
	  $scope.nome = "Flávio Monteiro Honorato";
	  $scope.mensagem = '';
	  $scope.hinos = [];
	  $http.get('http://localhost:8080/gerenciadorlds/lds/hino/todoshinos').success(function(data) {
		  $scope.hinos = data;
	  });
	  
	  $scope.orderProp = 'numero';
	  
	  $scope.remover = function(hino) {
		  $http.delete('http://localhost:8080/gerenciadorlds/lds/hino/'+hino.id).then(function successCallback(response) {
			  var indiceDoHino = $scope.hinos.indexOf(hino);
			  $scope.hinos.splice(indiceDoHino, 1);
			  $scope.mensagem = 'O hino '+hino.titulo+' foi removido com sucesso.';
		  }, function errorCallback(response) {
			  $scope.mensagem = 'Não foi possível excluir o hino '+hino.titulo+'!';
		  });
	  }
});