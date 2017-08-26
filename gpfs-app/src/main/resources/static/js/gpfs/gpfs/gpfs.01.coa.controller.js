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
		case 1000:
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

	$scope.totals = function () {
		if (!$scope.gpfs.coa) {
			return [0, 0];
		}
		let currentYearTotal = 0;
		let previousYearTotal = 0;
		for (var i in $scope.gpfs.coa.children) {
			let fs1 = $scope.gpfs.coa.children[i];
			for (var j in fs1.children) {
				let fs2 = fs1.children[j];
				for (var k in fs2.children) {
					let fs3 = fs2.children[k];
					for (var l in fs3.children) {
						let fs4 = fs3.children[l];
						for (var m in fs4.children) {
							let fs5 = fs4.children[m];
							for (var n in fs5.children) {
								let fs6 = fs5.children[n];
								currentYearTotal += fs6.currentYearAmount;
								previousYearTotal += fs6.previousYearAmount;
							}
						}
					}
				}
			}
		}
		return [currentYearTotal, previousYearTotal];
	};

	$scope.validateAndNext = function () {
		let totals = $scope.totals();
		if (totals[0] !== 0 || totals[1] !== 0) {
			alert('Current year amounts and previous yer amounts must total 0');
		} else {
			$scope.next();
		}
	};

}
