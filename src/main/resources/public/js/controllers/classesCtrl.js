angular.module("appEducation", []);

angular.module("appEducation").controller("appClassesCtrl", function ($scope, $http) {

    urlClass = 'http://localhost:8080/class';
    urlUser = 'http://localhost:8080/user/on';


    $scope.getClasses = function () {

        $http.get(urlClass).then(successCallback, errorCallback);

        function successCallback(response) {
            $scope.classes = response.data;
        }
        function errorCallback(error) {
            alert("erro no get");
        }
    };

    $scope.getUser = function () {

        $http.get(urlUser).then(successCallback, errorCallback);

        function successCallback(response) {
            $scope.userON = response.data;
        }

        function errorCallback(error) {
            alert("erro no get");
        }
    };

    $scope.getClassById = function (){
        urlClassById ='http://localhost:8080/class/' +  pathname[2];

        $http.get(urlClassById).then(successCallback, errorCallback);

        function successCallback(response) {
            $scope.classId = response.data;
            console.log('sala: ', response.data);
        }
        function errorCallback(error) {
            alert("erro no get");
        }
    }




    $scope.saveStream = function (stream){

        stream.user = $scope.userON;
        stream.aClass = $scope.classId;
        $http.post(urlStream, stream).then(successCallback, errorCallback);

        function successCallback(response) {
            $scope.stream = response.data;
            window.location.reload();

        }
        function errorCallback(error) {
            alert("erro no get");
        }
    }





    $scope.limparCampos = function () {
        $scope.usuario = "";
    };


    $scope.saveClass = function (aClass) {
        aClass.professor = $scope.userON;
        $http.post(urlClass, aClass).then(function (response) {
            delete $scope.aClass;
        });
    }


    $scope.getClasses();
    $scope.getUser();




});
