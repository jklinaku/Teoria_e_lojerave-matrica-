package matrica;

import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author Sead Mejzini && Jon Klinaku
 */
public abstract class AbstractPanel extends JPanel {

    protected Object[][] content;

    public AbstractPanel(PanelContent p) {
        super(new GridLayout());
        content = p.getContent();
        update(0);
    }

    public abstract void update(int count);
}
