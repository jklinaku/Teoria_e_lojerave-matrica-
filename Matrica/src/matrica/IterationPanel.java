
package matrica;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 *
 * @author Jon
 */
public class IterationPanel extends AbstractPanel{
    
    public IterationPanel(PanelContent p) {
        super(p);
    }

    @Override
    public void update(int count) {
        removeAll();
        System.err.println("printojm:" + count);
        Object[] temp = content[count];
        Matrix[] m = new Matrix[2];
        m[0] = (Matrix) (temp[0]);
        m[1] = (Matrix) (temp[1]);
        String[] s1 = (String[]) temp[2];
        String[] s2 = (String[]) temp[3];
        System.out.println(count);
        setLayout(new GridLayout(s1.length + 1, s2.length + 1));
       
        for (int i = 0; i <= s1.length; i++) {
            for (int j = 0; j <= s2.length; j++) {
                if (i == 0 && j == 0) {
                    JLabel label = new JLabel("L1\\L2");
                    label.setBorder(BorderFactory.createLineBorder(Color.black));
                    add(label);
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
}
