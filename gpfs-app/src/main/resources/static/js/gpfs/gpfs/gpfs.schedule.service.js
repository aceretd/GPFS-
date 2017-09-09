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
    				{content: '0'},
    				{content: '0'}
    			]},
    			{cells: [
    				{content: 'Write-off of deferred charges that do not meet the IFRS for SMEs definition of an intangible asset'},
    				{content: '0'},
    				{content: '0'}
    			]},
    			{cells: [
    				{content: 'Restatement of provision for post-employment benefits on a projected unit credit method basis'},
    				{content: '0'},
    				{content: '0'}
    			]},
    			{cells: [
    				{content: 'Fair value adjustment to biological assets'},
    				{content: '0'},
    				{content: '0'}
    			]},
    			{cells: [
    				{content: 'Fair value adjustment to investment property'},
    				{content: '0'},
    				{content: '0'}
    			]},
    			{cells: [
    				{content: 'Restatement of investments in associates to cost'},
    				{content: '0'},
    				{content: '0'}
    			]},
    			{cells: [
    				{content: 'Deferred tax adjustments'},
    				{content: '0'},
    				{content: '0'}
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
