package controlador;

import helpers.PasswordDB;
import helpers.validacionesUser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;
import modeloDao.UsuarioDao;

public class ControlPaciente extends HttpServlet {

    private UsuarioDao usuDao = new UsuarioDao();
    private PasswordDB passDB = new PasswordDB();
    private validacionesUser vUser = new validacionesUser();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String accion = request.getParameter("accion") == null ? "" : request.getParameter("accion");

        if (accion.equalsIgnoreCase("guardar")) {
            Guardar(request, response);
        }
    }

    protected void Guardar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        Usuario u = new Usuario();
        u.setNomUsu(request.getParameter("nombres") == null ? "" : request.getParameter("nombres"));
        u.setApeUsu(request.getParameter("apellidos") == null ? "" : request.getParameter("apellidos"));
        u.setDniUsu(request.getParameter("dni") == null ? "" : request.getParameter("dni"));
        String cadena = request.getParameter("pass");
        u.setPassUsu(passDB.encode(cadena));
        u.setTeleUsu(request.getParameter("telefono") == null ? "" : request.getParameter("telefono"));
        u.setEmailUsu(request.getParameter("correo") == null ? "" : request.getParameter("correo"));
        u.setEdadUsu(request.getParameter("edad") == null ? 0 : Integer.parseInt(request.getParameter("edad")));
        u.setTipoUsu("PACIENTE");

        request.getSession().setAttribute("paciente", u);

        String vUsuario = vUser.existeUsuario(u.getDniUsu());
        String vCorreo = vUser.correoUsuario(u.getEmailUsu());
        String vTelefono = vUser.telefonoExiste(u.getTeleUsu());

        if (vUsuario.equals("ok") && vCorreo.equals("ok") && vTelefono.equals("ok")) {
            int res = usuDao.Guardar(u);

            if (res > 0) {
                request.getSession().setAttribute("paciente", null);
                request.getSession().setAttribute("success", "Los datos del usuario "
                        + u.nombresCompletos() + " se guardaron correctamente.");
            } else {
                request.getSession().setAttribute("error", "Lo sentimos!! No se pudieron guardar los datos para el registro.");
            }
        } else {
            if (!vUsuario.equals("ok") && vCorreo.equals("ok") && vTelefono.equals("ok")) {
                request.getSession().setAttribute("error", vUsuario);
            }
            if (!vCorreo.equals("ok") && vUsuario.equals("ok") && vTelefono.equals("ok")) {
                request.getSession().setAttribute("error", vCorreo);
            }
            if (!vTelefono.equals("ok") && vUsuario.equals("ok") && vCorreo.equals("ok")) {
                request.getSession().setAttribute("error", vTelefono);
            }
        }

        response.sendRedirect("paciente/sesion.jsp");
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
