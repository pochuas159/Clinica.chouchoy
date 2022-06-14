/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class Medico {
    
    private String idMed;
    private String id_hor;
    private String espMed;
    private String nomMed;
    private String apeMed;
    private String telMed;
    private String emailMed;
    private int cmpMed;
    
    public String nomCompletos(){
        return nomMed + " "+apeMed;
    }

    @Override
    public String toString() {
        return "Medico{" + "idMed=" + idMed + ", id_hor=" + id_hor + ", espMed=" + espMed + ", nomMed=" + nomMed + ", apeMed=" + apeMed + ", telMed=" + telMed + ", emailMed=" + emailMed + ", cmpMed=" + cmpMed + '}';
    }

    public String getIdMed() {
        return idMed;
    }

    public void setIdMed(String idMed) {
        this.idMed = idMed;
    }

    public String getId_hor() {
        return id_hor;
    }

    public void setId_hor(String id_hor) {
        this.id_hor = id_hor;
    }

    public String getEspMed() {
        return espMed;
    }

    public void setEspMed(String espMed) {
        this.espMed = espMed;
    }

    public String getNomMed() {
        return nomMed;
    }

    public void setNomMed(String nomMed) {
        this.nomMed = nomMed;
    }

    public String getApeMed() {
        return apeMed;
    }

    public void setApeMed(String apeMed) {
        this.apeMed = apeMed;
    }

    public String getTelMed() {
        return telMed;
    }

    public void setTelMed(String telMed) {
        this.telMed = telMed;
    }

    public String getEmailMed() {
        return emailMed;
    }

    public void setEmailMed(String emailMed) {
        this.emailMed = emailMed;
    }

    public int getCmpMed() {
        return cmpMed;
    }

    public void setCmpMed(int cmpMed) {
        this.cmpMed = cmpMed;
    }
     
  
    
}
