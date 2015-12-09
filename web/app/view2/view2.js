'use strict';

angular.module('myApp.view2', ['ngRoute','myApp.view1'])

        .config(['$routeProvider', function ($routeProvider) {
            $routeProvider.when('/view2', {
              templateUrl: 'app/view2/view2.html',
              controller: 'View2Ctrl'
            });
          }])

        .controller('View2Ctrl', ["$scope","getNumOfSeats", "$http",function ($scope, getNumOfSeats,$http) { 
            
            
          $scope.book = function(booker){
              alert("inside");
                    alert(getNumOfSeats);
//                    var reserve = {};
//                    reserve.Name = booker.fName + " " + booker.lName;
//                    reserve.Phone = booker.phone;
//                    reserve.Email = booker.email;
//                    reserve.seats = getNumOfSeats;
//                    $http({method: 'POST', url: 'api/booking',
//                        contentType: "application/json", data: JSON.stringify(booker)}).
//                            success(function (data, status, headers, config) {
//                                 alert(user.fName + " booked");
//                                
//
//                            }).
//                            error(function (data, status, headers, config) {
//                                    "Something weng wrong try again."
//                            });
 
          }

        }]);