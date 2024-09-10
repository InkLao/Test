/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto.cliente;

import java.sql.Timestamp;

/**
 *
 * @author eduar
 */
public class ClienteDTO {
    private int idcliente;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Timestamp fechaHoraRegistro;

    public ClienteDTO() {}

    public ClienteDTO(int idcliente, String nombres, String apellidoPaterno, String apellidoMaterno, Timestamp fechaHoraRegistro) {
        this.idcliente = idcliente;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    // Getters y setters
    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Timestamp getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    public void setFechaHoraRegistro(Timestamp fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
    }
}
