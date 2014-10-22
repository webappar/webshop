'use strict';

/*
 *  The WebShop App
 */
var webshop = angular.module('WebShop', [
    'ngRoute',
    'WebShopControllers',
    'WebShopService'
    // More here
]);


webshop.config(['$routeProvider',
    function($routeProvider) {  // Injected object $routeProvider
        $routeProvider.
                when('/home', {
                    templateUrl: 'partials/home/home.html'
                    //controller: Not used
                }).
                when('/products', {
                    templateUrl: 'partials/products/products.html',
                    controller: 'ProductListCtrl'
                }).
                when('/products/:id', {
                    templateUrl: 'partials/products/product-detail.html',
                    controller: 'ProductDetailCtrl'
                }).
                when('/product', {
                    templateUrl: 'partials/products/product-new.html',
                    controller: 'ProductNewCtrl'
                }).
                when('/customers', {
                    templateUrl: 'partials/customers/customers.html'
                    //controller: Not used
                }).
                when('/orders', {
                    templateUrl: 'partials/orders/orders.html'
                    //controller: Not used
                }).
                when('/about', {
                    templateUrl: 'partials/about/about.html'
                    //controller: Not used
                }).
                otherwise({
                    redirectTo: '/home'
                });
    }]);
