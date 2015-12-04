angular.module('myApp.view1', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view1', {
                    templateUrl: 'app/view1/view1.html',
                    controller: 'View1Ctrl',
                    controllerAs: 'ctrl'
                });
            }])


        .controller('View1Ctrl', ["$scope", "$http", function ($scope, $http) {
                $http.get('api/flightinfo')
                        .success(function (data, status, headers, config) {
                            $scope.data = data;
                        })
                        .error(function (data, status, headers, config) {

                        });



                $scope.airport = [{
                        id: 1,
                        label: 'Copenhagen',
                        name: 'CPH'
                    }
                    , {
                        id: 2,
                        label: 'Berlin',
                        name: 'SXF'
                    }
                    , {
                        id: 3,
                        label: 'Barcelona',
                        name: 'BCN'
                    }
                    , {
                        id: 4,
                        label: 'Paris',
                        name: 'CDG'
                    }
                    , {
                        id: 5,
                        label: 'London',
                        name: 'STN'
                    }
                    
                ];


                $scope.getFlight = function () {
                    if ($scope.chosenAirportDestination === undefined) {
                        return $http({method: 'GET', url: '/3rdSemesterProject/api/flightinfo/' + $scope.chosenAirportOrigin.name + '/' + $scope.date.toISOString() + '/' + $scope.tickets,
                            contentType: "application/json"}).success(function (data) {

                            $scope.output = data;


                        }).
                                error(function (data, status, headers, config) {

                                });
                    }
                    else{
                    return $http({method: 'GET', url: '/3rdSemesterProject/api/flightinfo/' + $scope.chosenAirportOrigin.name + "/" + $scope.chosenAirportDestination.name + '/' + $scope.date.toISOString() + '/' + $scope.tickets,
                            contentType: "application/json"}).success(function (data) {

                        $scope.output = data;


                    }).
                            error(function (data, status, headers, config) {

                            });
                    };
                };





            }]
                );




