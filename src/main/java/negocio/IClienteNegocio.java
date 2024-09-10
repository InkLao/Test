/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import dto.cliente.ClienteFiltroTablaDTO;
import dto.cliente.ClienteGuardarDTO;
import dto.cliente.ClienteModificarDTO;
import dto.cliente.ClienteTablaDTO;
import java.util.List;

/**
 *
 * @author eduar
 */
public interface IClienteNegocio {
    
    List<ClienteTablaDTO> buscarClientesTabla(ClienteFiltroTablaDTO filtro) throws NegocioException;
    
    void guardar(ClienteGuardarDTO cliente) throws NegocioException;
    
    void modificar(ClienteModificarDTO cliente) throws NegocioException;
}
