package controlador.tda.grafos;

import controlador.tda.grafos.expetion.VerticeExeption;
import controlador.tda.lista.ListaEnlazada;
import java.util.HashMap;

/**
 *
 * @author Thais Cartuche
 */
public class GrafoDE<E> extends GrafoD {
    protected Class<E> clazz;
    protected E etiquetas [];
    protected HashMap <E, Integer> dicVertices;

    public GrafoDE(Integer numV, Class clazz) {
        super(numV);
        this.clazz = clazz;
        //etiquetas = (E[]) new Object[numV+1];
        etiquetas = (E[])(E[]) java.lang.reflect.Array.newInstance(this.clazz, numV+1);
        dicVertices = new HashMap<>(numV);
    }
    
    public Boolean modificar(E viejo, E nuevo)throws Exception{
        Integer pos = obtenerCodigo(viejo);
        etiquetas[pos] = nuevo;
        dicVertices.remove(viejo);
        dicVertices.put(nuevo, pos);
        return true;
    }

    public Object[] existeAristaE(E i, E j)throws Exception{
        return this.existeArista(obtenerCodigo(i), obtenerCodigo(j));
    }
    
    public void insertarAristaE(E i, E j, Double peso) throws Exception{
        this.insertarArista(obtenerCodigo(i), obtenerCodigo(j), peso);
    }
    
    public void insertarAristaE(E i, E j) throws Exception {
        this.insertarArista(obtenerCodigo(i), obtenerCodigo(j), Double.NaN);
    }
     
    public Integer obtenerCodigo(E etiqueta)throws Exception{
        Integer key = dicVertices.get(etiqueta);
        if (key != null) {
            return key;
        }else{
            throw new VerticeExeption("No se encuentra la etiqueta");
        }
    }
    
    public E obtenerEtiqueta(Integer codigo) throws Exception{
        return etiquetas[codigo];
    }
    
    public ListaEnlazada<Adycencia> adyacentesDEE(E i)throws Exception{
        return adycentes(obtenerCodigo(i));
    }
    
    public void etiquetarVertices(Integer codigo, E etiqueta){
        etiquetas[codigo] = etiqueta;
        dicVertices.put(etiqueta, codigo);
    }
    
    @Override
    public String toString() {
        StringBuilder grafo=new StringBuilder();
        try {
            for(int i = 1; i <= numVertices(); i++) {
            grafo.append("VERTICE "+i+" --E-- " + obtenerEtiqueta(i).toString());
            try {
                ListaEnlazada<Adycencia> lista = adycentes(i);
               
                for(int j = 0; j < lista.getSize(); j++) {
                    Adycencia aux = lista.obtenerDato(j);
                    if(aux.getPeso().toString().equalsIgnoreCase(String.valueOf(Double.NaN)))
                        grafo.append(" --- VERTICE DESTINO "+aux.getDestino()+ " --E-- "+ obtenerEtiqueta(aux.getDestino()));
                    else 
                        grafo.append(" --- VERTICE DESTINO "+aux.getDestino()+ " --E-- "+ obtenerEtiqueta(aux.getDestino()) + " --peso-- "+aux.getPeso());
                }
                grafo.append("\n");
            } catch (Exception e) {
                System.out.println("Error en toString "+e);
               
            }
        }
        } catch (Exception e) {
            System.out.println("Error en toString"+e);
        }
        return grafo.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args) {
        GrafoDE<String> gde = new GrafoDE<>(5, String.class);
        gde.etiquetarVertices(1, "Karen");
        gde.etiquetarVertices(2, "Maria");
        gde.etiquetarVertices(3, "Juan");
        gde.etiquetarVertices(4, "Hilary");
        gde.etiquetarVertices(5, "Sandra");
        try {
            gde.insertarAristaE("Karen", "Juan");
            gde.insertarAristaE("Sandra", "Hilary");
            gde.insertarAristaE("Sandra", "y");
        } catch (Exception e) {
            System.out.println("Error"+e);
        }
        System.out.println(gde.toString());
    }
    
}
