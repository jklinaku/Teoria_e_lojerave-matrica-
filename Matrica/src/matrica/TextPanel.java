/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrica;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.plaf.basic.BasicTextUI;

/**
 *
 * @author Jon
 */
public class TextPanel extends AbstractPanel {

    public TextPanel(PanelContent p) {
        super(p);

    }

    @Override
    public void update(int count) {
        removeAll();
        Object[] temp = content[count];
        Matrix[] m = new Matrix[2];
        m[0] = (Matrix) (temp[0]);
        m[1] = (Matrix) (temp[1]);
        String[] s1 = (String[]) temp[2];
        String[] s2 = (String[]) temp[3];
        JTextArea ta = new JTextArea("");
        ta.setEditable(false);
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        JScrollPane scroller = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        if (s1.length == s2.length) {
            ta.append("Ce te dy nga lojtaret kane nga " + s1.length + " strategji. Lojetari i pare ka strategjite: ");
            for (int i = 0; i < s1.length - 1; i++) {
                ta.append(s1[i] + ", ");
            }
            ta.append(s1[s1.length - 1] + " ndersa lojetari i dyte ka strategjite: ");
            for (int i = 0; i < s1.length - 1; i++) {
                ta.append(s2[i] + ", ");
            }
            ta.append(s2[s1.length - 1] + ".");
        } else {
            ta.append("lojetari i pare ka  " + s1.length + " strategji, ndersa lojetari i dyte ka " + s2.length + " strategji. Lojetari i pare ka strategjite: ");
            for (int i = 0; i < s1.length - 1; i++) {
                ta.append(s1[i] + ", ");
            }
            ta.append(s1[s1.length - 1] + " ndersa lojetari i dyte ka strategjite: ");
            for (int i = 0; i < s2.length - 1; i++) {
                ta.append(s2[i] + ", ");
            }
            ta.append(s2[s2.length - 1] + ".");

        }
        
        

        add(scroller);
        revalidate();

    }

}
