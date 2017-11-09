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

    private final Counter counter;
    private final MyPanel panel1;
    private final MyPanel panel2;
    private final JLabel label;

    public Button_back(MyPanel panel1, MyPanel panel2, Counter counter, JLabel label) {
        super("BACK");
        this.panel1 = panel1;
        this.panel2 = panel2;
        this.counter = counter;
        this.label = label;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (counter.sub()) {
            label.setText("Iteracioni i: " + counter.getCount());
            panel1.update(counter.getCount());
            panel2.update(counter.getCount());
        }
    }
}
