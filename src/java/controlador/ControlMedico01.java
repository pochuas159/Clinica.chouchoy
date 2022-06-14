/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modeloDao.MedicoDao;
import modelo.*;

/**
 *
 * @author brand
 */
public class ControlMedico01 extends HttpServlet {

    private MedicoDao medDao = new MedicoDao();

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

        Medico m = new Medico();

        m.setIdMed(request.getParameter("id") == null ? "" : request.getParameter("id"));
        m.setNomMed(request.getParameter("nombre") == null ? "" : request.getParameter("nombre"));
        m.setApeMed(request.getParameter("apellido") == null ? "" : request.getParameter("apellido"));
        m.setEspMed(request.getParameter("especialidad") == null ? "" : request.getParameter("especialidad"));
        m.setTelMed(request.getParameter("telefono") == null ? "" : request.getParameter("telefono"));
        m.setEmailMed(request.getParameter("email") == null ? "" : request.getParameter("email"));
        m.setCmpMed(request.getParameter("cmp") == null ? 0 : Integer.parseInt(request.getParameter("cmp")));
        int res = medDao.Editar(m);

        if (res > 0) {
            request.getSession().setAttribute("success", "Se guardaron los cambios " + m.getNomMed() + " se modificaron correctamente.");
        } else {
            request.getSession().setAttribute("error", "Lo sentimos!! No se pudieron modificar los datos del medico " + m.getNomMed() + " .");
        }
        response.sendRedirect("ControlMedico01?accion=listadoGeneral");
    }

    protected void Guardar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        Medico m = new Medico();

        m.setIdMed(request.getParameter("id") == null ? "" : request.getParameter("id"));
        m.setNomMed(request.getParameter("nombre") == null ? "" : request.getParameter("nombre"));
        m.setApeMed(request.getParameter("apellido") == null ? "" : request.getParameter("apellido"));
        m.setId_hor("H01");
        m.setEspMed(request.getParameter("especialidad") == null ? "" : request.getParameter("especialidad"));
        m.setTelMed(request.getParameter("telefono") == null ? "" : request.getParameter("telefono"));
        m.setEmailMed(request.getParameter("email") == null ? "" : request.getParameter("email"));
        m.setCmpMed(request.getParameter("cmp") == null ? 0 : Integer.parseInt(request.getParameter("cmp")));

        if (medDao.BuscarPorId(m.getIdMed()) == null) {
            int res = medDao.Guardar(m);

            if (res > 0) {
                request.getSession().setAttribute("success", "Los datos del MEDICO " + m.getNomMed() + " se guardaron correctamente.");
            } else {
                request.getSession().setAttribute("error", "Lo sentimos!! No se pudieron guardar los datos para el registro.");
            }
        }else{
            request.getSession().setAttribute("error", "Lo sentimos!! El ID "+m.getIdMed()+" ya se encuentra registrado.");
        }

        response.sendRedirect("ControlMedico01?accion=listadoGeneral");
    }

    protected void Eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String id = request.getParameter("id") == null ? null : (request.getParameter("id"));

        if (medDao.Eliminar(id) > 0) {
            System.out.println("OK");
            request.getSession().setAttribute("success", "Los datos del médico con id " + id + " se eliminaron correctamente.");
        } else {
            System.out.println("no se elimno");
            request.getSession().setAttribute("error", "No se ha podido eliminar médico con el  id " + request.getParameter("id"));
        }
        response.sendRedirect("ControlMedico01?accion=listadoGeneral");
    }

    protected void ListadoGeneral(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("lista", medDao.ListadoGeneral());
        request.getRequestDispatcher("/admin/listarMedico.jsp").forward(request, response);
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
