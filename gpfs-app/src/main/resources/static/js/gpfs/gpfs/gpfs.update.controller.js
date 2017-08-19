angular
    .module('AdminUI')
    .controller('GpfsUpdateController', GpfsUpdateController);

function GpfsUpdateController($scope, $state, gpfs) {
	console.debug('Gpfs update controller');
	$scope.gpfs = gpfs;
}
