/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Sead Mejzini
 */
public class Start extends JButton implements ActionListener {

    private final MyFrame mf;

    public Start(MyFrame mf) {
        super("START");
        this.mf = mf;
        addActionListener(this);
         
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ElementJTextField jtf[][] = mf.jf;
        ElementPanel ep[][] = mf.jp;
        double[][] temp1 = new double[jtf.length - 1][jtf[0].length - 1];
        double[][] temp2 = new double[jtf.length - 1][jtf[0].length - 1];
        String[] l1 = new String[jtf.length - 1];
        String[] l2 = new String[jtf[0].length - 1];
        try {
            for (int i = 0; i < jtf.length; i++) {
                for (int j = 0; j < jtf[0].length; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    } else if (i == 0) {
                        l2[j - 1] = jtf[0][j].getText();
                    } else if (j == 0) {
                        l1[i - 1] = jtf[i][0].getText();
                    } else {
                        temp1[i - 1][j - 1] = Double.parseDouble(ep[i - 1][j - 1].input[0].getText());
                        temp2[i - 1][j - 1] = Double.parseDouble(ep[i - 1][j - 1].input[1].getText());
                    }
                }
            }
            mf.dispose();
            new MyFrame1(temp1, temp2, l1, l2);
        } catch (Exception e1) {
            mf.dispose();
            JOptionPane.showMessageDialog(null, "Input i gabuar");
            new MyFrame();
        }
    }
}
