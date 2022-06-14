<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous"></link>

    </head>
    <body>
        <div class="container">
            <div class="card">
                <div class="card-header bg-primary text-white">
                    <h5>Nuevo Usuario</h5>
                </div>
                <div class="card-body">

                    <form class="row g-3" action="../ControlUsuario">
                        <div class="col-md-6">
                            <label >Nombres</label>
                            <input type="text" class="form-control" name="nombres" required="" maxlength="30">
                        </div>
                        <div class="col-md-6">
                            <label >Apellidos</label>
                            <input type="text" class="form-control" name="apellidos" required="" maxlength="40">
                        </div>

                        <div class="col-md-6">
                            <label >DNI</label>
                            <input type="text" class="form-control" name="dni" required="" maxlength="8">
                        </div>
                        <div class="col-md-6">
                            <label >Password</label>
                            <input type="password" class="form-control" name="pass" required="" maxlength="20">
                        </div>

                        <div class="col-md-6">
                            <label >Teléfono</label>
                            <input type="text" class="form-control" name="telefono" required="" maxlength="9">
                        </div>

                        <div class="col-md-6">
                            <label >Email</label>
                            <input type="email" class="form-control" name="email" required="" maxlength="40">
                        </div>

                        <div class="col-md-12">
                            <div class="col-md-6">
                                <label >Edad</label>
                                <input type="number" class="form-control" name="edad" required="" >
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
