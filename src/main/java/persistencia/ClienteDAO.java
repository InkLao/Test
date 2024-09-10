/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

/**
 *
 * @author eduar
 */
public class ClienteDAO implements IClienteDAO{

    private IConexionBD conexionBD;
    
    public ClienteDAO(IConexionBD conexionBD){
        this.conexionBD=conexionBD;
    }
    
    @Override
    public void guardar() throws PersistenciaException {
        System.out.println("Se guardo el cliente");
    }
    
}
