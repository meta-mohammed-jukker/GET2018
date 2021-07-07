'use strict';

angular.module('productList').
    component('productList',{
        templateUrl: 'product-list/product-list.template.html',
        controller: function ProductsController($scope,$http){
            const cartPort = 'http://localhost:3000/cart';
            const productPort = 'http://localhost:3000/products';
            var self = this;
            this.cartCount = 0;

            $http.get(productPort).then(function(response){
                self.products = response.data;
            });

            $http.get(cartPort).then(function(response){
                self.items = response.data;
                var item;
                for(item in self.items){
                    self.cartCount += self.items[item].count;
                }
            });

            $scope.addCart=function(product){
                self.cartCount = self.cartCount + 1;


                $http.get(cartPort+'/' + product.id).then(function successCallback(response){
                    response.data.count += 1;
                    response.data.price = response.data.count * product.price;
                    console.log(response.data.price);
                    $http({
                        method: 'PUT',
                        url:cartPort+'/' + product.id,
                        data: response.data,
                        dataType:'json'
                    });
                },function errorCallback(response){
            
                        var cartData = {
                            "id":product.id,
                            "title":product.title,
                            "price":product.price,
                            "imageUrl":product.imageUrl,
                            "count":1
                        }

                        $http({
                            method: 'POST',
                            url:cartPort+'/',
                            data: cartData,
                            dataType:'json'
                        })
                    
                });
            }


            
        }
    });