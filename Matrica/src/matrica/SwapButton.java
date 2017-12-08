package matrica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Sead Mejzini && Jon Klinaku
 */
public class SwapButton extends JButton implements ActionListener {

    private GraphicPanel gp;

    public SwapButton(GraphicPanel gp) {
        super("Swap");
        this.gp = gp;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gp.isBoth()) {
            gp.update(gp.getCount());
        }
    }
}
