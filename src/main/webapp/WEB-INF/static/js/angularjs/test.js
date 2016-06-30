angular.module("app",[]).controller('MainController',['$scope','$http',function($scope,$http){
    $scope.test =222;
    $http.defaults.headers.common['Authorization'] = "Basic YWRtaW46MTIzNDU2";

    var url = 'http://localhost:8080/travelalone/api/v1/headimage';
    var data = {};
    $http({
        method: 'POST',
        url: url,
        params: data//,
        /*headers:{
         'Accept': 'application/json; charset=utf-8',
         'Content-Type': 'application/json; charset=utf-8',
         'X-Auth-Token': 'Basic ' + 'YWRtaW46MTIzNDU2'
         }*/
    }).success(
        function (data, status, header, config) {
            //alert(JSON.stringify(data));
        });
}])