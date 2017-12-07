package matrica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Sead Mejzini && Jon Klinaku
 */
public class Button_back extends JButton implements ActionListener {

    private Counter counter;
    private IterationPanel panel1;
    private TextPanel panel2;
    private GraphicPanel panel3;
    private JLabel label;
    private SwapButton sb;

    public Button_back(IterationPanel panel1, TextPanel panel2, GraphicPanel panel3, Counter counter, JLabel label, SwapButton sb) {
        super("BACK");
        this.panel1 = panel1;
        this.panel2 = panel2;
        this.panel3 = panel3;
        this.counter = counter;
        this.label = label;
        this.sb = sb;
        sb.setEnabled(panel3.isBoth());
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (counter.sub()) {
            label.setText("Iteracioni i: " + counter.getCount());
            panel1.update(counter.getCount());
            panel2.update(counter.getCount());
            panel3.update(counter.getCount());
            sb.setEnabled(panel3.isBoth());
        }
    }
}
