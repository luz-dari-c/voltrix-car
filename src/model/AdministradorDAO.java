
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.mindrot.jbcrypt.BCrypt;


public class AdministradorDAO {
   public usuarios getAdministrador(String username, String password) {
        String sql = "SELECT id, nombre, apellido, identificacion, usuario, contraseña, correo_electronico, rol " +
                     "FROM usuarios WHERE usuario = ? AND rol = 'administrador'";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String hashedPassword = rs.getString("contraseña"); 
                if (BCrypt.checkpw(password, hashedPassword)) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String apellidos = rs.getString("apellido");
                    String identificacion = rs.getString("identificacion");
                    String correo = rs.getString("correo_electronico");
                    String rol = rs.getString("rol");

                    return new usuarios(id, nombre, apellidos, identificacion, username, password, correo, rol);
                } else {
                    System.out.println("Contraseña incorrecta.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el administrador: " + e.getMessage());
        }
        return null;
    }
    
     public boolean autenticarAdministrador(String username, String password) {
    usuarios admin = getAdministrador(username, password); 
    
    if (admin != null) {
        System.out.println("Administrador autenticado: " + admin.getNombre());
        SesionAdmin.iniciarSesionAdmin(admin); 
        return true; 
    } else {
        System.out.println("No se encontró el administrador.");
    }
    return false; 
}
      public usuarios obtenerInformacionAdministrador() throws SQLException {
        String query = """
            SELECT id, nombre, apellido, identificacion, usuario, correo_electronico, rol 
            FROM usuarios
            WHERE rol = 'administrador'
        """;

        try (Connection con = ConexionBD.conectar();
           PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String identificacion = rs.getString("identificacion");
                String usuario = rs.getString("usuario");
                String correo = rs.getString("correo_electronico");
                String rol = rs.getString("rol");

                return new usuarios(id, nombre, apellido, identificacion, usuario, null, correo, rol);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la información del administrador: " + e.getMessage());
            throw e;
        }
        return null;
    }
    
   public void modificarDatosAdministrador(String identificacionAdmin, String contraseñaActual, String nuevoNombre, String nuevoApellido, String nuevoUsuario, String nuevaContraseña, String nuevoCorreo) {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    String queryVerificacion = "SELECT contraseña FROM usuarios WHERE identificacion = ? AND rol = 'administrador'";
    StringBuilder queryActualizacion = new StringBuilder("UPDATE usuarios SET ");
    ArrayList<Object> parameters = new ArrayList<>();

    try {
        con = ConexionBD.conectar();
        if (con != null) {
            pst = con.prepareStatement(queryVerificacion);
            pst.setString(1, identificacionAdmin);
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
                    JOptionPane.showMessageDialog(null, "No se realizaron cambios en los datos del administrador.");
                    return;
                }

                queryActualizacion.setLength(queryActualizacion.length() - 2); 
                queryActualizacion.append(" WHERE identificacion = ? AND rol = 'administrador'");
                parameters.add(identificacionAdmin);

                pst = con.prepareStatement(queryActualizacion.toString());

                for (int i = 0; i < parameters.size(); i++) {
                    pst.setObject(i + 1, parameters.get(i));
                }

                int filasActualizadas = pst.executeUpdate();
                if (filasActualizadas > 0) {
                    JOptionPane.showMessageDialog(null, "Los datos del administrador con identificación " + identificacionAdmin + " fueron actualizados correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró ningún administrador con la identificación " + identificacionAdmin);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún administrador con la identificación " + identificacionAdmin);
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al modificar los datos del administrador: " + e.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage());
        }
    }
}

  
   
    
}
