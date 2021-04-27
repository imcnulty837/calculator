package calculator;

public class Multiplication extends CalcStrategy{
    public Multiplication(double a, double b, char MorD) {
        switch (MorD){
            case 'm' -> this.c = a*b;
            case 'd' -> {
                try {
                    this.c = a/b;
                } catch (Exception e) {
                    throw new ArithmeticException();
                }
            }
        }
    }
}
