angular.module('ldsApp').controller('HinoEditCtrl', function ($scope, $http) {
	$scope.hino = {};
	$scope.mensagem = '';
    $scope.submeter = function() {
    	if ($scope.formulario.$valid) {
    		$scope.dataconvertida = $scope.hino.dataUsado;
    		$scope.hino.dataUsado = new Date($scope.dataconvertida);
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
    		
//    		$http.post('http://localhost:8080/gerenciadorlds/rest/hinos/inserirhino',$scope.hino).success(function(data){
//    			console.log(data);
//    		}, function(err){
//    			console.log(err);
//    		})
    	}
    };
});