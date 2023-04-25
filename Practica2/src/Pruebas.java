import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Clase para realiza pruebas para el algoritmo Set Cover.
 * @author Zamora Cruz Diego Arturo.
 */
public class Pruebas {

    private Conjunto<String> cjt1 = new Conjunto<String>("S1");
    private Conjunto<String> cjt2 = new Conjunto<String>("S2");
    private Conjunto<String> cjt3 = new Conjunto<String>("S3");
    private Conjunto<String> cjt4 = new Conjunto<String>("S4");
    private Conjunto<String> cjt5 = new Conjunto<String>("S5");
    private Conjunto<String> cjt6 = new Conjunto<String>("S6");
    private Conjunto<String> cjt7 = new Conjunto<String>("S7");

    private Conjunto<String> cjtX = new Conjunto<String>("X");
    private Conjunto<Conjunto<String>> cjtF = new Conjunto<Conjunto<String>>("F");

    private SetCover setCover = new SetCover();

    private String salida = "";

    /**
     * Constructor vacio.
     */
    public Pruebas() {

    }
    
    /**
     * Prueba numero 1
     * @retunr una representacion en cadena la prueba 1
     */
    public String prueba1() {
        List<String> elemX;
        elemX = new ArrayList<String>(Arrays.asList("1","2","3","4","5","6",
                "7","8","9","10","11","12"));
        cjtX.setElementos(elemX);


        List<String> elem1;
        elem1 = new ArrayList<String>(Arrays.asList("1","2","3","4","5","6"));
        cjt1.setElementos(elem1);
        List<String> elem2;
        elem2 = new ArrayList<String>(Arrays.asList("5","6","8","9"));
        cjt2.setElementos(elem2);
        List<String> elem3;
        elem3 = new ArrayList<String>(Arrays.asList("1","4","7","10"));
        cjt3.setElementos(elem3);
        List<String> elem4;
        elem4 = new ArrayList<String>(Arrays.asList("2","5","7","8","11"));
        cjt4.setElementos(elem4);
        List<String> elem5;
        elem5 = new ArrayList<String>(Arrays.asList("3","6","9","12"));
        cjt5.setElementos(elem5);
        List<String> elem6;
        elem6 = new ArrayList<String>(Arrays.asList("10","11"));
        cjt6.setElementos(elem6);

        List<Conjunto<String>> elemF;
        elemF = new ArrayList<Conjunto<String>>(Arrays.asList(cjt1,cjt2,cjt3,cjt4,cjt5,cjt6));
        cjtF.setElementos(elemF);

        salida = cjtX.toString() + "\n";
        salida += "F = {" + "\n";
        salida += "\t" + cjt1.toString() + "\n";
        salida += "\t" + cjt2.toString() + "\n";
        salida += "\t" + cjt3.toString() + "\n";
        salida += "\t" + cjt4.toString() + "\n";
        salida += "\t" + cjt5.toString() + "\n";
        salida += "\t" + cjt6.toString() + "\n";
        salida += "}" + "\n";
        salida += setCover.setCover(cjtX, cjtF).toString();
        
        return salida;
    }

    /**
     * Prueba numero 2
     * @retunr una representacion en cadena la prueba 2
     */
    public String prueba2() {
        List<String> elemX;
        elemX = new ArrayList<String>(Arrays.asList("1","2","3","4","5","6",
                "7","8","9","10","11","12"));
        cjtX.setElementos(elemX);

        List<String> elem1;
        elem1 = new ArrayList<String>(Arrays.asList("1","2","3"));
        cjt1.setElementos(elem1);
        List<String> elem2;
        elem2 = new ArrayList<String>(Arrays.asList("5","6","8","9","11","12"));
        cjt2.setElementos(elem2);
        List<String> elem3;
        elem3 = new ArrayList<String>(Arrays.asList("1","4","7","10"));
        cjt3.setElementos(elem3);
        List<String> elem4;
        elem4 = new ArrayList<String>(Arrays.asList("2","5","7","8","9","11"));
        cjt4.setElementos(elem4);
        List<String> elem5;
        elem5 = new ArrayList<String>(Arrays.asList("3","6","9","12"));
        cjt5.setElementos(elem5);

        List<Conjunto<String>> elemF;
        elemF = new ArrayList<Conjunto<String>>(Arrays.asList(cjt1,cjt2,cjt3,cjt4,cjt5));
        cjtF.setElementos(elemF);

        salida = cjtX.toString() + "\n";
        salida += "F = {" + "\n";
        salida += "\t" + cjt1.toString() + "\n";
        salida += "\t" + cjt2.toString() + "\n";
        salida += "\t" + cjt3.toString() + "\n";
        salida += "\t" + cjt4.toString() + "\n";
        salida += "\t" + cjt5.toString() + "\n";
        salida += "}" + "\n";
        salida += setCover.setCover(cjtX, cjtF).toString();

        return salida;
    }

    /**
     * Prueba numero 3
     * @retunr una representacion en cadena la prueba 3
     */
    public String prueba3() {
        List<String> elemX;
        elemX = new ArrayList<String>(Arrays.asList("1","2","3","4","5","6",
                "7","8","9","10","11","12"));
        cjtX.setElementos(elemX);

        List<String> elem1;
        elem1 = new ArrayList<String>(Arrays.asList("1","2","3"));
        cjt1.setElementos(elem1);
        List<String> elem2;
        elem2 = new ArrayList<String>(Arrays.asList("1","4","7","10"));
        cjt2.setElementos(elem2);
        List<String> elem3;
        elem3 = new ArrayList<String>(Arrays.asList("10","11","12"));
        cjt3.setElementos(elem3);
        List<String> elem4;
        elem4 = new ArrayList<String>(Arrays.asList("3","6","9","12"));
        cjt4.setElementos(elem4);
        List<String> elem5;
        elem5 = new ArrayList<String>(Arrays.asList("4","5","6","7","8","9"));
        cjt5.setElementos(elem5);
        List<String> elem6;
        elem6 = new ArrayList<String>(Arrays.asList("2","5","8","11"));
        cjt5.setElementos(elem6);

        List<Conjunto<String>> elemF;
        elemF = new ArrayList<Conjunto<String>>(Arrays.asList(cjt1,cjt2,cjt3,cjt4,cjt5,cjt6));
        cjtF.setElementos(elemF);

        salida = cjtX.toString() + "\n";
        salida += "F = {" + "\n";
        salida += "\t" + cjt1.toString() + "\n";
        salida += "\t" + cjt2.toString() + "\n";
        salida += "\t" + cjt3.toString() + "\n";
        salida += "\t" + cjt4.toString() + "\n";
        salida += "\t" + cjt5.toString() + "\n";
        salida += "\t" + cjt6.toString() + "\n";
        salida += "}" + "\n";
        salida += setCover.setCover(cjtX, cjtF).toString();

        return salida;
    }


    /**
     * Prueba numero 4
     * @retunr una representacion en cadena la prueba 4
     */
    public String prueba4() {
        List<String> elemX;
        elemX = new ArrayList<String>(Arrays.asList("1","2","3","4","5","6","7","8",
                "9","10","11","12","13","14","15","16"));
        cjtX.setElementos(elemX);

        List<String> elem1;
        elem1 = new ArrayList<String>(Arrays.asList("1","2","3","4","5","6","7","8"));
        cjt1.setElementos(elem1);
        List<String> elem2;
        elem2 = new ArrayList<String>(Arrays.asList("7","8","11","12"));
        cjt2.setElementos(elem2);
        List<String> elem3;
        elem3 = new ArrayList<String>(Arrays.asList("4","8","12","16"));
        cjt3.setElementos(elem3);
        List<String> elem4;
        elem4 = new ArrayList<String>(Arrays.asList("6","7","10","11","14","15"));
        cjt4.setElementos(elem4);
        List<String> elem5;
        elem5 = new ArrayList<String>(Arrays.asList("13","14"));
        cjt5.setElementos(elem5);
        List<String> elem6;
        elem6 = new ArrayList<String>(Arrays.asList("1","5","9","13"));
        cjt6.setElementos(elem6);

        List<Conjunto<String>> elemF;
        elemF = new ArrayList<Conjunto<String>>(Arrays.asList(cjt1,cjt2,cjt3,cjt4,cjt5,cjt6));
        cjtF.setElementos(elemF);

        salida = cjtX.toString() + "\n";
        salida += "F = {" + "\n";
        salida += "\t" + cjt1.toString() + "\n";
        salida += "\t" + cjt2.toString() + "\n";
        salida += "\t" + cjt3.toString() + "\n";
        salida += "\t" + cjt4.toString() + "\n";
        salida += "\t" + cjt5.toString() + "\n";
        salida += "\t" + cjt6.toString() + "\n";
        salida += "}" + "\n";
        salida += setCover.setCover(cjtX, cjtF).toString();

        return salida;
    }

    /**
     * Prueba numero 5
     * @retunr una representacion en cadena la prueba 5
     */
    public String prueba5() {
        List<String> elemX;
        elemX = new ArrayList<String>(Arrays.asList("1","2","3","4","5","6","7","8",
                "9","10","11","12","13","14","15","16"));
        cjtX.setElementos(elemX);

        List<String> elem1;
        elem1 = new ArrayList<String>(Arrays.asList("1","2","5","6"));
        cjt1.setElementos(elem1);
        List<String> elem2;
        elem2 = new ArrayList<String>(Arrays.asList("1","2","3","5","6","7","9","10","11"));
        cjt2.setElementos(elem2);
        List<String> elem3;
        elem3 = new ArrayList<String>(Arrays.asList("11","12","15","16"));
        cjt3.setElementos(elem3);
        List<String> elem4;
        elem4 = new ArrayList<String>(Arrays.asList("6","7","8","10","11","12","14","15","16"));
        cjt4.setElementos(elem4);
        List<String> elem5;
        elem5 = new ArrayList<String>(Arrays.asList("9","13","14"));
        cjt5.setElementos(elem5);
        List<String> elem6;
        elem6 = new ArrayList<String>(Arrays.asList("3","4","7","8"));
        cjt6.setElementos(elem6);
        List<String> elem7;
        elem7 = new ArrayList<String>(Arrays.asList("6","7","10","11"));
        cjt7.setElementos(elem7);

        List<Conjunto<String>> elemF;
        elemF = new ArrayList<Conjunto<String>>(Arrays.asList(cjt1,cjt2,cjt3,cjt4,cjt5,cjt6,cjt7));
        cjtF.setElementos(elemF);

        salida = cjtX.toString() + "\n";
        salida += "F = {" + "\n";
        salida += "\t" + cjt1.toString() + "\n";
        salida += "\t" + cjt2.toString() + "\n";
        salida += "\t" + cjt3.toString() + "\n";
        salida += "\t" + cjt4.toString() + "\n";
        salida += "\t" + cjt5.toString() + "\n";
        salida += "\t" + cjt6.toString() + "\n";
        salida += "\t" + cjt7.toString() + "\n";
        salida += "}" + "\n";
        salida += setCover.setCover(cjtX, cjtF).toString();

        return salida;
    }

}
