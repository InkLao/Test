/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import dto.cliente.ClienteDTO;
import dto.cliente.ClienteFiltroTablaDTO;
import dto.cliente.ClienteGuardarDTO;
import dto.cliente.ClienteModificarDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eduar
 */
public class ClienteDAO implements IClienteDAO{

    private final IConexionBD conexionBD;
    
    public ClienteDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public void guardarCliente(ClienteGuardarDTO cliente) throws PersistenciaException {
        String query = "INSERT INTO clientes (nombres, apellidoPaterno, apellidoMaterno) VALUES (?, ?, ?)";
        try (Connection conexion = conexionBD.crearConexion(); PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, cliente.getNombres());
            stmt.setString(2, cliente.getApellidoPaterno());
            stmt.setString(3, cliente.getApellidoMaterno());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new PersistenciaException("Error al guardar el cliente", ex);
        }
    }

    @Override
    public ClienteDTO obtenerCliente(int idcliente) throws PersistenciaException {
        String query = "SELECT * FROM clientes WHERE idcliente = ?";
        try (Connection conexion = conexionBD.crearConexion(); PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, idcliente);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new ClienteDTO(
                        rs.getInt("idcliente"),
                        rs.getString("nombres"),
                        rs.getString("apellidoPaterno"),
                        rs.getString("apellidoMaterno"),
                        rs.getTimestamp("fechaHoraRegistro")
                    );
                }
            }
        } catch (SQLException ex) {
            throw new PersistenciaException("Error al obtener el cliente");
        }
        return null;
    }

    @Override
    public void modificarCliente(ClienteModificarDTO cliente) throws PersistenciaException {
        String query = "UPDATE clientes SET nombres = ?, apellidoPaterno = ?, apellidoMaterno = ? WHERE idcliente = ?";
        try (Connection conexion = conexionBD.crearConexion(); PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, cliente.getNombres());
            stmt.setString(2, cliente.getApellidoPaterno());
            stmt.setString(3, cliente.getApellidoMaterno());
            stmt.setInt(4, cliente.getIdcliente());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new PersistenciaException("Error al modificar el cliente", ex);
        }
    }

    @Override
    public void eliminarCliente(int idcliente) throws PersistenciaException {
        String query = "DELETE FROM clientes WHERE idcliente = ?";
        try (Connection conexion = conexionBD.crearConexion(); PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, idcliente);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new PersistenciaException("Error al eliminar el cliente", ex);
        }
    }

    @Override
    public List<ClienteDTO> obtenerClientesConFiltro(ClienteFiltroTablaDTO filtro) throws PersistenciaException {
        List<ClienteDTO> listaClientes = new ArrayList<>();
        String query = "SELECT * FROM clientes WHERE 1=1";
        
        // Filtrar por nombres
        if (filtro.getNombres() != null && !filtro.getNombres().isEmpty()) {
            query += " AND nombres LIKE ?";
        }
        
        // Filtrar por apellido paterno
        if (filtro.getApellidoPaterno() != null && !filtro.getApellidoPaterno().isEmpty()) {
            query += " AND apellidoPaterno LIKE ?";
        }
        
        // Filtrar por apellido materno
        if (filtro.getApellidoMaterno() != null && !filtro.getApellidoMaterno().isEmpty()) {
            query += " AND apellidoMaterno LIKE ?";
        }

        // Añadir paginación
        int offset = (filtro.getPage() - 1) * filtro.getSize();
        query += " LIMIT ? OFFSET ?";

        try (Connection conexion = conexionBD.crearConexion(); PreparedStatement stmt = conexion.prepareStatement(query)) {
            int paramIndex = 1;

            // Establecer valores de filtros si existen
            if (filtro.getNombres() != null && !filtro.getNombres().isEmpty()) {
                stmt.setString(paramIndex++, "%" + filtro.getNombres() + "%");
            }
            if (filtro.getApellidoPaterno() != null && !filtro.getApellidoPaterno().isEmpty()) {
                stmt.setString(paramIndex++, "%" + filtro.getApellidoPaterno() + "%");
            }
            if (filtro.getApellidoMaterno() != null && !filtro.getApellidoMaterno().isEmpty()) {
                stmt.setString(paramIndex++, "%" + filtro.getApellidoMaterno() + "%");
            }

            // Parámetros para la paginación
            stmt.setInt(paramIndex++, filtro.getSize());
            stmt.setInt(paramIndex, offset);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    ClienteDTO cliente = new ClienteDTO(
                        rs.getInt("idcliente"),
                        rs.getString("nombres"),
                        rs.getString("apellidoPaterno"),
                        rs.getString("apellidoMaterno"),
                        rs.getTimestamp("fechaHoraRegistro")
                    );
                    listaClientes.add(cliente);
                }
            }
        } catch (SQLException ex) {
            throw new PersistenciaException("Error al obtener clientes con filtro", ex);
        }
        return listaClientes;
    }
    
}
