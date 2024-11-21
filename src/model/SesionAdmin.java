
package model;

public class SesionAdmin {
  
    private static usuarios adminActual;

    public static void iniciarSesionAdmin(usuarios admin) {
        adminActual = admin;
    }

    public static usuarios getAdminActual() {
        return adminActual;
    }

    public static void cerrarSesionAdmin() {
        adminActual = null;
    }
}

    

