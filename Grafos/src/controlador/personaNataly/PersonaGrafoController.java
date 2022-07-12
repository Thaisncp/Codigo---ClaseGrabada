/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.personaNataly;

import controlador.tda.grafos.GrafoEND;
import modelo.Persona;
import modelo.TipoPersona;
import modelo.Ubicacion;

/**
 *
 * @author Thais cartuche
 */
public class PersonaGrafoController {
    private GrafoEND<Persona>  gend;
    private Persona persona;
    
    public PersonaGrafoController(Integer Nro_vertices){
        gend = new GrafoEND<>(Nro_vertices, Persona.class);
        for (int i = 1; i <= Nro_vertices; i++) {
            Persona p = new Persona();
            p.setNombres("Persona "+i);
            p.setTipoPerosna(TipoPersona.CLIENTE);
            Ubicacion U = new Ubicacion();
            U.setId(i);
            U.setLatitud(0.00);
            U.setLongitud(0.00);
            p.setUbicacion(U);
            gend.etiquetarVertices(i, p);
        }
    }

    public GrafoEND<Persona> getGend() {
        return gend;
    }

    public void setGend(GrafoEND<Persona> gend) {
        this.gend = gend;
    }

    public Persona getPersona() {
        if (persona == null) {
            persona = new Persona();
        }
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public double calcularDistancia(Persona po, Persona pd){
        Double dis = 0.0;
        Double x = po.getUbicacion().getLongitud()-pd.getUbicacion().getLongitud();
        Double y = po.getUbicacion().getLatitud()-pd.getUbicacion().getLatitud();
        dis = Math.sqrt((x*x)+(y*y));
        return dis;
    }
    
    
    
}
