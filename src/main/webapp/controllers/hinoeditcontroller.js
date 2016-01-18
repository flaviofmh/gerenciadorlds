angular.module('ldsApp').controller('HinoEditCtrl', function ($scope, $http, $routeParams) {
	$scope.hino = {};
	$scope.mensagem = '';
	
	if($routeParams.hinoId) {
//		$http({
//			  method: 'GET',
//			  url: 'http://localhost:8080/gerenciadorlds/lds/hino/selecionar/'+$routeParams.hinoId
//			}).then(function successCallback(data) {
//				$scope.hino = data;
//			  }, function errorCallback(response) {
//				  $scope.mensagem = 'Não foi possível selecionar o hino!';
//			});
//		$http.get('http://localhost:8080/gerenciadorlds/lds/hino/selecionar/'+$routeParams.hinoId).then(function successCallback(hino) {
//			$scope.hino = hino;
//		  }, function errorCallback(response) {
//			  $scope.mensagem = 'Não foi possível selecionar o hino!';
//		  });
		$http.get('http://localhost:8080/gerenciadorlds/lds/hino/selecionar/'+$routeParams.hinoId).success(function(data) {
			  $scope.hino = data;
		  });
	}
	
    $scope.submeter = function() {
    	if ($scope.formulario.$valid) {
    		$scope.dataconvertida = $scope.hino.dataUsado;
    		$scope.hino.dataUsado = new Date($scope.dataconvertida);
    		if($routeParams.hinoId) {
    			$http({
  				  method: 'PUT',
  				  url: 'http://localhost:8080/gerenciadorlds/lds/hino/inserir',
  				  data : $scope.hino,
  				  headers: {
  				        'Content-Type': 'application/json'
  				  }
  				}).then(function successCallback(response) {
  					$scope.mensagem = 'Hino atualizado com sucesso';
  					$scope.hino = {};
  				  }, function errorCallback(response) {
  					  $scope.mensagem = 'Não foi possível atualizar o hino';
  				});
    		} else {
		    	$http({
				  method: 'POST',
				  url: 'http://localhost:8080/gerenciadorlds/lds/hino/inserir',
				  data : $scope.hino,
				  headers: {
				        'Content-Type': 'application/json'
				  }
				}).then(function successCallback(response) {
					$scope.mensagem = 'Hino salvo com sucesso';
					$scope.hino = {};
				  }, function errorCallback(response) {
					  $scope.mensagem = 'Não foi possível registrar o hino';
				});
    		}
    	}
    };
});