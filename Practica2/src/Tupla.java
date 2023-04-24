import java.util.List;

/**
 * Interfaz para tuplas, una tupla debe de poder representarse como lista,
 * invertir los valores e intercambiar valores segun su indice.
 * @author Zamora Cruz Diego Arturo
 */
public interface Tupla<E> {

    /**
     * Regresa la dupla en forma de lista.
     * @return la dupla en forma de lista.
     */
    public List<E> getTupla();

    /**
     * Invierte los valores de la tupla, empezando en el ultimo y terminando en el primero.
     */
    public void invertirValores();

    /**
     * Coloca el valor de la posicion I en la posicion J y biceversa.
     * Las posiciones se comienzan a contar desde el 0.
     * @param posicionI el inidice del valor den la posicion I.
     * @param posicionJ el inidice del valor den la posicion J.
     */
    public void intercambiarValores(int posicionI, int posicionJ);
}