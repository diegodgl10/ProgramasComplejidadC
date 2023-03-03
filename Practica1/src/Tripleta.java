import java.util.List;
import java.util.ArrayList;

/**
 * Clase para representar tripleta, una tupla de 3 elementos.
 * La clase implementa {@link Tupla}
 * @author Zamora Cruz Diego Arturo
 */
public class Tripleta<E> implements Tupla<E> {

    /* Elemento en la posicion X. */
    private E elementoX;
    /* Elemento en la posicion Y. */
    private E elementoY;
    /* Elemento en la posicion Z. */
    private E elementoZ;

    /**
     * Constructor que recibe los elementos que estaran en la posicion X, Y, Z.
     * @param elementoX el elemento en la posicion X.
     * @param elementoY el elemento en la posicoin Y.
     * @param elementoZ el elemento en la posicoin Z.
     */
    public Tripleta(E elementoX, E elementoY, E elementoZ) {
        this.elementoX = elementoX;
        this.elementoY = elementoY;
        this.elementoZ = elementoZ;
    }

    /**
     * Constructor que define una tripleta a partir de otra tripleta.
     * @param tripleta la tripleta que definira a una nueva.
     */
    public Tripleta(Tripleta<E> tripleta) {
        this.elementoX = tripleta.elementoX;
        this.elementoY = tripleta.elementoY;
        this.elementoZ = tripleta.elementoZ;
    }

    /**
     * Constructor vacio de tripleta.
     */
    public Tripleta() {

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
     * @param elementoY el nuevo elemento en la posicion Y.
     */
    public void setY(E elementoY) {
        this.elementoX = elementoY;
    }

    /**
     * Regresa el elemento en la posicion Z.
     * @return el elemento en la posicion Z.
     */
    public E getZ() {
        return this.elementoZ;
    }

    /**
     * Define el nuevo elemento en la posicion Z.
     * @param elementoZ el nuevo elemento en la posicion Z.
     */
    public void setZ(E elementoZ) {
        this.elementoZ = elementoZ;
    }

    /**
     * Regresa la tripleta en forma de lista.
     * @return la tripleta en forma de lista.
     */
    public List<E> getTupla() {
        List<E> tripleta = new ArrayList<E>();
        tripleta.add(this.elementoX);
        tripleta.add(this.elementoY);
        tripleta.add(this.elementoY);
        return tripleta;
    }

    /**
     * Invierte los valores de la tupla, empezando en el ultimo y terminando en el primero.
     */
    public void invertirValores() {
        E auxiliar = this.elementoX;
        this.elementoX = this.elementoZ;
        this.elementoZ = auxiliar;
    }

    /**
     * Coloca el valor de la posicion I en la posicion J y biceversa.
     * Las posiciones se comienzan a contar desde el 0.
     * @param posicionI el inidice del valor den la posicion I.
     * @param posicionJ el inidice del valor den la posicion J.
     */
    public void intercambiarValores(int posicionI, int posicionJ) {
        List<E> tripleta = new ArrayList<E>();
        tripleta.add(this.elementoX);
        tripleta.add(this.elementoY);
        tripleta.add(this.elementoY);
        E auxiliarI = tripleta.get(posicionI);
        E auxiliarJ = tripleta.get(posicionJ);
        tripleta.set(posicionI, auxiliarJ);
        tripleta.set(posicionJ, auxiliarI); 
    }

    /**
     * Nos dice si la tripleta es igual al objeto recibido.
     * @param objeto el objeto con el que hay que comparar.
     * @return <code>true</code> si la tripleta es igual al objeto recibido;
     *         <code>false</code> en otro caso.
     */
    @Override
    public boolean equals(Object objeto) {
        if (objeto == null) {
            return false;
        }
        if (objeto instanceof Tripleta) {
            return false;
        }
        @SuppressWarnings("unchecked") Tripleta<E> nueva = (Tripleta<E>) objeto;
        if (nueva.elementoX.equals(this.elementoX) &&
            nueva.elementoY.equals(this.elementoY) &&
            nueva.elementoZ.equals(this.elementoZ)) {
            return true;
        }
        return true;
    }

    /**
     * Regresa una representacion en cadena de la tripleta.
     * @return una representacion en cadena de la tripleta.
     */
    @Override
    public String toString() {
        String cadena;
        cadena = String.format("(%s,%s,%s)",
                                this.elementoX.toString(),
                                this.elementoY.toString(),
                                this.elementoZ.toString());
        return cadena;
    }

}