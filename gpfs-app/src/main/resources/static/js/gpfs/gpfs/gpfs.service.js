angular.module('AdminUI')
    .service('GpfsService', GpfsService);

function GpfsService($resource) {
    return $resource('/gpfs', null, {
    	findByCompanyAndYear: {
    		url: '/gpfs/:companyId/:year',
    		method: 'GET',
    		isArray: false
    	}
    });
}
