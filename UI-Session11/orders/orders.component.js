'use strict';

angular.module('orders').
    component('orders',{
        templateUrl:"orders/orders.template.html",
        controller:function OrdersController($http,$scope){
            const cartPort = 'http://localhost:3000/cart';
            const orderPort = 'http://localhost:3000/orders';
            this.cartCount = 0;
            var self=this;

            $http.get(cartPort).then(function(response){
                self.items = response.data;
                var item;
                for(item in self.items){
                    self.cartCount += self.items[item].count;
                }
            });

            $http.get(orderPort).then(function(response){
                self.orders = response.data;
                console.log(self.orders[0].userId);
            });

            $scope.getOrder=function(orderId){
            
                $http.get(orderPort+'/'+ orderId).then(function(response){
                    self.items = response.data.items;
                    var item;
                    self.totalPrice=0;
                    for(item in self.items){
                        self.totalPrice += self.items[item].price;  
                    }
                });
            }
            //console.log(self.orders[0].user-id);
        }
    });