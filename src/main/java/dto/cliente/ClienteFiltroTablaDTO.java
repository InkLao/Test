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
    private int limite;
    private int pagina;
    private String filtro;

    public ClienteFiltroTablaDTO(int limite, int pagina, String filtro) {
        this.limite = limite;
        this.pagina = pagina;
        this.filtro = filtro;
    }

    // Métodos getter y setter
    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }
}
