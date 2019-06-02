angular.module("appCadastro", []);
console.log("fez a conexao");

angular.module("appCadastro").controller("appCadastroCtrl", function ($scope, $http) {

    urlCadastro = 'http://localhost:8080/user';
    urlUser = 'http://localhost:8080/user/on';
    $scope.userON = null;

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
        console.log("retornar usuário");
        $http.get(urlUser).then(successCallback, errorCallback);

        function successCallback(response) {
            $scope.userON = response.data;
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


    $scope.salvar = function (user) {
        if (user.type == 'Aluno') {
            user.type = user.type.toUpperCase();
            $http.post(urlCadastro, user).then(function (response) {
                console.log("salvou", user);
                delete $scope.user;
            });
        } else if (user.type == 'Professor') {
            console.log('O tipo do usuário é Professor');
        } else if (user.type == 'Tutor') {
            console.log('O tipo do usuário é Tutor ');
        }
        /*
             $http.post(urlCadastro, usuario).then(function (response){
                console.log("salvou");
                 delete $scope.usuario;
                    listarUsuarios();
             });
             */
    }

    //$scope.listarUsuarios();

    $scope.getUser();

});
