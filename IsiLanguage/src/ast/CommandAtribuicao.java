package ast;

import exceptions.IsiException;


public class CommandAtribuicao extends AbstractCommand {
    private String id;
    private int    type;
    private String expr;
    
    public CommandAtribuicao(String id, String expr, int type) {
        this.id = id;
        this.expr = expr;
        this.type = type;
    }
    
    
    @Override
    public String generateJavaCode() {
        if (type == 0 && expr.contains("\"")) {
            throw new IsiException ("Tipo de dados incompatível. A variável " + id + " espera uma entrada do tipo Float.");
        } else if (type == 1 && !expr.contains("\"")) {
            throw new IsiException ("Tipo de dados incompatível.A variável " + id + " espera uma entrada do tipo String.");
        }
        return id + " = " + expr + ";";
    }

    @Override
    public String toString() {
        return "CommandAtribuicao{" + "id=" + id + ", expr=" + expr + '}';
    }

    @Override
    public String generateCCode() {
        return id + " = " + expr + ";";
    }
    
}
