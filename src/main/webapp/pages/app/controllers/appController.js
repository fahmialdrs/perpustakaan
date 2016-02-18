"use strict";

angular.module('perpustakaan')
  .controller('PerpustakaanController', ['$scope', '$filter', '$window', '$base64', 'Flash', 'PerpustakaanService', function($scope, $filter, $window, $base64, Flash, PerpustakaanService) {

    $scope.dataDetailBuku = {};
    $scope.enable = true;
    $scope.inputBuku = {};
    $scope.inputPeminjaman = {};
    $scope.noKode = '';

    $scope.listBukuOriginal = {};
    $scope.listBukuFilter = {};

    $scope.listDetailBukuOriginal = {};
    $scope.listDetailBukuFilter = {};

    $scope.authentication = false;

    $scope.configBuku = {
      itemsPerPage: 5,
      fillLastPage: true
    };

    $scope.configDetailBuku = {
      itemsPerPage: 5,
      fillLastPage: true
    };

    $scope.updateFilteredBuku = function() {
      $scope.listBukuFilter = $filter("filter")($scope.listBukuOriginal, $scope.query);
    };

    $scope.updateFilteredDetailBuku = function(q) {
      $scope.listDetailBukuFilter = $filter("filter")($scope.listDetailBukuOriginal, q);
    };

    getAllBuku();

    function getAllBuku() {
      PerpustakaanService.getAllBuku().success(function(data) {
        $scope.listBukuOriginal = data;
        $scope.listBukuFilter = $scope.listBukuOriginal;
      });
    }

    $scope.detailBuku = function(noKode) {
      $scope.enable = false;
      $scope.noKode = noKode;
      PerpustakaanService.findBukuByNoKode(noKode).success(function(data) {
        $scope.dataDetailBuku = data;
        $scope.listDetailBukuOriginal = data.peminjamans;
        $scope.listDetailBukuFilter = $scope.listDetailBukuOriginal;
      });
    };

    $scope.back = function() {
      $scope.enable = true;
      getAllBuku();
    };

    $scope.editBuku = function(b) {
      $scope.inputBuku.noKode = b.noKode;
      $scope.inputBuku.noUrut = b.noUrut;
      $scope.inputBuku.warna = b.warna;
      $scope.inputBuku.ukuranP = b.ukuranP;
      $scope.inputBuku.ukuranL = b.ukuranL;
      $scope.inputBuku.tebal = b.tebal;
      $scope.inputBuku.kertasP = b.kertasP;
      $scope.inputBuku.kertasL = b.kertasL;
      $scope.inputBuku.cover = b.cover;
      $scope.inputBuku.kategori = b.kategori;
      $scope.inputBuku.jenis = b.jenis;
      $scope.inputBuku.madzhab = b.madzhab;
      $scope.inputBuku.pentahqiq = b.pentahqiq;
      $scope.inputBuku.pentakhrij = b.pentakhrij;
      $scope.inputBuku.pengantar = b.pengantar;
      $scope.inputBuku.penterjemah = b.penterjemah;
      $scope.inputBuku.pengedit = b.pengedit;
      $scope.inputBuku.penyalur = b.penyalur;
      $scope.inputBuku.cetakan = b.cetakan;
      $scope.inputBuku.tahun = b.tahun;
      $scope.inputBuku.jilid = b.jilid;
      $scope.inputBuku.juz = b.juz;
      $scope.inputBuku.eksemplar = b.eksemplar;
      $scope.inputBuku.judul1 = b.judul1;
      $scope.inputBuku.pengarang1 = b.pengarang1;
      $scope.inputBuku.judul2 = b.judul2;
      $scope.inputBuku.pengarang2 = b.pengarang2;
      $scope.inputBuku.catatan = b.catatan;
      $scope.inputBuku.peminjamans = b.peminjamans;
      $scope.inputBuku.fotoBuku = b.fotoBuku;
    };

    $scope.updateBuku = function(buku, noKode) {

      PerpustakaanService.updateBuku(buku).success(function(data) {
        getAllBuku();
        var message = '<strong>Info</strong> Data Berhasil Di Update';
        Flash.create('success', message, 'custom-class');
      });
    };

    $scope.deleteBuku = function(b) {
      if (angular.equals([], b.peminjamans)) {
        PerpustakaanService.deleteBuku(b.noUrut).success(function(data) {
          getAllBuku();
          var message = '<strong>Info</strong> Data Berhasil Di Hapus';
          Flash.create('success', message, 'custom-class');
        });
      } else {
        var message = '<strong>Warning</strong> buku masih dipinjam';
        Flash.create('danger', message, 'custom-class');
      }

    };

    $scope.savePeminjaman = function(peminjaman) {
      PerpustakaanService.savePeminjaman(peminjaman, $scope.noKode).success(function(data) {
        $scope.detailBuku($scope.noKode);
        var message = '<strong>Info</strong> Data Berhasil Di Simpan';
        Flash.create('success', message, 'custom-class');
      });
    };

    $scope.clear = function() {
      $scope.inputPeminjaman.namaPeminjam = '';
      $scope.inputPeminjaman.alamat = '';
      $scope.inputPeminjaman.noKontak = '';
      $scope.inputPeminjaman.tglPeminjaman = '';
      $scope.inputPeminjaman.tglPengembalian = '';
    };

    $scope.findBukuByKriteria = function(key, value) {
      if ((key === '' || key === null || key === undefined) && (value === '' || value === null || value === undefined)) {
        getAllBuku();
      } else if (key === '' || key === null || key === undefined) {
        var message = '<strong>Warning</strong> Kata Kunci Masih Kosong';
        Flash.create('danger', message, 'custom-class');
      } else if (value === '' || value === null || value === undefined) {
        var message1 = '<strong>Warning</strong> Isian Masih Kosong';
        Flash.create('danger', message1, 'custom-class');
      } else {
        PerpustakaanService.findBukuByKriteria(key, value).success(function(data) {
          if (angular.equals([], data)) {
            var message = '<strong>Warning</strong> Buku Kosong atau tidak ada';
            Flash.create('danger', message, 'custom-class');
            $scope.listBukuOriginal = data;
            $scope.listBukuFilter = $scope.listBukuOriginal;
          } else {
            $scope.listBukuOriginal = data;
            $scope.listBukuFilter = $scope.listBukuOriginal;
          }
        });
      }
    };

    $scope.kriteria = [
      {
        'key': 'Judul',
        'value': 'judul1'
      },
      {
        'key': 'Kategori',
        'value': 'kategori'
      },
      {
        'key': 'Jenis',
        'value': 'jenis'
      },
      {
        'key': 'Pengarang',
        'value': 'pengarang1'
      }
    ];

    function dateDiffInDays(a, b) {
      var _MS_PER_DAY = 1000 * 60 * 60 * 24;
      var utc1 = Date.UTC(a.getFullYear(), a.getMonth(), a.getDate());
      var utc2 = Date.UTC(b.getFullYear(), b.getMonth(), b.getDate());
      return Math.floor((utc2 - utc1) / _MS_PER_DAY);
    }

    $scope.differenceInDays = function(d) {
      return dateDiffInDays(new Date(), new Date(d.tglPengembalian));
    };

  }]);
