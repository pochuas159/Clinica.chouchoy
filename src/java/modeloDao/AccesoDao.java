package modeloDao;

import config.*;
import java.sql.*;
import modelo.*;

public class AccesoDao {

    private Connection cn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public Usuario AccesoLogin(String nomUsu, String passUsu) {
        Usuario u = null;
        try {
            cn = Conexion.getConexion();
            String sql = "select * from Usuario "
                    + "where DNI_USU =? and PASS_USU=?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, nomUsu);
            ps.setString(2, passUsu);
            rs = ps.executeQuery();

            if (rs.next()) {
                u = new Usuario();
                u.setIdUsu(rs.getInt("ID_USU"));
                u.setNomUsu(rs.getString("NOM_USU"));
                u.setApeUsu(rs.getString("APE_USU"));
                u.setDniUsu(rs.getString("DNI_USU"));
                u.setPassUsu(rs.getString("PASS_USU"));
                u.setTeleUsu(rs.getString("TELE_USU"));
                u.setEmailUsu(rs.getString("EMAIL_USU"));
                u.setEdadUsu(rs.getInt("EDAD_USU"));
                u.setTipoUsu(rs.getString("TIPO_USU"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
        return u;
    }

}
