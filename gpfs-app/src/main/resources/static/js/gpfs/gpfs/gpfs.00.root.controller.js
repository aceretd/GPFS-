angular
    .module('AdminUI')
    .controller('GpfsRootController', GpfsRootController);

function GpfsRootController($scope, $state, $parse, GpfsService, company) {
	let INITIAL_YEAR = 2001;
	let CURRENT_YEAR = $scope.initialYear = new Date().getFullYear();
	let PREVIOUS_YEAR = CURRENT_YEAR - 1;

	console.debug('Gpfs root controller');

	$scope.updateGpfs = {
		gpfs: {
			company: company,
			year: PREVIOUS_YEAR,
			notes: []
		},
		answer: function (idx) {
			for (let i in $scope.updateGpfs.gpfs.notes) {
				let note = $scope.updateGpfs.gpfs.notes[i];
				for (let j in note.questions) {
					if (note.questions[j].question.series === idx) {
						return note.questions[j].answer;
					}
				}
			}
		}
	};

	$scope.company = company;
	$scope.sequence = [
		'gpfs.create',
		'gpfs.update.coa',
		'gpfs.update.note1',
		'gpfs.update.note2'
	];

	$scope.back = function () {
		//Go to the prev state
		let currentState = $state.current.name;
		console.debug('going to previous state! current state=' + currentState);
		let nextState = $scope.sequence.indexOf(currentState) - 1;
		console.debug('next state index=' + nextState + ', name=' + $scope.sequence[nextState]);

		$scope.updateGpfs.gpfs.nextState = $scope.sequence[nextState];

		GpfsService.save($scope.updateGpfs.gpfs, function (data) {
			$scope.updateGpfs.gpfs = data;
			$state.go($scope.sequence[nextState], {companyId: $scope.updateGpfs.gpfs.company.id, year: $scope.updateGpfs.gpfs.year});
		});
	};
	$scope.next = function () {
		//Go to the next state
		let currentState = $state.current.name;
		console.debug('going to next state! current state=' + currentState);
		let nextState = $scope.sequence.indexOf(currentState) + 1;
		console.debug('next state index=' + nextState + ', name=' + $scope.sequence[nextState]);

		$scope.updateGpfs.gpfs.nextState = $scope.sequence[nextState];

		GpfsService.save($scope.updateGpfs.gpfs, function (data) {
			$scope.updateGpfs.gpfs = data;
			$state.go($scope.sequence[nextState], {companyId: $scope.updateGpfs.gpfs.company.id, year: $scope.updateGpfs.gpfs.year});
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
