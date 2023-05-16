import java.util.ArrayList;
import java.util.List;

public class SimulatedAnnealing {

    /* Tamanio del tablero que es igual numero de reinas. */
    private int tamanio;

    /* Lista con las posiciones en el tablero. */
    private List<Integer> posiciones;

    /**
     * Constructor que rebice el tamnio de tablero que es igual
     * al numero de rainas.
     * @param tamanio el tamanio del tablero que es igual
     * al numero de rainas.
     */
    public SimulatedAnnealing(int tamanio) {
        this.tamanio = tamanio;
    }

     /**
     * El tablero para la busqueda tabu.
     * @param tablero el tablero para la busqueda tabu.
     */
    public SimulatedAnnealing(Tablero tablero) {
        this.tamanio = tablero.getTamanio();
        for (int i = 0; i < this.tamanio; i++) {
            for (int j = 0; j < this.tamanio; j++) {
                if (tablero.hayReina(i, j)) {
                    this.posiciones.add(j);
                }
            }
        }
    }


    /* Genera un tablero colocando reinas en posiciones aleatorias. */
    private List<Integer> generarTablero() {
        List<Integer> posiciones = new ArrayList<Integer>();
        posiciones = new ArrayList<Integer>();
        while (posiciones.size() < this.tamanio) {
            int generado = (int) ((Math.random() * this.tamanio));
            if (!posiciones.contains(generado)) {
                posiciones.add(generado);
            }
        }
        return posiciones;
    }
    
    /**
     * Regresa el numero de colisiones que existen
     * con la configuracion actual del tablero recibido.
     * @param tablero, el tablero al sobre el que se realizara el conteo.
     * @return el numero de colisiones que existen
     * con la configuracion actual del tablero recibido.
     */
    public int contarColisiones(Tablero tablero) {
        int colisiones = 0;
        for (int i = 0; i < this.tamanio; i++) {
            for (int j = 0; j < this.tamanio; j++) {
                if (tablero.hayReina(i, j)) {
                    colisiones += colisonesVerticales(tablero, i, j);
                    colisiones += colisonesDiagonalesIzq(tablero, i, j);
                    colisiones += colisonesDiagonalesDer(tablero, i, j);
                }
            }
        }
        return colisiones;
    }

    /* Colisiones vertiales. */
    private int colisonesVerticales(Tablero tablero, int x, int y) {
        int contador = 0;
        for (int i = x+1; i < this.tamanio; i++) {
            if (tablero.hayReina(i, y)) {
                contador++;
            }
        }
        return contador;
    }

    /* Colisiones diagonales del lado izquierdo. */
    private int colisonesDiagonalesIzq(Tablero tablero, int x, int y) {
        int i = x+1;
        int j = y-1;
        int contador = 0;
        while (i < this.tamanio && j >= 0) {
            if (tablero.hayReina(i++, j--)) {
                contador++;
            }
        }
        return contador;
    }
    
    /* Colisiones diagonales del lado derecho. */
    public int colisonesDiagonalesDer(Tablero tablero, int x, int y) {
        int i = x+1;
        int j = y+1;
        int contador = 0;
        while (i < this.tamanio && j < this.tamanio) {
            if (tablero.hayReina(i++, j++)) {
                contador++;
            }
        } 
        return contador;
    }

    /**
     * Regresa una lista nueva con las posicones de la reina movida de forma
     * aleatoria.
     * @param posiciones la lista de posiciones de las reinas.
     * @return una lista nueva con las posicones de la reina movida de forma
     * aleatoria.
     */
    public List<Integer> vecino(List<Integer> posiciones){
        List<Integer> nuevasPos = new ArrayList<Integer>(posiciones);
        int i = (int) (Math.random() * this.tamanio);
        int j = (int) (Math.random() * this.tamanio);
        nuevasPos.set(i, j);
        return nuevasPos;
    }

    /**
     * Regresa la transformacion de una lista de posiciones a un tablero.
     * @param posiciones la lista de posiciones.
     * @return la transformacion de una lista de posiciones a un tablero.
     */
    public Tablero toTablero(List<Integer> posiciones) {
        Tablero tablero = new Tablero(posiciones.size());
        for (int i = 0; i < posiciones.size(); i++) {
            tablero.putReina(i, posiciones.get(i));
        }
        return tablero;
    }


    public List<Integer> simulatedAnnealing() {
        List<Integer> posiciones = generarTablero();
        double temperatura = 1000;
        double enfriamiento = 0.95;
        while (temperatura > 0.1) {
            List<Integer> vecino = vecino(posiciones);
            int colisiones = contarColisiones(toTablero(posiciones));
            int nuevasColisiones = contarColisiones(toTablero(vecino));
            int aux = nuevasColisiones - colisiones;
            if (aux < 0 || Math.random() < Math.exp(-aux / temperatura)) {
                posiciones = vecino;
            }
            temperatura = temperatura * enfriamiento;
        }
        return posiciones;
    }
}
