package model;

import java.math.BigDecimal;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.Timestamp;

public class carroDAO {

    public List<Carro> obtenerCarros() {
        List<Carro> cars = new ArrayList<>();
        String sql = "SELECT marca, modelo, año, precio, color, tipo_motor, fecha_ingreso, kilometraje, placa, cantidad FROM autos";

        try (Connection con = ConexionBD.conectar();
        PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {

                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String año = rs.getString("año");
                Double precio = rs.getDouble("precio");
                String color = rs.getString("color");
                String tipoMotor = rs.getString("tipo_motor");
                String fechaIngresoo = rs.getString("fecha_ingreso");
                String kilometraje = rs.getString("kilometraje");
                String placa = rs.getString("placa");
                int cantidad = rs.getInt("cantidad");

                Carro carr = new Carro(cantidad, marca, modelo, año, precio, color, tipoMotor, kilometraje, fechaIngresoo, placa, cantidad);

                cars.add(carr);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener autos: " + e.getMessage());
        }

        return cars;
    }

    public void disminuirCantidadCarro(String modelo) {
        String sql = "UPDATE autos SET cantidad = cantidad - 1 WHERE modelo = ? AND cantidad > 0";

        try (Connection con = ConexionBD.conectar();
           PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, modelo);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Cantidad de autos del modelo " + modelo + " disminuida en 1.");
            } else {
                System.out.println("No se encontró el auto con el modelo: " + modelo + " o ya no hay unidades disponibles.");
                JOptionPane.showMessageDialog(null, "No se encontró el auto o ya no hay unidades disponibles.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            System.err.println("Error al disminuir la cantidad de autos: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al disminuir la cantidad de autos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void aumentarCantidad(String modelo) {

        String sql = "UPDATE autos SET cantidad = cantidad + 1 WHERE modelo = ?";

        try (Connection con = ConexionBD.conectar(); 
            PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, modelo);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Cantidad de autos del modelo " + modelo + " aumentada en 1.");
            } else {
                System.out.println("No se encontró el auto con el modelo: " + modelo + " .");
            }

        } catch (SQLException e) {
            System.err.println("Error al aumentar la cantidad de autos: " + e.getMessage());
        }
    }

   public void ventacarro(String nombreAuto, double precio, int idUsuario, int idAuto, String colorAuto, String tipoMotorAuto) {
    String nombreUsuario = null;
    String identificacion = null;
    String placaGenerada = PlacaCarro.generarPlacaUnica();
        System.out.println("Nombre auto en ventacarro: " + nombreAuto);


    String queryUsuario = "SELECT nombre, identificacion FROM usuarios WHERE id = ?";

    try (Connection con = ConexionBD.conectar(); 
       PreparedStatement psUsuario = con.prepareStatement(queryUsuario)) {
        psUsuario.setInt(1, idUsuario);
        ResultSet rs = psUsuario.executeQuery();

        if (rs.next()) {
            nombreUsuario = rs.getString("nombre");
            identificacion = rs.getString("identificacion");
        } else {
            System.out.println("Usuario no encontrado.");
            return; 
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    String query = "INSERT INTO compras (nombre_auto, precio_auto, id_usuario, id_auto, fecha_compra, total, cantidad, nombre_usuario, identificacion, placa, color_auto, tipo_motor_auto) "
             + "VALUES (?, ?, ?, ?, NOW(), ?, ?, ?, ?, ?, ?, ?)";


    try (Connection con = ConexionBD.conectar(); PreparedStatement ps = con.prepareStatement(query)) {
        ps.setString(1, nombreAuto);
        ps.setDouble(2, precio);
        ps.setInt(3, idUsuario);
        ps.setInt(4, idAuto);
        ps.setDouble(5, precio);  
        ps.setInt(6, 1); 
        ps.setString(7, nombreUsuario);
        ps.setString(8, identificacion);
        ps.setString(9, placaGenerada);
        ps.setString(10, colorAuto);
        ps.setString(11, tipoMotorAuto); 
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    public void registrarCompra(int id_usuario, int id_auto, String nombre_auto, double precio_auto, double total, int cantidad, String placa) {
        String sql = "INSERT INTO compras (nombre_auto, precio_auto, id_usuario, id_auto, fecha_compra, total, cantidad, placa) VALUES (?, ?, ?, ?, NOW(), ?, ?, ?)";

        try (Connection con = ConexionBD.conectar();
                PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, nombre_auto);
            pstmt.setDouble(2, precio_auto);
            pstmt.setInt(3, id_usuario);
            pstmt.setInt(4, id_auto);
            pstmt.setDouble(5, total);
            pstmt.setInt(6, cantidad);
            pstmt.setString(7, placa);

            String mensajeRegistro = "Registrando compra: id_usuario=" + id_usuario + ", id_auto=" + id_auto + ", nombre_auto=" + nombre_auto + ", precio_auto=" + precio_auto + ", total=" + total + ", cantidad=" + cantidad + ", placa=" + placa;
            JOptionPane.showMessageDialog(null, mensajeRegistro, "Registro de Compra", JOptionPane.INFORMATION_MESSAGE);

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Compra registrada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            String errorMessage = "Error al registrar la compra: " + e.getMessage() + "\nCódigo SQLState: " + e.getSQLState() + "\nCódigo de Error: " + e.getErrorCode();
            JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean actualizarCantidadCarro(int idAuto, int nuevaCantidad) throws SQLException {
        boolean actualizado = false;
        Connection con = null;
        PreparedStatement ps = null;

        try {

            con = ConexionBD.conectar();
            String query = "UPDATE autos SET cantidad = ? WHERE id_auto = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, nuevaCantidad);
            ps.setInt(2, idAuto);
            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                actualizado = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error de actualización: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {

            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return actualizado;
    }

    public List<Compra> obtenerAutosVendidos() throws SQLException {
        List<Compra> compras = new ArrayList<>();
        String query = """
        SELECT c.nombre_auto, c.precio_auto, c.fecha_compra, c.total, c.cantidad, u.nombre, u.apellido, u.identificacion, c.placa, c.color_auto, c.tipo_motor_auto
        FROM compras c
        JOIN usuarios u ON c.id_usuario = u.id
    """;

        try (Connection con = ConexionBD.conectar(); PreparedStatement ps = con.prepareStatement(query); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String nombreAuto = rs.getString("nombre_auto");
                BigDecimal precioAuto = rs.getBigDecimal("precio_auto");
                Timestamp fechaCompra = rs.getTimestamp("fecha_compra");
                BigDecimal total = rs.getBigDecimal("total");
                int cantidad = rs.getInt("cantidad");
                String nombreUsuario = rs.getString("nombre");
                String apellidoUsuario = rs.getString("apellido");
                String identificacionUsuario = rs.getString("identificacion");
                String placa = rs.getString("placa");
                String Color = rs.getString("color_auto");
                String TipoMotor = rs.getString("tipo_motor_auto");

                Compra compra = new Compra(nombreAuto, precioAuto, fechaCompra, total, cantidad, nombreUsuario, apellidoUsuario, identificacionUsuario, placa, Color, TipoMotor);
                compras.add(compra);
            }
        }

        return compras;
    }

    public List<Compra> obtenerComprasPorUsuario(String identificacionUsuario) throws SQLException {
        List<Compra> compras = new ArrayList<>();
        String query = """
        SELECT c.nombre_auto, c.precio_auto, c.fecha_compra, c.total, c.cantidad,c.color_auto, c.tipo_motor_auto, u.nombre AS nombre_usuario, u.apellido AS apellido_usuario, u.identificacion AS identificacion_usuario, c.placa
        FROM compras c
        JOIN usuarios u ON c.id_usuario = u.id
        WHERE u.identificacion = ?
    """;

        try (Connection con = ConexionBD.conectar();
            PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, identificacionUsuario);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String nombreAuto = rs.getString("nombre_auto");
                BigDecimal precioAuto = rs.getBigDecimal("precio_auto");
                Timestamp fechaCompra = rs.getTimestamp("fecha_compra");
                BigDecimal total = rs.getBigDecimal("total");
                int cantidad = rs.getInt("cantidad");
                String nombreUsuario = rs.getString("nombre_usuario");
                String apellidoUsuario = rs.getString("apellido_usuario");
                String identificacionUsuarioResult = rs.getString("identificacion_usuario");
                String placa = rs.getString("placa");
                String Color = rs.getString("color_auto");
                String TipoMotor = rs.getString("tipo_motor_auto");
                Compra compra = new Compra(nombreAuto, precioAuto, fechaCompra, total, cantidad, nombreUsuario, apellidoUsuario, identificacionUsuarioResult, placa, Color, TipoMotor);
                compras.add(compra);
                
                System.out.println("Nombre auto: " + nombreAuto);
            }
        }

        return compras;
    }

    public double obtenerPrecioPorModelo(String modeloCarro) throws SQLException {
        double precio = 0.0;

        String query = "SELECT precio FROM autos WHERE modelo = ?";

        try (Connection con = ConexionBD.conectar();
                PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, modeloCarro);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                precio = rs.getDouble("precio");
            } else {
                System.out.println("No se encontró el modelo: " + modeloCarro);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return precio;
    }

    public void eliminarAuto(String inputPlacaAutoEliminar) {
        ConexionBD db = new ConexionBD();
        Connection con = null;
        PreparedStatement pst = null;

        String query = "DELETE FROM autos WHERE placa = ?";

        try {
            con = db.conectar();
            if (con != null) {
                pst = con.prepareStatement(query);
                pst.setString(1, inputPlacaAutoEliminar);
                int filasEliminadas = pst.executeUpdate();
                if (filasEliminadas > 0) {

                    JOptionPane.showMessageDialog(null, "El auto con placa " + inputPlacaAutoEliminar + " fue eliminado correctamente.");

                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró ningún auto con la placa " + inputPlacaAutoEliminar);

                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro al eliminar el auto: " + e.getMessage());

        } finally {

            try {
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

    

    public boolean carroEncontrado(String placa, String modelo) {
        ConexionBD db = new ConexionBD();
        boolean encontrado = false;

        try {
            Connection cn = db.conectar();
            String sql = "SELECT carro  FROM autos WHERE carro = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, placa);
            pst.setString(2, modelo);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                encontrado = true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);

        }
        return encontrado;

    }
    public void modificarPrecioAuto(String modelo, double nuevoPrecio) {
        ConexionBD db = new ConexionBD();
        Connection con = null;
        PreparedStatement pst = null;

        String query = "UPDATE autos SET precio = ? WHERE modelo = ?";

        try {
            con = db.conectar();
            if (con != null) {
                pst = con.prepareStatement(query);
                pst.setDouble(1, nuevoPrecio);
                pst.setString(2, modelo);
                int filasActualizadas = pst.executeUpdate();
                if (filasActualizadas > 0) {
                    JOptionPane.showMessageDialog(null, "El precio del auto modelo " + modelo + " fue actualizado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró ningún auto con el modelo " + modelo);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar el precio del auto: " + e.getMessage());
        } finally {
            try {
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

}
