package controlador;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.*;
import modeloDao.*;

public class ControlEspecialidad extends HttpServlet {

    private EspecialidadDao espDao = new EspecialidadDao();

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

        Especialidad e = new Especialidad();

        e.setNomEsp(request.getParameter("name") == null ? "" : request.getParameter("name"));
        e.setIdEsp(request.getParameter("id") == null ? "" : request.getParameter("id"));

        int res = espDao.Editar(e);

        if (res > 0) {
            request.getSession().setAttribute("success", "Se guardaron los cambios " + e.getNomEsp() + " se modificaron correctamente.");
        } else {
            request.getSession().setAttribute("error", "Lo sentimos!! No se pudieron modificar los datos de la especialidad " + e.getNomEsp() + " .");
        }
        response.sendRedirect("ControlEspecialidad?accion=listadoGeneral");
    }

    protected void Guardar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        Especialidad e = new Especialidad();

        e.setNomEsp(request.getParameter("name") == null ? "" : request.getParameter("name"));
        e.setIdEsp(request.getParameter("id") == null ? "" : request.getParameter("id"));

        if (espDao.BuscarPorId(e.getIdEsp()) == null) {
            int res = espDao.Guardar(e);

            if (res > 0) {
                request.getSession().setAttribute("success", "Los datos del usuario " + e.getSuccesSave() + " se guardaron correctamente.");
            } else {
                request.getSession().setAttribute("error", "Lo sentimos!! No se pudieron guardar los datos para el registro.");
            }
        } else {
            request.getSession().setAttribute("error", "Lo sentimos!! El ID " + e.getIdEsp() + " ya se encuentra registrado.");
        }

        response.sendRedirect("ControlEspecialidad?accion=listadoGeneral");
    }

    protected void Eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String id = request.getParameter("id") == null ? null : (request.getParameter("id"));

        if (espDao.Eliminar(id) > 0) {

            request.getSession().setAttribute("success", "Los datos de la especialidad con id " + id + " se eliminaron correctamente.");
        } else {
            System.out.println("no se elimno");
            request.getSession().setAttribute("error", "No se ha podido eliminar especialidad con el  id " + id);
        }
        response.sendRedirect("ControlEspecialidad?accion=listadoGeneral");
    }

    protected void ListadoGeneral(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("lista", espDao.ListadoGeneral());
        request.getRequestDispatcher("/admin/listarEspecialidad.jsp").forward(request, response);
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
