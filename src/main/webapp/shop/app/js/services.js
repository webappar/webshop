'use strict';

/* Services */

var webShopService = angular.module('WebShopService', []);

// Representing the remote RESTful WebShop
webShopService.factory('WebShopProxy', ['$http',
    function($http) {

        var url = 'http://localhost:8080/rest/products';

        return {
            findAll: function() {
                return $http.get(url);
            },
            findRange: function(first, count) {
                return $http.get(url + "/range?fst=" + first + "&count=" + count);
            },
            find: function(id) {
                return $http.get(url + "/" + id);
            },
            update: function(id, product) {
                return $http.put(url + "/" + id, product);
            },
            create: function(product) {
                return $http.post(url, product);
            },
            delete: function(id) {
                return $http.delete(url + "/" + id);
            },
            count: function() {
                return $http.get(url + "/count");
            }
        };
    }]);

webShopService.factory('CustomerProxy', ['$http',
    function($http) {
        
        var url = 'http://localhost:8080/rest/customer';
        return {
            find: function(id) {
                return $http.get(url + "/" + id);
            },
            update: function(customer) {
                return $http({
                            url: 'http://localhost:8080/rest/customer',
                            method: 'PUT',
                            headers: { 'Content-Type': 'application/json' },
                            data: { userName: customer.userName, 
                                    userEmail: customer.userEmail,
                                    password: customer.password 
                                }
                            });
                //return $http.put(url + "/" + customer);
            }
        };
    }]);

webShopService.factory('Auth', ['$cookies', 'CustomerProxy',
    function($cookies, CustomerProxy) {
     
        return {
            setCredentials: function(username, password) {
                CustomerProxy.find(username).success(function(user){
                    if(password === user.password){
                        $cookies.username = username;
                    }
                }).error(function(){
                    alert('Database error!');
                });
            },
            clearCredentials: function() {
                $cookies.username = "";
            },
            
            checkCredentials: function() {
                if($cookies.username == ""){
                    return false;
                }
                return true;
            }
        };
    }]);