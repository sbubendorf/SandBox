package ch.rusi.sandbox.swing;

import javax.swing.*;

public class SimpleInheritance extends JFrame {//inheriting JFrame
    JFrame f;

    SimpleInheritance() {
        JButton b = new JButton("click");//create button
        b.setBounds(130, 100, 100, 40);

        add(b);//adding button on frame
        setSize(400, 300);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleInheritance();
    }
}
