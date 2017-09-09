angular
    .module('AdminUI')
    .controller('ScheduleTableController', ScheduleTableController);

function ScheduleTableController($scope, $element) {
	console.debug('GPFS schedule table controller!');
	console.debug('$scope.updateGpfs=' + $scope.updateGpfs);
	$scope.schedule = {};
	let $table = $($element);
	$table.on('change', function () {
		let rows = parseValues($table);
		console.debug('New schedule rows! val=' + JSON.stringify(rows));
		console.debug('Will try to find matching sched. idx=' + $scope.schedule.index);
		console.debug('parent schedules=' + $scope.updateGpfs.gpfs.schedules);
		let schedule = $scope.updateGpfs.gpfs.schedules.find(function (s) {
			console.debug('Checking schedule match. s.index=' + s.index);
			return s.index === $scope.schedule.index;
		});
		console.debug('found schedule to replace rows: ' + schedule);
		schedule.rows = rows;
		$scope.schedule.rows = rows;
	});

}

function parseValues($table) {
	let rows = [];
	$table.find('tbody tr').each(function (trIdx, tr) {
		let cells = [];
		$(tr).find('td').each(function (tdIdx, td) {
			console.debug('td value! val=' + $(td).text());
			cells.push({
				content: $(td).text()
			});
		});
		rows.push({
			cells: cells
		});
	});
	return rows;
}