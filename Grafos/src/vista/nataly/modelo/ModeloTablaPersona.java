/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.nataly.modelo;

import controlador.tda.grafos.GrafoEND;
import javax.swing.table.AbstractTableModel;
import modelo.Persona;

/**
 *
 * @author Thais Cartuche
 */
public class ModeloTablaPersona extends AbstractTableModel{
    private GrafoEND<Persona> grafo;

    public GrafoEND<Persona> getGrafo() {
        return grafo;
    }

    public void setGrafo(GrafoEND<Persona> grafo) {
        this.grafo = grafo;
    }

    
    
    @Override
    public int getRowCount() {
        return grafo.numVertices();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

       @Override
    public Object getValueAt(int arg0, int arg1) {
        try {
            Persona p = grafo.obtenerEtiqueta(arg0+1);
            switch (arg1) {
                case 0:
                    return (arg0+1);
                case 1:
                    return p.getNombres();
                case 2:
                    return p.getTipoPerosna().toString();
                case 3:
                    return (p.getUbicacion() == null) ? "NO TIENE" : p.getUbicacion().toString();
                default:
                    return null;
            }
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex);
            return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "Nro";
            case 1: return "Nombres";
            case 2: return "Tipo";
            case 3: return "Ubicacion";
            default: return null;
        }
    }   
}
