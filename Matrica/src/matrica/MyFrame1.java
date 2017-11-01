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

    public MyFrame1(double[][] inputL1, double[][] inputL2, String[] a, String[] b) {
        Kalkulimi_i_problemit k = new Kalkulimi_i_problemit(inputL1, inputL2, a, b);
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel label = new JLabel("Iteracioni" + 1);
        JPanel panel1 = new JPanel();
        panel1.add(label);
        panel1.setSize(this.getWidth(), 50);

        JPanel panel_21 = new MyPanel(k, true);
        panel_21.setSize((this.getWidth() / 3), 700);

        JPanel panel_22 = new MyPanel(k, false);
        panel_22.setSize(this.getWidth() / 3, 700);

        JPanel panel3 = new JPanel(new GridLayout(1, 2));
        panel3.add(panel_21);
        panel3.add(panel_22);

        cp.add(panel1, BorderLayout.NORTH);
        cp.add(panel3, BorderLayout.CENTER);
        Counter counter = new Counter(k.getCounter());
        JButton b1 = new Button_back((MyPanel)panel_21 , counter);
        JButton b2 = new Button_next((MyPanel)panel_21 , counter);
        JPanel panel4 = new JPanel(new FlowLayout());
        JPanel panel4_1 = new JPanel(new BorderLayout());
        panel4.setSize(this.getWidth(), 50);
        panel4.add(b1);
        panel4.add(b2);
        panel4_1.add(panel4, BorderLayout.EAST);
        cp.add(panel4_1, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }
}
