package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

public class calculatorFrame extends JFrame implements WindowListener {
    private JTextField textField = new JTextField("");
    private Vector<JButton> buttons = new Vector<>();

    public calculatorFrame() {
        super("Calculator");

        JPanel textPnl = new JPanel();
        textField.setPreferredSize(new Dimension(250, 40));
        textField.setEditable(false);
        textPnl.add(textField);
        textPnl.setPreferredSize(new Dimension(250, 50));
        add(textPnl, BorderLayout.PAGE_START);
        JPanel buttonPnl = new JPanel(new GridLayout(4,3));
        for (int i = 0; i < 10; i = i + 1) {
            buttons.add(new JButton(String.valueOf(i)));
            buttons.get(i).setPreferredSize(new Dimension(90, 75));
            int finalI = i;
            buttons.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String prevText = textField.getText();
                    textField.setText(prevText + String.valueOf(finalI));
                }
            });
            if (i > 0)
                buttonPnl.add(buttons.get(i));
        }

        JButton clrBtn = new JButton("Clear");
        clrBtn.setPreferredSize(new Dimension(90, 75));
        clrBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
            }
        });
        buttonPnl.add(clrBtn);

        buttonPnl.add(buttons.get(0));

        JButton eqlBtn = new JButton("=");
        eqlBtn.setPreferredSize(new Dimension(90, 75));
        eqlBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
            }
        });
        buttonPnl.add(eqlBtn);
        add(buttonPnl, BorderLayout.PAGE_END);

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
        new calculatorFrame();
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
