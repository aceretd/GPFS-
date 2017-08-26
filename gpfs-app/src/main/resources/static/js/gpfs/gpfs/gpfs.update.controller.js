angular
    .module('AdminUI')
    .controller('GpfsUpdateController', GpfsUpdateController);

function GpfsUpdateController($scope, $state, $filter, gpfs) {
	console.debug('Gpfs update controller');
	$scope.gpfs = gpfs;
	$scope.updateGpfs.gpfs = $scope.gpfs;
	$scope.pageTitle = $state.current.title;
	$scope.noteIndex = $state.current.noteIndex;

	$scope.note = function (idx) {
		if (!$scope.gpfs.notes) {
			return {};
		}
		return $scope.gpfs.notes.filter(function (note) {
			return note.index === idx;
		})[0];
	};

	$scope.updateTemplate = function (qap) {
		if (qap.editTemplateMode) {
			return;
		}
		qap.template = $filter('replace')(qap.question.template, '<answer>', qap.answer);
	};

	//initialize templates if blank
	$scope.gpfs.$promise.then(function () {
		for (let i in $scope.gpfs.notes) {
			let note = $scope.gpfs.notes[i];
			for (let j in note.questions) {
				$scope.updateTemplate(note.questions[j]);
			}
		}
	});

	$scope.isActivated = function (qap) {
		if (!qap.question.activationCondition) {
			return true;
		} else {
			console.debug('Checking activation condition. condition=' + qap.question.activationCondition);
			let isActivated = $parse(qap.question.activationCondition);
			return isActivated($scope.updateGpfs);
		}
	};

}
