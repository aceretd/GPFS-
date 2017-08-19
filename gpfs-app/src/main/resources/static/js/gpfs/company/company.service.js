angular.module('AdminUI')
    .service('CompanyService', CompanyService);

function CompanyService($resource) {
    return $resource('/company', null, {
    	findOne: {
    		url: '/company/:id',
    		method: 'GET',
    		isArray: false
    	}
    });
}
