/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrica;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Sead Mejzini
 */
public class MyFrame1 extends JFrame {

    public MyFrame1(double[][] inputL1, double[][] inputL2) {
        Kalkulimi_i_problemit k = new Kalkulimi_i_problemit(inputL1, inputL2);
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(3, 1));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel label = new JLabel("Iteracioni" + 1);
        JPanel panel1 = new JPanel();
        panel1.add(label);
        panel1.setSize(this.getWidth(), 50);

        JPanel panel21 = new MyPanel(k, true);
        panel21.setSize(2 * (this.getWidth() / 3), 700);
        JPanel panel22 = new MyPanel(k, false);
        panel22.setSize(this.getWidth() / 3, 700);

        JPanel panel3 = new JPanel(new GridLayout(1, 2));
        panel3.add(panel21);
        panel3.add(panel22);

        cp.add(panel1);
        cp.add(panel3);
        JButton b1 = new JButton("A");

        JButton b2 = new JButton("b");
        JPanel panel4 = new JPanel(new FlowLayout());
        panel4.setSize(this.getWidth(), 50);
        panel4.add(b1, BorderLayout.SOUTH);
        panel4.add(b2, BorderLayout.SOUTH);
        setSize(1200, 768);
        setVisible(true);
    }
}
