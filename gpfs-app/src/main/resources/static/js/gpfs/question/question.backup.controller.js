angular
.module('AdminUI')
.controller('QuestionBackupCtrl', QuestionBackupCtrl);

function QuestionBackupCtrl($scope, FileUploader, QuestionService) {

  $scope.debugTxt = '';

  var uploader = $scope.uploader = new FileUploader({
    url: '/question/backup'
  });
  uploader.filters.push({
    name: 'syncFilter',
    fn: function(item /*{File|FileLikeObject}*/ , options) {
      console.log('syncFilter');
      return this.queue.length < 10;
    }
  });
  uploader.onErrorItem = function(fileItem, response, status, headers) {
    $scope.debugTxt = response;
    swal({
      title: 'Questions upload error',
      text: 'Could not upload questions. error: ' + status,
      type: 'error'
    });
  };
  uploader.onSuccessItem = function(fileItem, response, status, headers) {
    $scope.debugTxt = response;
    swal({
      title: 'Question upload success',
      text: 'Questions successfully uploaded',
      type: 'success'
    });
  };
  uploader.onCompleteAll = function() {
    //triggers on both success and failure
    //console.debug('onCompleteAll');
  };

}
