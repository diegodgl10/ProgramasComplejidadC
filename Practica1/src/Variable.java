/**
 * Clase para representar una variable boolean.
 * @author Zamora Cruz Diego Arturo.
 */
public class Variable {

    /* Nombre de la varialbe. */
    private String literal;
    /* Valor de verdad. */
    private boolean value;

    /**
     * Constructor que recibe una variable.
     * @param variable la variable que define los valores para la nueva variable.
     */
    public Variable(Variable variable) {
        this.literal = variable.literal;
        this.value = variable.value;
    }

    /**
     * Contructor que recibe el nombre de la variable
     * o el nombre mas un simbolo de negacion.
     * @param variable el nombre de la variable.
     */
    public Variable(String variable) {
        if (variable.length() == 1) {
            this.literal = variable;
            this.value = true;
        } else {
            String[] aux = variable.split("");
            this.literal = aux[1];
            this.value = false;
        }
    }

    /**
     * Constructor que recibe el nombre y valor de una variable.
     * @param name el nombre de la variable.
     * @param value el valor de verdad de la variable.
     */
    public Variable(String name, boolean value) {
        this.literal = name;
        this.value = value;
    }

    /**
     * Regresa el nombre de la variable.
     * @return el nombre de la variable.
     */
    public String getLiteral() {
        return this.literal;
    }

    /**
     * Define el nuevo nombre de la variable.
     * @param name el nombre de la variable.
     */
    public void setLiteral(String name) {
        this.literal = name;
    }

    /**
     * Regresa el valoor de verdad de la variable.
     * @return el valoor de verdad de la variable.
     */
    public boolean getValue() {
        return this.value;
    }

    /**
     * Define el nuevo valor de verdad de la variable.
     * @param value el nuevo valor de verdad de la variable.
     */
    public void setValue(boolean value) {
        this.value = value;
    }

    /**
     * Niega el valor de verdad actual de la variable.
     */
    public void neg() {
        this.value = !value;
    }

    /**
     * Regresa una representacion en cadena con el nombre de la variable
     * y su valor de verdad.
     * @return una representacion en cadena con el nombre de la variable
     * y su valor de verdad.
     */
    public String evaluation() {
        return this.literal +": "+ this.value;
    }

    /**
     * Regresa el una representacion en cadena de la variable.
     * @return el una representacion en cadena de la variable.
     */
    @Override
    public String toString() {
        String str = "";
        if (this.value == false) {
            str += "!";
        }
        return str += this.literal;
    }

    /**
     * Regresa <code>True</code> si la variable que manda a llamar al metodo
     * tiene el mismo nombre y valor booleano que la variable recibida por parametros.
     * @param var la variable con la que se comparara la variable que manda a llamar
     * al metodo.
     * @return <code>True</code> si la variable que manda a llamar al metodo
     * tiene el mismo nombre y valor booleano que la variable recibida por parametros.
     */
    public boolean isSame(Variable var) {
        return var.literal.equals(this.literal) && var.value == this.value;
    }

    /**
     * Regresa <code>True</code> si el objeto pasado por parametros es una variable
     * con el mismo nombre que la variable que invoca al metodo.
     * @return <code>True</code> si el objeto pasado por parametros es una variable
     * con el mismo nombre que la variable que invoca al metodo.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Variable)) {
            return false;
        }
        Variable var = (Variable) o;
        if (var.literal.equals(this.literal)) {
            return true;
        }
        return false;
    }
}
