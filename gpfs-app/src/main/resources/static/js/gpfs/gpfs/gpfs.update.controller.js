angular
    .module('AdminUI')
    .controller('GpfsUpdateController', GpfsUpdateController);

function GpfsUpdateController($scope, $rootScope, $state, $filter, $parse, gpfs) {
	console.debug('Gpfs update controller');
	$scope.gpfs = gpfs;
	$scope.updateGpfs.gpfs = $scope.gpfs;
	$rootScope.$broadcast('set-active-gpfs', $scope.updateGpfs.gpfs);

	$scope.pageTitle = $state.current.title;
	$scope.noteIndex = $state.current.noteIndex;
	$scope.schedules = $state.current.schedules;

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
		switch (qap.question.type) {
		case 'YES_NO':
			if (qap.answer === 'Yes') {
				qap.template = qap.question.template;
			} else if (qap.answer === 'No') {
				qap.template = qap.question.noTemplate;
			}
			break;
		case 'MULTIPLE_CHOICE':
			let selectedAnswer = qap.question.answers.find(function (ans) {
				return ans.answer === qap.answer;
			});
			if (selectedAnswer) {
				qap.template = selectedAnswer.template;
			}
			break;
		case 'MULTIPLE_SELECT':
			let template = qap.question.template;
			for (let i in qap.enumerationAnswers) {
				if (qap.enumerationAnswers[i] === 'Y' && qap.question.answers[i].template) {
					if (template) {
						template += '\n\n';
					}
					template += qap.question.answers[i].template;
				}
			}
			template = $scope.replaceVariables(template);
			console.debug('Got replaced template=' + template); 
			qap.template = template;
			break;
		default:
			qap.template = $filter('replace')(qap.question.template, '<answer>', qap.answer);
		}
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
			let isActivated = $parse(qap.question.activationCondition);
			let isActivatedAns = isActivated($scope.updateGpfs);
			return isActivatedAns;
		}
	};

	$scope.hasTemplate = function (qap) {
		switch(qap.question.type) {
		case 'YES_NO':
			return qap.question.template || qap.question.noTemplate;
		default:
			return true;
		}
	};

	$scope.initMultipleSelectAnswers = function (qap) {
		if (qap.enumerationAnswers.length) {
			return;
		} else {
			for (let i in qap.question.answers) {
				qap.enumerationAnswers.push(false);
			}
		}
	}

	$scope.replaceVariables = function (template) {
		let newTemplate = template.replace(/{{(.*?)}}/g, function(match, expr) {
			let exprFxn = $parse(expr);
			return exprFxn($scope.updateGpfs);
		});
		console.debug('newTemplate=' + newTemplate);
		return newTemplate;
	};

}
