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