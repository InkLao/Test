/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

import java.sql.Timestamp;

/**
 *
 * @author eduar
 */
public class ClienteEntidad {
    private int idcliente;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private boolean estaEliminado;
    private Timestamp fechaHoraRegistro;

    // Constructor vacío
    public ClienteEntidad() {}

    // Constructor con parámetros
    public ClienteEntidad(int idcliente, String nombres, String apellidoPaterno, String apellidoMaterno, boolean estaEliminado, Timestamp fechaHoraRegistro) {
        this.idcliente = idcliente;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.estaEliminado = estaEliminado;
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

    public boolean isEstaEliminado() {
        return estaEliminado;
    }

    public void setEstaEliminado(boolean estaEliminado) {
        this.estaEliminado = estaEliminado;
    }

    public Timestamp getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    public void setFechaHoraRegistro(Timestamp fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
    }
}
