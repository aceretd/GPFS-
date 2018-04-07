angular
.module('AdminUI')
.controller('GpfsCoaController', GpfsCoaController);

function GpfsCoaController($scope, $state, $stateParams, FileUploader, gpfs, GpfsService, CoaService) {
  console.debug('Gpfs coa controller');
  $scope.gpfs = gpfs;
  $scope.updateGpfs.gpfs = $scope.gpfs;






  var uploader = $scope.uploader = new FileUploader({
    url: '/gpfs/coa-template?gpfsId=' + $scope.gpfs.id
  });
  gpfs.$promise.then(function () {
    uploader.url = '/gpfs/coa-template/' + gpfs.id;

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
  // FILTERS

  // a sync filter
  uploader.filters.push({
    name: 'syncFilter',
    fn: function(item /*{File|FileLikeObject}*/ , options) {
      console.log('syncFilter');
      return this.queue.length < 10;
    }
  });

  // an async filter
  uploader.filters.push({
    name: 'asyncFilter',
    fn: function(item /*{File|FileLikeObject}*/ , options, deferred) {
      console.log('asyncFilter');
      setTimeout(deferred.resolve, 1e3);
    }
  });

  // CALLBACKS

  uploader.onWhenAddingFileFailed = function(item /*{File|FileLikeObject}*/ , filter, options) {
    console.info('onWhenAddingFileFailed', item, filter, options);
  };
  uploader.onAfterAddingFile = function(fileItem) {
    console.info('onAfterAddingFile', fileItem);
  };
  uploader.onAfterAddingAll = function(addedFileItems) {
    console.info('onAfterAddingAll', addedFileItems);
  };
  uploader.onBeforeUploadItem = function(item) {
    console.info('onBeforeUploadItem', item);
  };
  uploader.onProgressItem = function(fileItem, progress) {
    console.info('onProgressItem', fileItem, progress);
  };
  uploader.onProgressAll = function(progress) {
    console.info('onProgressAll', progress);
  };
  uploader.onSuccessItem = function(fileItem, response, status, headers) {
    console.info('onSuccessItem', fileItem, response, status, headers);
  };
  uploader.onErrorItem = function(fileItem, response, status, headers) {
    console.info('onErrorItem', fileItem, response, status, headers);
  };
  uploader.onCancelItem = function(fileItem, response, status, headers) {
    console.info('onCancelItem', fileItem, response, status, headers);
  };
  uploader.onCompleteItem = function(fileItem, response, status, headers) {
    console.info('onCompleteItem', fileItem, response, status, headers);
  };
  uploader.onCompleteAll = function() {
    console.info('onCompleteAll');
    $scope.reloadGpfs();
  };

  console.info('uploader', uploader);











  $scope.reloadGpfs = function () {
    console.debug('reloading gpfs. companyId=' + $stateParams.companyId + ', year=' + $stateParams.year);
    return GpfsService.findByCompanyAndYear({companyId: $stateParams.companyId, year: $stateParams.year}, function (data) {
      $scope.gpfs = data;
      $scope.updateGpfs.gpfs = data;
    });
  };

  $scope.uploadTemplate = function () {
    console.debug('gpfsId=' + $scope.gpfs.id);
    swal({
      title: 'Upload COA Template',
      type: 'info',
      html: 	'<form action="/gpfs/coa-template" enctype="multipart/form-data" method="POST">' +
      '  <input type="hidden" name="gpfsId" value="' + $scope.gpfs.id + '" />' +
      '  <input type="file" name="file" />' +
      '  <input type="submit" value="Upload" />' +
      '</form>',
      showConfirmButton: false,
      showCloseButton: false,
      showCancelButton: true
    });
  };

  $scope.nextChild = function (parent, increment) {
    let child = {
        accountNumber: (parseInt(parent.children.slice(-1)[0].accountNumber) + increment).toString(),
        children : []
    };
    switch (increment) {
    case 1:
      child.currentYearAmount = 0;
      child.previousYearAmount = 0;
      break;
    case 100:
      child.children.push({
        accountNumber: '1',
        currentYearAmount: 0,
        previousYearAmount: 0
      });
      break;
    case 1000:
      child.children.push({
        accountNumber: 100,
        children: [{
          accountNumber: '1',
          currentYearAmount: 0,
          previousYearAmount: 0
        }]
      });
    }
    parent.children.push(child);
  };

  $scope.totals = function () {
    if (!$scope.gpfs.coa) {
      return [0, 0];
    }
    let currentYearTotal = 0;
    let previousYearTotal = 0;
    for (var i in $scope.gpfs.coa.children) {
      let fs1 = $scope.gpfs.coa.children[i];
      for (var j in fs1.children) {
        let fs2 = fs1.children[j];
        for (var k in fs2.children) {
          let fs3 = fs2.children[k];
          for (var l in fs3.children) {
            let fs4 = fs3.children[l];
            for (var m in fs4.children) {
              let fs5 = fs4.children[m];
              for (var n in fs5.children) {
                let fs6 = fs5.children[n];
                currentYearTotal += (isNaN(fs6.currentYearAmount) ? 0 : +fs6.currentYearAmount.toFixed(2));
                previousYearTotal += (isNaN(fs6.previousYearAmount) ? 0 : +fs6.previousYearAmount.toFixed(2));
              }
            }
          }
        }
      }
    }
    return [+currentYearTotal.toFixed(2), +previousYearTotal.toFixed(2)];
  };

  $scope.validateAndNext = function () {
    let totals = $scope.totals();
    if (totals[0] !== 0 || totals[1] !== 0) {
      alert('Current year amounts and previous yer amounts must total 0');
    } else {
      $scope.next();
    }
  };

}
