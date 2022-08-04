# COMPILADOR ISILANGUAGE
Projeto para disciplina de Compiladores.

Compilador construído em java com auxílio da biblioteca ANTLR4.


# COMO USAR
Nesta build inicial, rode o programa java. Você verá duas janelas em uma interface gráfica: a da esquerda contém o código em IsiLanguage, o qual você quer compilar. Após inserir o código em IsiLanguage, clique no botão COMPILAR e, caso não hajam erros de compilação (os quais podem ser identificados no terminal e na janela da direita), o output será gerado no arquivo MainClass.java e será apresentado na janela à direita. Abaixo, um exemplo de código escrito em IsiLanguage:

       programa

          numero a,b, k.
          texto c.
          texto d.

          leia(a).
          leia(b).

          leia(c).

          d := "Isto nao eh um texto!".
          a := 5.
          b := 2.
          k := 7.
          c := "eita!+".

          se (b > a) {
              escreva(a).
          } senao {
              leia(c).
          }
          
          enquanto (a > b) {
              a = a - 1.
          }

          escreva(d).

      fimprog.

E sua transcrição gerada em Java:

       import java.util.Scanner;
       public class MainClass{ 
           public static void main (String args[]){ 
               Scanner _key = new Scanner(System.in);
              double  a;
              double  b;
              String  c;
              String  d;
              a= _key.nextDouble();
              b= _key.nextDouble();
              c= _key.nextLine();
              d = "Isto nao eh um texto!";
              a = 5;
              b = 2;
              k = 7;
              c = "eita!+";
              if (b>a) {
                System.out.println(a);
              } else {
                c= _key.nextLine();
              }
              
              while (a>b) {
                a = a-10;
              } 

              System.out.println(d);
           }
       }
