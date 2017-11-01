angular
    .module('AdminUI')
    .controller('CompanyFormCtrl', CompanyFormCtrl);

function CompanyFormCtrl($scope, CompanyService) {
	$scope.company = {
		incorporationDate: new Date(),
		reportingPeriodHolder: new Date()
	};

	$scope.setReportingPeriod = function () {
		alert('wtf');
		console.debug('set reporting period. rp=' + $scope.reportingPeriodHolder);
	}

	$scope.save = function () {
		if ($scope.company.reportingPeriodHolder) {
			$scope.company.reportingPeriodEndMonth = $scope.company.reportingPeriodHolder.getMonth();
			$scope.company.reportingPeriodEndDay = $scope.company.reportingPeriodHolder.getDate();
		}
		CompanyService.save($scope.company, function (data) {
			$scope.company = data.data;
		});
	}
}
