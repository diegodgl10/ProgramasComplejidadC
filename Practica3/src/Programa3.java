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
        List<Integer> posiciones = new ArrayList<Integer>();
        posiciones = new ArrayList<Integer>();
        while (posiciones.size() < 7) {
            int generado = (int) ((Math.random() * 7));
            if (!posiciones.contains(generado)) {
                posiciones.add(generado);
            }
        }
        System.out.println(posiciones);
        List<Integer> posiciones2 = new ArrayList<Integer>(posiciones);
        System.out.println(posiciones2);
        posiciones.set(0, -1);
        System.out.println(posiciones);
        System.out.println(posiciones2);

        
    }

    public static void ejecucionPrograma() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Tamanio: ");
        String entrada = sc.nextLine();
        int tamanio = validarInt(entrada);
        if (tamanio <= 0) {
            System.out.println("Entrada no valida");
            //return;
        }

        sc.close();
    }

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
