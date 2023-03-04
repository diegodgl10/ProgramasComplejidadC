import java.util.ArrayList;
import java.util.List;

/**
 * Programa para resolver el problmea 3SAT y Reachability.
 */
public class Programa1 {
    public static void main(String[] args) {
        String instrucciones = "" +
        "-t     para problmea 3Sat\n" +
        "-r     para problema de alcanzabilidad";
        if (args.length == 0) {
            System.out.println(instrucciones);
            return;
        }
        if (args[0].equals("-t")) {
            List<Tripleta<Variable>> clausulas = generateFNC();
            threeSat(clausulas);
            System.out.println();
            return;
        }
        if (args[0].equals("-r")) {
            Grafo grafo = generateGraph();
            reachability(grafo);
            System.out.println();
            return;
        }
    }

    /* Genera una expresion booleana en FNC */
    private static List<Tripleta<Variable>> generateFNC() {
        String abc = "qwertyuiopasdfghjklzxcvbnm";
        String[] abcArray = abc.split("");
        ArrayList<String> literales = new ArrayList<String>();
        while (literales.size() < 10) {
            int tomar = (int) ((Math.random() * (abcArray.length - 1)));
            if (!literales.contains(abcArray[tomar])) {
                literales.add(abcArray[tomar]);
            }
        }
        while (literales.size() < 15) {
            int tomar = (int) ((Math.random() * (literales.size() - 1)));
            String lit = literales.get(tomar);
            literales.add(lit);
        }
        List<Tripleta<Variable>> clausulas = new ArrayList<Tripleta<Variable>>();
        for (int i = 0; i < 5; i++) {
            int tomarX = 0;
            int tomarY = 0;
            int tomarZ = 0;
            while (tomarX >= tomarY || tomarY >= tomarZ) {
                tomarX = (int) ((Math.random() * (literales.size())));
                tomarY = (int) ((Math.random() * (literales.size())));
                tomarZ = (int) ((Math.random() * (literales.size())));
            }
            Variable varX = new Variable(literales.get(tomarX), tomarX % 2 == 0);
            Variable varY = new Variable(literales.get(tomarY), tomarY % 2 == 0);
            Variable varZ = new Variable(literales.get(tomarZ), tomarZ % 2 == 0);
            Tripleta<Variable> tripleta = new Tripleta<Variable>(varX, varY, varZ);
            literales.remove(tomarX);
            literales.remove(tomarY-1);
            literales.remove(tomarZ-2);
            clausulas.add(tripleta);
        }
        return clausulas;
    }

    /* Genera una grafica con 10 <= |V| <= 20 */
    private static Grafo generateGraph() {
        String abc = "qwertyuiopasdfghjklzxcvbnm";
        String[] abcArray = abc.split("");
        ArrayList<String> literales = new ArrayList<String>();
        int tamanio = (int) ((Math.random() * (20 - 10) + 10));
        tamanio = tamanio/2 + 2;
        while (literales.size() < tamanio) {
            int tomar = (int) ((Math.random() * (abcArray.length - 1)));
            if (!literales.contains(abcArray[tomar])) {
                literales.add(abcArray[tomar]);
            }
        }
        List<Vertice> lVertices = new ArrayList<Vertice>();
        List<Arista> lAristas = new ArrayList<Arista>();
        for (String literal : literales) {
            lVertices.add(new Vertice(literal));
        }
        Grafo grafo = new Grafo(lVertices, lAristas);
        for (Vertice vertice : lVertices) {
            int conecciones = (int) ((Math.random() * ((lVertices.size() -1) - 1) + 1));
            while (conecciones != 0) {
                int tomar = (int) ((Math.random() * (lVertices.size() - 2)));
                if (!vertice.equals(lVertices.get(tomar))) {
                    grafo.addArista(new Arista(vertice, lVertices.get(tomar)));
                    conecciones--;
                }
            }
        }
        return grafo;
    }

    /* Ejecuta la solucion para el problema 3SAT. */
    private static void threeSat(List<Tripleta<Variable>> clausulas) {
        ThreeSat tSat = new ThreeSat();
        tSat.solucion(clausulas);
    }

    /* Ejecuta la solucion para el problema Reachability. */
    private static void reachability(Grafo grafo) {
        Reachability reachability = new Reachability();
        List<Vertice> lVertices = grafo.getVertices();
        int tomarS = 0;
        int tomarT = 0;
        while (tomarS == tomarT) {
            tomarS = (int) ((Math.random() * grafo.getVertices().size() - 1));
            tomarT = (int) ((Math.random() * grafo.getVertices().size() - 1));
        }
        Vertice verticeS = lVertices.get(tomarS);
        Vertice verticeT = lVertices.get(tomarT);
        reachability.solucion(grafo, verticeS, verticeT);
    }
}
