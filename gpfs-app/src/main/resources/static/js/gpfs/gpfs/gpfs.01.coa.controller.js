angular
.module('AdminUI')
.controller('GpfsCoaController', GpfsCoaController);

function GpfsCoaController($scope, $state, $stateParams, FileUploader, gpfs, GpfsService, CoaService) {
  console.debug('Gpfs coa controller');
  $scope.gpfs = gpfs;
  $scope.updateGpfs.gpfs = $scope.gpfs;

  gpfs.$promise.then(function () {
    //set default coa if not yet set
    if (!gpfs.coa) {
      CoaService.getTemplate(function (coa) {
        $scope.gpfs.coa = coa;
        console.debug('COA updated to template');
        $scope.save().$promise.then(function (saved) {
          $scope.gpfs = saved;
        });
      });
    } else {
      console.debug('No need to update COA from template');
    }
  });

  $scope.reloadGpfs = function () {
    console.debug('reloading gpfs. companyId=' + $stateParams.companyId + ', year=' + $stateParams.year);
    return GpfsService.findByCompanyAndYear({companyId: $stateParams.companyId, year: $stateParams.year}, function (data) {
      $scope.gpfs = data;
      $scope.updateGpfs.gpfs = data;
    });
  };

}
