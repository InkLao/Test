
package persistencia;

import dto.cliente.ClienteDTO;
import dto.cliente.ClienteFiltroTablaDTO;
import dto.cliente.ClienteGuardarDTO;
import dto.cliente.ClienteModificarDTO;
import java.util.List;

/**
 *
 * @author eduar
 */
public interface IClienteDAO {
    
    void guardarCliente(ClienteGuardarDTO cliente) throws PersistenciaException;
    
    ClienteDTO obtenerCliente(int idcliente) throws PersistenciaException;
    
    void modificarCliente(ClienteModificarDTO cliente) throws PersistenciaException;
    
    void eliminarCliente(int idcliente) throws PersistenciaException;
    
    List<ClienteDTO> obtenerClientesConFiltro(ClienteFiltroTablaDTO filtro) throws PersistenciaException;

}
