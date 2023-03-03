import java.util.ArrayList;
import java.util.List;

public class Programa1 {
    public static void main(String[] args) {
        //threeSat("(p,!q,r)(r,r,p)(s,!s,t)");
        //threeSat("(p,p,p)(q,q,q)(!p,!p,!q)");
        //threeSat("(p,p,p)");
        //threeSat("(w,!x,!s)");

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
            System.out.println("POR HACER");
            return;
        }
    }

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

    private static void threeSat(List<Tripleta<Variable>> clausulas) {
        ThreeSat tSat = new ThreeSat();
        tSat.solucion(clausulas);
    }


    private static void threeSat(String in) {
        in = in.replace(" ", "");

        String[] fnc = in.split("\\)\\(");
        
        fnc[0] = fnc[0].replace("(", "");
        fnc[fnc.length - 1] = fnc[fnc.length - 1].replace(")", "");
        
        List<Tripleta<Variable>> clausulas = new ArrayList<Tripleta<Variable>>();
        for (int i = 0; i < fnc.length; i++) {
            String[] clausula = fnc[i].split(",");
            Tripleta<Variable> tripleta = new Tripleta<Variable>(
                new Variable(clausula[0]), 
                new Variable(clausula[1]),
                new Variable(clausula[2]));
            clausulas.add (tripleta);
        }
        ThreeSat tSat = new ThreeSat();
        
        tSat.solucion(clausulas);
    }
}
