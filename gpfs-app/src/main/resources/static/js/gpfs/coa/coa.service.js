angular.module('AdminUI')
    .service('CoaService', CoaService);

function CoaService($resource) {
    return $resource('/coa', null, {
    	getTemplate: {
    		url: '/coa/template',
    		method: 'GET',
    		isArray: false
    	}
    });
}
