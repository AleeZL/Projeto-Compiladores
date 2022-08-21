# COMPILADOR ISILANGUAGE
Projeto para disciplina de Compiladores.

Compilador construído em java com auxílio da biblioteca ANTLR4.

# CHECKLIST
Completar o checklist eleva a nota entre C e D. O checklist foi completado em 2022/08/21, sendo ele:

       -Possuir 2 tipos de dados                                             | OK - String e Double.
       -Possuir a instrução de decisão                                       | OK - if/else.
       -Pelo menos 1 estrutura de repetição                                  | OK - while.
       -Verificar Atrib. com compatibilidade de tipos (semântica)            | Ok - verificação primitiva de tipos na atribuição.
       -Possuir operações de Entrada e Saída                                 | OK - read e write.
       -Aceitar números decimais                                             | OK - o tipo double aceita decimais.
       -Verificar decl. de var. (ñ usar var. que ñ foram declaradas)         | OK - Apresenta uma exceção informando qual variável não foi declarada.
       -Verificar se há var. declaradas e não-utilizadas (warning)           | OK - Apresenta um warning (em uma janela) informando qual variável foi declarada e não usada.
       -Geração de pelo menos 1 linguagem destino (C/Java/Python)            | OK - linguagem de destino: Java.


# ANEXOS
Adicionar elementos dos anexos pode elevar a nota até A.

Anexo 1 - Elementos adicionais (pelo menos 2 dos itens abaixo)

       Nova instrução para Switch/Case (escolha/caso)
       Mais tipos de dados
       Inclusão de novos operadores (exponenciação, raiz quadrada, logaritmos)
       Geração de código para mais de uma linguagem diferente                | OK - foi inserida a adaptação para código em C.

Anexo 2 - Elementos Extraordinarios (pelo menos 2 itens abaixo)

       Criar um interpretador a partir da AST                                | PARCIAL? - foi criada uma interface gráfica onde os resultados são apresentados.
       Criar um editor com Highlights de palavras reservadas (editor Desktop)
       Criar um editor Web para o código
       Tornar o compilador um Webservice para receber programas e enviar respostas de possíveis erros



# COMO USAR
Nesta build inicial, rode o programa java. Você verá uma janela, a interface gráfica, com dois boxes de texto: o da esquerda contém o código em IsiLanguage, o qual você quer compilar; e o da direita, em que você verá a compilaçao para a linguagem de destino, podendo ela ser Java ou C. Após inserir o código em IsiLanguage, escolha a linguagem de destino no combo box (Java ou C), clique no botão COMPILAR e, caso não hajam erros de compilação (os quais podem ser identificados no terminal e na janela da direita), o output será gerado no arquivo MainClass.java ou output.c (dependendo da respectiva linguagem de destino escolhida) e será apresentado na janela à direita. Abaixo, um exemplo de código escrito em IsiLanguage:

          programa

             numero a,b, k.
             texto c.
             texto d.
             texto s.

             leia(a).
             leia(b).

             leia(c).

             d := "Isto nao eh um texto!".
             a := 5.75.
             b := 7.
             k := 7.
             c := "eita+!".

            se (b > a) {
               escreva(a).
             } senao { 
                escreva(c).
             }

             enquanto (a > b) {
                 a := a - 1.
             }

             escreva(d).

         fimprog.

E sua transcrição gerada em Java, no arquivo MainClass.java:

       import java.util.Scanner;
       public class MainClass{ 
           public static void main (String args[]){ 
               Scanner _key = new Scanner(System.in);
               double  a;
               double  b;
               String  c;
               String  s;
               String  d;
               double  k;
               a= _key.nextDouble();
               b= _key.nextDouble();
               c= _key.nextLine();
               d = "Isto nao eh um texto!";
               a = 5.75;
               b = 7;
               k = 7;
               c = "eita+!";
               if (b>a) {
                       System.out.println(a);
               } else {
                       System.out.println(c);
               }

               while (a>b) {
                       a = a-1;
               } 
               System.out.println(d);
           }
       }

E sua transcrição gerada em C, no arquivo output.c:

       #include <stdio.h>


       int main(){ 
               float a;
               float b;
               char *c;
               char *s;
               char *d;
               float k;
               scanf("%f", &a);
               scanf("%f", &b);
               scanf("%s", c);
               d = "Isto nao eh um texto!";
               a = 5.75;
               b = 7;
               k = 7;
               c = "eita+!";
               if (b>a) {
                       printf("%f", a);
               } else {
                       printf("%s", c);
               }

               while (a>b) {
                       a = a-1;
               } 
               printf("%s", d);
               return 0;
       }
