angular.module("appEducation", []);

angular.module("appEducation").controller("appClassesCtrl", function ($scope, $http, $sce) {

    var urlActivityAssigned = 'http://localhost:8080/activityAssigned/';
    var pathnameClass = window.location.pathname.split( '/' );
    urlClassById ='http://localhost:8080/class/' +  pathnameClass[2];

    $scope.getActivityAssignedById= function (){

        var pathnameVideo = window.location.pathname.split( '/' );
        var urlVideoById = 'http://localhost:8080/video/' +  pathnameVideo[4];

        $http.get(urlVideoById).then(successCallback, errorCallback);
        function successCallback(response) {
            $scope.ActivedAssigned = response.data;

        }
        function errorCallback(error) {
            alert("erro no get");
        }
    }
    $scope.getClassById = function (){

        $http.get(urlClassById).then(successCallback, errorCallback);

        function successCallback(response) {
            $scope.classId = response.data;
            console.log('sala: ', response.data);
        }
        function errorCallback(error) {
            alert("erro no get");
        }
    }

    $scope.saveActivityAssigned = function (activityAssigned) {
        activityAssigned.aClassActivity = $scope.classId;

        $http.post(urlActivityAssigned, activityAssigned).then(function (response) {
            delete $scope.activityAssigned;
        });
    }


    if (pathnameClass.length >4)
        $scope.getActivityAssignedById();

    $scope.getClassById();

});