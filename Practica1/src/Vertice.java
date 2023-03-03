/**
 * Clase para representar el vertice de un grafo.
 * El vertice tiene una etiqueta identificadora.
 * @author Zamora Cruz Diego Aruto.
 */
public class Vertice {

    /* Etiqueta del vertice. */
    private String etiqueta;
    /* Valor booleano que nos dice si el vertice ha sido visitado. */
    private boolean visitado;

    /**
     * Constructor del vertice de un grafo que recibe una etiqueta.
     * @param etiqueta la etiqueta del vertice.
     */
    public Vertice(String etiqueta) {
        this.etiqueta = etiqueta;
        this.visitado = false;
    }
    
    /**
     * Constructor del vertice de un grafo que recibe una etiqueta y su valor
     * booleano de visitado.
     * @param etiqueta la etiqueta del vertice.
     * @param visitado el valor booleano de visitado del vertice.
     */
    public Vertice(String etiqueta, boolean visitado) {
        this.etiqueta = etiqueta;
        this.visitado = visitado;
    }

    /**
     * Regresa <code>true</code> si el vertice ha sido visitado,
     * <code>false</code> en otro caso.
     * @return <code>true</code> si el vertice ha sido visitado,
     * <code>false</code> en otro caso.
     */
    public boolean getVisitado() {
        return this.visitado;
    }

    /**
     * Niega el valor booleano de visitado para el vertice.
     */
    public void setVisitado() {
        this.visitado = !visitado;
    }

    /**
     * Define el nuevo estado booleano de visitado para el vertice.
     * @param visitado el nuevo valor booleano de visitado para el vertice.
     */
    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    /**
     * Regresa una representacion en cadena del vertice
     * @return una representacion en cadena del vertice
     */
    @Override public String toString() {
        return "V:" + etiqueta;
    }

    /**
    * Nos dice si el nodo es igual al objeto recibido.
    * @param objeto el objeto con el que hay que comparar.
    * @return <code>true</code> si el nodo es igual al objeto recibido;
    *         <code>false</code> en otro caso.
    */
    @Override public boolean equals(Object objeto) {
        if (objeto == null) {
            return false;
        }
        if (!(objeto instanceof Vertice)) {
            return false;
        }
        Vertice vertice = (Vertice) objeto;
        if (vertice.etiqueta.equals(this.etiqueta)) {
            return true;
        }
        return false;
    }
}