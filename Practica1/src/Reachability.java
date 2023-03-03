import java.util.ArrayList;
import java.util.List;

public class Reachability {

    private Grafo grafo;
    private List<Vertice> camino;

    public Reachability(Grafo grafo) {
        this.grafo = grafo;
    }

    public Reachability() {
        this.grafo = new Grafo();
    }

    public boolean solucion(Grafo grafo, Vertice s, Vertice t) {
        this.grafo = grafo;
        Grafo grafoAux = new Grafo(grafo);
        this.camino = new ArrayList<Vertice>();

        System.out.println("Ejemplar de Alcansabilidad: \n" + this.grafo);
        System.out.println("Vertice s: " + s.toString());
        System.out.println("Vertice t: " + t.toString());

        // Generamos una lista de vertices que conforman el camino con nd-choice 
        Vertice auxV = s;
        grafoAux.setVerticeVisitado(auxV, true);
        List<Vertice> disponibles = new ArrayList<Vertice>();
        this.camino.add(auxV);
        do {
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
                grafoAux.setVerticeVisitado(auxV, true);
                this.camino.add(auxV);
            }
        } while (disponibles.size()-1 > 0);
        
        System.out.println("Candidato a solucion:\n" + this.camino);

        // Vemos si la asignacion es solucion
        for (Vertice vertice : this.camino) {
            if (vertice.equals(t)) {
                System.out.println("Si es solucion para el ejemplar");
                return true;
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