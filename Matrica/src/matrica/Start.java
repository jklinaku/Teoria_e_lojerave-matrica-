/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

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
        JTextField jtf[][] = mf.jf;
        double[][] temp = new double[jtf.length][jtf[0].length];
        for (int i = 0; i < jtf.length; i++) {
            for (int j = 0; j < jtf[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                temp[i][j] = Double.parseDouble(jtf[i][j].getText());
            }
        }
        mf.dispose();
        MyFrame1 myFrame1 = new MyFrame1(temp,temp);
    }
}
