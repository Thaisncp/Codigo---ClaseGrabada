/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author ASUS
 */
public class Persona {
    private Integer id;
    private String nombres;
    private TipoPersona tipoPerosna;
    private Ubicacion ubicacion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public TipoPersona getTipoPerosna() {
        return tipoPerosna;
    }

    public void setTipoPerosna(TipoPersona tipoPerosna) {
        this.tipoPerosna = tipoPerosna;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    @Override
    public String toString() {
        return nombres;
    }
    
}
