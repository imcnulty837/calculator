package source.calculator;

import java.lang.Math;

public class Powers extends CalcStrategy{
    public Powers(double a, String b) {
        double temp;
        if (b.contains("/")) {
            String[] tempArr = b.split("[/]");
            CalcStrategy object;
            object = new Multiplication(Double.parseDouble(tempArr[0]), Double.parseDouble(tempArr[1]), 'd');
            temp = object.getC();
        } else {
            temp = Double.parseDouble(b);
        }
        super.setC(Math.pow(a, temp));
    }
}
