angular.module("appEducation", []);

angular.module("appEducation").controller("appClassesCtrl", function ($scope, $http) {

    $scope.getVideoById= function (){

        var pathnameVideo = window.location.pathname.split( '/' );
        var urlClassById ='http://localhost:8080/video/' +  pathnameVideo[4];

        $http.get(urlClassById).then(successCallback, errorCallback);
        function successCallback(response) {
            $scope.videoId = response.data;
            console.log('sala: ', response.data);
        }
        function errorCallback(error) {
            alert("erro no get");
        }
    }

    $scope.getVideoById();
});