/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Sead Mejzini
 */
public class Button_next extends JButton implements ActionListener {

    private Counter counter;
    private MyPanel panel;
    private MyPanel panel2;
    private JLabel label;

    public Button_next(MyPanel panel,MyPanel panel2, Counter counter, JLabel label) {
        super("Next");
        this.panel = panel;
        this.panel2 = panel2;
        this.counter = counter;
        addActionListener(this);
        this.label = label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (counter.add()) {
            System.out.println("hello");
            label.setText("Iteracioni i "+(counter.getCount()+1));
            panel.update(counter.getCount());
            panel2.update(counter.getCount());
            //panel.repaint();
        }
    }
}
