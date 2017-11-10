/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrica;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Sead Mejzini
 */
public abstract class AbstractPanel extends JPanel {

    //private Kalkulimi_i_problemit kp;
   // private PanelContent pc;
   // private final boolean isMatix;
    protected Object[][] content;

    public AbstractPanel(PanelContent p) {
        super(new GridLayout());
     //   this.kp = kp;
       // this.isMatix = isMatrix;
     //   pc = new PanelContent(kp);
    // pc=p;
        content = p.getContent();
        setBorder(BorderFactory.createLineBorder(Color.black));
        update(0);
    }

//    public void update(int count) {
//        if (isMatix) {
//            update1(count);
//        } else {
//            update2(count);
//        }
//    }

    public abstract void update(int count);
     

//    public void update2(int count) {
//    }
}
