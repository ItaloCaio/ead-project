angular.module("appEducation", []);

angular.module("appEducation").controller("appClassesCtrl", function ($scope, $http) {

    urlClass = 'http://localhost:8080/class';
    urlUser = 'http://localhost:8080/user/on';

    var pathname = window.location.pathname.split( '/' );
    urlClassById ='http://localhost:8080/class/' +  pathname[2];

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
            $scope.userLogado = response.data;
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

    $scope.selecionaUsuario = function (usuarioSelecionado) {
        $scope.usuario = usuarioSelecionado;
    };


    $scope.limparCampos = function () {
        $scope.usuario = "";
    };


    $scope.save = function (aClass) {
        $http.post(urlClass, aClass).then(function (response) {
            delete $scope.aClass;
        });
    }


    $scope.getClasses();
    $scope.getUser();
    $scope.getClassById();

});
