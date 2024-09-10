/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dto.cliente.ClienteFiltroTablaDTO;
import dto.cliente.ClienteGuardarDTO;
import dto.cliente.ClienteModificarDTO;
import dto.cliente.ClienteTablaDTO;
import java.time.LocalDateTime;
import java.util.List;
import persistencia.IClienteDAO;
import persistencia.PersistenciaException;

/**
 *
 * @author eduar
 */
public class ClienteNegocio implements IClienteNegocio{

    private IClienteDAO clienteDAO;
    
    public ClienteNegocio(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }
    
    public void guardar() throws NegocioException {
        try {
            System.out.println("Paso por negocio del cliente " + LocalDateTime.now());
            this.clienteDAO.guardar();
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
        
    }

    @Override
    public List<ClienteTablaDTO> buscarClientesTabla(ClienteFiltroTablaDTO filtro) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void guardar(ClienteGuardarDTO cliente) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modificar(ClienteModificarDTO cliente) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
