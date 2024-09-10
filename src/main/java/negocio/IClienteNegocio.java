/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import dto.cliente.ClienteDTO;
import dto.cliente.ClienteFiltroTablaDTO;
import dto.cliente.ClienteGuardarDTO;
import dto.cliente.ClienteModificarDTO;
import dto.cliente.ClienteTablaDTO;
import java.util.List;
import persistencia.PersistenciaException;

/**
 *
 * @author eduar
 */
public interface IClienteNegocio {
    
    void guardarCliente(ClienteGuardarDTO cliente) throws PersistenciaException;
    
    ClienteDTO obtenerCliente(int idcliente) throws PersistenciaException;
    
    void modificarCliente(ClienteModificarDTO cliente) throws PersistenciaException;
    
    void eliminarCliente(int idcliente) throws PersistenciaException;
    
    List<ClienteDTO> obtenerClientesConFiltro(ClienteFiltroTablaDTO filtro) throws PersistenciaException;
    
    List<ClienteTablaDTO> buscarClientesTabla(ClienteFiltroTablaDTO filtro) throws NegocioException;

}
