angular
    .module('AdminUI')
    .controller('GpfsNavigationCtrl', GpfsNavigationCtrl);

function GpfsNavigationCtrl($scope) {

	$scope.$on('set-active-gpfs', function (evt, gpfs) {
		$scope.gpfs = gpfs;
	});

}
