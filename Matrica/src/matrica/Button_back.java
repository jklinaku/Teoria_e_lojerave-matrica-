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
public class Button_back extends JButton implements ActionListener {

    private final Counter counter;
    private final MyPanel panel;

    public Button_back(MyPanel panel, Counter counter) {
        super("Back");
        this.panel = panel;
        this.counter = counter;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (counter.sub()) {
            System.out.println("hi");
            panel.update(counter.getCount());
            //panel.repaint();
        }
    }

}
