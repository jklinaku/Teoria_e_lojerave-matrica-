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
public class Button_back extends JButton implements ActionListener {

    private final Counter counter;
    private final MyPanel panel;
    private final MyPanel panel2;
    private final JLabel label;

    public Button_back(MyPanel panel,MyPanel panel2, Counter counter, JLabel label) {
        super("Back");
        this.panel = panel;
        this.panel2 = panel2;
        this.counter = counter;
        addActionListener(this);
        this.label=label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (counter.sub()) {
            System.out.println("hi");
            label.setText("Iteracioni i "+(counter.getCount()+1));
            panel.update(counter.getCount());
            panel2.update(counter.getCount());
            //panel.repaint();
        }
    }

}
