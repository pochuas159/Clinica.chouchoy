<%@page import="modelo.Usuario"%>
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
                    <th>DNI</th>
                     <th>Contraseña</th>
                    <th>Teléfono</th>
                    <th>Email</th>
                    <th>Edad</th>
                    <th>Tipo</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ArrayList<Usuario> lista = (ArrayList<Usuario>) request.getAttribute("lista");

                    for (Usuario u : lista) {
                %>
                <tr>
                    <td><%=u.getIdUsu()%></td>
                    <td><%=u.getNomUsu()%></td>
                    <td><%=u.getApeUsu()%></td>
                    <td><%=u.getDniUsu()%></td>
                      <td><%=u.getPassUsu() %></td>
                    <td><%=u.getTeleUsu()%></td>
                    <td><%=u.getEmailUsu()%></td>
                    <td><%=u.getEdadUsu()%></td>
                    <td><%=u.getTipoUsu()%></td>
                    <td>
                        <a href="./admin/modificarUsuario.jsp?id=<%=u.getIdUsu() %>" class="btn btn-info btn-sm">
                            Editar
                        </a>
                           <a href="ControlUsuario?accion=eliminar&id=<%=u.getIdUsu() %>"  target="myFrame2"  class="btn btn-danger btn-sm">
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
