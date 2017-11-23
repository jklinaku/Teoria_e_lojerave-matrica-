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
public class SwapButton extends JButton implements ActionListener {

    private GraphicPanel gp;

    public SwapButton(GraphicPanel gp) {
        super("Swap");
        this.gp = gp;
        //setEnabled(gp.isBoth());
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean temp = gp.isBoth();
        if (gp.isBoth()) {
            //setEnabled(true);
            gp.setPlayer1(!gp.isPlayer1());
        }
    }
}
