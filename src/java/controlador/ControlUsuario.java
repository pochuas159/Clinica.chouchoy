package controlador;

import helpers.PasswordDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.*;
import modeloDao.*;

public class ControlUsuario extends HttpServlet {

    private UsuarioDao usuDao = new UsuarioDao();
    private PasswordDB passDB = new PasswordDB();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion") == null ? "" : request.getParameter("accion");

        if (accion.equalsIgnoreCase("listadoGeneral")) {
            ListadoGeneral(request, response);
        } else if (accion.equalsIgnoreCase("eliminar")) {
            Eliminar(request, response);
        } else if (accion.equalsIgnoreCase("guardar")) {
            Guardar(request, response);
        } else if (accion.equalsIgnoreCase("editar")) {
            Editar(request, response);
        }
    }

    protected void Editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        Usuario u = new Usuario();
           u.setIdUsu(request.getParameter("id") == null ? 0 : Integer.parseInt(request.getParameter("id")));
        u.setNomUsu(request.getParameter("nombres") == null ? "" : request.getParameter("nombres"));
        u.setApeUsu(request.getParameter("apellidos") == null ? "" : request.getParameter("apellidos"));
        u.setDniUsu(request.getParameter("dni") == null ? "" : request.getParameter("dni"));
        String pass = request.getParameter("pass") == null ? "" : request.getParameter("pass");      
        u.setPassUsu(passDB.encode(pass));
        u.setTeleUsu(request.getParameter("telefono") == null ? "" : request.getParameter("telefono"));
        u.setEmailUsu(request.getParameter("email") == null ? "" : request.getParameter("email"));
        u.setEdadUsu(request.getParameter("edad") == null ? 0 : Integer.parseInt(request.getParameter("edad")));

        int res = usuDao.Editar(u);

        if (res > 0) {
            request.getSession().setAttribute("success", "Los datos del usuario " + u.nombresCompletos() + " se modificaron correctamente.");
        } else {
            request.getSession().setAttribute("error", "Lo sentimos!! No se pudieron modificar los datos del usuario "+u.nombresCompletos()+" .");
        }
        response.sendRedirect("ControlUsuario?accion=listadoGeneral");
    }

    protected void Guardar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        Usuario u = new Usuario();
        u.setNomUsu(request.getParameter("nombres") == null ? "" : request.getParameter("nombres"));
        u.setApeUsu(request.getParameter("apellidos") == null ? "" : request.getParameter("apellidos"));
        u.setDniUsu(request.getParameter("dni") == null ? "" : request.getParameter("dni"));
        u.setPassUsu(request.getParameter("pass") == null ? "" : request.getParameter("pass"));
        u.setTeleUsu(request.getParameter("telefono") == null ? "" : request.getParameter("telefono"));
        u.setEmailUsu(request.getParameter("email") == null ? "" : request.getParameter("email"));
        u.setEdadUsu(request.getParameter("edad") == null ? 0 : Integer.parseInt(request.getParameter("edad")));
        u.setTipoUsu("PACIENTE");

        int res = usuDao.Guardar(u);

        if (res > 0) {
            request.getSession().setAttribute("success", "Los datos del usuario "
                    + u.nombresCompletos() + " se guardaron correctamente.");
        } else {
            request.getSession().setAttribute("error", "Lo sentimos!! No "
                    + "se pudieron guardar los datos para el registro.");
        }
        response.sendRedirect("ControlUsuario?accion=listadoGeneral");
    }

    protected void Eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int id = request.getParameter("id") == null ? 0 : Integer.parseInt(request.getParameter("id"));
        System.out.println("id usuario: " + id);
        if (usuDao.Eliminar(id) > 0) {
            System.out.println("OK");
            request.getSession().setAttribute("success", "Los datos del usuario con id "
                    + "" + id + " se eliminaron correctamente.");
        } else {
            System.out.println("no se elimno");
            request.getSession().setAttribute("error", "No se ha podido eliminar usuario "
                    + "con el  id " + id + ".");
        }
        response.sendRedirect("ControlUsuario?accion=listadoGeneral");
    }

    protected void ListadoGeneral(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("lista", usuDao.ListadoGeneral());
        request.getRequestDispatcher("/admin/listarUsuario.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
