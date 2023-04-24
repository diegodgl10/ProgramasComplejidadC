import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Clase para realiza pruebas para el algoritmo Set Cover.
 * @author Zamora Cruz Diego Arturo.
 */
public class Pruebas {

    Conjunto<String> cjt1 = new Conjunto<String>("S1");
    Conjunto<String> cjt2 = new Conjunto<String>("S2");
    Conjunto<String> cjt3 = new Conjunto<String>("S3");
    Conjunto<String> cjt4 = new Conjunto<String>("S4");
    Conjunto<String> cjt5 = new Conjunto<String>("S5");
    Conjunto<String> cjt6 = new Conjunto<String>("S6");
    Conjunto<String> cjt7 = new Conjunto<String>("S7");

    Conjunto<String> cjtX = new Conjunto<String>("X");
    Conjunto<Conjunto<String>> cjtF = new Conjunto<Conjunto<String>>("F");

    SetCover setCover = new SetCover();
    
    /**
     * Prueba numero 1
     */
    public void prueba1() {
        List<String> elemX;
        elemX = new ArrayList<String>(Arrays.asList("1","2","3","4","5","6",
                "7","8","9","10","11","12"));
        cjtX.setElementos(elemX);


        List<String> elem1 = new ArrayList<String>(Arrays.asList("1","2","3","4","5","6"));
        cjt1.setElementos(elem1);
        List<String> elem2 = new ArrayList<String>(Arrays.asList("5","6","8","9"));
        cjt2.setElementos(elem2);
        List<String> elem3 = new ArrayList<String>(Arrays.asList("1","4","7","10"));
        cjt3.setElementos(elem3);
        List<String> elem4 = new ArrayList<String>(Arrays.asList("2","5","7","8","11"));
        cjt4.setElementos(elem4);
        List<String> elem5 = new ArrayList<String>(Arrays.asList("3","6","9","12"));
        cjt5.setElementos(elem5);
        List<String> elem6 = new ArrayList<String>(Arrays.asList("10","11"));
        cjt6.setElementos(elem6);


        List<Conjunto<String>> elemF;
        elemF = new ArrayList<Conjunto<String>>(Arrays.asList(cjt1,cjt2,cjt3,cjt4,cjt5,cjt6));
        cjtF.setElementos(elemF);

        setCover.setCover(cjtX, cjtF);
    }
}
