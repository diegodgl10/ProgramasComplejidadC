import java.util.ArrayList;
import java.util.List;

public class SimulatedAnnealing {

    /* Tamanio del tablero que es igual numero de reinas. */
    private int tamanio;

    /* Tablero. */
    private Tablero tablero;

    /**
     * Constructor que rebice el tamnio de tablero que es igual
     * al numero de rainas.
     * @param tamanio el tamanio del tablero que es igual
     * al numero de rainas.
     */
    public SimulatedAnnealing(int tamanio) {
        this.tamanio = tamanio;
        generarTablero();
    }

     /**
     * El tablero para la busqueda tabu.
     * @param tablero el tablero para la busqueda tabu.
     */
    public SimulatedAnnealing(Tablero tablero) {
        this.tablero = new Tablero(tablero);
        this.tamanio = tablero.getTamanio();
    }


    /* Genera un tablero colocando reinas en posiciones aleatorias. */
    private void generarTablero() {
        List<Integer> posiciones = new ArrayList<Integer>();
        this.tablero = new Tablero(this.tamanio);
        posiciones = new ArrayList<Integer>();
        while (posiciones.size() < this.tamanio) {
            int generado = (int) ((Math.random() * this.tamanio));
            if (!posiciones.contains(generado)) {
                posiciones.add(generado);
            }
        }
        for (int x = 0; x < posiciones.size(); x++) {
            int y = posiciones.get(x);
            this.tablero.putReina(x, y);
        }
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
    private int colisonesDiagonalesDer(Tablero tablero, int x, int y) {
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
}
