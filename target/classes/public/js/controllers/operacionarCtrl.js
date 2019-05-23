angular.module("appOperacionar", []);

angular.module("appOperacionar").controller("appOperacionarCtrl", function ($scope, $http) {

    urlLevel = 'http://localhost:8080/level/1';
    //urlUser = 'http://localhost:8080/user/user/';

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

    $scope.getLevel = function () {
        $http.get(urlLevel).then(successCallback, errorCallback);

        function successCallback(response) {
            $scope.level = response.data;
            levelObj = response.data;
            console.log("level ", $scope.level.name);
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
        console.log(user);
        if (user.type == 'Aluno') {
            user.type = user.type.toUpperCase();
            $http.post(urlCadastro, user).then(function (response) {
                console.log("salvou");
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

    $scope.getLevel();

});
testLevel = levelObj;
