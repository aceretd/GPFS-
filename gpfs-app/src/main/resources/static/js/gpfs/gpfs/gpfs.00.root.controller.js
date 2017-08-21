angular
    .module('AdminUI')
    .controller('GpfsRootController', GpfsRootController);

function GpfsRootController($scope, $state, GpfsService, company) {
	let INITIAL_YEAR = 2001;
	let CURRENT_YEAR = $scope.initialYear = new Date().getFullYear();
	let PREVIOUS_YEAR = CURRENT_YEAR - 1;

	console.debug('Gpfs root controller');

	$scope.company = company;
	$scope.sequence = [
		'gpfs.create',
		'gpfs.update.coa'
	];
	$scope.gpfs = {
		company: company,
		year: PREVIOUS_YEAR
	}
	$scope.back = function () {
		//Go to the prev state
		let currentState = $state.current.name;
		console.debug('going to previous state! current state=' + currentState);
		let nextState = $scope.sequence.indexOf(currentState) - 1;
		console.debug('next state index=' + nextState + ', name=' + $scope.sequence[nextState]);

		$scope.gpfs.nextState = nextState;

		GpfsService.save($scope.gpfs, function (data) {
			$scope.gpfs = data;
			$state.go($scope.sequence[nextState], {companyId: $scope.gpfs.company.id, year: $scope.gpfs.year});
		});
	};
	$scope.next = function () {
		//Go to the next state
		let currentState = $state.current.name;
		console.debug('going to next state! current state=' + currentState);
		let nextState = $scope.sequence.indexOf(currentState) + 1;
		console.debug('next state index=' + nextState + ', name=' + $scope.sequence[nextState]);

		$scope.gpfs.nextState = nextState;

		GpfsService.save($scope.gpfs, function (data) {
			$scope.gpfs = data;
			$state.go($scope.sequence[nextState], {companyId: $scope.gpfs.company.id, year: $scope.gpfs.year});
		});
	};

	$scope.years = [];
	for (let i = INITIAL_YEAR; i < CURRENT_YEAR; i++) {
		$scope.years.push(i);
	}

	$scope.accountNumber = function (fs4, fs5, fs6) {
		return parseInt(fs4.accountNumber) + parseInt(fs5.accountNumber) + parseInt(fs6.accountNumber);
	};

}
