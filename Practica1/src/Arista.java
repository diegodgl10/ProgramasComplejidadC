/**
 * Clase para representar la arista con peso de un grafo.
 * La arista tiene dos vertices a los que es adyacente y un peso.
 * @author Zamora Cruz Diego Arturo.
 */
public class Arista {

    /* Primer vertice adyacente a la arista. */
    private Vertice vertice1;
    /* Segundo vertice adyacente a la arista. */
    private Vertice vertice2;
    /* Peso de la arista. */
    private double peso;

    /**
     * Constructor de la arista de un grafo con peso.
     * @param vertice1 el vertice 1 de la arista.
     * @param vertice2 el vertice 2 de la arista.
     * @param peso el peso de la arista.
     */
    public Arista(Vertice vertice1, Vertice vertice2, double peso) {
        this.vertice1 = vertice1;
        this.vertice2 = vertice2;
        this.peso = peso;
    }

    /**
     * Constructor de la arista de un grafo sin peso.
     * @param vertice1 el vertice 1 de la arista.
     * @param vertice2 el vertice 2 de la arista.
     */
    public Arista(Vertice vertice1, Vertice vertice2) {
        this.vertice1 = vertice1;
        this.vertice2 = vertice2;
        this.peso = 0;
    }

    /**
     * Regresa primer vertice al que es adyacente la arista
     * @return primer vertice al que es adyacente la arista
     */
    public Vertice getVertice1() {
        return this.vertice1;
    }

    /**
     * Define el primer vertice al que es adyacente la arista
     * @param vertice1 el primer vertice al que es adyacente la arista
     */
    public void setVertice1(Vertice vertice1) {
        this.vertice1 = vertice1;
    }

    /**
     * Regresa segundo vertice al que es adyacente la arista
     * @return segundo vertice al que es adyacente la arista
     */
    public Vertice getVertice2() {
        return this.vertice2;
    }

    /**
     * Define el segundo vertice al que es adyacente la arista
     * @param vertice2 el segundo vertice al que es adyacente la arista
     */
    public void setVertice2(Vertice vertice2) {
        this.vertice2 = vertice2;
    }

    /**
     * Regresa el peso de la arista.
     * @return el peso de la arista.
     */
    public double getPeso() {
        return this.peso;
    }

    /**
     * Regresa una representacion en cadena de la arista.
     * @return una representacion en cadena de la arista.
     */
    @Override public String toString() {
        String cadena;
        cadena = String.format("(%s, %s, P:%s)",
                vertice1.toString(), vertice2.toString(), this.peso);
        return cadena;
    }

    /**
    * Nos dice si una arista es igual al objeto recibido.
    * @param objeto el objeto con el que hay que comparar.
    * @return <code>true</code> si la arista es igual al objeto recibido;
    *         <code>false</code> en otro caso.
    */
    @Override public boolean equals(Object objeto) {
        if (objeto == null) {
            return false;
        }
        if (!(objeto instanceof Arista)) {
            return false;
        }
        Arista arista = (Arista) objeto;
        if (arista.vertice1.equals(this.vertice1) &&
            arista.vertice2.equals(this.vertice2)) {
            return true;
        }
        if (arista.vertice1.equals(this.vertice2) &&
            arista.vertice2.equals(this.vertice1)) {
            return true;
        } 
        return false;
    }
}