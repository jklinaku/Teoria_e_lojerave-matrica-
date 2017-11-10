/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrica;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Sead Mejzini
 */
public class MyFrame extends JFrame {

    protected ElementJTextField[][] jf;
    protected ElementPanel[][] jp;

    public MyFrame() {
        int row = RCnum("rreshtave");
        int col = RCnum("kolonave");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        JLabel label = new JLabel("Mbushni matricen me te dhena");
        JPanel labelPanel = new JPanel();
        labelPanel.add(label);
        labelPanel.setEnabled(true);
        JPanel panel1 = new JPanel(new GridLayout(row + 1, col + 1));
        jf = new ElementJTextField[row + 1][col + 1];
        jp = new ElementPanel[row][col];
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                if (i == 0 && j == 0) {
                    JLabel label1 = new JLabel("L1\\L2");
                    panel1.add(label1);
                    //continue;
                } else if (i == 0) {
                    jf[0][j] = new ElementJTextField("S"+j);
                    panel1.add(jf[0][j]);
                } else if (j == 0) {
                    jf[i][0] = new ElementJTextField("S"+i);
                    panel1.add(jf[i][0]);
                } else {
                    ElementJTextField[] temp = {new ElementJTextField(""+((int)(Math.random()*19)-9)), new ElementJTextField(""+((int)(Math.random()*19)-9))};
                    jp[i - 1][j - 1] = new ElementPanel(temp);
                    panel1.add(jp[i - 1][j - 1]);
                }
            }
        }
        cp.add(labelPanel, BorderLayout.NORTH);
        cp.add(panel1, BorderLayout.CENTER);
        JPanel panel2 = new JPanel(new BorderLayout());
        JButton b = new Start(this);
        panel2.add(b, BorderLayout.WEST);
        cp.add(panel2, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    public int RCnum(String a) {
        int ans = 0;
        try {
            ans = Integer.parseInt(JOptionPane.showInputDialog("Shtypni numrin e " + a));
            if (ans > 0) {
                return ans;
            } else {
                JOptionPane.showMessageDialog(null, "bad input");
                return RCnum(a);
            }
        } catch (HeadlessException | NumberFormatException e1) {
            JOptionPane.showMessageDialog(null, "bad input");
            return RCnum(a);
        }
    }

    
    
  
}
