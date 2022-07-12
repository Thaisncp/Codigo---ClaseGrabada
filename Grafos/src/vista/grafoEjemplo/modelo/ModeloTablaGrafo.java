package vista.grafoEjemplo.modelo;

import controlador.tda.grafos.GrafoD;
import controlador.tda.grafos.expetion.VerticeExeption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ASUS
 */
public class ModeloTablaGrafo extends AbstractTableModel{
    private GrafoD grafoD;
    private String [] columnas;
    
    private String[] generarColumnas(){
        columnas = new String [grafoD.numVertices() + 1];
        columnas[0] = "/";
        for (int i = 1; i < columnas.length; i++) {
            columnas[i] = String.valueOf(i);
        }
        return columnas;
    }

    public GrafoD getGrafoD() {
        return grafoD;
    }

    public void setGrafoD(GrafoD grafoD) {
        this.grafoD = grafoD;
        generarColumnas();
    }

    public String[] getColumnas() {
        return columnas;
    }

    public void setColumnas(String[] columnas) {
        this.columnas = columnas;
    }
    
    
    @Override
    public int getRowCount() {
        return grafoD.numVertices();
    }

    @Override
    public int getColumnCount() {
        return grafoD.numVertices()+1;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
    
    @Override
    public Object getValueAt(int arg0, int arg1) {
        if (arg1 == 0) {
            return columnas[arg0 + 1];
        } else {
            Object[] aux = null;
            try {
                aux = grafoD.existeArista((arg0 + 1), arg1);

                if (((Boolean) aux[0])) {
                    return aux[1];
                } else {
                    return "-----------";
                }
            } catch (Exception e) {
                System.out.println("Error en la tabla" + e);
                return "";
            }

        }
    }
}
