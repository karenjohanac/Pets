$(document).ready(function () {

    $("#form-login").submit(function (event) {  //Esta llamando la info que contenda el id form-login

        event.preventDefault();
        autenticarUsuario();
    });

    $("#form-register").submit(function (event) {

        event.preventDefault();
        registrarUsuario();
    });
    
    $("#form-register-mascota").submit(function (event) {
        event.preventDefault();
        registrarMascota();
    });
    
});


// Funcion para validar login de usuario
function autenticarUsuario() {

    let username = $("#usuario").val();
    let contrasena = $("#contrasena").val();

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioLogin",
        data: $.param({
            username: username,
            contrasena: contrasena
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult != false) {
                $("#login-error").addClass("d-none");
                let username = parsedResult['username'];
                document.location.href = "home.html?username=" + username;
            } else {
                $("#login-error").removeClass("d-none");
            }
        }
    });
}

// Funcion para el proceso de registro de usuario
function registrarUsuario() {

    let username = $("#username").val();         // Captura de datos por input para almacenar en base de datos
    let contrasena = $("#contrasena").val();
    let contrasenaConfirmacion = $("#contrasena-repeat").val();
    let primer_nombre = $("#primer_nombre").val();
    let segundo_nombre = $("#segundo_nombre").val();
    let primer_apellido = $("#primer_apellido").val();
    let segundo_apellido = $("#segundo_apellido").val();
    let email = $("#email").val();
    let telefono = $("#telefono").val();

    if (contrasena == contrasenaConfirmacion) {

        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletUsuarioRegister",
            data: $.param({
                username: username,
                contrasena: contrasena,
                primer_nombre: primer_nombre,
                segundo_nombre: segundo_nombre,
                primer_apellido: primer_apellido,
                segundo_apellido: segundo_apellido,
                email: email,
                telefono: telefono,
            }),
            success: function (result) {
                let parsedResult = JSON.parse(result);

                if (parsedResult != false) {
                    $("#register-error").addClass("d-none");
                    let username = parsedResult['username'];
                    document.location.href = "home.html?username=" + username;
                } else {
                    $("#register-error").removeClass("d-none");
                    $("#register-error").html("Error en el registro del usuario");
                }
            }
        });
    } else {
        $("#register-error").removeClass("d-none");
        $("#register-error").html("Las contraseñas no coinciden");
    }
}

// Funcion para el proceso de registro de usuario
function registrarMascota() {

    let nombre = $("#nombre").val();         // Captura de datos por input para almacenar en base de datos
    let edad = $("#edad").val();
    let foto = $("#fileImagen").val();
    let descripcion = $("#descripcion").val();
    let tipo_mascota_ = $("#tipo_mascota_").val();
    let sexo = $("#sexo").val();
    let tamanio = $("#tamanio").val();
    let color = $("#color").val();
    let raza = $("#raza").val();


        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletMascota",
            data: $.param({
                nombre: nombre,
                edad: edad,
                foto: foto,
                descripcion: descripcion,
                tipo_mascota_: tipo_mascota_,
                sexo: sexo,
                tamanio: tamanio,
                color: color,
                raza: raza,
            }),
            success: function (result) {
                let parsedResult = JSON.parse(result);

                if (parsedResult != false) {
                    $("#register-error").addClass("d-none");
                    alert(" Se ha registrado con exito :D ");
                    //let username = parsedResult['username'];
                    //document.location.href = "home.html?username=" + username;
                } else {
                    $("#register-error").removeClass("d-none");
                    $("#register-error").html("Error en el registro del usuario");
                }
            }
        });
}

