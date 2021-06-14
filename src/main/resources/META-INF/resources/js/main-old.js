var app = angular.module("FruitManagement", []);

        //Controller Part
        app.controller("FruitManagementController", function ($scope, $http) {

            //Initialize page with default data which is blank in this example
            $scope.fruits = [];

            $scope.form = {
                name: "",
                description: ""
            };

            //Now load the data from server
            _refreshPageData();

            //HTTP POST methods for add fruits
            $scope.add = function () {
                var data = { "name": $scope.form.name, "description": $scope.form.description };

                $http({
                    method: "POST",
                    url: '/fruits',
                    data: angular.toJson(data),
                    headers: {
                        'Content-Type': 'application/json'
                    }
                }).then(_success, _error);
            };

            $scope.delete = function () {
                var data = { "name": $scope.form.name, "description": $scope.form.description };

                $http({
                    method: "DELETE",
                    url: '/fruits/' + data.name
                }).then(_success, _error);
            };

            /* Private Methods */
            //HTTP GET- get all fruits collection
            function _refreshPageData() {
                $http({
                    method: 'GET',
                    url: '/fruits'
                }).then(function successCallback(response) {
                    $scope.fruits = response.data;
                }, function errorCallback(response) {
                    console.log(response.statusText);
                });
            }

            function _success(response) {
                _refreshPageData();
                _clearForm();
            }

            function _error(response) {
                alert(response.data.message || response.statusText);
            }

            //Clear the form
            function _clearForm() {
                $scope.form.name = "";
                $scope.form.description = "";
            }
        });