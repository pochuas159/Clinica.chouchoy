package modelo;

public class Usuario {

    private int idUsu;
    private String nomUsu;
    private String apeUsu;
    private String dniUsu;
    private String passUsu;
    private String teleUsu;
    private String emailUsu;
    private int edadUsu;
    private String tipoUsu;

    @Override
    public String toString() {
        return "Usuario{" + "idUsu=" + idUsu + ", nomUsu=" + nomUsu + ", apeUsu=" + apeUsu + ", dniUsu=" + dniUsu + ", passUsu=" + passUsu + ", teleUsu=" + teleUsu + ", emailUsu=" + emailUsu + ", edadUsu=" + edadUsu + ", tipoUsu=" + tipoUsu + '}';
    }
    
    public String nombresCompletos(){
        return nomUsu + " "+ apeUsu;
    }

    public int getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(int idUsu) {
        this.idUsu = idUsu;
    }

    public String getNomUsu() {
        return nomUsu;
    }

    public void setNomUsu(String nomUsu) {
        this.nomUsu = nomUsu;
    }

    public String getApeUsu() {
        return apeUsu;
    }

    public void setApeUsu(String apeUsu) {
        this.apeUsu = apeUsu;
    }

    public String getDniUsu() {
        return dniUsu;
    }

    public void setDniUsu(String dniUsu) {
        this.dniUsu = dniUsu;
    }

    public String getPassUsu() {
        return passUsu;
    }

    public void setPassUsu(String passUsu) {
        this.passUsu = passUsu;
    }

    public String getTeleUsu() {
        return teleUsu;
    }

    public void setTeleUsu(String teleUsu) {
        this.teleUsu = teleUsu;
    }

    public String getEmailUsu() {
        return emailUsu;
    }

    public void setEmailUsu(String emailUsu) {
        this.emailUsu = emailUsu;
    }

    public int getEdadUsu() {
        return edadUsu;
    }

    public void setEdadUsu(int edadUsu) {
        this.edadUsu = edadUsu;
    }

    public String getTipoUsu() {
        return tipoUsu;
    }

    public void setTipoUsu(String tipoUsu) {
        this.tipoUsu = tipoUsu;
    }

}
