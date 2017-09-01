angular
    .module('AdminUI')
    .controller('GpfsRootController', GpfsRootController);

function GpfsRootController($scope, $state, $parse, GpfsService, company) {
	let INITIAL_YEAR = 2001;
	let CURRENT_YEAR = $scope.initialYear = new Date().getFullYear();
	let PREVIOUS_YEAR = CURRENT_YEAR - 1;

	console.debug('Gpfs root controller');

	function sumOfChildren(fs) {
		let sum = 0;
		if (fs.children) {
			for (let i in fs.children) {
				sum += sumOfChildren(fs.children[i]);
			}
		} else {
			sum += fs.currentYearValue || 0;
			sum += fs.previousYearValue || 0;
		}
		return sum;
	}

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
					let qap = note.questions[j];
					if (qap.question.series === idx) {
						switch (qap.question.type) {
						case 'MULTIPLE_SELECT':
							let enumAnswer = [];
							for (let k in qap.enumerationAnswers) {
								if (qap.enumerationAnswers[k] === 'Y') {
									enumAnswer.push(qap.question.answers[k].answer);
								}
							}
							return enumAnswer.join(', ');
						default:
							return qap.answer;
						}
					}
				}
			}
		},
		coa: function (acctNo) {
			for (let i in $scope.updateGpfs.gpfs.coa.children) {
				let fs1 = $scope.updateGpfs.gpfs.coa.children[i];
				for (let j in fs1.children) {
					let fs2 = fs1.children[j];
					for (let k in fs2.children) {
						let fs3 = fs2.children[k];
						for (let l in fs3.children) {
							let fs4 = fs3.children[l];
							if (fs4.accountNumber === acctNo) {
								let fs4Sum = sumOfChildren(fs4);
								return fs4Sum;
							}
							for (let m in fs4.children) {
								let fs5 = fs4.children[m];
								let fs5AccountNo = $scope.accountNumber(fs4, fs5, {accountNumber: 0});
								if (fs5AccountNo === acctNo) {
									let fs5Sum = sumOfChildren(fs5);
									return fs5Sum;
								}
							}
						}
					}
				}
			}
			return false;
		}
	};

	$scope.company = company;
	$scope.sequence = [
		'gpfs.create',
		'gpfs.update.coa',
		'gpfs.update.note1',
		'gpfs.update.note2',
		'gpfs.update.note3',
		'gpfs.update.note4',
		'gpfs.update.note5'
	];

	$scope.save = function () {
		return GpfsService.save($scope.updateGpfs.gpfs, function (data) {
			$scope.updateGpfs.gpfs = data;
			swal('Save successful');
		});		
	};
	$scope.back = function () {
		//Go to the prev state
		let currentState = $state.current.name;
		console.debug('going to previous state! current state=' + currentState);
		let nextState = $scope.sequence.indexOf(currentState) - 1;
		console.debug('next state index=' + nextState + ', name=' + $scope.sequence[nextState]);

		$scope.updateGpfs.gpfs.nextState = $scope.sequence[nextState];
		$scope.save().$promise.then(function () {
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
		$scope.save().$promise.then(function () {
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
