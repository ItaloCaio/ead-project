angular.module("appEducation", []);

angular.module("appEducation").controller("appClassesCtrl", function ($scope, $http) {

    urlClass = 'http://localhost:8080/class';
    urlUser = 'http://localhost:8080/user/on';

    $scope.getClasses = function () {
        $http.get(urlClass).then(successCallback, errorCallback);
        function successCallback(response) {
            $scope.classes = response.data;
            console.log($scope.classes);
        }
        function errorCallback(error) {
            alert("erro no get");
        }
    };

    $scope.getUser = function () {
        console.log("retornar usuário");
        $http.get(urlUser).then(successCallback, errorCallback);

        function successCallback(response) {
            $scope.userLogado = response.data;
        }

        function errorCallback(error) {
            alert("erro no get");
        }
    };

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

});
