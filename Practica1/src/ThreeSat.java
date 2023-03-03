import java.util.List;
import java.util.ArrayList;

/**
 * Clase que resuelve el problema 3SAT con un algoritmo no determinista.
 * @author Zamora Cruz Diego Arturo.
 */
public class ThreeSat {

    /* Clausulas de la expresion booleana. */
    private List<Tripleta<Variable>> clausulas;
    /* Variables de la expresion booleana. */
    private List<Variable> variables;

    /**
     * Constructor que recibe una conjuncion de disyunciones.
     * @param clausulas las clausulas de la expresion.
     */
    public ThreeSat (List<Tripleta<Variable>> clausulas) {
        this.clausulas = clausulas;
    }

    /**
     * Constructor vacio.
     */
    public ThreeSat () {

    }

    /**
     * Regresa <code>True</code> si se encontro un conjunto de asignaciones
     * que satisfaga la expresion dada, en otro caso <code>False</code>
     * @return <code>True</code> si se encontro un conjunto de asignaciones
     * que satisfaga la expresion dada, en otro caso <code>False</code>
     */
    public boolean solucion(List<Tripleta<Variable>> clausulas) {
        this.clausulas = clausulas;
        this.variables = new ArrayList<Variable>();
        System.out.println("Ejemplar de 3SAT:\n" + this.clausulas);

        // Extraemos las variables (sin repeticion de la fnc)
        for (Tripleta<Variable> clausula : this.clausulas) {   
            Variable aux;
            if (!this.variables.contains(clausula.getX())) {
                aux = clausula.getX();
                aux.setValue(true);
                this.variables.add(aux);
            }
            if (!this.variables.contains(clausula.getY())) {
                aux = clausula.getY();
                aux.setValue(true);
                this.variables.add(aux);
            }
            if (!this.variables.contains(clausula.getZ())) {
                aux = clausula.getZ();
                aux.setValue(true);
                this.variables.add(aux);
            }
        }
        
        // Le asignamos un valor a cada variable con nd-chooise
        for (int i = 0; i < this.variables.size(); i++) {
            Variable var = new Variable(this.variables.get(i));
            if (ndChoice() == 1) {
                var.setValue(true);
            } else {
                var.setValue(false);
            }
            this.variables.set(i, var);
        }

        System.out.println("Candidato a solucion:\n" + this.variables);
        
        // Vemos si la asignacion es solucion
        for (Tripleta<Variable> clausula : this.clausulas) {
            boolean varX = true;
            boolean varY = true;
            boolean varZ = true;
            for (Variable variable : this.variables) {
                if (variable.equals(clausula.getX()))
                    varX = variable.getValue();
                if (variable.equals(clausula.getY()))
                    varY = variable.getValue();
                if (variable.equals(clausula.getZ()))
                    varZ = variable.getValue();
            }
            if (clausula.getX().getValue() == false)
                varX = !varX;
            if (clausula.getY().getValue() == false)
                varY = !varY;
            if (clausula.getZ().getValue() == false)
                varZ = !varZ;
            if ((varX || varY || varZ) == false){
                System.out.println("No es solucion para el ejemplar");
                return false;
            }
        }
        
        System.out.println("Si es solucion para el ejemplar");
        return true;
    }

    /* La primitiva adivinadora que selecciona un elemento del conjunto {1,2} */
    private int ndChoice() {
        return (int) ((Math.random() * (3-1)) + 1);
    }

}