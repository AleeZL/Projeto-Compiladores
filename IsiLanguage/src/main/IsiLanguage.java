package main;

import exceptions.IsiException;
import interfacesgraficas.MainFrame;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.IsiLangLexer;
import parser.IsiLangParser;

/**
 * Esta classe será a responsável por criar a interação com o usuário,
 * instanciando o parser e apontando para o arquivo fonte (.isi).
 *
 */
public class IsiLanguage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Altere esta variável para deixar de exibir a interface gráfica.
        Boolean useGraphicalInterface = true;
        
        
        try {
            if (useGraphicalInterface) {
                MainFrame frame = new MainFrame();
                frame.init();
            } else {
                IsiLangLexer    lexer;
                IsiLangParser   parser;

                //Lê o arquivo input.isi, que serve de entrada para o analisador léxico.
                lexer = new IsiLangLexer(CharStreams.fromFileName("input.isi"));

                //Gera o fluxo de tokens, que será utilizado no parser.
                CommonTokenStream tokenStream = new CommonTokenStream(lexer);

                //Criação do parser a partir do tokenStream
                parser = new IsiLangParser(tokenStream);

                parser.prog();

                System.out.println("Sucesso!");

                parser.exibeComandos();

                parser.generateCode();
            }
                    
            
        } catch (IsiException ex) {
            System.err.println("Semantic error - "+ex.getMessage());
        }catch (Exception ex) {
            System.err.println("Error "+ex.getMessage());
        }
    }
    
}
