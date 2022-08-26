var helloAjaxApp = angular.module("myApp", []);
 
helloAjaxApp.controller("myCtrl", [ '$scope', '$http', function($scope, $http) {
 
    $http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded; charset=utf-8";
     
    $scope.sendPost = function() {
        $http({
            url : 'MyServlet',
            method : "POST",
            data : {
                'name' : $scope.name
            }
        }).then(function(response) {
           
            $scope.message = response.data;
        }, function(response) {
           
            
            $scope.message = response;
        });
 
    };
} ]);