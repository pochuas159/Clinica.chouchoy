<%@page import="modelo.Especialidad"%>
<%@page import="modeloDao.EspecialidadDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous" />
    </head>
    <body>
        <%
            EspecialidadDao espDao = new EspecialidadDao();
            String id = (request.getParameter("id"));
            Especialidad e = espDao.BuscarPorId(id);
        %>
        <div class="container">
            <div class="card">
                <div class="card-header bg-primary text-white">
                    <h5>Modificar Especialidad</h5>
                </div>
                <div class="card-body">

                    <form class="row g-3" action="../ControlEspecialidad">
                        <div class="col-md-6">
                            <label >Id</label>
                            <input type="text" class="form-control" name="codigo" required="" maxlength="30" value="<%=e.getIdEsp() %>" readonly="">
                        </div>
                        <div class="col-md-6">
                            <label >Nombres</label>
                            <input type="text" class="form-control" name="name" required="" maxlength="40" value="<%=e.getNomEsp()%>" >
                        </div>

                        <div class="col-md-3">
                             <input type="hidden" name="id" value="<%=e.getIdEsp()%>">
                            <input type="hidden" name="accion" value="editar">
                            <input type="submit" value="Guardar edición" class="btn btn-primary">
                            <input type="reset" value="Nuevo" class="btn btn-danger">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
