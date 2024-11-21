package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.ConexionBD;
import org.mindrot.jbcrypt.BCrypt;

public class userController {

    
    public boolean registroUsuario(String gmail, String name, String lastName, String id, String user, String pass) {
    ConexionBD bd = new ConexionBD();
    boolean registrado = false;

    Connection cn = null;
    PreparedStatement pst = null;

    try {
        String sql = "INSERT INTO usuarios (correo_electronico, nombre, apellido, identificacion, usuario, contraseña, rol) VALUES (?,?,?,?,?,?,?)";
        cn = bd.conectar();
        pst = cn.prepareStatement(sql);
        
        String PasswordEncriptada = BCrypt.hashpw(pass, BCrypt.gensalt());
        
        pst.setString(1, gmail);
        pst.setString(2, name);
        pst.setString(3, lastName);
        pst.setString(4, id);
        pst.setString(5, user);
        pst.setString(6, PasswordEncriptada);
        pst.setString(7, "Cliente");

        int filasAfectadas = pst.executeUpdate();

        if (filasAfectadas > 0) {
            registrado = true;
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al registrar usuario: " + e.getMessage());
    } finally {
        try {
            if (pst != null) pst.close();
            if (cn != null) cn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar recursos: " + e.getMessage());
        }
    }

    return registrado = true; 
}

    
}