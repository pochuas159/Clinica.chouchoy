<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administradores</title>
        <script src="https://www.google.com/recaptcha/api.js"></script>
        <link href="../resources/css/estilos3.css" rel="stylesheet" type="text/css"/>
        <link href="../css/styles.css" rel="stylesheet" type="text/css"/>
        <link href="../resources/alertifyjs/css/alertify.min.css" rel="stylesheet" >  
        <link href="../resources/alertifyjs/css/themes/default.min.css" rel="stylesheet" />  
    </head>
    <body>
        <main>
            <div class="contenedor__todo">

                <div class="caja__trasera">
                    <div class="caja__trasera-login">
                        <h3>Ya </h3>
                        <p>Ingresa</p>
                    </div>
                </div>

                <div class="contenedor__login-register">
                    <!--sesion-->
                    <form id="frmLogin" name="frmLogin" method="post"  class="formulario__login" >
                        <input type="hidden" id="accion" name="accion"  value="login" />
                        <input type="hidden" id="modulo" name="modulo" value="administrador" />
                        <table>
                            <tbody>
                                <tr>
                                    <td>Usuario: </td>
                                    <td><input type="text" name="usuario" value="72316242"/></td>
                                </tr>
                                <tr>
                                    <td>Password: </td>
                                    <td><input type="password" name="pass" value="72316242" /></td>
                                </tr>
                                
                                 <tr>
        
                                <td></td>
                                <td>
                                    <div class="g-recaptcha" data-sitekey="6Ldh9LcfAAAAAB8JN09iDD7IjXZWjedjnbsHSmc5"></div>
                                </td>
                                </tr>
                                
                                <tr>
                                    <td><input type="button" value="Aceptar" onclick="IniciarSesion()" /></td>
                                </tr>
                            </tbody>
                        </table>
                    </form>

                </div>
                <br>
                <a href="../index.jsp" class="btn btn-dark">Ir a pagina Principal</a>

            </div>
        </main>
        <script src="../resources/js/script.js" type="text/javascript"></script>
          <script src="../js/jquery.min.js" type="text/javascript"></script>
        <script src="../resources/alertifyjs/js/alertify.min.js"></script> 
        <script src="../resources/js/misFunciones.js" type="text/javascript"></script>
    </body>
</html>
