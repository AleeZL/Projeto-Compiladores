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