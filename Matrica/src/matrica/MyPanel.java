/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrica;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Sead Mejzini
 */
public class MyPanel extends JPanel {

    private Kalkulimi_i_problemit kp;
    private final boolean isMatix;

    public MyPanel(Kalkulimi_i_problemit kp, boolean isMatrix) {
        this.kp = kp;
        this.isMatix = isMatrix;
    }

    @Override
    public void paintComponent(Graphics g) {
        if (isMatix) {
            update1(g);
        } else {
            update2(g);
        }
    }

    public void update1(Graphics g) {
        //permbajtja e paneles qe e ka matricen 
        g.drawString("Hi", 20, 20);
    }

    public void update2(Graphics g) {
        //permbajtja e paneles qe e ka tekstin
        g.drawString("Hello", 30, 30);

    }
}
