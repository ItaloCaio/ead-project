angular.module("appEducation", []);

angular.module("appEducation").controller("appClassesCtrl", function ($scope, $http, $sce) {

    var urlVideo = 'http://localhost:8080/video/';
    var pathnameClass = window.location.pathname.split( '/' );
    urlClassById ='http://localhost:8080/class/' +  pathnameClass[2];

    $scope.getVideoById= function (){

        var pathnameVideo = window.location.pathname.split( '/' );
        var urlVideoById = 'http://localhost:8080/video/' +  pathnameVideo[4];

        $http.get(urlVideoById).then(successCallback, errorCallback);
        function successCallback(response) {
            $scope.videoId = response.data;

            $scope.movie = {src:"http://www.youtube.com/embed/"+$scope.videoId.url, title: $scope.videoId.title};
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

    $scope.saveVideo = function (video) {
        video.aClass = $scope.classId;
        console.log(video.aClass)
        $http.post(urlVideo, video).then(function (response) {
            delete $scope.video;
        });
    }

    $scope.trustSrc = function(src) {
        return $sce.trustAsResourceUrl(src);
    }

    if (pathnameClass.length >4)
        $scope.getVideoById();

    $scope.getClassById();

});