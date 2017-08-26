angular
    .module('AdminUI')
    .controller('GpfsNote1Controller', GpfsNote1Controller);

function GpfsNote1Controller($scope, ReferenceService, gpfs) {
	console.debug('Gpfs note1 controller');
	$scope.gpfs = gpfs;
	$scope.updateGpfs.gpfs = $scope.gpfs;
	$scope.principalActivities = [];

	$scope.refreshPrincipalActivities = function (term) {
		let searchTerm = '\'' + term + '\'';
		let activitySearchParams = {term: 'activity=like=' + searchTerm, page: 1, count: 10};
		ReferenceService.principalActivity(activitySearchParams, function (page) {
	        $scope.principalActivities = page.content;
	    });
	};

}
