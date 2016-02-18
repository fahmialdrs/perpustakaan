"use strict";

angular.module('perpustakaan')
  .factory('PerpustakaanService', ['$http', function($http) {

    return {
      getAllBuku: function() {
        return $http.get('/api/buku');
      },
      findBukuByNoKode: function(noKode) {
        return $http.get('/api/buku/' + noKode);
      },
      updateBuku: function(buku) {
        return $http.put('/api/buku/', buku);
      },
      deleteBuku: function(noKode) {
        return $http.delete('/api/buku/' + noKode);
      },
      savePeminjaman: function(peminjaman, noKode) {
        return $http.post('/api/peminjaman/' + noKode, peminjaman);
      },
      login: function(login) {
        return $http.post('/login', login);
      },
      logout: function() {
        return $http.post('/logout');
      },
      findBukuByKriteria: function(key, value) {
        return $http.get('/api/buku/' + key + '/' + value);
      },
      registerAdmin: function(user) {
        return $http.post('/user', user);
      }
    };

  }]);
