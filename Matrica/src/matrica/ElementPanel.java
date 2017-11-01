/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrica;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Sead Mejzini
 */
public class ElementPanel extends JPanel {

    protected JTextField[] input;
    protected JLabel[] label;

    public ElementPanel(JTextField[] input) {
        super(new GridLayout(1, 2));
        this.input = input;
        insert(this.input);
    }

    public ElementPanel(JLabel[] label) {
        super(new GridLayout(1, 2));
        this.label = label;
        insert(this.label);
    }

    public void insert(JTextField[] input) {
        this.add(input[0]);
        this.add(input[1]);
    }

    public void insert(JLabel[] label) {
        label[0].setText("( " + label[0].getText() + " ,");
        this.add(label[0]);
        label[1].setText(label[1].getText()+" )");
        this.add(label[1]);
    }
}
