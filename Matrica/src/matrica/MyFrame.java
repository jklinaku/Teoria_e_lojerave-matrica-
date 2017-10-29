/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrica;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
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
    protected JTextField[][] jf;
    public MyFrame() {
        int row = Integer.parseInt(JOptionPane.showInputDialog("Shtypni nr. rreshtave"));
        int col = Integer.parseInt(JOptionPane.showInputDialog("Shtypni nr. kolonave"));
        
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        JLabel label = new JLabel("Mbushni matricen me te dhena");
        JPanel labelPanel = new JPanel();
        labelPanel.add(label);
        labelPanel.setEnabled(true);
        JPanel panel1 = new JPanel(new GridLayout(row+1,col+1));
        jf = new JTextField[row+1][col+1]; 
        for (int i = 0; i <=row; i++) {
            for (int j = 0; j <=col; j++) {
                if (i==0&&j==0){
                    jf[0][0] = new JTextField("L1\\L2");
                    panel1.add(jf[0][0]);
                    j+=1;
                } 
                jf[i][j] = new JTextField();
                panel1.add(jf[i][j]);
            }
        }
        cp.add(labelPanel,BorderLayout.NORTH);
        cp.add(panel1,BorderLayout.CENTER);
        JPanel panel2 = new JPanel(new BorderLayout());
        JButton b = new Start(this);
        panel2.add(b,BorderLayout.WEST);
        cp.add(panel2,BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    public JTextField[][] getJf() {
        return jf;
    }
}
