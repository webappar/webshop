'use strict';

/*
 * Controllers
 */

var webShopControllers = angular.module('WebShopControllers', []);

// General navigation controller
webShopControllers.controller('NavigationCtrl', ['$scope', '$location',
    function($scope, $location) {
        $scope.navigate = function(url) {
            $location.path(url);
        };
    }]);

//Product list display controller
webShopControllers.controller('ProductListCtrl', ['$scope', 'WebShopProxy',
    function($scope, WebShopProxy) {
        $scope.orderProp = 'artNr';
        $scope.pageSize = '5';
        $scope.currentPage = 0;
        WebShopProxy.count()
                .success(function(count) {
                    $scope.count = count.value;
                }).error(function() {
            console.log("count: error");
        });
        getRange();
        $scope.$watch('currentPage', function() {
            getRange();
        });
        $scope.$watch('pageSize', function() {
            getRange();
        });
        function getRange() {
            var fst = $scope.pageSize * $scope.currentPage;
            WebShopProxy.findRange(fst, $scope.pageSize)
                    .success(function(products) {
                        $scope.products = products;
                    }).error(function() {
                console.log("findRange: error");
            });
        }
    }]);

webShopControllers.controller('ProductDetailCtrl', ['$scope',
    '$location', '$routeParams', 'WebShopProxy', 'CartService', 'Auth',
    function($scope, $location, $routeParams, WebShopProxy, CartService, Auth) {
        WebShopProxy.find($routeParams.id)
                .success(function(product) {
                    $scope.product = product;
                }).error(function() {
            console.log("selectByPk: error");
        });
        //Determine login status in order to display purchase button
        $scope.loggedIn = Auth.checkCredentials();
        
        $scope.addToCart = function() {
            CartService.updateCart($scope.product, false);
        };
    }]);

//Login controller for /home
webShopControllers.controller('LoginCtrl', ['$scope', 'Auth', '$location', 
    function($scope, Auth, $location) {
        $scope.loggedIn = Auth.checkCredentials();
        $scope.login = function() {
            Auth.setCredentials($scope.user.name, $scope.user.password);
            $scope.loggedIn = Auth.checkCredentials();
            //Weirdness ensues, have to click button twice to update view
        };

        $scope.logout = function() {
            Auth.clearCredentials();
            $scope.loggedIn = Auth.checkCredentials();
        };
    }]);

//Control for updating user credentials
webShopControllers.controller('CustomerDetailCtrl', ['$scope',
    '$location', 'CustomerProxy', 'Auth',
    function($scope, $location, CustomerProxy, Auth) {
        //If not logged in, send to login page
        if(!Auth.checkCredentials()){
            $location.path('/home');
        }
        $scope.customer = Auth.getCredentials();
        $scope.update = function() {
            CustomerProxy.update($scope.customer)
                    .success(function() {
                        //Update cookie
                        Auth.updateCredentials();
                        $location.path('/customers');
                    }).error(function() {
                ;
            });
        };
    }]);
//Control for registration
webShopControllers.controller('CustomerNewCtrl', ['$scope',
    '$location', 'CustomerProxy',
    function($scope, $location, CustomerProxy) {
        $scope.register = function() {
            CustomerProxy.save($scope.user)
                    .success(function() {
                        $location.path('/home');
                    }).error(function() {
                console.log("create: error");
            });
        };
        $scope.cancel = function(){
            $location.path('/home');
        };
    }]);

//Control for the Orders page
webShopControllers.controller('OrderCtrl', ['$scope', 'CartService', '$route', '$location', 'Auth',
    function($scope, CartService, $route, $location, Auth) {
        //If not logged in, send to login page
        if(!Auth.checkCredentials()){
            $location.path('/home');
        }
        //Set cart and cost of cart
        $scope.products = CartService.getCart();
        $scope.cost = CartService.calculateCost();
        
        $scope.removeFromCart = function(product) {
            CartService.updateCart(product, true);
            $route.reload();
        };
        //Buy the stuff
        $scope.checkout =function(){
            CartService.emptyCart();
            alert('All the awesome stuffs are headed your way!');
            $route.reload();
        };
    }]);
