package modeloDao;

import config.*;
import java.sql.*;
import java.util.*;
import modelo.*;

public class EspecialidadDao {

    private Connection cn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ArrayList<Especialidad> ListadoGeneral() {
        ArrayList<Especialidad> lista = new ArrayList<Especialidad>();
        try {
            String sql = "select * from Especialidad ";
            cn = Conexion.getConexion();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Especialidad e = new Especialidad();
                e.setIdEsp(rs.getString("id_esp"));
                e.setNomEsp(rs.getString("nom_esp"));
                lista.add(e);
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

    public int Eliminar(String id) {
        int res = 0;
        try {
            String sql = "delete from Especialidad where id_esp=? ";
            cn = Conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, id);
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

    public int Guardar(Especialidad e) {
        int res = 0;
        try {
            cn = Conexion.getConexion();
            String sql = "insert into Especialidad(id_esp,nom_esp,prec_esp)" + "values(?,?,0)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, e.getIdEsp());
            ps.setString(2, e.getNomEsp());
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

    public int Editar(Especialidad e) {
        int res = 0;
        try {
            cn = Conexion.getConexion();
            String sql = "update Especialidad set nom_esp=? where id_esp=?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, e.getNomEsp());
            ps.setString(2, e.getIdEsp());
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

    public Especialidad BuscarPorId(String id) {
        Especialidad e = null;
        try {
            String sql = "select * from Especialidad where id_Esp=?";
            cn = Conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                e = new Especialidad();

                e.setIdEsp(rs.getString("id_esp"));
                e.setNomEsp(rs.getString("nom_esp"));
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
        return e;
    }
}
