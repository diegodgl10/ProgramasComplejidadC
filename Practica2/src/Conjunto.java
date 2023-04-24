import java.util.List;
import java.util.ArrayList;

/**
 * Clase para representar un cojunto algebraico.
 * @author Zamora Cruz Diego Arturo
 */
public class Conjunto<E> {

    /* Nombre del conjunto. */
    private String nombre;

    /* Elementos del conjunto. */
    private List<E> elementos;
    
    /**
     * Constructor vacio.
     */
    public Conjunto(String nombre) {
        this.nombre = nombre;
        this.elementos = new ArrayList<E>();
    }

    /**
     * Constructor que recibe una lista como parametros.
     * @param elementos lista de elementos para el conjunto.
     */
    public Conjunto(String nombre, List<E> elementos) {
        this.nombre = nombre;
        this.elementos = new ArrayList<E>(elementos);
    }

    /**
     * Constructor que recibe un conjunto como parametros.
     * @param newCjt el conjunto con el que se definira uno nuevo.
     */
    public Conjunto(String nombre, Conjunto<E> newCjt) {
        this.nombre = nombre;
        this.elementos = new ArrayList<E>(newCjt.elementos);
    }

    /**
     * Regresa el nombre del conjunto.
     * @return el nombre del conjunto.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Define un nuevo nombre para el conjunto.
     * @param nombre el nuevo nombre del conjunto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Regresa la lista de elementos.
     * @return la lista de elementos.
     */
    public List<E> getElementos() {
        return this.elementos;
    }

    /**
     * Define una nueva lista de elementos para el conjunto.
     * @param elementos los nuevos elementos del conjunto.
     */
    public void setElementos(List<E> elementos) {
        this.elementos = elementos;
    }

    /**
     * Operacion de union entre conjuntos.
     * @param otroCjt el segundo conjunto con quien se hara la union.
     * @return el resultado de realizar la operacion de union.
     */
    public Conjunto<E> union(Conjunto<E> otroCjt) {
        List<E> union = this.elementos;
        List<E> otroCjtLs = otroCjt.elementos;
        for (E elemento : otroCjtLs) {
            if (!this.elementos.contains(elemento)) {
                union.add(elemento);
            }
        }
        return new Conjunto<E>(this.nombre+" u "+otroCjt.nombre, union);
    }

    /**
     * Operacion de interseccion entre conjuntos.
     * @param otroCjt el segundo conjunto con quien se hara la interseccion.
     * @return el resultado de realizar la operacion de interseccion.
     */
    public Conjunto<E> interseccion(Conjunto<E> otroCjt) {
        List<E> interseccion = new ArrayList<E>();
        List<E> otroCjtLs = otroCjt.elementos;
        for (E elemento : otroCjtLs) {
            if (this.elementos.contains(elemento)) {
                interseccion.add(elemento);
            }
        }
        return new Conjunto<E>(this.nombre+" n "+otroCjt.nombre, interseccion);
    }

    /**
     * Operacion de diferencia entre conjuntos.
     * @param otroCjt el segundo conjunto con quien se hara la diferencia.
     * @return el resultado de realizar la operacion de diferencia.
     */
    public Conjunto<E> diferencia(Conjunto<E> otroCjt) {
        List<E> diferencia = new ArrayList<E>();
        for (E e : this.elementos) {
            if (!otroCjt.elementos.contains(e)) {
                diferencia.add(e);
            }
        }
        return new Conjunto<E>(this.nombre+"-"+otroCjt.nombre, diferencia);
    }

    /**
     * Operacion de diferencia simetrica entre conjuntos.
     * @param otroCjt el segundo conjunto con quien se hara la diferencia simetrica.
     * @return el resultado de realizar la operacion de diferencia simetrica.
     */
    public Conjunto<E> difSimetrica(Conjunto<E> otroCjt) {
        Conjunto<E> dif1 = this.diferencia(otroCjt);
        Conjunto<E> dif2 = otroCjt.diferencia(this);
        Conjunto<E> union = dif1.union(dif2);
        union.setNombre(this.nombre +"/\\"+ otroCjt); 
        return union;
    }

    /**
     * Regresa el numero de elementos del conjunto.
     * @return el numero de elementos del conjunto.
     */
    public int cardinalidad() {
        return this.elementos.size();
    }

    /**
     * Regresa <code>True</code> si el conjunto es vacio,
     * <code>False</code> en otro caso.
     * @return <code>True</code> si el conjunto es vacio,
     * <code>False</code> en otro caso.
     */
    public boolean esVacio() {
        return this.elementos.size() == 0;
    }

    /**
     * Regresa una representacion en cadena del conjunto.
     * @return una representacion en cadena del conjunto.
     */
    @Override
    public String toString() {
        String lista = this.elementos.toString();
        lista = lista.substring(1, lista.length()-1);
        lista = "{" + lista + "}";
        return lista;
    }

    /**
     * Regresa <code>true</code> si el objeto recibido es igual al objeto que
     * manda a llamar al metodo, <code>false</code> en otro caso.
     * @return <code>true</code> si el objeto recibido es igual al objeto que
     * manda a llamar al metodo, <code>false</code> en otro caso.
     */
    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (!(object instanceof Conjunto)) {
            return false;
        }
        Conjunto<E> cjt;
        try {
            cjt = (Conjunto<E>) object;
        } catch (ClassCastException e) {
            return false;
        }
        if (cjt.elementos.size() != this.elementos.size()) {
            return false;
        }
        for (E e : this.elementos) {
            if (!cjt.elementos.contains(e)) {
                return false;
            }
        }
        return true;
    }
}