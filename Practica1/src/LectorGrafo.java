import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * Clase para leer un archivo y convertir la informacion leida en un grafo.
 * @author Zamora Cruz Diego Arturo.
 */
public class LectorGrafo {
    
    /* Nombre del archivo. */
    private String archivo;
    /* Grafo generada a partir del archivo leido. */
    private Grafo grafo;

    /**
     * Constructor vacio del lector de un archivo.
     */
    public LectorGrafo() {
        this.grafo = new Grafo();
    }

    /**
     * Constructor que recibe el nombre del archivo a leer.
     * @param archivo el nombre del archivo a leer.
     */
    public LectorGrafo(String archivo) {
        this.archivo = archivo;
        this.grafo = new Grafo();
    }

    /**
     * Define el nuevo nombre del archivo a leer.
     * @param archivo el nuevo nombre del archivo.
     */
    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    /**
     * Regresa el grafo generado a partor del archivo leido.
     * @return el grafo generado a partor del archivo leido.
     */
    public Grafo getGrafo() {
        return this.grafo;
    }

    /**
     * Lee el archivo y genera un grafo con la informacion del archivo.
     */
    public void leer() {
        int contador = 1;
        String lVertices = "";
        List<String> lAristas = new ArrayList<String>();
        try {
            File documento = new File(this.archivo);
            if (!documento.exists()) {
                System.out.println("(x) El archivo no existe");
                System.exit(1);
            }
            Scanner lector = new Scanner(documento);
            while (lector.hasNextLine()) {
                String data = lector.nextLine();
                if (contador == 1) {
                    lVertices = data;
                    contador = 2;
                } else {
                    lAristas.add(data);
                }
            }
            lector.close();
        } catch (FileNotFoundException e) {
            System.out.println("(x) Ha ocurrido un error");
            e.printStackTrace();
        }
        agregarVertices(lVertices);
        agregarAristas(lAristas);
    }

    /* Agrega los vertices al grafo. */
    private void agregarVertices(String lVertices) {
        String[] arrVertices = lVertices.split(",");
        for (int i = 0; i < arrVertices.length; i++) {
            String etiqueta = arrVertices[i];
            etiqueta = etiqueta.replaceAll("\\s", "");
            Vertice vertice = new Vertice(etiqueta);
            this.grafo.addVertice(vertice);
        }

    }

    /* Agrega las aristas al grafo. */
    private void agregarAristas(List<String> lAristas) {
        for (String aristaStr : lAristas) {
            String[] arrArista = aristaStr.split(",");
            for (int i = 0; i < arrArista.length; i++) {
                arrArista[i] = arrArista[i].replaceAll("\\s", "");
            }
            Vertice vertice1 = new Vertice(arrArista[0]);
            Vertice vertice2 = new Vertice(arrArista[1]);
            double peso = Double.parseDouble(arrArista[2]);
            Arista arista = new Arista(vertice1, vertice2, peso);
            this.grafo.addArista(arista);
        }        
    }
}