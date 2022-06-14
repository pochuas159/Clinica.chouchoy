package modeloDao;

import config.*;
import java.sql.*;
import java.util.*;
import modelo.*;

public class MedicoDao {

    private Connection cn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ArrayList<Medico> ListadoGeneral() {
        ArrayList<Medico> lista = new ArrayList<Medico>();
        try {
            String sql = "SELECT * FROM medico";
            cn = Conexion.getConexion();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Medico m = new Medico();
                m.setIdMed(rs.getString("ID_MED"));
                m.setNomMed(rs.getString("NOM_MED"));
                m.setApeMed(rs.getString("APE_MED"));
                m.setTelMed(rs.getString("TELE_MED"));
                m.setEmailMed(rs.getString("EMAIL_MED"));
                m.setCmpMed(rs.getInt("CMP_MED"));
                m.setEspMed(rs.getString("ID_ESP"));

                lista.add(m);
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
            String sql = "delete from Medico where ID_MED=? ";
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

    public int Guardar(Medico m) {
        int res = 0;
        try {
            cn = Conexion.getConexion();
            String sql = "INSERT INTO medico(ID_MED,NOM_MED,APE_MED,TELE_MED,EMAIL_MED,CMP_MED,ID_ESP) "
                    + " VALUES(?,?,?,?,?,?,?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, m.getIdMed());
            ps.setString(2, m.getNomMed());
            ps.setString(3, m.getApeMed());
            ps.setString(4, m.getTelMed());
            ps.setString(5, m.getEmailMed());
            ps.setInt(6, m.getCmpMed());
            ps.setString(7, m.getEspMed());;

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

    public int Editar(Medico m) {
        int res = 0;
        try {
            cn = Conexion.getConexion();
            String sql = "update Medico set NOM_MED=?,APE_MED=?,ID_ESP=?,TELE_MED=?,EMAIL_MED=?,CMP_MED=? "
                    + "where ID_MED=?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, m.getNomMed());
            ps.setString(2, m.getApeMed());
            ps.setString(3, m.getEspMed());
            ps.setString(4, m.getTelMed());
            ps.setString(5, m.getEmailMed());
            ps.setInt(6, m.getCmpMed());
            ps.setString(7, m.getIdMed());
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

    public Medico BuscarPorId(String id) {
        Medico m = null;
        try {
            String sql = "select * from Medico where ID_MED=?";
            cn = Conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                m = new Medico();
                m.setIdMed(rs.getString("ID_MED"));
                m.setNomMed(rs.getString("NOM_MED"));
                m.setApeMed(rs.getString("APE_MED"));
                m.setEspMed(rs.getString("ID_ESP"));
                m.setTelMed(rs.getString("TELE_MED"));
                m.setEmailMed(rs.getString("EMAIL_MED"));
                m.setCmpMed(rs.getInt("CMP_MED"));

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
        return m;
    }

    public ArrayList<Medico> ListadoPorTurno(int idTurno) {
        ArrayList<Medico> lista = new ArrayList<Medico>();
        try {
            String sql = "SELECT * FROM medico\n"
                    + "WHERE id_med IN (SELECT id_med FROM horario_medico WHERE id_Turno = ?)";
            cn = Conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, idTurno);
            rs = ps.executeQuery();

            while (rs.next()) {
                Medico m = new Medico();
                m.setIdMed(rs.getString("ID_MED"));
                m.setNomMed(rs.getString("NOM_MED"));
                m.setApeMed(rs.getString("APE_MED"));
                m.setTelMed(rs.getString("TELE_MED"));
                m.setEmailMed(rs.getString("EMAIL_MED"));
                m.setCmpMed(rs.getInt("CMP_MED"));
                m.setEspMed(rs.getString("ID_ESP"));

                lista.add(m);
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
}
