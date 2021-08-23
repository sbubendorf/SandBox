package ch.rusi.sandbox.swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Button Example");
        final JTextField textField = new JTextField();
        textField.setBounds(50,50,150,20);
        JButton button = new JButton("Click Here");
        button.setBounds(50, 100, 95, 30);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("Welcome to Swing!");
            }
        });
        frame.add(textField);
        frame.add(button);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
