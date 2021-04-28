package calculator;

public class Multiplication extends CalcStrategy{
    public Multiplication(double a, double b, char MorD) {
        switch (MorD){
            case 'm' -> super.setC(a*b);
            case 'd' -> {
                try {
                    super.setC(a/b);
                } catch (Exception e) {
                    throw new ArithmeticException();
                }
            }
        }
    }
}
