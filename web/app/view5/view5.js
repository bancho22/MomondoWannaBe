angular.module('myApp.view5', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view5', {
                    templateUrl: 'app/view5/view5.html',
                    controller: 'View5Ctrl',
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
        .service('getLname', [function () {
                var lname = {};

                return  lname;



            }])
        .service('getFname', [function () {
                var fname = {};

                return  fname;



            }])

        .controller('View5Ctrl', ["username", function ($scope, $http) {



                $scope.getReservations = function () {
                    return $http({method: 'GET', url: '/3rdSemesterProject/api/booking/getBookings/' + $scope.username,
                        contentType: "application/json"}).success(function (data) {



                        $scope.output = data;
                        getOrigin.origin = origin;
                        getDestination.destination = destination;
                        getFlightID.flightID = flightNumber;
                        getAirline.airlineName = airline;
                        getFname.fname = fname;
                        getLname.lname = lname;
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

