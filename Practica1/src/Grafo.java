import java.util.List;
import java.util.ArrayList;

/**
 * Clase para representar un grafo.
 * Posee una lista de vertices y una lista de aristas.
 * @author Zamora Cruz Diego Arturo.
 */
public class Grafo {

    /* Lista de vertices del grafo. */
    private List<Vertice> lVertices;
    /* Lista de aristas del grafo. */
    private List<Arista> lAristas;

    /**
     * Constructor de un grafo que recibe una lista de vertices y aristas.
     * @param lVertices lista de vertices del grafo.
     * @param lAristas lista de aristas del grafo.
     */
    public Grafo(List<Vertice> lVertices, List<Arista> lAristas) {
        this.lVertices = lVertices;
        this.lAristas = lAristas;
    }

    /**
     * Constructor de un grafo a partir de otro.
     * @param grafo el grafo que definira a uno nuevo.
     */
    public Grafo(Grafo grafo) {
        this.lVertices = grafo.lVertices;
        this.lAristas = grafo.lAristas;
    }

    /**
     * Constructor vacio de un grafo.
     */
    public Grafo() {
        this.lVertices = new ArrayList<Vertice>();
        this.lAristas = new ArrayList<Arista>();
    }

    /**
     * Regresa la lista de vertices.
     * @return la lista de vertices.
     */
    public List<Vertice> getVertices() {
        return this.lVertices;
    }

    /**
     * Regresa la lista de aristas.
     * @return la lista de aristas.
     */
    public List<Arista> getAristas() {
        return this.lAristas;
    }

    /**
     * Regresa la arista que es adyacente a los vertices dados,
     * <code>null</code> en otro caso.
     * @param vertice1 el primer vertice adyacente a la arista buscada.
     * @param vertice2 el segundo vertice adyacente a la arista buscada.
     * @return la arista que es adyacente a los vertices dados,
     * <code>null</code> en otro caso.
     */
    public Arista getArista(Vertice vertice1, Vertice vertice2) {
        Arista aux = new Arista(vertice1, vertice2, 0);
        for (Arista arista : this.lAristas) {
            if (arista.equals(aux)) {
                return arista;
            }
        }
        return null;
    }

    /**
     * Define el estado de visitado de un vertice del grafo.
     * @param vertice el vertice que sera modificado.
     * @param visitado el nuevo estado booleano de visitado para el
     * vertice del grafo.
     */
    public void setVerticeVisitado(Vertice vertice, boolean visitado) {
        int aux = this.lVertices.indexOf(vertice);
        if (aux != -1) {
            Vertice temporal = this.lVertices.get(aux);
            temporal.setVisitado(visitado);
            this.lVertices.set(aux, temporal);
        }
    }

    /**
     * Define el estado de visitado de un vertice del grafo.
     * @param indice el indice del vertice que sera modificado.
     * @param visitado el nuevo estado booleano de visitado para el
     * vertice del grafo.
     */
    public void setVerticeVisitado(int indice, boolean visitado) {
        if (indice > -1 && indice < this.lVertices.size()) {
            Vertice temporal = this.lVertices.get(indice);
            temporal.setVisitado(visitado);
            this.lVertices.set(indice, temporal);
        }
    }

    /**
     * Define el nuevo estado de visitado para todos vertices del grafo.
     * @param visitado el nuevo valor booleano de visitado para
     * todos los vertices.
     */
    public void allVisitados(boolean visitado) {
        for (Vertice vertice : this.lVertices) {
            vertice.setVisitado(visitado);
        }
    }

    /**
     * Agrega un vertice a la lista de vertices.
     * @param vertice el vertice que sera agregado a la lista de vertices.
     */
    public void addVertice(Vertice vertice) {
        if (!this.lVertices.contains(vertice)) {
            this.lVertices.add(vertice);
        }
    }

    /**
     * Elimina un vertice de la lista de vertices.
     * @param vertice el vertice que sera eliminado de la lista de vertices.
     */
    public void removeVertice(Vertice vertice) {
        this.lVertices.remove(vertice);
        int contador = 0;
        List<Integer> aristasIndice = new ArrayList<Integer>();
        if (this.lAristas != null) {
            for (Arista arista : this.lAristas) {
                if (arista.getVertice1().equals(vertice) ||
                    arista.getVertice2().equals(vertice)) {
                    aristasIndice.add(contador++);
                }
            }
            for (int i = aristasIndice.size() - 1; i >= 0; i--) {
                removeArista(this.lAristas.get(i));   
            }
        }

    }

    /**
     * Agrega una arista a la lista de aristas.
     * @param arista la arista que sera agregada a la lista de aristas.
     */
    public void addArista(Arista arista) {
        if (!this.lAristas.contains(arista)) {
            this.lAristas.add(arista);
            addVertice(arista.getVertice1());
            addVertice(arista.getVertice2());
        }
    }

    /**
     * Elimina un arista de la lista de aristas.
     * @param arista la arista que sera eliminada de la lista de aristas.
     */
    public void removeArista(Arista arista) {
        this.lAristas.remove(arista);
    }

    /**
     * Regresa <code>true</code> si el vertice pertenece al grafo,
     * <code>false</code> en otro caso.
     * @param vertice el vertice que se buscara en el grafo.
     * @return <code>true</code> si el vertice pertenece al grafo,
     * <code>false</code> en otro caso.
     */
    public boolean contains(Vertice vertice) {
        return this.lVertices.contains(vertice);
    }

    /**
     * Regresa <code>true</code> si la arista pertenece al grafo,
     * <code>false</code> en otro caso.
     * @param arista la arista que se buscara en el grafo.
     * @return <code>true</code> si la arista pertenece al grafo,
     * <code>false</code> en otro caso.
     */
    public boolean contains(Arista arista) {
        return this.lAristas.contains(arista);
    }

    /**
     * Regresa la lista de vertices a la que es adyacente el vertice recibido.
     * @param vertice el vertice al que se le buscaran los vertices adyacentes.
     * @return la lista de vertices a la que es adyacente el vertice recibido.
     */
    public List<Vertice> getAdyacentes(Vertice vertice) {
        List<Vertice> adyacentes = new ArrayList<Vertice>();
        for (Arista arista : this.lAristas) {
            if (arista.getVertice1().equals(vertice)) {
                if (!adyacentes.contains(arista.getVertice2())) {
                    adyacentes.add(arista.getVertice2());
                }
            }
            if (arista.getVertice2().equals(vertice)) {
                if (!adyacentes.contains(arista.getVertice1())) {
                    adyacentes.add(arista.getVertice1());
                }
            }
        } 
        return adyacentes;
    }

    /**
     * Regresa <code>true</code> si la grafica tiene ciclos,
     * <code>false</code> en otro caso.
     * @return <code>true</code> si la grafica tiene ciclos,
     * <code>false</code> en otro caso.
     */
    public boolean tieneCiclos() {
        int vertices = this.lVertices.size();
        int aristas = this.lAristas.size();
        if (aristas < vertices) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Regresa una representacion en cadena del grafo.
     * @return una representacion en cadena del grafo.
     */
    @Override public String toString() {
        String cadena;
        cadena = "Vertices: ";
        cadena += this.lVertices.toString();
        /*
        for (Vertice vertice : this.lVertices) {
            cadena += vertice.toString() + "\n";
        }
        */
        cadena += "\nAristas:  ";
        cadena += this.lAristas.toString();
        /*
        for (Arista arista : this.lAristas) {
            cadena += "\n" + arista.toString();   
        }
        */
        return cadena;
    }
}