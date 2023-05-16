import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Programa para resolver el problmea de las N-Reinas usando las MetaHuristicas .
 */
public class Programa3 {

    public static Tablero tableroPruebas() {
        Tablero tab = new Tablero(7);
        tab.putReina(0, 3);
        tab.putReina(1, 4);
        tab.putReina(2, 2);
        tab.putReina(3, 5);
        tab.putReina(4, 6);
        tab.putReina(5, 0);
        tab.putReina(6, 1);
        return tab;
    }

    public static void pruebasTabu() {
        Tablero tab = tableroPruebas();
        System.out.println(tab.toString());
        BusquedaTabu bTabu = new BusquedaTabu(tab);
        //System.out.println(bTabu.contarColisiones());
        bTabu.solucion();
        List<Tablero> soluciones = bTabu.getSoluciones();
        for (int i = 0; i < soluciones.size(); i++) {
            System.out.println(soluciones.get(i));
        }
        //System.out.println(bTabu.generarIntercambios(0).size());

        /*
        int tamanio = 7;
        BusquedaTabu tabu;
        for (int i = 0; i < tamanio; i++) {
            tabu = new BusquedaTabu(tamanio);
            System.out.println(tabu.toString() + "\n\n\n");
        }
        */
    }

    public static void main(String[] args) {
       ejecucionPrograma();        
    }

    /* Arraca el programa para el problema de las n reinas. */
    private static void ejecucionPrograma() {
        Scanner sc = new Scanner(System.in);
        String entrada;
        System.out.println("1 Busqueda Tabu");
        System.out.println("2 Simulated Annealing");
        System.out.println("0 Salir");
        System.out.print("> ");
        entrada = sc.nextLine();
        int algoritmo = validarInt(entrada);
        if (algoritmo < 1 || algoritmo > 2) {
            if (algoritmo != 0) {
                System.out.println("Entrada no valida");
            }
            sc.close();
            return;
        }
        System.out.print("Tamanio: ");
        entrada = sc.nextLine();
        int tamanio = validarInt(entrada);
        if (tamanio <= 0) {
            System.out.println("Entrada no valida");
            sc.close();
            return;
        }
        if (algoritmo == 1) {
            solucionBusquedaTabu(tamanio);
        } else {
            solucionSimulatedAnnealing(tamanio);
        }
        sc.close();
    }

    /* Solucion haciendo uso de Busqueda Tabu. */
    private static void solucionBusquedaTabu(int tamanio) {
        
    }
    
    /* Solucion haciendo uso de Simulated Annealing. */
    private static void solucionSimulatedAnnealing(int tamanio) {
        SimulatedAnnealing sA = new SimulatedAnnealing(tamanio);
        List<Integer> inicio = sA.generarTablero();
        Tablero tabInicio = sA.toTablero(inicio);
        String estado = "\nTablero inicial:\n" + tabInicio.toString();
        System.out.println(estado);
        List<Integer> fin = sA.simulatedAnnealing(inicio);
        Tablero tabFin = sA.toTablero(fin);
        estado = "\nTablero final:\n" + tabFin.toString();
        System.out.println(estado);
        //estado = "Iteraciones:" + sA.getIteraciones();
        //System.out.println(estado);
    }

    /* Valida si la entrada recibida es un entero. */
    public static int validarInt(String entrada) {
        int valor;
        try {
           valor = Integer.parseInt(entrada);
        }
        catch (NumberFormatException e) {
           valor = -1;
        }
        return valor;
    }
}
