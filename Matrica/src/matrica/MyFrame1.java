package matrica;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Sead Mejzini && Jon Klinaku
 */
public class MyFrame1 extends JFrame {

    public MyFrame1(double[][] inputL1, double[][] inputL2, String[] a, String[] b) {
        Kalkulimi_i_problemit k = new Kalkulimi_i_problemit(inputL1, inputL2, a, b);
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel label = new JLabel("Matricat e dhena nga ana e shfrytezuesit");
        JPanel panel1 = new JPanel();
        panel1.add(label);
        PanelContent pc = new PanelContent(k);

        IterationPanel panel_21 = new IterationPanel(pc);
        TextPanel panel_22 = new TextPanel(pc);
        GraphicPanel panel_23 = new GraphicPanel(pc);

        JPanel panel3 = new JPanel(new GridLayout(1, 3));
        panel3.add(panel_21);
        panel3.add(panel_22);
        panel3.add(panel_23);
        cp.add(panel1, BorderLayout.NORTH);
        cp.add(panel3, BorderLayout.CENTER);

        Counter counter = new Counter(((IterationPanel) panel_21).content.length);
        SwapButton sb = new SwapButton(panel_23);
        JButton b1 = new Button_back(panel_21, panel_22, panel_23, counter, label, sb);
        JButton b2 = new Button_next(panel_21, panel_22, panel_23, counter, label, sb);
        JPanel panel4 = new JPanel(new FlowLayout());
        JPanel panel4_1 = new JPanel(new BorderLayout());
        panel4.setSize(this.getWidth(), 50);
        panel4.add(sb);
        panel4.add(b1);
        panel4.add(b2);
        panel4_1.add(panel4, BorderLayout.EAST);

        cp.add(panel4_1, BorderLayout.SOUTH);

        setSize(new Dimension(700, 480));
        setVisible(true);
    }
}
