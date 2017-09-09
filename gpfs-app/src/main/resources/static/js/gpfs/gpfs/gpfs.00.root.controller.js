angular
    .module('AdminUI')
    .controller('GpfsRootController', GpfsRootController);

function GpfsRootController($scope, $state, $parse, GpfsService, ScheduleService, company) {
	let INITIAL_YEAR = 2001;
	let CURRENT_YEAR = $scope.initialYear = new Date().getFullYear();
	let PREVIOUS_YEAR = CURRENT_YEAR - 1;

	console.debug('Gpfs root controller');

	function sumOfChildren(fs) {
		console.debug('Attempting to find sum of children (CY + PY) FS name =' + fs.name);
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
	function sumOfChildrenCy(fs) {
		console.debug('Attempting to find sum of children (CY) FS name =' + fs.name);
		let sum = 0;
		if (fs.children) {
			for (let i in fs.children) {
				sum += sumOfChildren(fs.children[i]);
			}
		} else {
			sum += fs.currentYearValue || 0;
		}
		return sum;
	}
	function sumOfChildrenPy(fs) {
		console.debug('Attempting to find sum of children (PY) FS name =' + fs.name);
		let sum = 0;
		if (fs.children) {
			for (let i in fs.children) {
				sum += sumOfChildren(fs.children[i]);
			}
		} else {
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

	$scope.getSchedule = function (index) {
		let matchingSchedule =  $scope.updateGpfs.gpfs.schedules.find(function (schedule) {
			return schedule.index === index;
		});
		if (!$scope.updateGpfs.gpfs.schedules) {
			$scope.updateGpfs.gpfs.schedules = [];
		}
		if (!matchingSchedule) {
			matchingSchedule = ScheduleService.getSchedule(index);
			$scope.updateGpfs.gpfs.schedules.push(matchingSchedule);
		}
		return matchingSchedule;
	}

	$scope.coaSumCy = function (lvl, lvlName) {
		for (let i in $scope.updateGpfs.gpfs.coa.children) {
			let fs1 = $scope.updateGpfs.gpfs.coa.children[i];

			//return lvl 1 sum
			if (lvl === 1 && lvlName === fs1.name) {
				return sumOfChildrenCy(fs1);
			}

			for (let j in fs1.children) {
				let fs2 = fs1.children[j];

				//return lvl 2 sum
				if (lvl === 2 && lvlName === fs2.name) {
					return sumOfChildrenCy(fs2);
				}

				for (let k in fs2.children) {
					let fs3 = fs2.children[k];

					//lvl 3 sum
					if (lvl === 3 && lvlName === fs3.name) {
						return sumOfChildrenCy(fs3);
					}

					for (let l in fs3.children) {
						let fs4 = fs3.children[l];

						//lvl 4 sum
						if (lvl === 4 && lvlName === fs4.name) {
							return sumOfChildrenCy(fs4);
						}

						for (let m in fs4.children) {
							let fs5 = fs4.children[m];

							//lvl 5 sum
							if (lvl === 5 && lvlName === fs5.name) {
								return sumOfChildrenCy(fs5);
							}
						}
					}
				}
			}
		}
		console.warn('Unable to find CY sum at level! level=' + lvl + ', name=' + lvlName);
		return 0;
	};
	$scope.coaSumPy = function (lvl, lvlName) {
		for (let i in $scope.updateGpfs.gpfs.coa.children) {
			let fs1 = $scope.updateGpfs.gpfs.coa.children[i];

			//return lvl 1 sum
			if (lvl === 1 && lvlName === fs1.name) {
				return sumOfChildrenPy(fs1);
			}

			for (let j in fs1.children) {
				let fs2 = fs1.children[j];

				//return lvl 2 sum
				if (lvl === 2 && lvlName === fs2.name) {
					return sumOfChildrenPy(fs2);
				}

				for (let k in fs2.children) {
					let fs3 = fs2.children[k];

					//lvl 3 sum
					if (lvl === 3 && lvlName === fs3.name) {
						return sumOfChildrenPy(fs3);
					}

					for (let l in fs3.children) {
						let fs4 = fs3.children[l];

						//lvl 4 sum
						if (lvl === 4 && lvlName === fs4.name) {
							return sumOfChildrenPy(fs4);
						}

						for (let m in fs4.children) {
							let fs5 = fs4.children[m];

							//lvl 5 sum
							if (lvl === 5 && lvlName === fs5.name) {
								return sumOfChildrenPy(fs5);
							}
						}
					}
				}
			}
		}
		console.warn('Unable to find PY sum at level! level=' + lvl + ', name=' + lvlName);
		return 0;
	};

}
