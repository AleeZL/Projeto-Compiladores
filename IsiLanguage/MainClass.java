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

	while (a>b) {
	  a = a-1;
 	} 
	System.out.println(d);
    }
}