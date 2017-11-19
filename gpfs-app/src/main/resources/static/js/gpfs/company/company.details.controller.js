angular
    .module('AdminUI')
    .controller('CompanyDetailsCtrl', CompanyDetailsCtrl);

function CompanyDetailsCtrl($scope, $state, company) {
	console.debug('got company: ');
	console.debug(company);
	$scope.company = company;
}
