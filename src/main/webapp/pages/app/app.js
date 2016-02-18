angular.module('perpustakaan', ['ngRoute', 'tabs', 'base64', 'ngBootbox', 'angular-table', 'flash', 'ui.select2'])
  .config(['$routeProvider', function($routeProvider) {
    $routeProvider
      .when('/', {
        controller: 'PerpustakaanController',
        templateUrl: 'templates/tabelBuku.html'
      })
      .when('/peminjaman', {
        controller: 'PeminjamanController',
        templateUrl: 'templates/peminjaman.html'
      })
      .when('/tulisan', {
        controller: 'TulisanController',
        templateUrl: 'templates/tulisan.html'
      })
      .when('/newBuku', {
        templateUrl: 'templates/newBuku.html'
      })
      .when('/newTulisan', {
        templateUrl: 'templates/newTulisan.html'
      })
      .otherwise({
        templateUrl: 'templates/tabelBuku.html'
      });
  }]);
