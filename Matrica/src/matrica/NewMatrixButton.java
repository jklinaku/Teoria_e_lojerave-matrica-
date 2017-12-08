package matrica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Sead Mejzini && Jon Klinaku
 */
public class NewMatrixButton extends JButton implements ActionListener {

    private EntryFrame f;

    public NewMatrixButton(EntryFrame f) {
        super("New strategy");
        this.f = f;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        f.dispose();
        new MyFrame();
    }

}
