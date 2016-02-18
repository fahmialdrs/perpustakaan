"use strict";

angular.module('perpustakaan')
  .factory('TulisanService', ['$http', function($http) {
    return {
      getAllTulisan: function() {
        return $http.get('/api/tulisan');
      },
      updateTulisan: function(tulisan) {
        return $http.put('/api/tulisan/', tulisan);
      },
      deleteTulisan: function(idTulisan) {
        return $http.delete('/api/tulisan/' + idTulisan);
      },
      findTulisan: function() {
        return $http.get('/api/tulisan/publish');
      }
    };

  }]);
