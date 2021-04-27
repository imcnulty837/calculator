package calculator;

public class Addition extends CalcStrategy{
    public Addition(double a, double b, char AorS) {
        switch (AorS){
            case 'a' -> this.c = a+b;
            case 's' -> this.c = a-b;
        }
    }
}
