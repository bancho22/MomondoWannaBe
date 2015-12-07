'use strict';

angular.module('myApp.view2', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
            $routeProvider.when('/view2', {
              templateUrl: 'app/view2/view2.html',
              controller: 'View2Ctrl'
            });
          }])

        .controller('View2Ctrl', ["$scope", "$http",function ($http, $scope) { 
            
            
          var book = function(){
              alert("inside");
             var user = {};

                    $http({method: 'POST', url: 'api/booking',
                        contentType: "application/json", data: JSON.stringify($scope.user)}).
                            success(function (data, status, headers, config) {
                                 alert($scope.user.userName + " booked");
                                

                            }).
                            error(function (data, status, headers, config) {
                                    "Something weng wrong try again."
                            });
 
          }

        }]);