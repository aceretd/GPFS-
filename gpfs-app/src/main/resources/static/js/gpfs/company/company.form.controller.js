angular
    .module('AdminUI')
    .controller('CompanyFormCtrl', CompanyFormCtrl);

function CompanyFormCtrl($scope, CompanyService) {

	$scope.company = {
		incorporationDate: new Date()
	};

	$scope.save = function () {
		CompanyService.save($scope.company, function (data) {
			$scope.company = data.data;
		});
	}
}
