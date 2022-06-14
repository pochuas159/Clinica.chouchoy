package modeloDao;

import config.*;
import java.sql.*;
import java.util.*;
import modelo.*;

public class UsuarioDao {

    private Connection cn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ArrayList<Usuario> ListadoGeneral() {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        try {
            String sql = "select * from Usuario ";
            cn = Conexion.getConexion();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsu(rs.getInt("ID_USU"));
                u.setNomUsu(rs.getString("NOM_USU"));
                u.setApeUsu(rs.getString("APE_USU"));
                u.setDniUsu(rs.getString("DNI_USU"));
                u.setPassUsu(rs.getString("PASS_USU"));
                u.setTeleUsu(rs.getString("TELE_USU"));
                u.setEmailUsu(rs.getString("EMAIL_USU"));
                u.setEdadUsu(rs.getInt("EDAD_USU"));
                u.setTipoUsu(rs.getString("TIPO_USU"));
                lista.add(u);
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
        return lista;
    }

    public int Eliminar(int id) {
        int res = 0;
        try {
            String sql = "delete from Usuario where ID_USU=? ";
            cn = Conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            res = ps.executeUpdate();
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
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return res;
    }

    public int Guardar(Usuario u) {
        int res = 0;
        try {
            cn = Conexion.getConexion();
            String sql = "insert into Usuario(NOM_USU,APE_USU,PASS_USU,TELE_USU,"
                    + "EMAIL_USU,EDAD_USU,TIPO_USU,DNI_USU) "
                    + "values(?,?,?,?,?,?,?,?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, u.getNomUsu());
            ps.setString(2, u.getApeUsu());
            ps.setString(3, u.getPassUsu());
            ps.setString(4, u.getTeleUsu());
            ps.setString(5, u.getEmailUsu());
            ps.setInt(6, u.getEdadUsu());
            ps.setString(7, u.getTipoUsu());
            ps.setString(8, u.getDniUsu());
            res = ps.executeUpdate();
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
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return res;
    }

    public int Editar(Usuario u) {
        int res = 0;
        try {
            cn = Conexion.getConexion();
            String sql = "update Usuario set NOM_USU=?,APE_USU=?,"
                    + "PASS_USU=?,TELE_USU=?,EMAIL_USU=?,"
                    + "EDAD_USU=?,DNI_USU=? "
                    + "where ID_USU=?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, u.getNomUsu());
            ps.setString(2, u.getApeUsu());
            ps.setString(3, u.getPassUsu());
            ps.setString(4, u.getTeleUsu());
            ps.setString(5, u.getEmailUsu());
            ps.setInt(6, u.getEdadUsu());
            ps.setString(7, u.getDniUsu());
            ps.setInt(8, u.getIdUsu());
            res = ps.executeUpdate();
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
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return res;
    }

    public Usuario BuscarPorId(int id) {
        Usuario u = null;
        try {
            String sql = "select * from Usuario where ID_USU=?";
            cn = Conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
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

    public String BuscarPorDNI(String dni) {
        String DNI = null;
        try {
            String sql = "select dni_usu from Usuario where dni_usu=?";
            cn = Conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, dni);
            rs = ps.executeQuery();

            if (rs.next()) {
                DNI = rs.getString(1);
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
        return DNI;

    }

    public String buscarPorEmail(String correo) {
        String email = null;
        try {
            String sql = "select email_usu from Usuario where email_usu=?";
            cn = Conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, correo);
            rs = ps.executeQuery();

            if (rs.next()) {
                email = rs.getString(1);
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
        return email;

    }

    public String buscarPorTelefono(String telefono) {
        String fono = null;
        try {
            String sql = "select tele_usu from Usuario where tele_usu=?";
            cn = Conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, telefono);
            rs = ps.executeQuery();

            if (rs.next()) {
                fono = rs.getString(1);
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
        return fono;

    }

    /*public static void main(String[] args) {
        UsuarioDao db = new UsuarioDao();
        System.out.println(db.buscarPorTelefono("92254365a"));
    }*/
}
