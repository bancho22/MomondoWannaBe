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

        .controller('View4Ctrl', ["username", function (username, $scope, $http) {



                $scope.getReservations = function (username) {
                    return $http({method: 'GET', url: '/3rdSemesterProject/api/booking/' + $scope.username,
                        contentType: "application/json"}).success(function (data) {



                        $scope.output = data;
                        getOrigin.origin = origin;
                        getDestination.destination = destination;
                        getFlightID.flightID = flightNumber;
                        getAirline.airlineName = airline;
                        getPrice.price = price;
                    }).
                            error(function (data, status, headers, config) {

                                alert("No data found.");
                                $scope.output = [];
                            });

                    ;
                };





            }]
                );

