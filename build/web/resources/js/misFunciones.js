
function IniciarSesion() {
    $.ajax({
        type: "post",
        url: "../ControlAcceso",
        data: $("#frmLogin").serialize(),
        success: function (data) {
            if (data !== "") {
                $(location).attr("href", data);
            } else {
                alertify.error('Usuario y/o clave incorrecto');
            }
        },
        error: function (data) {
            console.dir(data);
        }
    });
}