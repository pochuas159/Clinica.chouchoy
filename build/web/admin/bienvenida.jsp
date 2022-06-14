<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous"></link>
        <link href="../resources/css/estilo4.css" rel="stylesheet" type="text/css"/>
        <link href="../resources/css/estilo2.css" rel="stylesheet" type="text/css"/>
        <title>Bienvenido</title>
    </head>
    <body>
        <%@include file="verificarSesion.jsp" %>
        
        <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #66d7d1;">
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a href="bienvenida.jsp" style="margin-left: 10px; border: none" class="btn btn-outline-light" >Inicio</a>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="btn btn-outline-light dropdown-toggle"  style="margin-left: 10px; border: none" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Usuarios
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item btn btn-outline-light" href="crearUsuario.jsp"  target="myFrame2" >Crear Usuario</a></li>
                            <li><a class="dropdown-item btn btn-outline-light" href="../ControlUsuario?accion=listadoGeneral"  target="myFrame2" >Listar Usuarios</a></li>
                        </ul>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="btn btn-outline-light dropdown-toggle"  style="margin-left: 10px; border: none" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Médicos
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item btn btn-outline-light" href="crearMedico.jsp"  target="myFrame2" >Crear Medico</a></li>
                            <li><a class="dropdown-item btn btn-outline-light" href="../ControlMedico01?accion=listadoGeneral"  target="myFrame2" >Listar Medico</a></li>
                        </ul>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="btn btn-outline-light dropdown-toggle"  style="margin-left: 10px; border: none" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Especialidades
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item btn btn-outline-light" href="crearEspecialidad.jsp"  target="myFrame2" >Crear Especialidad</a></li>
                            <li><a class="dropdown-item btn btn-outline-light" href="../ControlEspecialidad?accion=listadoGeneral"  target="myFrame2" >Listar Especialidad</a></li>
                        </ul>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="btn btn-outline-light dropdown-toggle"  style="margin-left: 10px; border: none" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Administrar Citas Médicas
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item btn btn-outline-light" href="listarCitas.jsp"  target="myFrame2" >Listar Citas</a></li>
                            <li><a class="dropdown-item btn btn-outline-light" href="reporteCita.jsp"  target="myFrame2" >Reporte Citas</a></li>
                 
                        </ul>
                    </li>
                </ul>
            </div>

            <div class="dropdown" >
                <button style="border: none" class="btn btn-outline-light dropdown-toggle"  type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false" >
                    <strong>Administrador:</strong> <span><c:out value="${sessionScope.usuario.nombresCompletos()}"/></span>
                </button>
                <div class="dropdown-menu text-center" aria-labelledby="dropdownMenuButton1">
                    <li><a class="dropdown-item" href="#">
                            <img src="../resources/img/user.png" alt="60" width="60"/>
                        </a>
                    </li>
                    <li>
                        <a href="#" class="dropdown-item" >Actualizar mi cuenta</a>
                    </li>

                    <div class="dropdown-divider"></div>
                    <a href="../ControlAcceso?accion=logout"  class="dropdown-item">Cerrar sesión</a>
                </div>
            </div>
        </nav>

        <!-- fondo para inicio
        <div class="contenedor">
            <img src="../resources/img/fondosf.png" style="width: 100%;height: 100%;" />
            <div class="centrado">
            </div>
        </div>
        -->
        <!-- fondo para inicio-->

        <div class="m-4" style="height: 550px;">
            <iframe  name="myFrame2" style="height: 100%; width: 100%;"> 
            </iframe>          
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

    </body>
</html>
