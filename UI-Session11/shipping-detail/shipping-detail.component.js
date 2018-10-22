'use strict';

angular.module('shippingDetail').
    component('shippingDetail',{
        templateUrl:"shipping-detail/shipping-detail.template.html",
        controller:function ShippingDetailController($http,$scope){
            const cartPort = 'http://localhost:3000/cart';
            const orderPort = 'http://localhost:3000/orders';
            const shippingPort = 'http://localhost:3000/shipping';
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

            $http.get(shippingPort).then(function(response){
                self.shipping = response.data;
                console.log(self.shipping[0].name);
            });
            
            $scope.placeOrder=function(){
                $http({
                    method:'PUT',
                    data:self.shipping[0],
                    url:shippingPort+'/'+self.shipping[0].id,
                    dataType:'json'
                }).then(function(response){
                    console.log("successfull");
                });
                $http.get(cartPort).then(function(response){
                    self.items = response.data;
                });

                var today = new Date();
                var dd = today.getDate();
                var mm = today.getMonth()+1; //January is 0!
                var yyyy = today.getFullYear();

                today = mm + '/' + dd + '/' + yyyy;


                var orderData={
                    "items":self.items,
                    "customerName":self.shipping[0].name,
                    "date":today
                }

                $http({
                    method:'POST',
                    url:orderPort,
                    data:orderData,
                    dataType:'json'
                });

                var item=1;
                for(item in self.items){
                    console.log(item.id);
                    $http.delete(cartPort+'/' + self.items[item].id, item).then(function(response){
                        console.log("successfull");
                    })
                }
                window.location="#!/products/order-success/";   
            }
            
        }
    });