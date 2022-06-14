<%@page import="modelo.Especialidad"%>
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
                    <th>Nombre</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ArrayList<Especialidad> lista = (ArrayList<Especialidad>) request.getAttribute("lista");

                    for (Especialidad e : lista) {
                %>
                <tr>
                    <td><%=e.getIdEsp()%></td>
                    <td><%=e.getNomEsp()%></td>
                    <td>
                        <a href="./admin/modificarespecialidad.jsp?id=<%=e.getIdEsp() %>" class="btn btn-info btn-sm">
                            Editar
                        </a>
                           <a href="ControlEspecialidad?accion=eliminar&id=<%=e.getIdEsp() %>"  target="myFrame2"  class="btn btn-danger btn-sm">
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
