public class Botella extends Elemento {
    private static final Integer PESO_PROPIO = 4;
    private Elemento contenido;

    public Botella() {
        setPeso(PESO_PROPIO);
        generarNombre();
        setTipo(TipoElemento.RECIPIENTE);
    }    

    /**
     * Llena la botella con el liquido indicado agregando el peso del
     * nuevo liquido. Genera el nuevo nombre de la botella y actualiza
     * el peso.
     * 
     * Solo puede rellenarse cuando esta vacia. Si tiene contenido,
     * debe imprimir el mensaje:
     *    "<botella>: Se encuentra llena"
     * siendo <botella> el texto provisto por toString().
     * 
     * Si el elemento no es del tipo "liquido", debe imprimir el mensaje:
     *    "<botella>: No admite <elemento>"
     * siendo <botella> el texto provisto por toString() y <elemento> la
     * descripcion del elemento entregado (toString()).
     * 
     * @param liquido El liquido para rellenar la botella
     */
    public void llenarBotella (Elemento liquido) {
        if(contenido == null){
            if(liquido.getTipo().equals(TipoElemento.LIQUIDO)){
              setContenido(liquido);  
              generarNombre();
              setPeso(PESO_PROPIO + liquido.getPeso());
            }
            else{
                System.out.println(toString()+": "+"No admite "+liquido.toString());
            }
            
        }
        else{
            System.out.println(toString()+": "+"Se encuentra llena");
        }
        // TODO - Implementar metodo
    }

    /**
     * Vacia el contenido de la botella y actualiza el peso.
     * La botella queda lista para recargar.
     * Genera el nuevo nombre de la botella.
     * 
     * @return El contenido de la botella.
     */
    public Elemento vaciarBotella () {
        if (contenido != null){  
            int elpeso = getPeso() - contenido.getPeso();
            setPeso(elpeso);
            contenido = null;
            generarNombre();
        }
        return contenido;
    
    }

    /**
     * Establece la descripcion de la botella con su contenido
     * correspondiente, por ej. "Botella con Agua".
     * En caso de que no tenga contenido, utiliza el texto
     * "Botella vacia"
     */
    public void generarNombre () {
        String nomDesc;
        if(isVacia()){
            nomDesc = "Botella vacia";
            setNombre(nomDesc);
        }
        else{
            nomDesc ="Botella con "+contenido.getNombre();
            setNombre(nomDesc);
        }
        // TODO - Implementar metodo
    }

    /**
     * Devuelve verdadero en caso de contener algun tipo de pocima
     * y falso si esta vacia o contiene otro tipo de liquido.
     * 
     * @return true en caso de contener algun tipo de pocima.
     */
    public Boolean hasPocima () {
        if (contenido instanceof Pocima){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Devuelve verdadero en caso de contener agua
     * y falso si esta vacia o contiene otro tipo de liquido.
     * 
     * @return true en caso de contener agua
     */
    public Boolean hasAgua () {
        if (contenido instanceof Agua){
            return true;
        }
        else{
            return false;
        }
        // TODO - Implementar metodo
    }
  
    /**
     * Devuelve verdadero en caso de contener vino
     * y falso si esta vacia o contiene otro tipo de liquido.
     * 
     * @return true en caso de contener vino
     */
    public Boolean hasVino () {
        if (contenido instanceof Vino){
            return true;
        }
        else{
            return false;
        }
        // TODO - Implementar metodo
    }
  
    /**
     * Devuelve verdadero o falso segun tenga o no contenido.
     * 
     * @return true en caso de estar vacia
     */
    public Boolean isVacia () { 
        return contenido == null;
    }

    public Elemento getContenido() {
        return contenido;
    }

    public void setContenido(Elemento contenido) {
        this.contenido = contenido;
    }

}