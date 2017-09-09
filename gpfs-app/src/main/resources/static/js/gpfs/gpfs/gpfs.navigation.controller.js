angular
    .module('AdminUI')
    .controller('GpfsNavigationCtrl', GpfsNavigationCtrl);

function GpfsNavigationCtrl($scope) {

	$scope.$on('set-active-gpfs', function (evt, gpfs) {
		console.debug('Set active gpfs! gpfs=' + JSON.stringify(gpfs));
		$scope.gpfs = gpfs;
	});

}
