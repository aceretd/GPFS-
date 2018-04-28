angular
  .module('AdminUI')
  .controller('QuestionUpdateCtrl', QuestionUpdateCtrl);

function QuestionUpdateCtrl($stateParams, $scope, QuestionService, question) {

  $scope.question = question;

  $scope.saveQuestion = function () {
    QuestionService.save({}, $scope.question, function () {
      swal({
        title: 'Save success',
        type: 'success',
        text: 'Question has been saved'
      });
    }, function (resp) {
      if (resp.data && resp.data.errors) {
        let e = resp.data.errors[0];
        swal({
          title: 'Save failed',
          type: 'error',
          text: 'Validation failed. field: ' + e.field + ', error: ' + e.defaultMessage
        });
      } else {
        console.debug(resp);
        swal({
          title: 'Save failed',
          type: 'error',
          text: 'Question save failed. Please try again'
        });
      }
    });
  };

  $scope.resetQuestion = function () {
    swal({
      title: 'Confirm question reset',
      type: 'warning',
      text: 'Are you sure you want to reset this question?',
      showCancelButton: true,
      closeOnConfirm: false,
      showLoading: true
    }, function (r) {
      if (r) {
        $scope.question = QuestionService.findBySeries({series: $stateParams.series}, {}, function () {
          swal('Question has been reset');
        });
      }
    });
  };

  $scope.removeAnswer = function (index) {
    if ($scope.question.answers[index].answer && $scope.question.answers[index].answer.trim()) {
      swal({
        title: 'Confirm remove answer',
        type: 'warning',
        text: 'Are you sure you want to remove "' + $scope.question.answers[index].answer + '"?',
        showCancelButton: true
      }, function (r) {
        console.debug(r);
        if (r) {
          $scope.question.answers.splice(index, 1);
          $scope.$apply();
        }
      });
    } else {
      $scope.question.answers.splice(index, 1);
      $scope.$apply();
    }
  };

}
