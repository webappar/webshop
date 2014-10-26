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
            count: function() {
                return $http.get(url + "/count");
            }
        };
    }]);

webShopService.factory('CustomerProxy', ['$http',
    function($http) {
        
        var url = 'http://localhost:8080/rest/customer';
        return {
            //Find a customer
            find: function(id) {
                return $http.get(url + "/" + id);
            },
            //Update a customer
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
            //Create new customer
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
            //retrieve user from cookies
            getCredentials: function() {
                return $cookieStore.get('currentUser');
            },
            //if user credentials are updated, update cookie
            updateCredentials: function() {
                var user = $cookieStore.get('currentUser');
                $cookieStore.remove('CurrentUser');
                CustomerProxy.find(user.userName).success(function(updated_user) {
                    $cookieStore.put('currentUser', updated_user);
                }).error(function() {
                    //Shouldn't happen
                    alert('Something went horribly wrong');
                });
            }
        };
    }]);
//Shopping cart service
webShopService.factory('CartService', ['$cookieStore',
    function($cookieStore) {
     
        return {
            //Update the shopping cart, either add or remove a product
            //if remove == true, then remove a product, if false add a product
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
            //set empty cart as a cookie
            createCart: function() {
                var list = [];
                $cookieStore.put('shoppingCart', list);
            },
            //destroys the cart, only use on logout
            destroyCart: function() {
                $cookieStore.remove('shoppingCart');
            },
            //Used for checking out, removes cart and creates a new empty one
            emptyCart: function() {
                $cookieStore.remove('shoppingCart');
                var list = [];
                $cookieStore.put('shoppingCart', list);
            },
            //Retrieve the cart from cookies
            getCart: function() {
                return $cookieStore.get('shoppingCart');
            },
            //For displaying total cost of curren cart
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

webShopService.factory('OrdersProxy', ['$http',
    function($http) {
        
        var url = 'http://localhost:8080/rest/orders';
        return {
            findAll: function() {
                return $http.get(url);
            }

        };
    }]);

webShopService.factory('OrderitemProxy', ['$http',
    function($http) {
        
        var url = 'http://localhost:8080/rest/orderitem';
        return {
            findAll: function() {
                return $http.get(url);
            }

        };
    }]);