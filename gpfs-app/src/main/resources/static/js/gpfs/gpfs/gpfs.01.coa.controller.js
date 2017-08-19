angular
    .module('AdminUI')
    .controller('GpfsCoaController', GpfsCoaController);

function GpfsCoaController($scope, $state, gpfs, CoaService) {
	console.debug('Gpfs coa controller');
	$scope.gpfs = gpfs;

	if (!gpfs.coa) {
		CoaService.getTemplate(function (coa) {
			$scope.gpfs.coa = coa;
			console.debug('coa=' + JSON.stringify(coa));
		});
	} else {
		console.debug('No need to update COA. coa=' + JSON.stringify(gpfs.coa));
	}

}
