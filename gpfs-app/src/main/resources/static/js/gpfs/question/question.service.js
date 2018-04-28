angular.module('AdminUI')
.service('QuestionService', QuestionService);

function QuestionService($resource) {
  return $resource('/question', null, {
    findByNote: {
      url: '/gpfs/note/:note',
      method: 'GET',
      isArray: true
    },
    findBySeries: {
      url: '/question/series/:series',
      method: 'GET',
      isArray: false
    }
  });
}
