angular.module('AdminUI')
    .service('ReferenceService', ReferenceService);

function ReferenceService($resource) {
    return $resource('/reference', null, {
    	principalActivity: {
    		url: '/reference/principal-activity',
    		method: 'GET',
    		isArray: false
    	}
    });
}
