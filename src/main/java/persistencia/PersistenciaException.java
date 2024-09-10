/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

/**
 *
 * @author eduar
 */
public class PersistenciaException extends Exception {
    
    // Constructor con mensaje
    public PersistenciaException(String mensaje) {
        super(mensaje);
    }

    // Constructor con mensaje y causa
    public PersistenciaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
