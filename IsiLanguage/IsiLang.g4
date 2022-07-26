grammar IsiLang;

prog    : 'programa' decl bloco 'fimprog;'
        ;

decl    : (declaravar)+
        ;

declaravar  :   tipo ID (VIR ID)* SC
            ;

tipo    : 'numero'
        | 'texto'
        ;

bloco   : (cmd)+
        ;

cmd     : cmdleitura { System.out.println("Comando de leitura reconhecido!"); }
        | cmdescrita { System.out.println("Comando de escrita reconhecido!"); }
        | cmdattrib  { System.out.println("Comando de atribuição reconhecido!"); }
        ;


cmdleitura  : 'leia' AP ID FP SC
            ;

cmdescrita  : 'escreva' AP ID FP SC
            ;


cmdattrib   : ID ATTR expr SC
            ;

expr    : termo ( OP termo)*
        ;


termo   : ID | NUMBER
        ;

AP  :   '('
    ;

FP  :   ')'
    ;

SC  :   ';'
    ;

OP  : '+' | '-' | '*' | '/'
    ;

ATTR    : '='
        ;

VIR     : ','
        ;

ID  : [a-z] ([a-z] | [A-Z] | [0-9])*
    ;

NUMBER  : [0-9]+ ('.' [0-9]+)?
        ;

WS  : (' ' | '\t' | '\n' | '\r') -> skip
    ;