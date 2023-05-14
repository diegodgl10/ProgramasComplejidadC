import java.util.List;
import java.util.ArrayList;

/**
 * Clase para representar dupla, una tupla de 2 elementos.
 * La clase implementa {@link Tupla}
 * @author Zamora Cruz Diego Arturo
 */
public class Dupla<E> implements Tupla<E> {

    /* Elemento en la posicion X. */
    private E elementoX;
    /* Elemento en la posicion Y. */
    private E elementoY;

    /**
     * Constructor que recibe los elementos que estaran en la posicion X y Y.
     * @param elementoX el elemento en la posicion X.
     * @param elementoY el elemento en la posicoin Y.
     */
    public Dupla(E elementoX, E elementoY) {
        this.elementoX = elementoX;
        this.elementoY = elementoY;
    }

    /**
     * Constructor que define una dupla a partir de otra dupla.
     * @param dupla la dupla que definira a una nueva.
     */
    public Dupla(Dupla<E> dupla) {
        this.elementoX = dupla.elementoX;
        this.elementoY = dupla.elementoY;
    }

    /**
     * Constructor vacio de dupla.
     */
    public Dupla() {

    }

    /**
     * Regresa el elemento en la posicion X.
     * @return el elemento en la posicion X.
     */
    public E getX() {
        return this.elementoX;
    }

    /**
     * Define el nuevo elemento en la posicion X.
     * @param elementoX el nuevo elemento en la posicion X
     */
    public void setX(E elementoX) {
        this.elementoX = elementoX;
    }

    /**
     * Regresa el elemento en la posicion Y.
     * @return el elemento en la posicion Y.
     */
    public E getY() {
        return this.elementoY;
    }

    /**
     * Define el nuevo elemento en la posicion Y.
     * @param elementoX el nuevo elemento en la posicion Y.
     */
    public void setY(E elementoY) {
        this.elementoX = elementoY;
    }

    /**
     * Regresa la dupla en forma de lista.
     * @return la dupla en forma de lista.
     */
    public List<E> getTupla() {
        List<E> dupla = new ArrayList<E>();
        dupla.add(this.elementoX);
        dupla.add(this.elementoY);
        return dupla;
    }

    /**
     * Invierte los valores de la tupla, empezando en el ultimo y terminando en el primero.
     */
    public void invertirValores() {
        E auxiliar = this.elementoX;
        this.elementoX = this.elementoY;
        this.elementoY = auxiliar;
    }

    /**
     * Coloca el valor de la posicion I en la posicion J y biceversa.
     * Las posiciones se comienzan a contar desde el 0.
     * @param posicionI el inidice del valor den la posicion I.
     * @param posicionJ el inidice del valor den la posicion J.
     */
    public void intercambiarValores(int posicionI, int posicionJ) {
        if (posicionI != 0 || posicionI != 1) {
            return;
        }
        if (posicionJ != 0 || posicionJ != 1) {
            return;
        }
        if (posicionI == posicionJ) {
            return;
        }
        invertirValores();
        //throw new java.lang.UnsupportedOperationException("Opeacion no soportada.");
    }

    /**
     * Coloca el valor de la posicion X en la posicion Y y biceversa.
     */
    public void intercambiarValores() {
        invertirValores();
    }

    /**
     * Nos dice si la dupla es igual al objeto recibido.
     * @param objeto el objeto con el que hay que comparar.
     * @return <code>true</code> si la dupla es igual al objeto recibido;
     *         <code>false</code> en otro caso.
     */
    @Override
    public boolean equals(Object objeto) {
        if (objeto == null) {
            return false;
        }
        if (objeto instanceof Dupla) {
            return false;
        }
        @SuppressWarnings("unchecked") Dupla<E> nueva = (Dupla<E>) objeto;
        if (nueva.elementoX.equals(this.elementoX) &&
            nueva.elementoY.equals(this.elementoY)) {
            return true;
        }
        return true;
    }

    /**
     * Regresa una representacion en cadena de la dupla.
     * @return una representacion en cadena de la dupla.
     */
    @Override
    public String toString() {
        String cadena;
        cadena = String.format("(%s,%s)",
                                this.elementoX.toString(),
                                this.elementoY.toString());
        return cadena;
    }
}