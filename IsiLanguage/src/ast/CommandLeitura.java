package ast;

import datastructures.IsiVariable;


public class CommandLeitura extends AbstractCommand {
    
    private String id;
    private IsiVariable var;
    
    public CommandLeitura (String id, IsiVariable var) {
        this.id = id;
        this.var = var;
    }
    
    @Override
    public String generateJavaCode() {
        return id + "= _key." + (var.getType()==IsiVariable.NUMBER? "nextDouble();": "nextLine();");
    }

    @Override
    public String toString() {
        return "CommandLeitura{" + "id=" + id + '}';
    }

    @Override
    public String generateCCode() {
        StringBuilder str = new StringBuilder();
        
        if (var.getType()==IsiVariable.NUMBER) {
            str.append("scanf(\"%f\", &" + id +");");
        } else {
            str.append("scanf(\"%s\", " + id + ");");
        }
        
        return str.toString();
    }
    
    
    
}
