/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class Especialidad {
    
    public String idEsp;
    private String nomEsp;
    
    @Override
    public String toString() {
        return "Especialidad{" + "idEsp=" +idEsp+ ", nomEsp=" + nomEsp ;
                };
    
     public String getSuccesSave(){
        return idEsp + " "+ nomEsp;
    }

    
    public String getIdEsp() {
        return idEsp;
    }

    public void setIdEsp(String idEsp) {
        this.idEsp = idEsp;
    }

    
    public String getNomEsp() {
        return nomEsp;
    }

    public void setNomEsp(String nomEsp) {
        this.nomEsp = nomEsp;
    }


   
    

}
