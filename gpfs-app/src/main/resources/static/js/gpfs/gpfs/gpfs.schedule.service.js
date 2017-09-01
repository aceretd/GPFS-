angular.module('AdminUI')
    .service('ScheduleService', ScheduleService);

function ScheduleService($resource) {
    let scheduleService = {};
    let defaultSchedules = [
    	//Schedule 1
    	{
    		index: 1,
    		rows: [
    			//Total equity under (PAS 101 or full PFRS), etc etc
    			{cells: [
    				{content: 'Total equity under (PAS 101 or full PFRS)'},
    				{content: '200'},
    				{content: '100'}
    			]},
    			{cells: [
    				{content: 'Capitalization of costs directly attributable to site preparation'},
    				{content: '12'},
    				{content: '30'}
    			]}
    		]
    	},
    	//Schedule 47
    	{
    		index: 47,
    		rows: [
    			{cells: [
    				{content: '0'},
    				{content: '0'},
    				{content: '0'},
    				{content: '0'}
    			]},
    			{cells: [
    				{content: '0'},
    				{content: '0'},
    				{content: '0'},
    				{content: '0'}
    			]}
    		]
    	}
    ];
    scheduleService.getSchedule = function (idx) {
    	return defaultSchedules.find(function (schedule) {
    		return schedule.index === idx;
    	});
    }
    return scheduleService;
}
