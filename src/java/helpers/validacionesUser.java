package helpers;

import modeloDao.UsuarioDao;

public class validacionesUser {

    private UsuarioDao userDao = new UsuarioDao();
    
    public String existeUsuario(String dni){
        if(dni.length()<8){
            return "El DNI no es valido, por favor vuelva a intentarlo";
        }else{
            String DNI = userDao.BuscarPorDNI(dni);
            if(DNI == null){
                return "ok";
            }
        }
        return "El DNI "+dni+" ya ha sido registrado en una cuenta, por favor vuelva a intentarlo";
    }

    public String correoUsuario(String correo) {
        
        String email = userDao.buscarPorEmail(correo);
        if (email == null) {
            return "ok";
        }
        return "El Email "+correo+" ya ha sido registrado en una cuenta, por favor vuelva a intentarlo";
    }
    
    public String telefonoExiste(String tel){
        
        if(tel.length() < 9){
            return "El número "+tel+" que registro no es correcto"; 
        }else{
            String fono = userDao.buscarPorTelefono(tel);
            if(fono ==null){
                return "ok";
            }
        }
        return "El número "+tel+" ya ha sido registrado en una cuenta, por favor vuelva a intentarlo";
    }
}
