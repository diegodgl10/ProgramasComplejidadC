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

    /* Lista de soluciones encontradas. */
    private List<Tablero> soluciones;


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
        this.soluciones = new ArrayList<Tablero>();
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
        this.posiciones = obtenerPosiciones();
        this.soluciones = new ArrayList<Tablero>();
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

    private List<Integer> obtenerPosiciones() {
        this.posiciones = new ArrayList<Integer>();
        for (int i = 0; i < this.tamanio; i++) {
            for (int j = 0; j < this.tamanio; j++) {
                if (this.tablero.hayReina(i, j)) {
                    this.posiciones.add(j);
                }
            }
        }
        return this.posiciones;
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
     * Regresa la lista con las soluciones encontradas.
     * @return la lista con las soluciones encontradas.
     */
    public List<Tablero> getSoluciones() {
        return this.soluciones;
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

    /**
     * Mueve una reina de la solicion (x1,y1) a (x1,y2) y
     * la reina de la posicion (x2,y2) a (x2,y1) y regresa el tablero
     * con el intercambio realizado.
     * @param tablero el tablero sobre el que se realizara el intercambio.
     * @param x1 la fila de la reina 1.
     * @param y1 la columna de la reina 1.
     * @param x2 la fila de la reina 2.
     * @param y2 la columna de la reina 2.
     * @return el tablero con el intercambio realizado.
     */
    public Tablero intercambiarReina(Tablero tablero, int x1, int y1, int x2, int y2) {
        tablero.removeReina(x1, y1);
        tablero.removeReina(x2, y2);
        tablero.putReina(x1, y2);
        tablero.putReina(x2, y1);
        return tablero;
    }

    /**
     * Regresa una lista con los posibles intercambios de posiciones.
     * @param x la fila de la reina para la que se le quieren calcular
     * posibles intercambios.
     * @return una lista con los posibles intercambios de posiciones.
     */
    public List<Dupla<Integer>> generarIntercambios(int x) {
        List<Dupla<Integer>> intercambios = new ArrayList<Dupla<Integer>>();
        for (int i = x+1; i < this.tamanio; i++) {
            intercambios.add(new Dupla<Integer>(i,this.posiciones.get(i)));
        }
        return intercambios;
    }

    public void solucion() {
        int funObjetivo = contarColisiones(this.tablero);
        if (funObjetivo == 0) {
            soluciones.add(new Tablero(this.tablero));
        }
        int sumatoria = (int) ((this.tamanio-1) * ((this.tamanio-1) + 1))/2;
        Integer[][] candidatos = new Integer[sumatoria][4];
        for (int iteracion = 0; iteracion < this.maxiter; iteracion++) {
            for (int i = 0; i < this.tamanio; i++) {
                List<Dupla<Integer>> intercambios = generarIntercambios(i);
                for (Dupla<Integer> dupla : intercambios) {
                    Tablero nuevoT = new Tablero(this.tablero);
                    nuevoT = intercambiarReina(nuevoT, i, this.posiciones.get(i),
                                dupla.getX(), dupla.getY());
                    int colisiones = contarColisiones(nuevoT);
                    candidatos = agregarCandidato(candidatos,
                                dupla.getX(), dupla.getY(), colisiones, i);
                }
            }
            // Actualizamos el estado de uso
            for (int i = 0; i < this.tamanio; i++) {
                for (int j = 0; j < this.tamanio; j++) {
                    if (this.listaTabu[i][j] != null && this.listaTabu[i][j] > 0) {
                        this.listaTabu[i][j] = this.listaTabu[i][j]-1;
                    }
                }
            }
            int bandera = -1;
            for (int i = 0; i < sumatoria; i++) {
                bandera++;
                if (this.listaTabu[candidatos[bandera][0]][candidatos[bandera][1]] == null ||
                this.listaTabu[candidatos[bandera][0]][candidatos[bandera][1]] == 0) {
                    this.listaTabu[candidatos[bandera][0]][candidatos[bandera][1]] = 3;
                    break;
                }
            }

            /*
            for (int h = 0; h < sumatoria; h++) {
                for (int j = 0; j < 4; j++) {
                    System.out.print(candidatos[h][j] +" ");
                }
                System.out.println("");
            }
            */

            int origenX = candidatos[bandera][3];
            int origenY = this.posiciones.get(bandera);
            this.tablero = intercambiarReina(this.tablero, origenX, origenY,
                            candidatos[bandera][0], candidatos[bandera][1]);
            System.out.println(origenX +","+ origenY +","+ candidatos[bandera][0] +","+ candidatos[bandera][1]);
            System.out.println(this.tablero);
            if (contarColisiones(this.tablero) == 0) {
                this.soluciones.add(new Tablero(this.tablero));
            }
            this.posiciones = obtenerPosiciones();
        }
    }

    private Integer[][] agregarCandidato(Integer[][] candidatos, int x, int y,
            int colisiones, int origen) {
        int sumatoria = (int) ((this.tamanio-1) * ((this.tamanio-1) + 1))/2;
        int posicion = -1;
        Integer[][] nuevoCandidatos = new Integer[sumatoria][4];
        for (int i = 0; i < sumatoria; i++) {
            if (candidatos[i][0] == null) {
                posicion = i;
                break;
            }
            if (candidatos[i][2] > colisiones) {
                posicion = i;
                break;
            }
        }
        if (posicion == -1) {
            posicion = sumatoria-1;

        }
        for (int i = 0; i < posicion; i++) {
            nuevoCandidatos[i][0] = candidatos[i][0];
            nuevoCandidatos[i][1] = candidatos[i][1];
            nuevoCandidatos[i][2] = candidatos[i][2];
            nuevoCandidatos[i][3] = candidatos[i][3];
        }

        nuevoCandidatos[posicion][0] = x;
        nuevoCandidatos[posicion][1] = y;
        nuevoCandidatos[posicion][2] = colisiones;
        nuevoCandidatos[posicion][3] = origen;
        
        //int i = posicion+1;
        posicion++;
        while (posicion < sumatoria) {
            nuevoCandidatos[posicion][0] = candidatos[posicion-1][0];
            nuevoCandidatos[posicion][1] = candidatos[posicion-1][1];
            nuevoCandidatos[posicion][2] = candidatos[posicion-1][2];
            nuevoCandidatos[posicion][3] = candidatos[posicion-1][3];
            posicion++;
        }
        return nuevoCandidatos;
    }

    /**
     * Regresa una representacion en cadena.
     * @return una representacion en cadena.
     */
    @Override
    public String toString() {
        String tablero = this.tablero.toString();
        String posiciones = this.posiciones.toString();
        return tablero + "\n" + posiciones;
    }
}
