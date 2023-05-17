// import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Programa para resolver el problmea de las N-Reinas usando las MetaHuristicas .
 */
public class Programa3 {

    /* Metodo para crear un tablero de pruebas. */
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

    public static void main(String[] args) {
       ejecucionPrograma();        
    }

    /* Arraca el programa para el problema de las n reinas. */
    private static void ejecucionPrograma() {
        Scanner sc = new Scanner(System.in);
        String entrada;
        System.out.println("1 Busqueda Tabu");
        System.out.println("2 Recocido Simulado");
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
            solucionRecocidoSimulado(tamanio);
        }
        sc.close();
    }

    /* Solucion haciendo uso de Busqueda Tabu. */
    private static void solucionBusquedaTabu(int tamanio) {
        BusquedaTabu busquedaTabu = new BusquedaTabu(tamanio);
        String estado;
        List<Integer> inicio = busquedaTabu.generarTablero();
        Tablero tabInicio = busquedaTabu.toTablero(inicio);
        estado = "\nTablero inicial:\n" + tabInicio.toString();
        estado += "\nColisiones: " + busquedaTabu.contarColisiones(tabInicio);
        System.out.println(estado);
        List<Integer> fin = busquedaTabu.busquedaTabu(inicio);        
        Tablero tabFin = busquedaTabu.toTablero(fin);
        estado = "\nTablero final:\n" + tabFin.toString();
        estado += "\nColisiones: " + busquedaTabu.contarColisiones(tabFin);
        estado += "\nIteraciones: " + busquedaTabu.getMaxiter();
        System.out.println(estado);
        List<List<Integer>> soluciones = busquedaTabu.getSoluciones();
        if (soluciones.size() > 0) {
            System.out.println("Soluciones exactas");
        }
        for (int i = 0; i < soluciones.size(); i++) {
            System.out.println("Solucion " + (i+1));
            Tablero tabTemp = busquedaTabu.toTablero(soluciones.get(i));
            System.out.println(tabTemp.toString());
        }
    }
    
    /* Solucion haciendo uso de Recocido Simulado. */
    private static void solucionRecocidoSimulado(int tamanio) {
        RecocidoSimulado recocidoSimulado = new RecocidoSimulado(tamanio);
        String estado;
        List<Integer> inicio = recocidoSimulado.generarTablero();
        Tablero tabInicio = recocidoSimulado.toTablero(inicio);
        estado = "\nTablero inicial:\n" + tabInicio.toString();
        estado += "\nColisiones: " + recocidoSimulado.contarColisiones(tabInicio);
        System.out.println(estado);
        List<Integer> fin = recocidoSimulado.recocidoSimulado(inicio);
        Tablero tabFin = recocidoSimulado.toTablero(fin);
        estado = "\nTablero final:\n" + tabFin.toString();
        estado += "\nColisiones: " + recocidoSimulado.contarColisiones(tabFin);
        estado += "\nIteraciones: " + recocidoSimulado.getIteraciones();
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
