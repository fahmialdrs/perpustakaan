"use strict";

angular.module('perpustakaan')
  .factory('PeminjamanService', ['$http', function($http) {
    return {
      getAllPeminjaman: function() {
        return $http.get('/api/peminjaman');
      },
      deletePeminjaman: function(idPeminjaman) {
        return $http.delete('/api/peminjaman/' + idPeminjaman);
      }
    };

  }]);
