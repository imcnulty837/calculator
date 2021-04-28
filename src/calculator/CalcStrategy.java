package calculator;

import java.util.Vector;

public class CalcStrategy {
    private final String[] OPERATORS;

    {
        OPERATORS = new String[]{"[+]", "[-]", "[*]", "[/]"};
    }

    protected double c;

    public CalcStrategy() {}

    // Can only handle two operands and one operator right now
    public CalcStrategy(String input){
        String temp = input;
        while (check(temp)){
            int i = 0;
            for (String s: OPERATORS){
                String tempChar = String.valueOf(s.charAt(1));
                if (temp.contains(tempChar)){
                    String[] tempArr = temp.split(OPERATORS[i]);
                    CalcStrategy object;
                    switch (i){
                        case 0 -> object = new Addition(Double.parseDouble(tempArr[0]), Double.parseDouble(tempArr[1]), 'a');
                        case 1 -> object = new Addition(Double.parseDouble(tempArr[0]), Double.parseDouble(tempArr[1]), 's');
                        case 2 -> object = new Multiplication(Double.parseDouble(tempArr[0]), Double.parseDouble(tempArr[1]), 'm');
                        case 3 -> object = new Multiplication(Double.parseDouble(tempArr[0]), Double.parseDouble(tempArr[1]), 'd');
                        default -> throw new IllegalStateException("Unexpected value: " + i);
                    }
                    setC(object.getC());
                    temp = tempArr[1];
                }
                i = i + 1;
            }
        }
    }

    public boolean check(String input) {
        for (String s: OPERATORS) {
            String temp = String.valueOf(s.charAt(1));
            if (input.contains(temp)) return true;
        }
        return false;
    }

    public double getC() { return this.c; }
    public void setC(double c) { this.c = c; }
}
