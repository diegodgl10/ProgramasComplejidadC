// import java.util.List;
// import java.util.ArrayList;
// import java.util.Arrays;

public class Programa2 {
    public static void main(String[] args) {
        Pruebas pruebas = new Pruebas();

        String barra = "";
        barra += "------------------------------------------------";
        barra = "\n\n" +barra+ "<>" +barra+ "\n";

        System.out.println("PRUEBA 1:\n" + pruebas.prueba1() + barra);
        System.out.println("PRUEBA 2:\n" + pruebas.prueba2() + barra);
        System.out.println("PRUEBA 3:\n" + pruebas.prueba3() + barra);
        System.out.println("PRUEBA 4:\n" + pruebas.prueba4() + barra);
        System.out.println("PRUEBA 5:\n" + pruebas.prueba5());
    }
}