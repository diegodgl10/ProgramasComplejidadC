import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Clase para dar una solucion aproximada para el problema Set Cover con la estrategia
 * de Greedy.
 * @author Zamora Cruz Diego Arturo.
 */
public class SetCover {
    
    /**
     * Ejecuta el algoritmo de aproximacion Greedy para el problema Set Cover.
     * @param cjtX conjunto X con los elementos del universo de discurso.
     * @param cjtF conjunto de sub-conjuntos de X.
     * @return regresa una solucion aproximada para el problema Set Cover.
     */
    public Conjunto<Conjunto<String>> setCover(Conjunto<String> cjtX,
            Conjunto<Conjunto<String>> cjtF) {
        Conjunto<String> cjtU = new Conjunto<String>("X", cjtX);
        Conjunto<Conjunto<String>> cjtC = new Conjunto<Conjunto<String>>("C");

        while (!cjtU.esVacio()) {
            Conjunto<String> cjtS = maximizeS(cjtF, cjtU);
            cjtU = cjtU.diferencia(cjtS);
            cjtU.setNombre("U");
            List<Conjunto<String>> aux = new ArrayList<Conjunto<String>>(Arrays.asList(cjtS));
            Conjunto<Conjunto<String>> cjtAux = new Conjunto<Conjunto<String>>("S", aux);
            cjtC = cjtC.union(cjtAux);
        }
        cjtC.setNombre("C");
        return cjtC;
    }

    /* Funcion para encontrar el conjunto de F que maximiza |S n U| */
    private Conjunto<String> maximizeS(Conjunto<Conjunto<String>> cjtF, Conjunto<String> cjtU) {
        List<Conjunto<String>> elemDeF = cjtF.getElementos();
        Conjunto<String> cjtMayor = elemDeF.get(0).interseccion(cjtU);
        cjtMayor.setNombre(elemDeF.get(0).getNombre());
        int cardMayor =  cjtMayor.cardinalidad();
        for (Conjunto<String> cjtS : elemDeF) {
            Conjunto<String> interseccion = cjtS.interseccion(cjtU);
            interseccion.setNombre(cjtS.getNombre());
            int cardinalidad = interseccion.cardinalidad();
            if (cardinalidad > cardMayor) {
                cjtMayor = interseccion;
                cardMayor = cardinalidad;
            }
        }
        return cjtMayor;
    }
}
