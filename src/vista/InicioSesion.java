/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Sesion;
import sombra.textoSombra;
import model.UsuarioDAO;
import model.usuarios;

public class InicioSesion extends javax.swing.JFrame {

    public InicioSesion() {
        initComponents();

        setResizable(false);
        setLocationRelativeTo(null);

        textoSombra usuario = new textoSombra("Usuario", txtuser);
        textoSombra contraseña = new textoSombra("Contraseña", txtpassword);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        panelAzulFondoCarro = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        logoLabel = new javax.swing.JLabel();
        logintext = new javax.swing.JLabel();
        botonIngresar = new javax.swing.JButton();
        txtAunNotieneCuenta = new javax.swing.JLabel();
        registreseAqui = new javax.swing.JButton();
        txtContraseña = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();
        jSeparator3 = new javax.swing.JSeparator();
        ingreseUser = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        show = new javax.swing.JLabel();
        hidden = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel5MouseEntered(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelAzulFondoCarro.setBackground(new java.awt.Color(0, 0, 0));
        panelAzulFondoCarro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Le damos la bienvenida a ");
        panelAzulFondoCarro.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 45, 343, 31));

        jLabel3.setFont(new java.awt.Font("Century Schoolbook", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Voltrix car's");
        panelAzulFondoCarro.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 82, 451, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 2, 12)); // NOI18N
        jLabel5.setText("Calidad e innovacion en cada kilometro.");
        panelAzulFondoCarro.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 506, 210, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/white-cars-lamborghini-italian-cars-4724x3569-cars-lamborghini-hd-art-wallpaper-preview-removebg-preview.png"))); // NOI18N
        panelAzulFondoCarro.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 580, 290));

        jPanel5.add(panelAzulFondoCarro, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 620, 590));

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/image 2.jpg"))); // NOI18N
        jPanel5.add(logoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, -1, -1));

        logintext.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        logintext.setForeground(new java.awt.Color(0, 0, 0));
        logintext.setText("Inicie sesion.");
        jPanel5.add(logintext, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 45, 245, 35));

        botonIngresar.setBackground(new java.awt.Color(0, 0, 0));
        botonIngresar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        botonIngresar.setForeground(new java.awt.Color(255, 255, 255));
        botonIngresar.setText("Ingresar");
        botonIngresar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                botonIngresarMouseMoved(evt);
            }
        });
        botonIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonIngresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonIngresarMouseExited(evt);
            }
        });
        botonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIngresarActionPerformed(evt);
            }
        });
        botonIngresar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botonIngresarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                botonIngresarKeyReleased(evt);
            }
        });
        jPanel5.add(botonIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 264, 57));

        txtAunNotieneCuenta.setForeground(new java.awt.Color(0, 0, 0));
        txtAunNotieneCuenta.setText("¿Aun no tiene una cuenta?");
        jPanel5.add(txtAunNotieneCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 155, -1));

        registreseAqui.setBackground(new java.awt.Color(255, 255, 255));
        registreseAqui.setForeground(new java.awt.Color(0, 0, 255));
        registreseAqui.setText("Registrese aqui.");
        registreseAqui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registreseAquiActionPerformed(evt);
            }
        });
        jPanel5.add(registreseAqui, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, -1, -1));

        txtContraseña.setForeground(new java.awt.Color(0, 0, 0));
        txtContraseña.setText("Ingrese su contraseña");
        jPanel5.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 320, 20));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Imagen de WhatsApp 2024-09-19 a las 14.46.04_8cb85dea.jpg"))); // NOI18N
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 30, 40));

        txtpassword.setBackground(new java.awt.Color(0, 0, 0, 0
        ));
        txtpassword.setForeground(new java.awt.Color(0, 0, 0));
        txtpassword.setBorder(null);
        txtpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswordActionPerformed(evt);
            }
        });
        txtpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpasswordKeyPressed(evt);
            }
        });
        jPanel5.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 290, 40));
        jPanel5.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 320, 10));

        ingreseUser.setForeground(new java.awt.Color(0, 0, 0));
        ingreseUser.setText("Ingrese su usuario:");
        jPanel5.add(ingreseUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 320, 20));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/profile-user.png"))); // NOI18N
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 30, 40));

        txtuser.setBackground(new java.awt.Color(0, 0, 0, 0));
        txtuser.setForeground(new java.awt.Color(51, 51, 51));
        txtuser.setBorder(null);
        txtuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtuserActionPerformed(evt);
            }
        });
        jPanel5.add(txtuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 290, 40));
        jPanel5.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 320, 10));

        show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/view.png"))); // NOI18N
        show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showMouseClicked(evt);
            }
        });
        jPanel5.add(show, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 50, 40));

        hidden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/hide (1).png"))); // NOI18N
        hidden.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                hiddenMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                hiddenMouseReleased(evt);
            }
        });
        jPanel5.add(hidden, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, 40, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1110, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonIngresarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonIngresarMouseMoved
        botonIngresar.setBackground(Color.DARK_GRAY);

    }//GEN-LAST:event_botonIngresarMouseMoved

    private void botonIngresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonIngresarMouseEntered

    }//GEN-LAST:event_botonIngresarMouseEntered

    private void botonIngresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonIngresarMouseExited
        botonIngresar.setBackground(Color.BLACK);
    }//GEN-LAST:event_botonIngresarMouseExited

    private void botonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIngresarActionPerformed
        String username = txtuser.getText();
        String password = new String(txtpassword.getPassword());

        UsuarioDAO userDao = new UsuarioDAO();
        usuarios usuarioActual = userDao.getUsuario(username, password);

        if (usuarioActual != null) {
            if ("Administrador".equals(usuarioActual.getRol())) {
                try {
                    String identificacionAdmin = usuarioActual.getIdentificacion();
                    Administrador adminDashboard = new Administrador(identificacionAdmin);
                    adminDashboard.setVisible(true);
                    this.dispose();
                } catch (SQLException ex) {
                    Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                Sesion.iniciarSesion(usuarioActual);

                String identificacionUsuario = usuarioActual.getIdentificacion();

                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {

                            new Cliente(identificacionUsuario).setVisible(true);
                        } catch (SQLException ex) {
                            Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });

                this.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrecta", "Error de Login", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_botonIngresarActionPerformed
    }
    private void registreseAquiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registreseAquiActionPerformed
        Registro opi = new Registro();
        opi.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_registreseAquiActionPerformed

    private void txtuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtuserActionPerformed

    }//GEN-LAST:event_txtuserActionPerformed

    private void jPanel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseEntered

    }//GEN-LAST:event_jPanel5MouseEntered

    private void botonIngresarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botonIngresarKeyPressed

    }//GEN-LAST:event_botonIngresarKeyPressed

    private void txtpasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordKeyPressed

    }//GEN-LAST:event_txtpasswordKeyPressed

    private void botonIngresarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botonIngresarKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_botonIngresarKeyReleased

    private void txtpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpasswordActionPerformed

    private void showMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMouseClicked
        show.setVisible(false);
        hidden.setVisible(true);
        txtpassword.setEchoChar('*');
    }//GEN-LAST:event_showMouseClicked

    private void hiddenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hiddenMousePressed
        show.setVisible(true);
        hidden.setVisible(false);
        txtpassword.setEchoChar((char) 0);
    }//GEN-LAST:event_hiddenMousePressed

    private void hiddenMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hiddenMouseReleased

    }//GEN-LAST:event_hiddenMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonIngresar;
    private javax.swing.JLabel hidden;
    private javax.swing.JLabel ingreseUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel logintext;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JPanel panelAzulFondoCarro;
    private javax.swing.JButton registreseAqui;
    private javax.swing.JLabel show;
    private javax.swing.JLabel txtAunNotieneCuenta;
    private javax.swing.JLabel txtContraseña;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}
