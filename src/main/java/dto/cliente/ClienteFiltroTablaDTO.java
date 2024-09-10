/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto.cliente;

/**
 *
 * @author eduar
 */
public class ClienteFiltroTablaDTO {
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    
    // Campos para la paginación
    private int page;
    private int size;

    public ClienteFiltroTablaDTO() {}

    public ClienteFiltroTablaDTO(String nombres, String apellidoPaterno, String apellidoMaterno, int page, int size) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.page = page;
        this.size = size;
    }

    // Getters y setters
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

    // Métodos para paginación
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
