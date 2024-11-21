package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.mindrot.jbcrypt.BCrypt;


public class UsuarioDAO {
    
 
   public usuarios getUsuario(String username, String password) {
    String sql = "SELECT id, nombre, apellido, identificacion, usuario, contraseña, correo_electronico, rol FROM usuarios WHERE usuario = ?";  
    try (Connection conn = ConexionBD.conectar();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        pstmt.setString(1, username);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            
            //ENCRIPTAR CONTRASEÑA
            
            String ContraseñaEncriptada = rs.getString("contraseña");
            
            if (BCrypt.checkpw(password, ContraseñaEncriptada)) {
            int id = rs.getInt("id"); 
            String nombre = rs.getString("nombre");
            String apellidos = rs.getString("apellido"); 
            String identificacion = rs.getString("identificacion");
            String correo = rs.getString("correo_electronico");
            String rol = rs.getString("rol"); 
            

            return new usuarios(id, nombre, apellidos, identificacion, username, password, correo, rol );
            } else {
                System.out.println("La contraseña encriptada no concuerda.");
            }
            
            
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener el usuario: " + e.getMessage());
    }
    return null; 
}


    public boolean authenticateUser(String username, String password) {
        return getUsuario(username, password) != null;
    }
    
    
    public usuarios obtenerInformacionPorUsuario(String identificacionUsuario) throws SQLException {
        String query = """
            SELECT id, nombre, apellido, identificacion, usuario, correo_electronico
            FROM usuarios
            WHERE identificacion = ?
        """;

        try (Connection con = ConexionBD.conectar(); 
            PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, identificacionUsuario);  

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String usuario = rs.getString("usuario");
                String correo = rs.getString("correo_electronico");

                return new usuarios(id, nombre, apellido, identificacionUsuario, usuario, null, correo,null);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la información del usuario: " + e.getMessage());
            throw e;
        }

        return null; 
    }
    
    public void modificarDatosUsuario(String identificacion, String contraseñaActual, String nuevoNombre, String nuevoApellido, String nuevoUsuario, String nuevaContraseña, String nuevoCorreo) {
        ConexionBD db = new ConexionBD();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String queryVerificacion = "SELECT contraseña FROM usuarios WHERE identificacion = ?";
        StringBuilder queryActualizacion = new StringBuilder("UPDATE usuarios SET ");
        ArrayList<Object> parameters = new ArrayList<>();

        try {
            con = db.conectar();
            if (con != null) {
                pst = con.prepareStatement(queryVerificacion);
                pst.setString(1, identificacion);
                rs = pst.executeQuery();

                if (rs.next()) {
                    String contraseñaBD = rs.getString("contraseña");

                    if (!contraseñaActual.equals(contraseñaBD)) {
                        JOptionPane.showMessageDialog(null, "La contraseña actual es incorrecta.");
                        return;
                    }

                    if (!nuevoNombre.isEmpty()) {
                        queryActualizacion.append("nombre = ?, ");
                        parameters.add(nuevoNombre);
                    }
                    if (!nuevoApellido.isEmpty()) {
                        queryActualizacion.append("apellido = ?, ");
                        parameters.add(nuevoApellido);
                    }
                    if (!nuevoUsuario.isEmpty()) {
                        queryActualizacion.append("usuario = ?, ");
                        parameters.add(nuevoUsuario);
                    }
                    if (!nuevoCorreo.isEmpty()) {
                        queryActualizacion.append("correo_electronico = ?, ");
                        parameters.add(nuevoCorreo);
                    }

                    if (!nuevaContraseña.isEmpty()) {
                        if (nuevaContraseña.equals(contraseñaBD)) {
                            JOptionPane.showMessageDialog(null, "La nueva contraseña debe ser diferente de la contraseña actual.");
                            return;
                        }
                        queryActualizacion.append("contraseña = ?, ");
                        parameters.add(nuevaContraseña);
                    }

                    if (parameters.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No se realizaron cambios en los datos del usuario.");
                        return;
                    }

                    queryActualizacion.setLength(queryActualizacion.length() - 2);
                    queryActualizacion.append(" WHERE identificacion = ?");
                    parameters.add(identificacion);

                    pst = con.prepareStatement(queryActualizacion.toString());

                    for (int i = 0; i < parameters.size(); i++) {
                        pst.setObject(i + 1, parameters.get(i));
                    }

                    int filasActualizadas = pst.executeUpdate();
                    if (filasActualizadas > 0) {
                        JOptionPane.showMessageDialog(null, "Los datos del usuario con identificación " + identificacion + " fueron actualizados correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró ningún usuario con la identificación " + identificacion);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró ningún usuario con la identificación " + identificacion);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar los datos del usuario: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
   
    public void asignarRol(int usuarioId, String rol) {
    String sql = "UPDATE usuarios SET rol = ? WHERE id = ?";  
    try (Connection conn = ConexionBD.conectar();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, rol);
        pstmt.setInt(2, usuarioId);
        pstmt.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Error al asignar el rol: " + e.getMessage());
    }
}
    
 

    
    
   


    
   
}
