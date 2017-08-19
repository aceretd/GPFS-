angular
    .module('AdminUI')
    .controller('GpfsCoaController', GpfsCoaController);

function GpfsCoaController($scope, $state, gpfs) {
	console.debug('Gpfs coa controller');
	$scope.gpfs = gpfs;
}
