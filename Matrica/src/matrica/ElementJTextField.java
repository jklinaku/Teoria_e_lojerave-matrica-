package matrica;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/**
 *
 * @author Sead Mejzini && Jon Klinaku
 */
public class ElementJTextField extends JTextField implements FocusListener {

    private String text;

    public ElementJTextField(String text) {
        setForeground(Color.gray);
        setText(text);

        this.text = text;
        addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {
        this.selectAll();
        setForeground(Color.black);
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (this.getText().isEmpty()) {
            setForeground(Color.gray);
            setText(text);
        }

    }
}
