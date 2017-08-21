angular
    .module('AdminUI')
    .controller('GpfsListCtrl', GpfsListCtrl);

function GpfsListCtrl($scope, DTOptionsBuilder, GpfsService) {

	$scope.gpfss = [];

    $scope.dtOptions = DTOptionsBuilder.newOptions()
    .withDOM('<"html5buttons"B>lTfgitp')
    .withButtons([{
            extend: 'copy'
        },
        {
            extend: 'csv'
        },
        {
            extend: 'excel',
            title: 'ExampleFile'
        },
        {
            extend: 'pdf',
            title: 'ExampleFile'
        },

        {
            extend: 'print',
            customize: function(win) {
                $(win.document.body).addClass('white-bg');
                $(win.document.body).css('font-size', '10px');

                $(win.document.body).find('table')
                    .addClass('compact')
                    .css('font-size', 'inherit');
            }
        }
    ]);

    $scope.nextState = function (gpfs) {
    	let state = gpfs.nextState ? gpfs.nextState : 'gpfs.update.coa';
    	let args = '({companyId: ' + gpfs.company.id + ', year: ' + gpfs.year + '})';
    	return state + args;
    };

    GpfsService.get({size: 2000}, function (data) {
    	$scope.gpfss = data.content;
    });
}
