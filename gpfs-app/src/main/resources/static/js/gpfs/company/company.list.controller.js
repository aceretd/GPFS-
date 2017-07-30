angular
    .module('AdminUI')
    .controller('CompanyListCtrl', CompanyListCtrl);

function CompanyListCtrl($scope, DTOptionsBuilder, CompanyService) {

	$scope.message = 'Hello world!';
	$scope.companies = [];

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

    CompanyService.get({size: 2000}, function (data) {
    	$scope.companies = data.content;
    });
}
