package vista;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.AdministradorDAO;
import model.Compra;
import model.Carro;
import model.SesionAdmin;
import model.UsuarioDAO;
import model.carroDAO;
import model.usuarios;

public class Administrador extends javax.swing.JFrame {

    private String identificacionAdmin;

    public Administrador(String identificacionAdmin) throws SQLException {
        initComponents();
        setResizable(false);
        this.identificacionAdmin = identificacionAdmin;
        setLocationRelativeTo(null);
        cargarCarroEnTabla();
        iniciarOpciones();
        cargarComprasEnTabla();

    }

    public void iniciarOpciones() {
        JMenuItem aumentar = new JMenuItem("Agregar cantidad");
        JMenuItem eliminar = new JMenuItem("Eliminar cantidad");

        ppMenuTabla.add(aumentar);
        ppMenuTabla.add(eliminar);

        tablaAdministrador.setComponentPopupMenu(ppMenuTabla);

        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tablaAdministrador.getSelectedRow();

                if (selectedRow != -1) {

                    String modelo = (String) tablaAdministrador.getValueAt(selectedRow, 1);

                    int confirm = JOptionPane.showConfirmDialog(null, "Seguro de que deseas disminuir la cantidad", "Confirmación", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {

                        carroDAO crd = new carroDAO();
                        crd.disminuirCantidadCarro(modelo);

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un carro a aumentar su cantidad.");
                }
            }
        });

        aumentar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tablaAdministrador.getSelectedRow();

                if (selectedRow != +1) {

                    String modelo = (String) tablaAdministrador.getValueAt(selectedRow, 1);

                    int confirm = JOptionPane.showConfirmDialog(null, "Seguro de que deseas aumentar la cantidad", "Confirmación", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {

                        carroDAO crd = new carroDAO();
                        crd.aumentarCantidad(modelo);

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un carro al cual aumentar su cantidad.");
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ppMenuTabla = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        venta = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ventasTbla = new javax.swing.JTable();
        ModificarPrecio = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        imputPrecioModificar = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        imputModeloModificar = new javax.swing.JTextField();
        modificarPrecioCarro = new javax.swing.JButton();
        ModificarUsuario = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        CorreoAdmin = new javax.swing.JLabel();
        NombreAdmin = new javax.swing.JLabel();
        ApellidoAdmin = new javax.swing.JLabel();
        IdentificacionAdmin = new javax.swing.JLabel();
        UsuarioAdmin = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        NuevoApellidoAdmin = new javax.swing.JTextField();
        NuevoNombreAdmin = new javax.swing.JTextField();
        NuevoUsuarioAdmin = new javax.swing.JTextField();
        NuevoCorreoAdmin = new javax.swing.JTextField();
        NuevaContraseñaAdmin = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        ContraseñaDelAdmin = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        ModificarInformacionDeAdmin = new javax.swing.JButton();
        CargarInformacion = new javax.swing.JButton();
        Disponibles = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAdministrador = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        btn_4 = new javax.swing.JPanel();
        ind_4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btn_1 = new javax.swing.JPanel();
        ind_1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        vendidodopanel = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        CierreSesion = new javax.swing.JButton();
        btn_2 = new javax.swing.JPanel();
        ind_2 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ADMINISTRACION");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 215, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 860, 150));

        venta.setBackground(new java.awt.Color(255, 255, 255));
        venta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Ventas");
        venta.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 110, 30));

        ventasTbla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre Auto", "Precio Auto", "Placa", "Fecha Compra", "Total", "Cantidad", "Cliente", "Apellido", "Identificacion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(ventasTbla);

        venta.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 810, 380));

        jTabbedPane1.addTab("Ventas", venta);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setBackground(new java.awt.Color(0, 0, 0));
        jLabel21.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Ingrese el modelo para modificar precio de un automovil");
        jPanel8.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 660, 30));

        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Precio nuevo");
        jPanel8.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));
        jPanel8.add(imputPrecioModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 210, 40));

        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("Modelo");
        jPanel8.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 50, 50, -1));
        jPanel8.add(imputModeloModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 210, 40));

        modificarPrecioCarro.setText("Modificar precio");
        modificarPrecioCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarPrecioCarroActionPerformed(evt);
            }
        });
        jPanel8.add(modificarPrecioCarro, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        javax.swing.GroupLayout ModificarPrecioLayout = new javax.swing.GroupLayout(ModificarPrecio);
        ModificarPrecio.setLayout(ModificarPrecioLayout);
        ModificarPrecioLayout.setHorizontalGroup(
            ModificarPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ModificarPrecioLayout.setVerticalGroup(
            ModificarPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Modificar", ModificarPrecio);

        ModificarUsuario.setBackground(new java.awt.Color(255, 255, 255));
        ModificarUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel19.setBackground(new java.awt.Color(204, 204, 204));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setBackground(new java.awt.Color(0, 0, 0));
        jLabel29.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setText("Correo electronico:");
        jPanel19.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        jLabel32.setBackground(new java.awt.Color(0, 0, 0));
        jLabel32.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 0));
        jLabel32.setText("Nombre:");
        jPanel19.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel34.setBackground(new java.awt.Color(0, 0, 0));
        jLabel34.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jLabel34.setText("Apellido:");
        jPanel19.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel35.setBackground(new java.awt.Color(0, 0, 0));
        jLabel35.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 0));
        jLabel35.setText("Identificación:");
        jPanel19.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel36.setBackground(new java.awt.Color(0, 0, 0));
        jLabel36.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 0, 0));
        jLabel36.setText("Usuario:");
        jPanel19.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        CorreoAdmin.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        CorreoAdmin.setForeground(new java.awt.Color(0, 0, 0));
        jPanel19.add(CorreoAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 180, 30));

        NombreAdmin.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        NombreAdmin.setForeground(new java.awt.Color(0, 0, 0));
        jPanel19.add(NombreAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 180, 30));

        ApellidoAdmin.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ApellidoAdmin.setForeground(new java.awt.Color(0, 0, 0));
        jPanel19.add(ApellidoAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 180, 30));

        IdentificacionAdmin.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        IdentificacionAdmin.setForeground(new java.awt.Color(0, 0, 0));
        jPanel19.add(IdentificacionAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 180, 30));

        UsuarioAdmin.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        UsuarioAdmin.setForeground(new java.awt.Color(0, 0, 0));
        jPanel19.add(UsuarioAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 180, 30));

        ModificarUsuario.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 300, 340));

        jLabel43.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 0, 0));
        jLabel43.setText("INFORMACIÓN DE ADMINISTRADOR");
        ModificarUsuario.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 340, -1));
        ModificarUsuario.add(NuevoApellidoAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 200, 190, 30));
        ModificarUsuario.add(NuevoNombreAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 160, 190, 30));
        ModificarUsuario.add(NuevoUsuarioAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 240, 190, 30));
        ModificarUsuario.add(NuevoCorreoAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 280, 190, 30));
        ModificarUsuario.add(NuevaContraseñaAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 320, 190, 30));

        jLabel48.setBackground(new java.awt.Color(0, 0, 0));
        jLabel48.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(0, 0, 0));
        jLabel48.setText("Nueva contraseña:");
        ModificarUsuario.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, -1, -1));

        jLabel56.setBackground(new java.awt.Color(0, 0, 0));
        jLabel56.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(0, 0, 0));
        jLabel56.setText("Nuevo correo:");
        ModificarUsuario.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, -1, 20));

        jLabel53.setBackground(new java.awt.Color(0, 0, 0));
        jLabel53.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(0, 0, 0));
        jLabel53.setText("Nuevo usuario:");
        ModificarUsuario.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, -1, -1));

        jLabel52.setBackground(new java.awt.Color(0, 0, 0));
        jLabel52.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 0, 0));
        jLabel52.setText("Nuevo apellido");
        ModificarUsuario.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, -1, 20));

        jLabel49.setBackground(new java.awt.Color(0, 0, 0));
        jLabel49.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(0, 0, 0));
        jLabel49.setText("Nuevo nombre:");
        ModificarUsuario.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, -1, -1));

        jLabel44.setBackground(new java.awt.Color(0, 0, 0));
        jLabel44.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 0, 0));
        jLabel44.setText("Ingrese los nuevos datos:");
        ModificarUsuario.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, -1, -1));
        ModificarUsuario.add(ContraseñaDelAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 190, 30));

        jLabel45.setBackground(new java.awt.Color(0, 0, 0));
        jLabel45.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 0, 0));
        jLabel45.setText("Ingrese su contraseña:");
        ModificarUsuario.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, -1, -1));

        jLabel41.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 0, 0));
        jLabel41.setText("Modificar informacion de usuario");
        ModificarUsuario.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, -1, -1));

        ModificarInformacionDeAdmin.setText("Modificar");
        ModificarInformacionDeAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarInformacionDeAdminActionPerformed(evt);
            }
        });
        ModificarUsuario.add(ModificarInformacionDeAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 370, -1, -1));

        CargarInformacion.setText("Refrescar");
        CargarInformacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarInformacionActionPerformed(evt);
            }
        });
        ModificarUsuario.add(CargarInformacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, -1));

        jTabbedPane1.addTab("Usuario", ModificarUsuario);

        Disponibles.setBackground(new java.awt.Color(255, 255, 255));
        Disponibles.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaAdministrador.setBackground(new java.awt.Color(255, 255, 255));
        tablaAdministrador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Marca", "Modelo", "Año", "Precio", "Color", "Tipo Motor", "Fecha ingreso", "Kilometraje", "Placa", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaAdministrador);

        Disponibles.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 840, 340));

        jButton2.setText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        Disponibles.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jTabbedPane1.addTab("Disponibles", Disponibles);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 860, 440));

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_4.setBackground(new java.awt.Color(0, 0, 0));
        btn_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_4MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_4MousePressed(evt);
            }
        });
        btn_4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_4.setOpaque(false);
        ind_4.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_4Layout = new javax.swing.GroupLayout(ind_4);
        ind_4.setLayout(ind_4Layout);
        ind_4Layout.setHorizontalGroup(
            ind_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_4Layout.setVerticalGroup(
            ind_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        btn_4.add(ind_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Modificar Precio");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        btn_4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, 43));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-edit-car-37.png"))); // NOI18N
        btn_4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 50, 40));

        jPanel7.add(btn_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 280, 50));

        btn_1.setBackground(new java.awt.Color(0, 0, 0));
        btn_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_1MousePressed(evt);
            }
        });
        btn_1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_1.setOpaque(false);
        ind_1.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_1Layout = new javax.swing.GroupLayout(ind_1);
        ind_1.setLayout(ind_1Layout);
        ind_1Layout.setHorizontalGroup(
            ind_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_1Layout.setVerticalGroup(
            ind_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        btn_1.add(ind_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Usuario");
        btn_1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        btn_1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 50, -1));
        btn_1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 40));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-user-35.png"))); // NOI18N
        btn_1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 40, 50));

        jPanel7.add(btn_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 280, 50));

        vendidodopanel.setBackground(new java.awt.Color(0, 0, 0));
        vendidodopanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vendidodopanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vendidodopanelMouseEntered(evt);
            }
        });
        vendidodopanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 23)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Autos Vendidos");
        vendidodopanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 170, 30));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-sold-35.png"))); // NOI18N
        vendidodopanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 50, 50));

        jPanel7.add(vendidodopanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 280, 50));

        CierreSesion.setBackground(new java.awt.Color(0, 0, 0));
        CierreSesion.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        CierreSesion.setForeground(new java.awt.Color(255, 255, 255));
        CierreSesion.setText("Cerrar Sesión");
        CierreSesion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CierreSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CierreSesionActionPerformed(evt);
            }
        });
        jPanel7.add(CierreSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 510, 90, 20));

        btn_2.setBackground(new java.awt.Color(0, 0, 0));
        btn_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_2MousePressed(evt);
            }
        });
        btn_2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_2.setOpaque(false);
        ind_2.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_2Layout = new javax.swing.GroupLayout(ind_2);
        ind_2.setLayout(ind_2Layout);
        ind_2Layout.setHorizontalGroup(
            ind_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_2Layout.setVerticalGroup(
            ind_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        btn_2.add(ind_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Disponibles");
        btn_2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 2, -1, 40));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        btn_2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 50, -1));
        btn_2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 40));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-car-rental-35.png"))); // NOI18N
        btn_2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 40, 50));

        jPanel7.add(btn_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 280, 50));

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 550));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btn_4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_4MouseClicked
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btn_4MouseClicked

    private void btn_4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_4MousePressed

    }//GEN-LAST:event_btn_4MousePressed

    private void btn_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_1MouseClicked
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btn_1MouseClicked

    private void btn_1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_1MousePressed

    }//GEN-LAST:event_btn_1MousePressed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked

    private void vendidodopanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vendidodopanelMouseClicked

       jTabbedPane1.setSelectedIndex(0);


    }//GEN-LAST:event_vendidodopanelMouseClicked

    private void vendidodopanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vendidodopanelMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_vendidodopanelMouseEntered

    private void CierreSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CierreSesionActionPerformed

        int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas cerrar sesión?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {

            this.dispose();

            InicioSesion is = new InicioSesion();
            is.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "Cierre de sesión cancelado.");

        }
    }//GEN-LAST:event_CierreSesionActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        cargarCarroEnTabla();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void modificarPrecioCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarPrecioCarroActionPerformed

        String modelo = imputModeloModificar.getText().trim();
        String nuevoPrecioTexto = imputPrecioModificar.getText().trim();

        if (modelo.isEmpty() || nuevoPrecioTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese el modelo del auto y el nuevo precio.");
            return;
        }

        double nuevoPrecio;
        try {
            nuevoPrecio = Double.parseDouble(nuevoPrecioTexto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El precio debe ser un número válido.");
            return;

        }

        carroDAO modificador = new carroDAO();
        modificador.modificarPrecioAuto(modelo, nuevoPrecio);


    }//GEN-LAST:event_modificarPrecioCarroActionPerformed

    private void btn_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_2MouseClicked

    private void btn_2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_2MousePressed
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_btn_2MousePressed

    private void ModificarInformacionDeAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarInformacionDeAdminActionPerformed
        String contraseñaActualAdmin = ContraseñaDelAdmin.getText().trim();
        String nuevoNombreAdmin = NuevoNombreAdmin.getText().trim();
        String nuevoApellidoAdmin = NuevoApellidoAdmin.getText().trim();
        String nuevoUsuarioAdmin = NuevoUsuarioAdmin.getText().trim();
        String nuevoCorreoAdmin = NuevoCorreoAdmin.getText().trim();
        String nuevaContraseñaAdmin = NuevaContraseñaAdmin.getText().trim();

        if (nuevoNombreAdmin.isEmpty() && nuevoApellidoAdmin.isEmpty() && nuevoUsuarioAdmin.isEmpty() && nuevoCorreoAdmin.isEmpty() && nuevaContraseñaAdmin.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe modificar al menos un campo.");
            return;
        }

        if (contraseñaActualAdmin.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese la contraseña actual del administrador.");
            return;
        }

        AdministradorDAO Ad = new AdministradorDAO();
        Ad.modificarDatosAdministrador(identificacionAdmin, contraseñaActualAdmin, nuevoNombreAdmin, nuevoApellidoAdmin, nuevoUsuarioAdmin, nuevaContraseñaAdmin, nuevoCorreoAdmin);

    }//GEN-LAST:event_ModificarInformacionDeAdminActionPerformed

    private void CargarInformacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarInformacionActionPerformed
        AdministradorDAO Ad = new AdministradorDAO();
        
        try {
            usuarios admin = Ad.obtenerInformacionAdministrador();

            if (admin != null) {
                NombreAdmin.setText(admin.getNombre());
                ApellidoAdmin.setText(admin.getApellidos());
                IdentificacionAdmin.setText(admin.getIdentificacion());
                UsuarioAdmin.setText(admin.getUser());
                CorreoAdmin.setText(admin.getCorreo());
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró información del administrador.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar la información del administrador: " + e.getMessage());
        }
    }//GEN-LAST:event_CargarInformacionActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                usuarios adminActual = SesionAdmin.getAdminActual();
                if (adminActual != null) {
                    String identificacionAdmin = adminActual.getIdentificacion();
                    try {
                        new Administrador(identificacionAdmin).setVisible(true);
                    } catch (SQLException ex) {
                        java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No hay administrador autenticado.");
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ApellidoAdmin;
    private javax.swing.JButton CargarInformacion;
    private javax.swing.JButton CierreSesion;
    private javax.swing.JTextField ContraseñaDelAdmin;
    private javax.swing.JLabel CorreoAdmin;
    private javax.swing.JPanel Disponibles;
    private javax.swing.JLabel IdentificacionAdmin;
    private javax.swing.JButton ModificarInformacionDeAdmin;
    private javax.swing.JPanel ModificarPrecio;
    private javax.swing.JPanel ModificarUsuario;
    private javax.swing.JLabel NombreAdmin;
    private javax.swing.JTextField NuevaContraseñaAdmin;
    private javax.swing.JTextField NuevoApellidoAdmin;
    private javax.swing.JTextField NuevoCorreoAdmin;
    private javax.swing.JTextField NuevoNombreAdmin;
    private javax.swing.JTextField NuevoUsuarioAdmin;
    private javax.swing.JLabel UsuarioAdmin;
    private javax.swing.JPanel btn_1;
    private javax.swing.JPanel btn_2;
    private javax.swing.JPanel btn_4;
    private javax.swing.JTextField imputModeloModificar;
    private javax.swing.JTextField imputPrecioModificar;
    private javax.swing.JPanel ind_1;
    private javax.swing.JPanel ind_2;
    private javax.swing.JPanel ind_4;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton modificarPrecioCarro;
    private javax.swing.JPopupMenu ppMenuTabla;
    public javax.swing.JTable tablaAdministrador;
    private javax.swing.JPanel vendidodopanel;
    private javax.swing.JPanel venta;
    private javax.swing.JTable ventasTbla;
    // End of variables declaration//GEN-END:variables

    public void cargarCarroEnTabla() {
        carroDAO cd = new carroDAO();
        List<Carro> listaCarros = cd.obtenerCarros();

        DefaultTableModel model = (DefaultTableModel) tablaAdministrador.getModel();

        model.setRowCount(0);
        DecimalFormat formatoPrecio = new DecimalFormat("#,##0.00");
        for (Carro cars : listaCarros) {
            model.addRow(new Object[]{
                cars.getMarca(),
                cars.getModelo(),
                cars.getAño(),
                formatoPrecio.format(cars.getPrecio()),
                cars.getColor(),
                cars.getTipoMotor(),
                cars.getKilometraje(),
                cars.getFechaIngresoo(),
                cars.getPlaca(),
                cars.getCantidad()

            });
        }
    }
    
    public void cargarComprasEnTabla() throws SQLException {
        carroDAO carroD = new carroDAO();
        List<Compra> listaCarros = carroD.obtenerAutosVendidos();

        DefaultTableModel model = (DefaultTableModel) ventasTbla.getModel();
        model.setRowCount(0);

        for (Compra compra : listaCarros) {
            model.addRow(new Object[]{
                compra.getNombreAuto(),
                compra.getPrecioAuto(),
                compra.getPlaca(),
                compra.getFechaCompra(),
                compra.getTotal(),
                compra.getCantidad(),
                compra.getNombreUsuario(),
                compra.getApellidoUsuario(),
                compra.getIdentificacionUsuario()

            });
        }
    }

}
