angular.module('AdminUI')
    .service('CompanyService', CompanyService);

function CompanyService($resource) {
    return $resource('/company');
}
