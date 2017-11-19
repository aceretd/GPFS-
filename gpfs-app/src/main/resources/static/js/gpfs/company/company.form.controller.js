angular
    .module('AdminUI')
    .controller('CompanyFormCtrl', CompanyFormCtrl);

function CompanyFormCtrl($scope, $state, CompanyService) {
	$scope.company = {
		incorporationDate: new Date(),
		reportingPeriodHolder: new Date(),
		type: 'COMPANY'
	};

	$scope.setReportingPeriod = function () {
		console.debug('set reporting period. rp=' + $scope.reportingPeriodHolder);
	}

	$scope.save = function () {
		if ($scope.company.reportingPeriodHolder) {
			$scope.company.reportingPeriodEndMonth = $scope.company.reportingPeriodHolder.getMonth();
			$scope.company.reportingPeriodEndDay = $scope.company.reportingPeriodHolder.getDate();
		}
		CompanyService.save($scope.company, function (data) {
			$scope.company = data;
			swal({title: 'Success', text: 'Company Created', type: 'success'}).then(function () {
				$state.go('company_details', {companyId: $scope.company.id});
			});
		});
	}
}
