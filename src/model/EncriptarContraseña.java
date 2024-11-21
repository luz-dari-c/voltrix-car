
package model;
import org.mindrot.jbcrypt.BCrypt;

public class EncriptarContraseña {
    public static void main(String[] args) {
        
        String password = "Admin123";  

        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        System.out.println("Contraseña encriptada: " + hashedPassword);
    }
}