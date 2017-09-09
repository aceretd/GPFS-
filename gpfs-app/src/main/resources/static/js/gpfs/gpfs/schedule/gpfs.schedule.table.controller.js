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
		let schedule = $scope.updateGpfs.gpfs.schedules.find(function (s) {
			return s.index === $scope.schedule.index;
		});
		schedule.rows = rows;
		$scope.schedule.rows = rows;
	});

	$scope.sum = function (col) {
		let sum = $scope.schedule.rows.reduce(function (sum, row) {
			return sum + (parseFloat(row.cells[col].content) || 0);
		}, 0);
		return sum;
	};

	//Funky timing for editableTableWidget call
	setTimeout(function(){
		$table.find('table').editableTableWidget();
	});
	//Handle angular rerender of table on event
	$scope.$on('gpfs-save', function () {
		$table.find('table').editableTableWidget();
	});

}

function parseValues($table) {
	let rows = [];
	$table.find('tbody tr').each(function (trIdx, tr) {
		let cells = [];
		$(tr).find('td').each(function (tdIdx, td) {
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