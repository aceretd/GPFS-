angular
    .module('AdminUI')
    .controller('QuestionListCtrl', QuestionListCtrl);

function QuestionListCtrl($scope, DTOptionsBuilder, QuestionService) {

	$scope.questions = [];

    $scope.dtOptions = DTOptionsBuilder.newOptions()
    .withDOM('<"html5buttons"B>lTfgitp')
    .withButtons([]);

    QuestionService.get({size: 2000}, function (data) {
    	$scope.questions = data.content;
    });
}
