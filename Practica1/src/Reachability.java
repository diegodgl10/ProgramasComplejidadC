import java.util.ArrayList;
import java.util.List;

/**
 * Clase que resuelve el problema de Alcanzabilidad con un algoritmo no determinista.
 * @author Zamora Cruz Diego Arturo.
 */
public class Reachability {

    /* Grafo par el problema de alcanzabilidad. */
    private Grafo grafo;
    /* Gamino desde una variable a otra para el problema de alcanzabilidad. */
    private List<Vertice> camino;

    /**
     * Constructor que recibe un grafo
     * @param grafo el grafo al que se le buscara un camino.
     */
    public Reachability(Grafo grafo) {
        this.grafo = grafo;
    }

    /**
     * Constructor vacio.
     */
    public Reachability() {
        this.grafo = new Grafo();
    }

    /**
     * Regresa <code>True</code> si se encontro un camino desde s hasta t
     * que no repita vertices, <code>False</code> en otro caso.
     * @param grafo el grafo al que se le aplicara el agloritmo.
     * @param s el vertice de origen.
     * @param t el vertice de destino.
     * @return <code>True</code> si se encontro un camino desde s hasta t
     * que no repita vertices, <code>False</code> en otro caso.
     */
    public boolean solucion(Grafo grafo, Vertice s, Vertice t) {
        this.grafo = grafo;
        this.camino = new ArrayList<Vertice>();

        System.out.println("Ejemplar de Alcansabilidad: \n" + this.grafo);
        System.out.println("Vertice s: " + s.toString());
        System.out.println("Vertice t: " + t.toString());

        // Generamos una lista de vertices que conforman el camino con nd-choice 
        Vertice auxV = s;
        this.grafo.setVerticeVisitado(auxV, true);
        List<Vertice> disponibles = new ArrayList<Vertice>();
        this.camino.add(auxV);
        do {
            disponibles = new ArrayList<Vertice>();
            List<Vertice> adyacentes = grafo.getAdyacentes(auxV);
            for (Vertice vertice : adyacentes) {
                if (vertice.getVisitado() == false) {
                    disponibles.add(vertice);
                }
            }
            Vertice adyacente;
            if (disponibles.size() != 0) {
                int tomar = ndChoice(0, disponibles.size());
                adyacente = disponibles.get(tomar);
                auxV = adyacente;
                this.grafo.setVerticeVisitado(auxV, true);
                this.camino.add(auxV);
            }
        } while (disponibles.size()-1 > 0);
        
        System.out.println("Candidato a solucion:\n" + this.camino);

        // Vemos si la asignacion es solucion
        String caminoSt = "";
        for (Vertice vertice : this.camino) {
            caminoSt += vertice.toString();
            if (vertice.equals(t)) {
                System.out.println("Si es solucion para el ejemplar\n" +caminoSt);
                return true;
            } else {
                caminoSt += " -> ";
            }
        }
        System.out.println("No es solucion para el ejemplar");
        return false;
    }

    /* La primitiva adivinadora que selecciona un elemento del conjunto de enteros
    entre n y m */
    private int ndChoice(int n, int m) {
        return (int) ((Math.random() * (m-n)) + n);
    }
}