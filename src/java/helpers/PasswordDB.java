package helpers;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.tomcat.util.codec.binary.Base64;


public class PasswordDB {

    private static String llaveSecreta = "clinicaVeterinaria";

    public String encode(String cadena) {
        String encriptacion = "";
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] llavePassword = md5.digest(llaveSecreta.getBytes("utf-8"));
            byte[] BytesKey = Arrays.copyOf(llavePassword, 24);
            SecretKey key = new SecretKeySpec(BytesKey, "DESede");
            Cipher cifrado = Cipher.getInstance("DESede");
            cifrado.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainTextBytes = cadena.getBytes("utf-8");
            byte[] buf = cifrado.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            encriptacion = new String(base64Bytes);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return encriptacion;
    }

    public String decode(String cadenaEncriptada) {
        String desencriptacion = "";
        try {
            byte[] message = Base64.decodeBase64(cadenaEncriptada.getBytes("utf-8"));
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md5.digest(llaveSecreta.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);
            byte[] plainText = decipher.doFinal(message);
            desencriptacion = new String(plainText, "UTF-8");

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return desencriptacion;
    }
    /*public static void main(String[] args){
        SecurityDb db = new SecurityDb();
        Scanner es = new Scanner(System.in);
        System.out.println("Ingresa una cadena a encriptar");
        String cad = es.next();
        String cadenaEncriptada = db.encode(cad);
        System.out.println("Cadena encriptada: "+ cadenaEncriptada);
        String cadenaDesencriptada = db.decode(cadenaEncriptada);
        System.out.println("Cadena desencriptada: "+ cadenaDesencriptada);
    }*/
}
