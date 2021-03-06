'use strict';

/*
 *  The WebShop App
 */
var webshop = angular.module('WebShop', [
    'ngRoute',
    'WebShopControllers',
    'WebShopService',
    'ngCookies'
    // More here
]);


webshop.config(['$routeProvider', '$locationProvider',
    function($routeProvider, $locationProvider) {  // Injected object $routeProvider

        $routeProvider.
                when('/home', {
                    templateUrl: 'shop/app/partials/home/home.html',
                    controller: 'LoginCtrl'
                }).
                when('/products', {
                    templateUrl: 'shop/app/partials/products/products.html',
                    controller: 'ProductListCtrl'
                }).
                when('/products/:id', {
                    templateUrl: 'shop/app/partials/products/product-detail.html',
                    controller: 'ProductDetailCtrl'
                }).
                when('/product', {
                    templateUrl: 'shop/app/partials/products/product-new.html',
                    controller: 'ProductNewCtrl'
                }).
                when('/customers', {
                    templateUrl: 'shop/app/partials/customers/customers.html',
                    controller: 'CustomerDetailCtrl'
                }).
                when('/register', {
                    templateUrl: 'shop/app/partials/customers/register.html',
                    controller: 'CustomerNewCtrl'
                }).
                when('/orders', {
                    templateUrl: 'shop/app/partials/orders/orders.html',
                    controller: 'OrdersCtrl'
                }).
                when('/orders/:id', {
                    templateUrl: 'shop/app/partials/orders/order-detail.html',
                    controller: 'OrdersDetailCtrl'
                }).
                when('/about', {
                    templateUrl: 'shop/app/partials/about/about.html'
                    //controller: Not used
                }).
                when('/cart', {
                    templateUrl: 'shop/app/partials/cart/cart.html',
                    controller: 'CartCtrl'
                }).
                otherwise({
                    redirectTo: '/home'
                });

        // use the HTML5 History API
        $locationProvider.html5Mode(true);
    }]);
