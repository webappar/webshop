'use strict';

/*
 * Controllers
 */

var webShopControllers = angular.module('WebShopControllers', []);

// General navigation controller (possibly useful?)
webShopControllers.controller('NavigationCtrl', ['$scope', '$location',
    function($scope, $location) {
        $scope.navigate = function(url) {
            $location.path(url);
        };
    }]);


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
        $scope.loggedIn = Auth.checkCredentials();
        // A listener
        $scope.update = function() {
            WebShopProxy.update($routeParams.id, $scope.product)
                    .success(function() {
                        $location.path('/products');
                    }).error(function() {
                ; // TODO;
            });
        };
        //Currently not in use
        $scope.delete = function() {
            // Really delete?? message
            WebShopProxy.delete($routeParams.id)
                    .success(function() {
                        $location.path('/products');
                    }).error(function() {
                ; // TODO;
            });
        };
        $scope.addToCart = function() {
            CartService.updateCart($scope.product, false);
        };
    }]);

webShopControllers.controller('ProductNewCtrl', ['$scope',
    '$location', 'WebShopProxy',
    function($scope, $location, WebShopProxy) {
        $scope.save = function() {
            WebShopProxy.create($scope.product)
                    .success(function() {
                        $location.path('/products');
                    }).error(function() {
                console.log("create: error");
            });
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
            //$location.path("/home");
        };

        $scope.logout = function() {
            Auth.clearCredentials();
            $scope.loggedIn = Auth.checkCredentials();
            //$location.path("/home");
        };
    }]);

webShopControllers.controller('CustomerDetailCtrl', ['$scope',
    '$location', 'CustomerProxy', 'Auth',
    function($scope, $location, CustomerProxy, Auth) {
        if(!Auth.checkCredentials()){
            $location.path('/home');
        }
        $scope.customer = Auth.getCredentials();
        $scope.update = function() {
            CustomerProxy.update($scope.customer)
                    .success(function() {
                        Auth.updateCredentials();
                        $location.path('/customers');
                    }).error(function() {
                ;
            });
        };
    }]);

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

webShopControllers.controller('OrderCtrl', ['$scope', 'CartService', '$route', '$location', 'Auth',
    function($scope, CartService, $route, $location, Auth) {
        if(!Auth.checkCredentials()){
            $location.path('/home');
        }
        $scope.products = CartService.getCart();
        $scope.cost = CartService.calculateCost();
        $scope.removeFromCart = function(product) {
            CartService.updateCart(product, true);
            $route.reload();
        };
        $scope.checkout =function(){
            CartService.emptyCart();
            alert('All the awesome stuffs are headed your way!');
            $route.reload();
        };
    }]);
