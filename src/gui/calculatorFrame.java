package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

public class calculatorFrame extends JFrame implements WindowListener {
    private JTextField textField = new JTextField();
    private Vector<JButton> buttons = new Vector<>();

    public calculatorFrame() {
        super("Calculator");

        JPanel textPnl = new JPanel();
        textField.setPreferredSize(new Dimension(250, 40));
        textPnl.add(textField);
        textPnl.setPreferredSize(new Dimension(250, 50));
        this.add(textPnl, BorderLayout.PAGE_START);
        JPanel buttonPnl = new JPanel(new GridLayout(4,3));
        for (int i = 0; i < 10; i = i + 1) {
            buttons.add(new JButton(String.valueOf(i)));
            buttons.get(i).setPreferredSize(new Dimension(90, 75));
            if (i > 0)
                buttonPnl.add(buttons.get(i));
        }
        buttonPnl.add(new JLabel());
        buttonPnl.add(buttons.get(0));
        buttonPnl.add(new JLabel());
        this.add(buttonPnl, BorderLayout.PAGE_END);

        this.setVisible(true);
        this.setSize(new Dimension(300, 500));
        this.pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
