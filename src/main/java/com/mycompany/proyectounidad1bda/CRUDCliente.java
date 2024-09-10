/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectounidad1bda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUDCliente {

    // Definimos los parámetros de conexión a la base de datos
    private final String SERVER = "localhost";
    private final String BASE_DATOS = "crud";
    private final String CADENA_CONEXION = "jdbc:mysql://" + SERVER + "/" + BASE_DATOS;
    private final String USUARIO = "root";
    private final String CONTRASEÑA = "root";
    private Connection conexion;

    public CRUDCliente() throws SQLException {
        // Establecemos la conexión con la base de datos utilizando los parámetros definidos
        conexion = DriverManager.getConnection(CADENA_CONEXION, USUARIO, CONTRASEÑA);
    }

    public void leer() throws SQLException {
        String leerCliente = """
                                SELECT idcliente, nombres, apellidoPaterno, apellidoMaterno, estaEliminado 
                                FROM clientes 
                                WHERE idCliente = ?
                             """;
        PreparedStatement preparedStatement = conexion.prepareStatement(leerCliente);
        preparedStatement.setInt(1, 20);

        ResultSet resultado = preparedStatement.executeQuery(); // Ejecutar la consulta

        while (resultado.next()) {
            int idClienteResult = resultado.getInt("idcliente");
            String nombres = resultado.getString("nombres");
            String apellidoPaterno = resultado.getString("apellidoPaterno");
            String apellidoMaterno = resultado.getString("apellidoMaterno");
            boolean estaEliminado = resultado.getBoolean("estaEliminado");

            // Imprimir los valores en la consola
            System.out.println("idCliente: " + idClienteResult);
            System.out.println("Nombres: " + nombres);
            System.out.println("Apellido Paterno: " + apellidoPaterno);
            System.out.println("Apellido Materno: " + apellidoMaterno);
            System.out.println("Eliminado: " + estaEliminado);
            System.out.println("-----------------------------"); // Línea separadora para claridad
        }

        resultado.close();
        preparedStatement.close();
        conexion.close();
    }

    public void insertar() throws SQLException {

        // Definimos la consulta SQL para insertar un nuevo cliente en la tabla 'clientes'
        String insertCliente = "INSERT INTO clientes (nombres, apellidoPaterno, apellidoMaterno) VALUES (?, ?, ?)";

        // Creamos un objeto PreparedStatement pa>ra ejecutar la consulta de inserción
        // Statement.RETURN_GENERATED_KEYS indica que queremos obtener las claves generadas automáticamente
        PreparedStatement preparedStatement = conexion.prepareStatement(insertCliente, Statement.RETURN_GENERATED_KEYS);

        // Asignamos valores a los parámetros de la consulta SQL
        preparedStatement.setString(1, "Jesus");
        preparedStatement.setString(2, "Torres");
        preparedStatement.setString(3, "Mendrano");

        // Ejecutamos la consulta de inserción en la base de datos
        preparedStatement.executeUpdate();

        // Obtenemos las claves generadas automáticamente (por ejemplo, el ID del nuevo registro)
        ResultSet resultado = preparedStatement.getGeneratedKeys();
        if (resultado.next()) {
            System.out.println(resultado.getInt(1));
        }

        // Cerramos el ResultSet, el PreparedStatement y la conexión a la base de datos
        resultado.close();
        preparedStatement.close();
        conexion.close();
    }

    public void actualizar() throws SQLException {
        // Definimos la consulta SQL para actualizar un cliente en la tabla 'clientes'
        String updateCliente = """
                                UPDATE clientes 
                                SET nombres = ?,
                                    apellidoPaterno = ?,
                                    apellidoMaterno = ? ,
                                    estaEliminado = ?
                                WHERE idcliente = ?
                                """;

        // Creamos un objeto PreparedStatement para ejecutar la consulta de actualización
        PreparedStatement preparedStatement = conexion.prepareStatement(updateCliente);

        // Asignamos valores a los parámetros de la consulta SQL
        preparedStatement.setString(1, "Ivanna");
        preparedStatement.setString(2, "Fabela");
        preparedStatement.setString(3, "Angulo");
        preparedStatement.setBoolean(4, false);
        preparedStatement.setInt(5, 1);

        // Ejecutamos la consulta de actualización en la base de datos
        int filasAfectadas = preparedStatement.executeUpdate();

        // Imprimimos el número de filas afectadas por la actualización
        System.out.println("Filas afectadas: " + filasAfectadas);

        // Cerramos el PreparedStatement y la conexión a la base de datos
        preparedStatement.close();
        conexion.close();
    }
}
