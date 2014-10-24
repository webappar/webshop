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
        $scope.pageSize = '10';
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
    '$location', '$routeParams', 'WebShopProxy',
    function($scope, $location, $routeParams, WebShopProxy) {
        WebShopProxy.find($routeParams.id)
                .success(function(product) {
                    $scope.product = product;
                }).error(function() {
            console.log("selectByPk: error");
        });

        // A listener
        $scope.update = function() {
            WebShopProxy.update($routeParams.id, $scope.product)
                    .success(function() {
                        $location.path('/products');
                    }).error(function() {
                ; // TODO;
            });
        };
        // A listener
        $scope.delete = function() {
            // Really delete?? message
            WebShopProxy.delete($routeParams.id)
                    .success(function() {
                        $location.path('/products');
                    }).error(function() {
                ; // TODO;
            });
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

webShopControllers.controller('LoginCtrl', ['$scope', 'Auth', '$location',
    function($scope, Auth, $location) {
        $scope.login = function() {
            Auth.setCredentials($scope.user.name, $scope.user.password);
            $location.path("/home");
        };

        $scope.logout = function() {
            Auth.clearCredentials();
            $location.path("/home");
        };
    }]);

webShopControllers.controller('CustomerDetailCtrl', ['$scope',
    '$location', 'CustomerProxy', '$cookies',
    function($scope, $location, CustomerProxy, $cookies) {
        CustomerProxy.find($cookies.username)
                .success(function(customer) {
                    $scope.customer = customer;
                }).error(function() {
            //console.log("selectByPk: error");
        });

        // A listener
        $scope.update = function() {
            CustomerProxy.update($scope.customer)
                    .success(function() {
                        $location.path('/customers');
                    }).error(function() {
                ; // TODO;
            });
        };
    }]);
