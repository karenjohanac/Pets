var username = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {

    fillUsuario().then(function () {

        $("#user-petcoin").html("$" + user.petcoin.toFixed());

        getAdoptados(user.username);
    });

    $("#adoptar-btn").attr("href", `home.html?username=${username}`);

    $("#form-modificar").on("submit", function (event) {

        event.preventDefault();
        modificarUsuario();
    });

    $("#aceptar-eliminar-cuenta-btn").click(function () {

        eliminarCuenta().then(function () {
            location.href = "index.html";
        })
    })

});

async function fillUsuario() {
    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioPedir",
        data: $.param({
            username: username,
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;

                $("#primer_nombre").val(parsedResult.primer_nombre);
                $("#segundo_nombre").val(parsedResult.segundo_nombre);
                $("#primer_apellido").val(parsedResult.primer_apellido);
                $("#segundo_apellido").val(parsedResult.segundo_apellido);
                $("#telefono").val(parsedResult.telefono);
                $("#correo").val(parsedResult.email);
                $("#username").val(parsedResult.username);
                $("#contrasena").val(parsedResult.contrasena);

            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });
}


function modificarUsuario() {

    let primer_nombre = $("#primer_nombre").val();
    let segundo_nombre = $("#segundo_nombre").val();
    let primer_apellido = $("#primer_apellido").val();
    let segundo_apellido = $("#segundo_apellido").val();
    let telefono = $("#telefono").val();
    let correo = $("#correo").val();
    let username = $("#username").val();
    let contrasena = $("contrasena").val();
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioModificar",
        data: $.param({
            primer_nombre: primer_nombre,
            segundo_nombre: segundo_nombre,
            primer_apellido: primer_apellido,
            segundo_apellido: segundo_apellido,
            telefono : telefono,
            correo: correo,
            username: username,
            contrasena: contrasena,
        }),
        success: function (result) {

            if (result != false) {
                $("#modificar-error").addClass("d-none");
                $("#modificar-exito").removeClass("d-none");
            } else {
                $("#modificar-error").removeClass("d-none");
                $("#modificar-exito").addClass("d-none");
            }

            setTimeout(function () {
                location.reload();
            }, 3000);

        }
    });
}

async function eliminarCuenta() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioEliminar",
        data: $.param({
            username: username
        }),
        success: function (result) {

            if (result != false) {

                console.log("Usuario eliminado")

            } else {
                console.log("Error eliminando el usuario");
            }
        }
    });
}



