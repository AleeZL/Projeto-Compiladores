package ast;

import datastructures.IsiSymbol;
import datastructures.IsiSymbolTable;
import datastructures.IsiVariable;
import exceptions.IsiException;
import java.awt.Component;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class IsiProgram {
    private IsiSymbolTable varTable;
    private ArrayList<AbstractCommand> comandos;
    private String programName;
    private String programa;
    
    public void generateTarget() {
        StringBuilder str = new StringBuilder();
        str.append("import java.util.Scanner;\n");
        str.append("public class MainClass{ \n");
        str.append("    public static void main (String args[]){ \n");
        str.append("        Scanner _key = new Scanner(System.in);\n");
        for (IsiSymbol symbol: varTable.getAll()) {
            str.append("\t" +symbol.generateJavaCode() + "\n");
        }
        
        for (AbstractCommand command: comandos) {
            str.append("\t" + command.generateJavaCode()+ "\n");
        }
        
        str.append("    }");
        str.append("\n}");
        
        try {
            FileWriter fr = new FileWriter(new File ("output.java"));
            programa = str.toString();
            fr.write(programa);
            fr.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        
    }
    
    public void checaUso() {
        for (IsiSymbol symbol: varTable.getAll()) {
            IsiVariable currentVariable = (IsiVariable) symbol;
            
            if (currentVariable.getUsage() == 0) {
                //Mostra warning que a variável não foi utilizada.
                System.out.println("Warning: variavel \"" + currentVariable.getName() + "\" declarada, mas não usada.");
                JOptionPane.showMessageDialog(null, ("Warning: variavel \"" + currentVariable.getName() + "\" declarada, mas não usada."));
            }
        }
    }
    
    public String getPrograma() {
        return programa;
    }

    public IsiSymbolTable getVarTable() {
        return varTable;
    }

    public void setVarTable(IsiSymbolTable varTable) {
        this.varTable = varTable;
    }

    public ArrayList<AbstractCommand> getComandos() {
        return comandos;
    }

    public void setComandos(ArrayList<AbstractCommand> comandos) {
        this.comandos = comandos;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }
}
