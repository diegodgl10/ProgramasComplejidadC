import java.util.ArrayList;
import java.util.List;

/**
 * Clase para resolver el problema de las n-reinas usando la Busqueda Tabu
 * @author Zamora Cruz Diego Arturo.
 */
public class BusquedaTabu {

    /* Tamanio del tablero que es igual numero de reinas. */
    private int tamanio;

    /* Tablero. */
    private Tablero tablero;

    /* Lista con las posiciones en el tablero. */
    private List<Integer> posiciones;

    /* Lista Tabu */
    private Integer[][] listaTabu;

    /* Numero maximo de iteraciones. */
    private int maxiter;


    /**
     * Constructor que rebice el tamnio de tablero que es igual
     * al numero de rainas.
     * @param tamanio el tamanio del tablero que es igual
     * al numero de rainas.
     */
    public BusquedaTabu(int tamanio) {
        this.tamanio = tamanio;
        generarTablero();
        this.listaTabu = new Integer[tamanio][tamanio];
        this.maxiter = (int) (1.5 * tamanio) * 10;
    }

    /**
     * El tablero para la busqueda tabu.
     * @param tablero el tablero para la busqueda tabu.
     */
    public BusquedaTabu(Tablero tablero) {
        this.tablero = tablero;
        this.tamanio = tablero.getTamanio();
        this.listaTabu = new Integer[tamanio][tamanio];
        this.maxiter = (int) (1.5 * this.tamanio) * 10;
    }

    /* Genera un tablero colocando reinas en posiciones aleatorias. */
    private void generarTablero() {
        this.tablero = new Tablero(this.tamanio);
        this.posiciones = new ArrayList<Integer>();
        while (this.posiciones.size() < this.tamanio) {
            int generado = (int) ((Math.random() * this.tamanio));
            if (!this.posiciones.contains(generado)) {
                this.posiciones.add(generado);
            }
        }
        for (int x = 0; x < this.posiciones.size(); x++) {
            int y = this.posiciones.get(x);
            this.tablero.putReina(x, y);
        }
    }

    /**
     * Regresa el tablero.
     * @return el tablero.
     */
    public Tablero getTablero() {
        return this.tablero;
    }

    /**
     * Regresa la cantidad maxima de iteraciones.
     * @return la cantidad maxima de iteraciones.
     */
    public int getMaxiter() {
        return maxiter;
    }

    /**
     * Define una nueva cantidad maxima de iteraciones.
     * @param maxiter una nueva cantidad maxima de iteraciones.
     */
    public void setMaxiter(int maxiter) {
        this.maxiter = maxiter;
    }

    /**
     * Regresa la lista tabu.
     * @return la lista tabu.
     */
    public Integer[][] getListaTabu() {
        return this.listaTabu;
    }

    /**
     * Regresa el numero de colisiones que existen
     * con la configuracion actual.
     * @return el numero de colisiones que existen
     * con la configuracion actual.
     */
    public int contarColisiones() {
        int colisiones = 0;
        for (int i = 0; i < this.tamanio; i++) {
            for (int j = 0; j < this.tamanio; j++) {
                if (this.tablero.hayReina(i, j)) {
                    int colVerticales = colisonesVerticales(i, j);
                    int colDiagonalesIzq = colisonesDiagonalesIzq(i, j);
                    int colDiagonalesDer = colisonesDiagonalesDer(i, j);

                    System.out.println(colVerticales+","+colDiagonalesIzq+","+colDiagonalesDer);

                    colisiones += colVerticales + colDiagonalesIzq + colDiagonalesDer;
                }
            }
        }
        return colisiones;
    }

    /* Colisiones vertiales. */
    private int colisonesVerticales(int x, int y) {
        int contador = 0;
        for (int i = x+1; i < this.tamanio; i++) {
            if (this.tablero.hayReina(i, y)) {
                contador++;
            }
        }
        return contador;
    }

    /* Colisiones diagonales del lado izquierdo. */
    private int colisonesDiagonalesIzq(int x, int y) {
        int i = x+1;
        int j = y-1;
        int contador = 0;
        while (i < this.tamanio && j >= 0) {
            if (this.tablero.hayReina(i++, j--)) {
                contador++;
            }
        }
        return contador;
    }
    
    /* Colisiones diagonales del lado derecho. */
    private int colisonesDiagonalesDer(int x, int y) {
        int i = x+1;
        int j = y+1;
        int contador = 0;
        while (i < this.tamanio && j < this.tamanio) {
            if (this.tablero.hayReina(i++, j++)) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Regresa una representacion en cadena.
     * @return una representacion en cadena.
     */
    @Override
    public String toString() {
        String tablero = this.tablero.toString();
        String posiciones = this.posiciones.toString();
        return tablero + "\n\n" + posiciones;
    }
}
