/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrica;

import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Sead Mejzini
 */
public class ElementPanel extends JPanel {

    protected JTextField[] input;

    public ElementPanel(JTextField[] input) {
        super(new GridLayout(1,2));
        this.input = input;
    }

    @Override
    public void paintComponent(Graphics g) {
        this.add(input[0]);
        this.add(input[1]);
    }
}
