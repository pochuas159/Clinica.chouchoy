
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Especialidad</title>
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous"></link>

    </head>
    <body>
        <div class="container">
            <div class="card">
                <div class="card-header bg-primary text-white">
                    <h5>Crear nueva especialidad</h5>
                </div>
                <div class="card-body">

                    <form class="row g-3" action="../ControlEspecialidad">
                       

                        <div class="col-md-6">
                            <label >ID especialidad</label>
                            <input type="text" class="form-control" name="id" required="" maxlength="3">
                        </div>

                        <div class="col-md-12">
                            <div class="col-md-6">
                                <label >Nombre de la especialidad</label>
                                <input type="text" class="form-control" name="name" required="" >
                            </div>
                        </div>

                        <div class="col-md-3">
                            <input type="hidden" name="accion" value="guardar">
                            <input type="submit" value="Guardar cambios" class="btn btn-primary">
                            <input type="reset" value="Nuevo" class="btn btn-danger">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
