'use strict';

angular.module('orderSuccess').
    component('orderSuccess',{
        templateUrl:"order-success/order-success.template.html",
        controller:function OrderSuccessController($http){
            const cartPort = 'http://localhost:3000/cart';
            this.cartCount = 0;

            $http.get(cartPort).then(function(response){
                self.items = response.data;
                var item;
                for(item in self.items){
                    self.cartCount += self.items[item].count;
                }
            });
        }
    });