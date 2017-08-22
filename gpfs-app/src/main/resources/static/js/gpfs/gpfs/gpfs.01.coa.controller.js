angular
    .module('AdminUI')
    .controller('GpfsCoaController', GpfsCoaController);

function GpfsCoaController($scope, $state, gpfs, CoaService) {
	console.debug('Gpfs coa controller');
	$scope.gpfs = gpfs;
	$scope.updateGpfs.gpfs = $scope.gpfs;

	if (!gpfs.coa) {
		CoaService.getTemplate(function (coa) {
			$scope.gpfs.coa = coa;
			console.debug('COA updated to template');
		});
	} else {
		console.debug('No need to update COA from template');
	}

	$scope.nextChild = function (parent, increment) {
		let child = {
			accountNumber: (parseInt(parent.children.slice(-1)[0].accountNumber) + increment).toString(),
			children : []
		};
		switch (increment) {
		case 1:
			child.currentYearAmount = 0;
			child.previousYearAmount = 0;
			break;
		case 100:
			child.children.push({
				accountNumber: '1',
				currentYearAmount: 0,
				previousYearAmount: 0
			});
			break;
		case 5000:
			child.children.push({
				accountNumber: 100,
				children: [{
					accountNumber: '1',
					currentYearAmount: 0,
					previousYearAmount: 0
				}]
			});
		}
		parent.children.push(child);
	};

	$scope.isFs3last = function (fs3, acctNo) {
		if (!fs3 || !acctNo) {
			return false;
		}
		console.debug(fs3.children.length + ' vs ' + acctNo);
		return fs3.children.length === acctNo/5000;
	};

}
