package calculator;

public class Addition extends CalcStrategy{
    public Addition(double a, double b, char AorS) {
        switch (AorS){
            case 'a' -> super.setC(a+b);
            case 's' -> super.setC(a-b);
        }
    }
}
