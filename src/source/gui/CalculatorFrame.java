package source.gui;

import source.calculator.CalcStrategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class CalculatorFrame extends JFrame implements WindowListener {
    private JTextField textField = new JTextField("");
    private Vector<JButton> buttons = new Vector<>();
    private CalcStrategy calcStrategy = new CalcStrategy();
    private boolean resultFlag = false, exponentFlag = false;

    public CalculatorFrame() {
        super("Calculator");

        JPanel textPnl = new JPanel();
        textField.setPreferredSize(new Dimension(250, 40));
        textField.setEditable(false);
        textPnl.add(textField);
        textPnl.setPreferredSize(new Dimension(250, 50));
        add(textPnl, BorderLayout.PAGE_START);
        JPanel numberPnl = new JPanel(new GridLayout(4,3));
        for (int i = 0; i < 10; i = i + 1) {
            buttons.add(new JButton(String.valueOf(i)));
            buttons.get(i).setPreferredSize(new Dimension(90, 75));
            int finalI = i;
            buttons.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!resultFlag) {
                        String prevText = textField.getText();
                        textField.setText(prevText + String.valueOf(finalI));
                    } else {
                        textField.setText(String.valueOf(finalI));
                        resultFlag = false;
                    }
                }
            });
            if (i > 0)
                numberPnl.add(buttons.get(i));
        }

        JButton clrBtn = new JButton("Clear");
        clrBtn.setPreferredSize(new Dimension(90, 75));
        clrBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
            }
        });
        numberPnl.add(clrBtn);

        numberPnl.add(buttons.get(0));

        JButton eqlBtn = new JButton("=");
        eqlBtn.setPreferredSize(new Dimension(90, 75));
        eqlBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CalcStrategy temp = new CalcStrategy(textField.getText());
                textField.setText(String.valueOf(temp.getC()));
                resultFlag = true;
            }
        });
        numberPnl.add(eqlBtn);
        add(numberPnl, BorderLayout.CENTER);

        JPanel operationPnl = new JPanel(new GridLayout(4,2));
        // + button for addition
        JButton addBtn = new JButton("+");
        addBtn.setPreferredSize(new Dimension(90, 75));
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String prevText = textField.getText();
                if (!calcStrategy.check(prevText) && !prevText.isEmpty())
                    textField.setText(prevText + "+");
            }
        });
        // - button for subtraction
        JButton subBtn = new JButton("-");
        subBtn.setPreferredSize(new Dimension(90, 75));
        subBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String prevText = textField.getText();
                if (!calcStrategy.check(prevText) && !prevText.isEmpty())
                    textField.setText(prevText + "-");
            }
        });
        // * button for multiplication
        JButton mulBtn = new JButton("*");
        mulBtn.setPreferredSize(new Dimension(90, 75));
        mulBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String prevText = textField.getText();
                if (!calcStrategy.check(prevText) && !prevText.isEmpty())
                    textField.setText(prevText + "*");
            }
        });
        // / button for division and fractions
        JButton divBtn = new JButton("/");
        divBtn.setPreferredSize(new Dimension(90, 75));
        divBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String prevText = textField.getText();
                if ((!calcStrategy.check(prevText) && !prevText.isEmpty()) || exponentFlag) {
                    textField.setText(prevText + "/");
                    exponentFlag = false;
                }
            }
        });
        // ^ button for exponents
        JButton expBtn = new JButton("^");
        expBtn.setPreferredSize(new Dimension(90, 75));
        expBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String prevText = textField.getText();
                if (!calcStrategy.check(prevText) && !prevText.isEmpty()) {
                    textField.setText(prevText + "^");
                    exponentFlag = true;
                }
            }
        });
        // ^2 button for squaring input
        JButton sqrBtn = new JButton("^2");
        sqrBtn.setPreferredSize(new Dimension(90, 75));
        sqrBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String prevText = textField.getText();
                if (!calcStrategy.check(prevText) && !prevText.isEmpty()) {
                    CalcStrategy temp = new CalcStrategy(textField.getText()+"^2");
                    textField.setText(String.valueOf(temp.getC()));
                    resultFlag = true;
                }
            }
        });
        // sqrt button for square root of input
        JButton sqrtBtn = new JButton("sqrt");
        sqrtBtn.setPreferredSize(new Dimension(90, 75));
        sqrtBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String prevText = textField.getText();
                if (!calcStrategy.check(prevText) && !prevText.isEmpty()) {
                    CalcStrategy temp = new CalcStrategy(textField.getText()+"^1/2");
                    textField.setText(String.valueOf(temp.getC()));
                    resultFlag = true;
                }
            }
        });
        operationPnl.add(addBtn);
        operationPnl.add(subBtn);
        operationPnl.add(mulBtn);
        operationPnl.add(divBtn);
        operationPnl.add(expBtn);
        operationPnl.add(sqrBtn);
        operationPnl.add(sqrtBtn);
        add(operationPnl, BorderLayout.EAST);

        setVisible(true);
        setSize(new Dimension(300, 500));
        pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addWindowListener(this);
        setResizable(false);
    }

    public static void main(String[] args) {
        new CalculatorFrame();
    }

    public void windowActivated(WindowEvent event) {
        System.out.println("The window has been activated");
    }

    public void windowClosed(WindowEvent event) {
        System.out.println("The window has been closed");
    }

    public void windowClosing(WindowEvent event) {
        System.out.println("About to close the window");
    }

    public void windowDeactivated(WindowEvent event) {
        System.out.println("The window has been deactivated");
    }

    public void windowDeiconified(WindowEvent event) {
        System.out.println("The window has been restored");
    }

    public void windowIconified(WindowEvent event) {
        System.out.println("The window has been minimized");
    }

    public void windowOpened(WindowEvent event) {
        System.out.println("The window has been opened");
    }
}
