<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous"></link>
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

                    <li class="nav-item">
                        <a href="citaInicial.jsp" style="margin-left: 10px; border: none" class="btn btn-outline-light" target="myFrame" >Generar Cita</a>
                    </li>
                    <li class="nav-item">
                        <a href="listarCitas.jsp" style="margin-left: 10px; border: none" class="btn btn-outline-light" target="myFrame" >Mis Citas</a>
                    </li> 
                </ul>
            </div>



            <div class="dropdown">
                <button style="border: none" class="btn btn-outline-light dropdown-toggle"  type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false" >
                    <strong>Paciente:</strong> <span><c:out value="${sessionScope.usuario.nombresCompletos()}"/></span>
                </button>
                <div class="dropdown-menu text-center" aria-labelledby="dropdownMenuButton1">
                    <li>
                        <a class="dropdown-item" href="#">
                            <img src="../resources/img/paciente.png" alt="60" width="60"/>
                        </a>
                    </li>
                    <li>
                        <a href="#" class="dropdown-item" >Actualizar mi cuenta</a>
                    </li>
                    <li>
                        <a class="dropdown-item" href="#"></a>
                    </li>
                    <div class="dropdown-divider"></div>
                    <a href="../ControlAcceso?accion=logout"  class="dropdown-item">Cerrar sesión</a>
                </div>
            </div>
        </nav>
        <!-- fondo para inicio-->

        <!-- fondo para inicio-->

        <div class="m-4" style="height: 550px;">

            <iframe  name="myFrame" style="height: 100%; width: 100%;"> 
                <!--
                           <h:link outcome="listarCitas" value="Mis citas"></h:link> <br></br>
                <h:link outcome="citaInicial" value="Generar Cita"></h:link><br></br>
                -->
            </iframe>          
        </div>




        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

    </body>
</html>
