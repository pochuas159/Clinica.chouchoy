<%-- 
    Document   : listarMedico
    Created on : 11-feb-2022, 16:51:47
    Author     : brand
--%>
<%@page import="modelo.Medico"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous"></link>

    </head>
    <body>
        <%@include file="verificarMensajes.jsp" %>
        
        <table class="table table-bordered">
            <thead class="table-success">
                <tr>
                    <th>Código</th>
                    <th>Nombres</th>
                    <th>Apellidos</th>
                    <th>Especialidad</th>
                    <th>Teléfono</th>
                    <th>Email</th>
                    <th>Nro Colegiatura</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ArrayList<Medico> lista = (ArrayList<Medico>) request.getAttribute("lista");

                    for (Medico m : lista) {
                %>
                <tr>
                    <td><%=m.getIdMed()%></td>
                    <td><%=m.getNomMed()%></td>
                    <td><%=m.getApeMed()%></td>
                    <td><%=m.getEspMed()%></td>
                      <td><%=m.getTelMed()%></td>
                    <td><%=m.getEmailMed()%></td>
                    <td><%=m.getCmpMed()%></td>
                    <td>
                        <a href="./admin/modificarMedico.jsp?id=<%=m.getIdMed()%>" class="btn btn-info btn-sm">
                            Editar
                        </a>
                        <a href="ControlMedico01?accion=eliminar&id=<%=m.getIdMed()%>"  target="myFrame2"  class="btn btn-danger btn-sm">
                            Eliminar
                        </a>
                    </td>
                </tr>
                <%
                    }

                    if (lista == null || lista.size() == 0) {
                    %>
                    <tr>
                        <td colspan="10" class="text-center">No se encontraron datos.</td>
                    </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
