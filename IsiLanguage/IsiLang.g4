grammar IsiLang;

@header {
    import datastructures.*;
    import exceptions.*;
    import ast.*;
    import java.util.ArrayList;
    import java.util.Stack;
}

@members{
    private int _tipo;
    private String _varName;
    private String _varValue;
    private IsiSymbolTable symbolTable = new IsiSymbolTable();
    private IsiSymbol symbol;
    private IsiProgram program = new IsiProgram();
    private ArrayList<AbstractCommand> currentThread;
    private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
    private String _readID;
    private String _writeID;
    private String _exprID;
    private String _exprContent;
    private String _exprDecision;
    private String _exprLoop;
    private String _exprSwitch;
    private String _exprCase;
    private ArrayList<AbstractCommand> listaTrue;
    private ArrayList<AbstractCommand> listaFalse;
    private ArrayList<AbstractCommand> listaCase;


    public void verificaID(String id) {
        if (!symbolTable.exists(id)) {
            throw new IsiException("Symbol \"" + id + "\" not declared.");
        }
    }

    public void verificaUsage() {
        program.checaUso();
    }

   public void exibeComandos () {
        for (AbstractCommand c: program.getComandos()) {
            System.out.println(c);
        }
   }

    public void generateCode() {
        program.generateTarget();
    }

    public void generateC() {
        program.generateC();
    }

    public String getGeneratedCode() {
        return program.getPrograma();
    }
}


prog    : 'programa' decl bloco 'fimprog.'
            { 
                program.setVarTable(symbolTable);
                program.setComandos(stack.pop());
            }
        ;

decl    : (declaravar)+
        ;

declaravar  :   tipo ID {   _varName = _input.LT(-1).getText();
                            _varValue = null;
                            symbol = new IsiVariable(_varName, _tipo, _varValue);
                            if (!symbolTable.exists(_varName)) {
                                symbolTable.add(symbol);
                            } else {
                                throw new IsiException("Symbol " + symbol + " already declared.");
                            }
                        }
                (   VIR 
                    ID  {   _varName = _input.LT(-1).getText();
                            _varValue = null;
                            symbol = new IsiVariable(_varName, _tipo, _varValue);
                            if (!symbolTable.exists(_varName)) {
                                symbolTable.add(symbol);
                            } else {
                                throw new IsiException("Symbol " + symbol + " already declared.");
                            }
                        }
                )* SC
            ;

tipo    : 'numero'  { _tipo = IsiVariable.NUMBER; }
        | 'texto'   { _tipo = IsiVariable.TEXT; }
        ;

bloco   :   {   currentThread = new ArrayList<AbstractCommand>();
                stack.push(currentThread);
            }
            (cmd)+
        ;

cmd     : cmdleitura 
        | cmdescrita 
        | cmdattrib
        | cmdselecao
        | cmdloop
        | cmdtrocar
        | cmdcaso
        ;


cmdleitura  : 'leia'    AP
                        ID { 
                            verificaID(_input.LT(-1).getText());
                            _readID = _input.LT(-1).getText();
                           }
                        FP
                        SC
                {
                    IsiVariable var = (IsiVariable) symbolTable.get(_readID);
                    var.registerUsage();
                    CommandLeitura cmd = new CommandLeitura(_readID, var);
                    stack.peek().add(cmd);
                }
            ;

cmdescrita  : 'escreva' AP
                        ID {
                                verificaID(_input.LT(-1).getText());
                                _writeID =_input.LT(-1).getText();
                           }
                        FP
                        SC
                {   
                    IsiVariable var = (IsiVariable) symbolTable.get(_writeID);
                    var.registerUsage();
                    CommandEscrita cmd = new CommandEscrita(_writeID, var);
                    stack.peek().add(cmd);
                }
            ;


cmdattrib   :   ID { 
                        verificaID(_input.LT(-1).getText());
                        _exprID = _input.LT(-1).getText();
                   }
                ATTR { _exprContent = ""; }
                expr
                SC  {
                        IsiVariable var = (IsiVariable) symbolTable.get(_exprID);
                        var.registerUsage();
                        int type = var.getType();
                        CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent, type);
                        stack.peek().add(cmd);
                    }
            ;

cmdselecao  :   'se'    AP 
                        ID {_exprDecision = _input.LT(-1).getText(); }
                        OPREL {_exprDecision += _input.LT(-1).getText(); }
                        (ID | NUMBER) {
                                        _exprDecision += _input.LT(-1).getText(); 
                                        
                                        if (symbolTable.exists(_exprDecision)) {
                                            IsiVariable var = (IsiVariable) symbolTable.get(_exprDecision);
                                            var.registerUsage();
                                        }
                                      }
                        FP 
                        ACH 
                        {   
                            currentThread = new ArrayList<AbstractCommand>();
                            stack.push(currentThread);
                        }
                        (cmd)+ 
                        FCH
                        {
                            listaTrue = stack.pop();
                        }
                ('senao'    ACH 
                            {
                                currentThread = new ArrayList<AbstractCommand>();
                                stack.push(currentThread);
                            }
                            (cmd+) 
                            FCH
                            {
                                listaFalse = stack.pop();
                                CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
                                stack.peek().add(cmd);
                            }
                )?
            ;

cmdloop : 'enquanto'    AP
                        ID {_exprLoop = _input.LT(-1).getText(); }
                        OPREL {_exprLoop += _input.LT(-1).getText(); }
                        (ID | NUMBER) {
                                        _exprLoop += _input.LT(-1).getText(); 
                                        if (symbolTable.exists(_exprLoop)) {
                                            IsiVariable var = (IsiVariable) symbolTable.get(_exprLoop);
                                            var.registerUsage();
                                        }
                                      }
                        FP 
                        ACH 
                        {   currentThread = new ArrayList<AbstractCommand>();
                            stack.push(currentThread);
                        }
                        (cmd)+
                        FCH
                        {
                            listaTrue = stack.pop();
                            CommandLoop cmd = new CommandLoop(_exprLoop, listaTrue);
                            stack.peek().add(cmd);
                        }
                        
        ;

cmdtrocar: 'troque'     AP
                        ID  {_exprSwitch = _input.LT(-1).getText(); }
                        FP
                        ACH
                        {   currentThread = new ArrayList<AbstractCommand>();
                            stack.push(currentThread);
                        }
                        (cmdcaso)+

                        {
                            listaTrue = stack.pop();
                        }

                        ('padrao'
                        DP
                        {
                                currentThread = new ArrayList<AbstractCommand>();
                                stack.push(currentThread);
                        }
                        (cmd)+
                        FCH
                        {
                            listaCase = stack.pop();
                            CommandTrocar cmd = new CommandTrocar(_exprSwitch, listaTrue, listaCase);
                            stack.peek().add(cmd);
                        })?
        ;

cmdcaso:'caso'      ID   {_exprCase = _input.LT(-1).getText(); }
                    DP
                    {   currentThread = new ArrayList<AbstractCommand>();
                            stack.push(currentThread);
                    }
                    (cmd)+
                    'parar'
                    SC
                    {
                        listaTrue = stack.pop();
                        CommandCase cmd = new CommandCase(_exprCase, listaTrue);
                        stack.peek().add(cmd);
                    }
        ;
            

expr    :   termo (
            OP { _exprContent += _input.LT(-1).getText(); }
            termo
            )*
        ;


termo   : ID    {
                    verificaID(_input.LT(-1).getText());
                    _exprContent += _input.LT(-1).getText();
                }
        | (NUMBER | TEXT) {
                    _exprContent += _input.LT(-1).getText();
                 }
        ;

AP  :   '('
    ;

FP  :   ')'
    ;

SC  :   '.'
    ;

OP  : '+' | '-' | '*' | '/'
    ;

ATTR    : ':='
        ;

VIR     : ','
        ;

ACH     : '{'
        ;

FCH     : '}'
        ;

OPREL   : '>' | '<' | '>=' | '<=' | '==' | '!='
        ;

ID  : [a-z] ([a-z] | [A-Z] | [0-9])*
    ;

NUMBER  : [0-9]+ ('.' [0-9]+)?
        ;

TEXT   : ['"'] ([a-z] | [A-Z] | [0-9] | ' ' | '\t' | '!' | [#-/])* ['"']
       ;

WS  : (' ' | '\t' | '\n' | '\r') -> skip
    ;

DP  :   ':'
    ;