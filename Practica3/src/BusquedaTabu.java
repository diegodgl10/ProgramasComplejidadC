import java.util.ArrayList;
import java.util.List;

/**
 * Clase para resolver el problema de las n-reinas usando la Busqueda Tabu
 * @author Zamora Cruz Diego Arturo.
 */
public class BusquedaTabu {

    /* Tamanio del tablero que es igual numero de reinas. */
    private int tamanio;

    /* Lista con las posiciones en el tablero. */
    private List<Integer> posiciones;

    /* Lista Tabu */
    private Integer[][] listaTabu;

    /* Numero maximo de iteraciones. */
    private int maxiter;

    /* Lista de soluciones encontradas. */
    private List<List<Integer>> soluciones;


    /**
     * Constructor que rebice el tamnio de tablero que es igual
     * al numero de rainas.
     * @param tamanio el tamanio del tablero que es igual
     * al numero de rainas.
     */
    public BusquedaTabu(int tamanio) {
        this.tamanio = tamanio;
        this.listaTabu = new Integer[tamanio][tamanio];
        this.maxiter = (int) (1.5 * tamanio) * 10;
        this.soluciones = new ArrayList<List<Integer>>();
    }

    /**
     * El tablero para la busqueda tabu.
     * @param tablero el tablero para la busqueda tabu.
     */
    public BusquedaTabu(Tablero tablero) {
        this.tamanio = tablero.getTamanio();
        for (int i = 0; i < this.tamanio; i++) {
            for (int j = 0; j < this.tamanio; j++) {
                if (tablero.hayReina(i, j)) {
                    this.posiciones.add(j);
                }
            }
        }
        this.listaTabu = new Integer[this.tamanio][this.tamanio];
        this.maxiter = (int) (1.5 * this.tamanio) * 10;
        this.soluciones = new ArrayList<List<Integer>>();
    }

    /**
     * Regresa una lista con las posiciones de las reinas
     * que representan un tablero aleatorio.
     * @return una lista con las posiciones de las reinas
     * que representan un tablero aleatorio. 
     */
    public List<Integer> generarTablero() {
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
    public List<List<Integer>> getSoluciones() {
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

    /**
     * Regresa una lista con los posibles intercambios de posiciones.
     * @param x la fila de la reina para la que se le quieren calcular
     * posibles intercambios.
     * @return una lista con los posibles intercambios de posiciones.
     */
    public List<Dupla<Integer>> generarIntercambios(int x, List<Integer> posiciones) {
        List<Dupla<Integer>> intercambios = new ArrayList<Dupla<Integer>>();
        for (int i = x+1; i < this.tamanio; i++) {
            intercambios.add(new Dupla<Integer>(i, posiciones.get(i)));
        }
        return intercambios;
    }

    /**
     * Regresa una lista con las posiciones de las reinas despues
     * de aplicar el algoritmos de la metauristica Busqueda Tabu.
     * @return una lista con las posiciones de las reinas despues
     * de aplicar el algoritmos de la metauristica Busqueda Tabu.
     */
    public List<Integer> busquedaTabu(List<Integer> posiciones) {
        int funObjetivo = contarColisiones(toTablero(posiciones));
        List<Integer> salida = posiciones;
        if (funObjetivo == 0) {
            soluciones.add(posiciones);
        }
        int sumatoria = (int) ((this.tamanio-1) * ((this.tamanio-1) + 1))/2;
        Integer[][] candidatos = new Integer[sumatoria][4];
        for (int iteracion = 0; iteracion < this.maxiter; iteracion++) {
            for (int i = 0; i < this.tamanio; i++) {
                List<Dupla<Integer>> intercambios = generarIntercambios(i, posiciones);
                for (Dupla<Integer> dupla : intercambios) {
                    List<Integer> nuevasPos = new ArrayList<Integer>(posiciones);
                    int aux = nuevasPos.get(i);
                    nuevasPos.set(i, dupla.getY());
                    nuevasPos.set(dupla.getX(), aux);
                    int colisiones = contarColisiones(toTablero(nuevasPos));
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
            // Buscamos el mas optimo que no haya sido usado en 3 iteraciones
            int bandera = -1;
            for (int i = 0; i < sumatoria; i++) {
                bandera++;
                if (this.listaTabu[candidatos[bandera][0]][candidatos[bandera][1]] == null ||
                this.listaTabu[candidatos[bandera][0]][candidatos[bandera][1]] == 0) {
                    this.listaTabu[candidatos[bandera][0]][candidatos[bandera][1]] = 3;
                    break;
                }
            }
            int origenX = candidatos[bandera][3];
            int origenY = posiciones.get(bandera);
            List<Integer> nuevasPos = new ArrayList<Integer>(posiciones);
            nuevasPos.set(origenX, candidatos[bandera][1]);
            nuevasPos.set(candidatos[bandera][0], origenY);
            posiciones = nuevasPos;
            if (contarColisiones(toTablero(nuevasPos)) == 0 &&
                    !this.soluciones.contains(nuevasPos)) {
                this.soluciones.add(posiciones);
            }
            if (contarColisiones(toTablero(nuevasPos)) <= funObjetivo) {
                funObjetivo = contarColisiones(toTablero(nuevasPos));
                salida = nuevasPos;
            }
        }
        return salida;
    }

    /* Agrega un candidato de forma ordenada al arreglo de candidatos. */
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
}
