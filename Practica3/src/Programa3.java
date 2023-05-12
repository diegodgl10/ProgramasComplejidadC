// import java.util.Scanner;

/**
 * Programa para resolver el problmea de las N-Reinas usando las MetaHuristicas .
 */
public class Programa3 {
    public static void main(String[] args) {
        pruebaVertical();
    }

    private static void pruebaVertical() {
        Tablero tab1 = new Tablero(5);
        tab1.putReina(2, 2);
        System.out.println(tab1);
        System.out.println(tab1.esDisponible(4, 0));
        tab1.putReina(4, 0);
        System.out.println(tab1);
        
    }
}
