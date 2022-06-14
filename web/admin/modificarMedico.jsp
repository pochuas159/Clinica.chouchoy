<%-- 
    Document   : modificarMedico
    Created on : 10/02/2022, 10:03:37 PM
    Author     : USER
--%>
<%@page import="modelo.*"%>
<%@page import="modeloDao.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous" />
    </head>


    <body>
        <%
            EspecialidadDao daoEsp = new EspecialidadDao();
            MedicoDao medDao = new MedicoDao();
            String id = request.getParameter("id");
            Medico m = medDao.BuscarPorId(id);

        %>
        <div class="container">
            <div class="card">
                <div class="card-header bg-primary text-white">
                    <h5>Modificar Usuario</h5>
                </div>
                <div class="card-body">

                    <form class="row g-3" action="../ControlMedico01">

                        <div class="col-md-6">
                            <label >Nombres</label>
                            <input type="text" class="form-control" name="nombre" required="" maxlength="30" value="<%=m.getNomMed()%>">
                        </div>
                        <div class="col-md-6">
                            <label >Apellidos</label>
                            <input type="text" class="form-control" name="apellido" required="" maxlength="40" value="<%=m.getApeMed()%>">
                        </div>

                        <div class="col-md-6">
                            <label >Especialidad</label>
                            <select class="form-control" name="especialidad">
                                <%
                                    for (Especialidad e : daoEsp.ListadoGeneral()) {
                                        if(e.getIdEsp().equals(m.getEspMed()) ){
                                            out.print("<option value='"+e.getIdEsp()+"' selected>"+e.getNomEsp()+"</option>");
                                        }else{
                                            out.print("<option value='"+e.getIdEsp()+"'>"+e.getNomEsp()+"</option>");
                                        }
                           
                                    }
                                %>
                            </select>
                        </div>

                        <div class="col-md-6">
                            <label >Teléfono</label>
                            <input type="text" class="form-control" name="telefono" required="" maxlength="9" value="<%=m.getTelMed()%>">
                        </div>

                        <div class="col-md-6">
                            <label >Email</label>
                            <input type="text" class="form-control" name="email" required="" maxlength="40" value="<%=m.getEmailMed()%>">
                        </div>
                        <div class="col-md-6">
                            <label >Colegiatura</label>
                            <input type="text" class="form-control" name="cmp" required="" maxlength="6" value="<%=m.getCmpMed()%>">
                        </div>

                        <div class="col-md-3">
                            <input type="hidden" name="id" value="<%=m.getIdMed()%>">
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
