/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Sead Mejzini
 */
public class Button_next extends JButton implements ActionListener {

    private Counter counter;
    private MyPanel panel;

    public Button_next(MyPanel panel, Counter counter) {
        super("Next");
        this.panel = panel;
        this.counter = counter;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (counter.add()) {
            System.out.println("hello");
            panel.update(counter.getCount());
            //panel.repaint();
        }
    }
}
