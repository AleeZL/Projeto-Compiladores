package ast;

import java.util.ArrayList;


public class CommandLoop extends AbstractCommand {
    private String condition;
    private ArrayList<AbstractCommand> listaTrue;
    
    public CommandLoop(String condition, ArrayList<AbstractCommand> lt) {
        this.condition = condition;
        this.listaTrue = lt;
    }

    @Override
    public String generateJavaCode() {
        StringBuilder str = new StringBuilder();
        str.append("while ("+ condition + ") {\n");
        for (AbstractCommand cmd: listaTrue) {
            str.append("\t  " + cmd.generateJavaCode());
        }
        str.append("\n \t} ");
        
        return str.toString();
    }

    @Override
    public String toString() {
        return "CommandLoop{" + "condition=" + condition + ", listaTrue=" + listaTrue + '}';
    }
}
