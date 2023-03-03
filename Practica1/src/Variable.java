public class Variable {
    private String literal;
    private boolean value;

    public Variable(Variable variable) {
        this.literal = variable.literal;
        this.value = variable.value;
    }

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

    public Variable(String name, boolean value) {
        this.literal = name;
        this.value = value;
    }

    public String getLiteral() {
        return this.literal;
    }

    public void setLiteral(String name) {
        this.literal = name;
    }

    public boolean getValue() {
        return this.value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public void neg() {
        this.value = !value;
    }

    public String evaluation() {
        return this.literal +": "+ this.value;
    }

    @Override
    public String toString() {
        String str = "";
        if (this.value == false) {
            str += "!";
        }
        return str += this.literal;
    }

    public boolean isSame(Variable var) {
        return var.literal.equals(this.literal) && var.value == this.value;
    }

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
