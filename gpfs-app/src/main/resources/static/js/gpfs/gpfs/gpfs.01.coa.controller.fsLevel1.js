angular
.module('AdminUI')
.controller('GpfsFsLevel1Controller', GpfsFsLevel1Controller);

function GpfsFsLevel1Controller($stateParams, $scope, gpfs) {
  $scope.gpfs = gpfs;
  $scope.gpfs.$promise.then(function (gpfs) {
    $scope.fs1 = gpfs.coa.children.find(function (fs1) {
      return fs1.id.toString() === $stateParams.fsLevel1Id;
    });
  });

  $scope.addFs4Child = function (fs4) {
    swal({
      title: 'Add an account under ' + fs4.name,
      text: 'Enter the account name',
      type: 'input',
      showCancelButton: true,
    }, function (accountName) {
      fs4.children.unshift({
        name: accountName,
        series: extractMaxSeries(fs4) + 10
      });
      $scope.$apply();
    });
  }

  function extractMaxSeries(fs4) {
    return fs4.children.map(function (fs5) {
      return fs5.series || 0;
    }).reduce(function (prev, current) {
      return prev > current ? prev : current;
    });
  }

}
