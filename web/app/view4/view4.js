angular.module('myApp.view4', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view4', {
                    templateUrl: 'app/view4/view4.html',
                    controller: 'View4Ctrl',
                    controllerAs: 'ctrl'
                });
            }])

        .service('getPrice', [function () {
                var numOfSeats = {};

                return  numOfSeats;



            }])
        .service('getFlightID', [function () {
                var flightID = {};

                return  flightID;



            }])
        .service('getAirline', [function () {
                var airlineName = {};

                return  airlineName;



            }])
        .service('getDestination', [function () {
                var destination = {};

                return  destination;



            }])
        .service('getOrigin', [function () {
                var origin = {};

                return  origin;



            }])

        .controller('View4Ctrl', ["$scope","$http", function ( $scope, $http) {



                $scope.getReservations = function () {
                    return $http({method: 'GET', url: '/3rdSemesterProject/api/booking/getBookings',
                        contentType: "application/json"}).success(function (data) {



                        $scope.output = data;
                        
                    }).
                            error(function (data, status, headers, config) {

                                alert("No data found.");
                                $scope.output = [];
                            });

                    ;
                };





            }]
                );

