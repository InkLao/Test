/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dto.cliente.ClienteDTO;
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
    
    private final IClienteDAO clienteDAO;

    public ClienteNegocio(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    public void guardarCliente(ClienteGuardarDTO cliente) throws PersistenciaException {
        // Puedes agregar validaciones de negocio aquí si es necesario
        clienteDAO.guardarCliente(cliente);
    }

    @Override
    public ClienteDTO obtenerCliente(int idcliente) throws PersistenciaException {
        return clienteDAO.obtenerCliente(idcliente);
    }

    @Override
    public void modificarCliente(ClienteModificarDTO cliente) throws PersistenciaException {
        // Puedes agregar validaciones de negocio aquí si es necesario
        clienteDAO.modificarCliente(cliente);
    }

    @Override
    public void eliminarCliente(int idcliente) throws PersistenciaException {
        // Ejemplo de validación de negocio antes de eliminar
        ClienteDTO cliente = clienteDAO.obtenerCliente(idcliente);
        if (cliente == null) {
            throw new PersistenciaException("El cliente con id " + idcliente + " no existe.");
        }
        clienteDAO.eliminarCliente(idcliente);
    }

    @Override
    public List<ClienteDTO> obtenerClientesConFiltro(ClienteFiltroTablaDTO filtro) throws PersistenciaException {
        return clienteDAO.obtenerClientesConFiltro(filtro);
    }
    
}
