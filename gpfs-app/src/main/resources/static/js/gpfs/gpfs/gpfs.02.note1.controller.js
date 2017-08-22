angular
    .module('AdminUI')
    .controller('GpfsNote1Controller', GpfsNote1Controller);

function GpfsNote1Controller($scope, $state, ReferenceService, gpfs) {
	console.debug('Gpfs note1 controller');
	$scope.gpfs = gpfs;
	$scope.updateGpfs.gpfs = $scope.gpfs;
	$scope.principalActivities = [];
//	$scope.questions = questions;

	if (!gpfs.note1) {
		console.debug('Getting note1')
	} else {
		console.debug('No need to update Note 1. note1=' + JSON.stringify(gpfs.note1));
	}

	$scope.refreshPrincipalActivities = function (term) {
		console.debug('Searching for term=' + term);
		let activitySearchParams = {term: 'activity=like=' + term, page: 1, count: 10};
		ReferenceService.principalActivity(activitySearchParams, function (page) {
	        $scope.principalActivities = page.content;
	    });
	}

}
