/**
 * Clase para representar un tablero de n x n para el problema de
 * las n-reinas.
 * @author Zamora Cruz Diego Arturo
 */
public class Tablero {
    
    /* Tamanio del tablero. */
    private int tamanio;
    /* Arreglo para simular el tablero. */
    private String[][] tablero;
    /* Representacion en cadena de una reina. */
    private final String reina = "☗";

    /**
     * Constructor que recibe el tamanio del tablero como parametro.
     * @param tamanio el tamanio del tablero.
     */
    public Tablero(int tamanio) {
        this.tamanio = tamanio;
        this.tablero = new String[tamanio][tamanio];
        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                this.tablero[i][j] = " ";
            }
        }
    }

    /**
     * Constructor que recibe otro tablero como parametro.
     * @param tablero el tablero con el cual se definira uno nuevo.
    */
    public Tablero(Tablero tablero) {
        this.tamanio = tablero.tamanio;
        this.tablero = new String[this.tamanio][this.tamanio];
        for (int i = 0; i < this.tamanio; i++) {
            for (int j = 0; j < this.tamanio; j++) {
                this.tablero[i][j] = tablero.tablero[i][j];
            }
        }
    }

    /**
     * Constructor vacio.
     */
    public Tablero() {

    }

    /**
     * Regresa el tamanio del tablero.
     * @return el tamanio del tablero.
     */
    public int getTamanio() {
        return this.tamanio;
    }

    /**
     * Regresa una matriz que representa el tablero.
     * @return una matriz que representa el tablero.
     */
    public String[][] getTablero() {
        return this.tablero;
    }

    /**
     * Pone una reina en la posicion (x,y)
     * @param x la fila en la que se pondra la reina.
     * @param y la columna en la que se pondra la reina.
     */
    public void putReina(int x, int y) {
        this.tablero[x][y] = this.reina;
    }

    /**
     * Quita una reina de la posicion (x,y)
     * @param x la fila en la que se quitara la reina.
     * @param y la columna en la que se quitara la reina.
     */
    public void removeReina(int x, int y) {
        this.tablero[x][y] = " ";
    }

    /**
     * Regresa <code>True</code> si colocal una nueva reina en la
     * posicion (x,y) no alcanza a ninguna otra, <code>False</code> en
     * otro caso.
     * @param x la fila en la que se quiere poner a una reina.
     * @param y la columna en la que se quiere poner a una reina.
     * @return <code>True</code> si colocal una nueva reina en la
     * posicion (x,y) no alcanza a ninguna otra, <code>False</code> en
     * otro caso.
     */
    public boolean esDisponible(int x, int y) {
        if (this.tablero[x][y].equals(this.reina)) {
            return true;
        }

        boolean libVertical = libVertical(x, y);
        boolean libHorizontal = libHorizontal(x, y);
        boolean libDiagonalAsc = libDiagonalAsc(x, y);
        boolean libDiagonalDes = libDiagonalDes(x, y);
        boolean libDiagonal = libDiagonalAsc && libDiagonalDes;

        return libVertical && libHorizontal && libDiagonal;
    }

    /* Verifica si a lo vertical no alacanza a ninguna reina. */
    private boolean libVertical(int x, int y) {
        for (int i = 0; i < this.tamanio; i++) {
            if (this.tablero[i][y].equals(this.reina)) {
                return false;
            }
        }
        return true;
    }

    /* Verifica si a lo horizontal no alacanza a ninguna reina. */
    private boolean libHorizontal(int x, int y) {
        for (int i = 0; i < this.tamanio; i++) {
            if (this.tablero[x][i].equals(this.reina)) {
                return false;
            }
        }
        return true;
    }

    /* Verifica si en la diagonal ascende no alacanza a ninguna reina. */
    private boolean libDiagonalAsc(int x, int y) {
        int i = x;
        int j = y;
        while (i < this.tamanio && j >= 0) {
            if (this.tablero[i++][j--].equals(this.reina)) {
                return false;
            }
        }
        i = x;
        j = y;
        while (i >= 0 && j < this.tamanio) {
            if (this.tablero[i--][j++].equals(this.reina)) {
                return false;
            }
        }
        return true;
    }

    /* Verifica si en la diagonal descente no alacanza a ninguna reina. */
    private boolean libDiagonalDes(int x, int y) {
        int i = x;
        int j = y;
        while (i < this.tamanio && j < this.tamanio) {
            if (this.tablero[i++][j++].equals(this.reina)) {
                return false;
            }
        }
        i = x;
        j = y;
        while (i >= 0 && j >= 0) {
            if (this.tablero[i--][j--].equals(this.reina)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Regresa <code>True</code> si el objeto que manda a llamar al metodo
     * es igual al objeto recibido, <code>false</code> en otro caso.
     * @return <code>True</code> si el objeto que manda a llamar al metodo
     * es igual al objeto recibido, <code>false</code> en otro caso.
     */
    @Override
    public boolean equals(Object objeto) {
        if (objeto == null) {
            return false;
        }
        if (!(objeto instanceof Tablero)) {
            return false;
        }
        Tablero tab = (Tablero) objeto;
        if (this.tamanio != tab.tamanio) {
            return false;
        }
        for (int i = 0; i < this.tamanio; i++) {
            for (int j = 0; j < this.tamanio; j++) {
                if (!this.tablero[i][j].equals(tab.tablero[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Regresa una representacion en cadena del tablero.
     * @return una representacion en cadena del tablero.
     */
    @Override
    public String toString() {
        String cadena = generarLinea(true) + "\n";
        for (int i = 0; i < this.tamanio; i++) {
            cadena += "|";
            for (int j = 0; j < this.tamanio; j++) {
                cadena += " " + this.tablero[i][j] + " ";
                cadena += "|";
            }
            cadena += "\n";
            if (i < this.tamanio-1) {
                cadena += generarLinea(false);
                cadena += "\n";
            }
        }
        cadena += generarLinea(true);
        return cadena;
    }

    /* Ayuda a generar una representacion en cadena del tablero. */
    private String generarLinea(boolean extremo) {
        String linea = "|";
        String threeL = "---";
        for (int i = 0; i < this.tamanio; i++) {
            linea += threeL;
            if (i < this.tamanio-1) {
                if (extremo) {
                    linea += "-";
                } else {
                    linea += "+";
                }
            }
        }
        linea += "|";
        if (extremo) {
            linea = linea.replace("|", "+");
        }
        return linea;
    }
}
