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
                            url: url,
                            method: 'PUT',
                            headers: { 'Content-Type': 'application/json' },
                            data: { userName: customer.userName, 
                                    userEmail: customer.userEmail,
                                    password: customer.password 
                                }
                            });
                //return $http.put(url + "/" + customer);
            },
            save: function(customer) {
                return $http({
                            url: url,
                            method: 'POST',
                            headers: { 'Content-Type': 'application/json' },
                            data: { userName: customer.userName,
                                    userEmail: customer.userEmail,
                                    password: customer.password
                               }
                });
            }
        };
    }]);

//Auth service
webShopService.factory('Auth', ['$cookieStore', 'CustomerProxy', 'CartService',
    function($cookieStore, CustomerProxy, CartService) {
     
        return {
            //Check password, set cookie
            setCredentials: function(username, password) {
                CustomerProxy.find(username).success(function(user){
                    if(password === user.password){
                        $cookieStore.put('currentUser', user);
                        CartService.createCart();
                    }
                }).error(function(){
                    alert('Database error!');
                });
            },
            //Clear cookie
            clearCredentials: function() {
                $cookieStore.remove('currentUser');
                CartService.destroyCart();
            },
            //Check if logged in
            checkCredentials: function() {
                if($cookieStore.get('currentUser')){
                    return true;
                }
                return false;
            },
            getCredentials: function() {
                return $cookieStore.get('currentUser');
            },
            updateCredentials: function() {
                var user = $cookieStore.get('currentUser');
                $cookieStore.remove('CurrentUser');
                CustomerProxy.find(user.userName).success(function(updated_user) {
                    $cookieStore.put('currentUser', updated_user);
                }).error(function() {
                    alert('Something went horribly wrong');
                });
            }
        };
    }]);

webShopService.factory('CartService', ['$cookieStore',
    function($cookieStore) {
     
        return {
            updateCart: function(product, remove) {
                var list = $cookieStore.get('shoppingCart');
                for(var i = 0; i < list.length; i++){
                    if(list[i].artNr == product.artNr){
                        if(remove){
                            list.splice(i, 1);
                            $cookieStore.remove('shoppingCart');
                            $cookieStore.put('shoppingCart', list);
                            alert('Product removed!');
                        }
                        else {
                            alert('You\'re already trying to buy that!');
                        }
                        return;
                    }
                }
                $cookieStore.remove('shoppingCart');
                list[list.length] = product;
                $cookieStore.put('shoppingCart', list);
                alert('Added to cart!');
            },
            createCart: function() {
                var list = [];
                $cookieStore.put('shoppingCart', list);
            },
            destroyCart: function() {
                $cookieStore.remove('shoppingCart');
            },
            emptyCart: function() {
                $cookieStore.remove('shoppingCart');
                var list = [];
                $cookieStore.put('shoppingCart', list);
            },
            getCart: function() {
                return $cookieStore.get('shoppingCart');
            },
            calculateCost: function() {
                var list = $cookieStore.get('shoppingCart');
                var cost = 0;
                for(var i = 0; i < list.length; i++){
                    cost = cost + list[i].price;
                }
                return cost;
            }
        };
    }]);