package calculator;

import java.util.Vector;

public class CalcStrategy {
    private final String[] OPERATORS;

    {
        OPERATORS = new String[]{"+", "-", "*", "/"};
    }

    protected double c;

    public CalcStrategy() {}

    // Can only handle two operands and one operator right now
    public CalcStrategy(String input){
        while (check(input)){
            int i = 0;
            for (String s: OPERATORS){
                if (input.contains(OPERATORS[i])){
                    String[] temp = input.split(OPERATORS[i]);
                    switch (i){
                        case 0 -> new Addition(Double.parseDouble(temp[0]), Double.parseDouble(temp[1]), 'p');
                        case 1 -> new Addition(Double.parseDouble(temp[0]), Double.parseDouble(temp[1]), 'n');
                        case 2 -> new Multiplication(Double.parseDouble(temp[0]), Double.parseDouble(temp[1]), 'm');
                        case 3 -> new Multiplication(Double.parseDouble(temp[0]), Double.parseDouble(temp[1]), 'd');
                    }
                }
                i = i + 1;
            }
        }
    }

    public boolean check(String input) {
        for (String s: OPERATORS)
            if (input.contains(s)) return true;
        return false;
    }
}
