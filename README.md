# COMPILADOR ISILANGUAGE
Projeto para disciplina de Compiladores.

Compilador construído em java com auxílio da biblioteca ANTLR4.


# COMO USAR
Nesta build inicial, entre com o código em IsiLanguage no arquivo input.isi, rode o programa java e, caso não hajam erros de compilação (os quais podem ser identificados no terminal), o output será gerado no arquivo MainClass.java. Abaixo, um exemplo de código escrito em IsiLanguage.

       programa

          numero a,b.
          texto c.
          texto d.

          leia(a).
          leia(b).

          leia(c).

          d := "Isto eh um texto!".
          a := 3.
          b := 2.
          c := "eita!+".

          se (b > a) {
              escreva(a).
          } senao {
              leia(c).
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
              d = "Isto eh um texto!";
              a = 3;
              b = 2;
              c = "eita!+";
              if (b>a) {
                System.out.println(a);
              } else {
                c= _key.nextLine();
              }

              System.out.println(d);
           }
       }
