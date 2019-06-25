angular.module("appCadastro", []);
console.log("fez a conexao");

angular.module("appCadastro").controller("appCadastroCtrl", function ($scope, $http) {

    urlCadastro = 'http://localhost:8080/user';
    urlUser = 'http://localhost:8080/user/on';

    $scope.users = ['ALUNO', 'PROFESSOR', 'TUTOR'];

    $scope.listarUsuarios = function () {
        console.log("ListarUsuarios");
        $http.get(urlCadastro).then(successCallback, errorCallback);

        function successCallback(response) {
            $scope.usuarios = response.data;
            console.log("entrou");
        }

        function errorCallback(error) {
            alert("erro no get");
        }
    };

    $scope.getUser = function () {

        $http.get(urlUser).then(successCallback, errorCallback);

        function successCallback(response) {
            $scope.userON = response.data;
            console.log("retornar usuário", $scope.userON.name );
        }

        function errorCallback(error) {
            alert("erro no get");
            $scope.userON = undefined;
        }
    };

    $scope.selecionaUsuario = function (usuarioSelecionado) {
        $scope.usuario = usuarioSelecionado;
    };


    $scope.limparCampos = function () {
        $scope.usuario = "";
    };


    $scope.salvar = function (user) {

        user.type = user.type.toUpperCase();
        $http.post(urlCadastro, user).then(successCallback, errorCallback);

        function successCallback(response) {
            console.log("salvou", user);
            delete $scope.user;
            $scope.userSucess = true;
            setTimeout(function () {


                window.location.href = "/";

            }, 1000);
        }

        function errorCallback(error) {
            alert("erro no get");
        }

    };

    //$scope.listarUsuarios();

    $scope.getUser();
    console.log($scope.userON);

});
