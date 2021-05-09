package source.calculator;

public class CalcStrategy {
    private final String[] OPERATORS;

    {
        OPERATORS = new String[]{"[()]", "[}^]", "[*]", "[/]", "[+]", "[-]"};
    }

    protected double c;

    public CalcStrategy() {}

    // Can only handle two operands and one operator right now
    public CalcStrategy(String input){
        String temp = input;
        boolean opFlag = false;
        while (check(temp)){
            int i = 0;
            for (String s: OPERATORS){
                String tempChar;
                if (i == 0)
                    tempChar = String.valueOf(s.charAt(2));
                else
                    tempChar = String.valueOf(s.charAt(1));
                if (temp.contains(tempChar)){
                    String[] tempArr = temp.split(OPERATORS[i]);
                    CalcStrategy object;
                    switch (i){
                        case 2 -> {
                            object = new Multiplication(Double.parseDouble(tempArr[0]), Double.parseDouble(tempArr[1]), 'm');
                            opFlag = true;
                        }
                        case 3 -> {
                            object = new Multiplication(Double.parseDouble(tempArr[0]), Double.parseDouble(tempArr[1]), 'd');
                            opFlag = true;
                        }
                        case 4 -> {
                            object = new Addition(Double.parseDouble(tempArr[0]), Double.parseDouble(tempArr[1]), 'a');
                            opFlag = true;
                        }
                        case 5 -> {
                            object = new Addition(Double.parseDouble(tempArr[0]), Double.parseDouble(tempArr[1]), 's');
                            opFlag = true;
                        }
                        case 1 -> {
                            object = new Powers(Double.parseDouble(tempArr[0]), tempArr[1]);
                            opFlag = true;
                        }
                        default -> throw new IllegalStateException("Unexpected value: " + i);
                    }
                    setC(object.getC());
                    temp = tempArr[1];
                }
                if (opFlag)
                    break;
                i = i + 1;
            }
            if (opFlag)
                break;
        }
    }

    public boolean check(String input) {
        int i = 0;
        for (String s: OPERATORS) {
            String temp = null;
            if (i == 0)
                temp = String.valueOf(s.charAt(2));
            else
                temp = String.valueOf(s.charAt(1));

            if (input.contains(temp)) return true;
            i = i + 1;
        }
        return false;
    }

    public double getC() { return this.c; }
    public void setC(double c) { this.c = c; }
}
