import java.util.ArrayList;
import java.util.List;

/**
 * Modela el Carcaj que lleva el personaje para
 * tranportar sus flechas.
 */
public class Carcaj extends Elemento {
    private final Integer PESO_PROPIO = 10;
    private Integer capacidad;
    private List<Flecha> flechas;

    /**
     * Constructor para un Carcaj generico chico. Su capacidad
     * es de 5 flechas pero se inicializa vacio.
     * Recordar que es de tipo recipiente y tiene un peso inicial.
     */
    public Carcaj() {
        
        super("Carcaj chico", 0,TipoElemento.RECIPIENTE);
        setPeso(PESO_PROPIO);
        capacidad=5;
        flechas = new ArrayList<Flecha>();
        
        
        // TODO - Implementar metodo
    }

    /**
     * Constructor para un Carcaj de nombre y capacidad indicados
     * por parametro.  Se inicializa vacio.
     * Recordar que es de tipo recipiente y tiene un peso inicial.
     * 
     * @param nombre El nombre del carcaj.
     * @param capacidad Cantidad maxima de flechas.
     */
    public Carcaj(String nombre, Integer capacidad) {
        
        super(nombre , 0, TipoElemento.RECIPIENTE);
        setPeso(PESO_PROPIO);
        this.capacidad = capacidad;
        flechas = new ArrayList<Flecha>();
        
        
        
        // TODO - Implementar metodo
    }

    /**
     * Agrega una flecha al carcaj.
     * 
     * Debe actualizarse el peso total.
     * 
     * Si no tiene capacidad disponible, debe imprimir
     *     "<nombre>: Capacidad completa"
     * donde <nombre> es el nombre del carcaj.
     * 
     * Si el elemento a agregar no es una flecha, debe imprimir:
     *     "<nombre>: No es una flecha"
     * donde <nombre> es el nombre del elemento entregado.
     * 
     * @param flecha La flecha a agregar.
     */
    public void addFlecha (Elemento flecha) {
        if(flechas.size()<getCapacidad()){
            if(flecha.getTipo().equals(TipoElemento.MUNICION)){
                Flecha addFL = new Flecha();
                addFL = (Flecha) flecha;
                flechas.add(addFL);
                addPeso(flecha.getPeso());
            
            } 
            else{
                System.out.println (flecha.getNombre()+": "+"No es una flecha");
            }
        }
        else{
            System.out.println (getNombre()+": "+"Capacidad Completa");
        }

        // TODO - Implementar metodo
    }

    /**
     * Quita del carcaj una flecha.
     * 
     * Debe actualizarse el peso total.
     * 
     * Si no hay mas flechas, devuelve null y debe imprimir:
     *      "<nombre>: No quedan flechas"
     * donde <nombre> es el nombre del carcaj.
     * 
     * @return Una flecha.
     */
    public Flecha getFlecha () {
        if(flechas.size() != 0){
            Flecha outFL = new Flecha(); 
            flechas.remove(flechas.size()-1); 
            addPeso(-(outFL.getPeso()));
            return outFL;
        }
        else{
            System.out.println(getNombre()+": No quedan flechas");
            return null;
        }
        // TODO - Implementar metodo
        
    }

    /**
     * Modifica el peso del carcaj.
     * Puede sumar o restar peso.
     * 
     * @param peso El peso a modificar.
     */
    public void addPeso (Integer peso) {
        int pesoMod = getPeso() + peso;
        setPeso(pesoMod);
        // TODO - Implementar metodo
    }

    /**
     * Devuelve informacion sobre el carcaj de la forma:
     *     "<nombre>: Flechas <cant>/<max>"
     * donde <nombre> es el nombre del carcaj,
     * <cant> es la cantidad de flechas que contiene y
     * <max> la capacidad maxima.
     */
    @Override        
    public String toString() {
        String texto;
        texto = getNombre()+": "+"Flechas "+getCantidadFlechas()+"/"+getCapacidad();
        // TODO - Implementar metodo
        return texto;
    }

    public Integer getCantidadFlechas () {
        return flechas.size();
    }

    public Integer getCapacidad () {
        return capacidad;
    }
    
}
