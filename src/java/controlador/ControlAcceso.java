package controlador;

import helpers.PasswordDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;
import modeloDao.AccesoDao;

public class ControlAcceso extends HttpServlet {

    private AccesoDao acceso = new AccesoDao();
    private PasswordDB passDB = new PasswordDB();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion") == null ? "" : request.getParameter("accion");

        if (accion.equalsIgnoreCase("login")) {
            IniciarSesion(request, response);
        } else if (accion.equalsIgnoreCase("logout")) {
            CerrarSesion(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    protected void IniciarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession sesion = request.getSession();

        String usuario = request.getParameter("usuario") == null ? "" : request.getParameter("usuario");
        String pass = request.getParameter("pass") == null ? "" : request.getParameter("pass");
        String contra = passDB.encode(pass);
        
        String modulo = request.getParameter("modulo") == null ? "" : request.getParameter("modulo");
        String pagina = "";

        Usuario user = acceso.AccesoLogin(usuario, contra);

        if (user != null && modulo.equalsIgnoreCase(user.getTipoUsu())) {
            sesion.setAttribute("usuario", user);

            pagina = "bienvenida.jsp";
        }

        out.print(pagina);
    }

    protected void CerrarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession sesion = request.getSession();
        sesion.setAttribute("usuario", null);

        request.getRequestDispatcher("index.jsp").forward(request, response);
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
