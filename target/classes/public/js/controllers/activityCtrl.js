angular.module("appEducation", []);

angular.module("appEducation").controller("appClassesCtrl", function ($scope, $http, $sce) {

    var urlActivityAssigned = 'http://localhost:8080/activityAssigned/';
    var pathnameClass = window.location.pathname.split( '/' );
    urlClassById ='http://localhost:8080/class/' +  pathnameClass[2];
    var urlActivirtyReceived = 'http://localhost:8080/activityReceived/';
    var urlUser = 'http://localhost:8080/user/on';

    $scope.getActivityAssignedById= function (){

        var pathnameVideo = window.location.pathname.split( '/' );
        var urlActivityAssigned = 'http://localhost:8080/activityAssigned/' +  pathnameVideo[4];

        $http.get(urlActivityAssigned).then(successCallback, errorCallback);
        function successCallback(response) {
            $scope.activedAssigned = response.data;

        }
        function errorCallback(error) {
            alert("erro no get");
        }
    }

    $scope.getUser = function () {

        $http.get(urlUser).then(successCallback, errorCallback);

        function successCallback(response) {
            $scope.user = response.data;
        }
        function errorCallback(error) {
            alert("erro no get");
        }
    };

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

    $scope.saveActivityReceived = function (activirtyReceived) {
        activirtyReceived.activityAssigned = $scope.activedAssigned;
        activirtyReceived.userActivity = $scope.user;

        $http.post(urlActivirtyReceived, activirtyReceived).then(function(response) {
            delete $scope.activityReceived;
        });
    }

    if (pathnameClass.length >4)
        $scope.getActivityAssignedById();

    $scope.getClassById();
    $scope.getUser();

});