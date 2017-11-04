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
public class MyPanel extends JPanel {

    private Kalkulimi_i_problemit kp;
    private PanelContent pc;
    private final boolean isMatix;
    protected Object[][] content;

    public MyPanel(Kalkulimi_i_problemit kp, boolean isMatrix) {
        super(new GridLayout());
        this.kp = kp;
        this.isMatix = isMatrix;
        pc = new PanelContent(kp);
        content = pc.getContent();
        setBorder(BorderFactory.createLineBorder(Color.black));
        update(0);
    }

    public void update(int count) {
        if (isMatix) {
            update1(count);
        } else {
            update2(count);
        }
    }

    public void update1(int count) {
        removeAll();
        Object[] temp = content[count];
        Matrix[] m = {(Matrix) (temp[0]), (Matrix) (temp[1])};
        String[] s1 = (String[]) temp[2];
        String[] s2 = (String[]) temp[3];
        String[][] a = {s1, s2};
        setLayout(new GridLayout(s1.length + 1, s2.length + 1));
        for (int i = 0; i <= s1.length; i++) {
            for (int j = 0; j <= s2.length; j++) {
                if (i == 0 && j == 0) {
                    JLabel label = new JLabel("L1\\L2");
                    label.setBorder(BorderFactory.createLineBorder(Color.black));
                    add(label);
                    continue;
                } else if (i == 0) {
                    JLabel label = new JLabel(s2[j - 1]);
                    label.setBorder(BorderFactory.createLineBorder(Color.black));
                    add(label);
                } else if (j == 0) {
                    JLabel label = new JLabel(s1[i - 1]);
                    label.setBorder(BorderFactory.createLineBorder(Color.black));
                    add(label);
                } else {
                    JLabel[] temp1 = {new JLabel("" + m[0].getContent()[i - 1][j - 1]), new JLabel("" + m[1].getContent()[i - 1][j - 1])};
                    ElementPanel ep = new ElementPanel(temp1);
                    ep.setBorder(BorderFactory.createLineBorder(Color.black));
                    add(ep);
                }
            }
        }
        revalidate();
    }

    public void update2(int count) {
        // add(new JLabel("Do te vije se shpejti!!!!!"));
    }
}
