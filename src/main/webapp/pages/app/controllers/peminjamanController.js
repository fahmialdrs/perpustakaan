"use strict";

angular.module('perpustakaan')
  .controller('PeminjamanController', function($scope, $filter, PeminjamanService) {

    $scope.listPeminjamanOriginal = {};
    $scope.listPeminjamanFilter = {};

    $scope.configPeminjaman = {
      itemsPerPage: 5,
      fillLastPage: true
    };

    $scope.updateFilteredPeminjaman = function() {
      $scope.listPeminjamanFilter = $filter("filter")($scope.listPeminjamanOriginal, $scope.query);
    };

    function getAllPeminjaman() {
      PeminjamanService.getAllPeminjaman().success(function(data) {
        $scope.listPeminjamanOriginal = data;
        $scope.listPeminjamanFilter = $scope.listPeminjamanOriginal;
      });
    }

    getAllPeminjaman();

    function dateDiffInDays(a, b) {
      var _MS_PER_DAY = 1000 * 60 * 60 * 24;
      var utc1 = Date.UTC(a.getFullYear(), a.getMonth(), a.getDate());
      var utc2 = Date.UTC(b.getFullYear(), b.getMonth(), b.getDate());
      return Math.floor((utc2 - utc1) / _MS_PER_DAY);
    }

    $scope.differenceInDays = function(d) {
      return dateDiffInDays(new Date(), new Date(d.tglPengembalian));
    };

    $scope.deletePeminjaman = function(idPeminjaman) {
      PeminjamanService.deletePeminjaman(idPeminjaman).success(function(data) {
        getAllPeminjaman();
      });
    };

  });
