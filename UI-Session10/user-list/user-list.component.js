angular.module('userList').
    component('userList',{
        templateUrl: 'user-list/user-list.template.html',
        controller: function UserListController($scope,$http){
            
            $http({
                method: 'GET',
                url: 'http://localhost:3000/users/'
              }).then(function (response){
               $scope.userData = response.data;
             });
            
              $scope.addUser=function(){
            
               if($scope.user.id == null || $scope.user.id === ""){
                    $http({
                      method: 'POST',
                      url:'http://localhost:3000/users/',
                      data: $scope.user,
                      dataType:'json'
                    });
            
                 }else{
                    $http.put('http://localhost:3000/users/' + $scope.user.id,$scope.user);
                 }
                 window.location.reload();
              }
            
              $scope.populateEditForm = function(userId){
                  $http({
                    method: 'GET',
                    url: 'http://localhost:3000/users/' + userId
                 }).then(function (response){
                    $scope.user = response.data;
                 });
               }
            
              $scope.resetUser = function(){
                  $scope.user.id = null;  
                  $scope.user.name = null;
                  $scope.user.city = null;
                  $scope.user.contact = null;
                  
               }
            }
    });