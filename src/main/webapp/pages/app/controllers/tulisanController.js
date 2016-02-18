"use strict";

angular.module('perpustakaan')
  .controller('TulisanController', function($scope, TulisanService) {

    $scope.listTulisan = {};
    $scope.tulisanDetail = {};

    function getAllTulisan() {
      TulisanService.getAllTulisan().success(function(data) {
        $scope.listTulisan = data;
      });
    }

    getAllTulisan();

    function findTulisan() {
      TulisanService.findTulisan().success(function(data) {
        $scope.tulisanDetail = data;
      });
    }

    findTulisan();

    $scope.updatePublish = function(idTulisan, p) {
      if (p.publish) {
        p.publish = false;
        TulisanService.updateTulisan(p).success(function(data) {
          getAllTulisan();
        });
      } else {
        p.publish = true;
        TulisanService.updateTulisan(p).success(function(data) {
          getAllTulisan();
        });
      }
    };

    $scope.hapusTulisan = function(idTulisan) {
      TulisanService.deleteTulisan(idTulisan).success(function(data) {
        getAllTulisan();
      });
    };

  });
