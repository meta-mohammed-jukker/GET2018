'use strict';

angular.module('cartDetail').
    component('cartDetail',{
        templateUrl: "cart-detail/cart-detail.template.html",
        controller: function CartDetailController($http,$scope){
            const cartPort = 'http://localhost:3000/cart';
            this.cartCount = 0;
            var self = this;
            $http.get(cartPort).then(function(response){
                self.items = response.data;
                var item;
                self.totalPrice=0;
                for(item in self.items){
                    self.totalPrice += self.items[item].price;
                    self.cartCount += self.items[item].count;  
                }
            });

            
            $scope.deleteAll=function(){
                
                var item=1;
                for(item in self.items){
                    console.log(item.id);
                    $http.delete(cartPort+'/' + self.items[item].id, item).then(function(response){
                        console.log("successfull");
                    })
                }
                //  $scope.cartCount = 0;
                window.location.reload();
            }

        }
    });