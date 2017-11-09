package matrica;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Sead Mejzini && Jon Klinaku
 */
public class EntryFrame extends JFrame implements ActionListener {

    public EntryFrame() {
        this.setTitle("Iterativ strategy elimination");
        Container cp = getContentPane();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(2, 1));
        cp.add(panel);
        
        JButton button1 = new NewMatrixButton(this);// holds the frame that requires the input of matrixes
        button1.setPreferredSize(new Dimension(70, 40));

        JButton button2 = new JButton("Quit");
        button2.setPreferredSize(new Dimension(70, 40));
        button2.addActionListener(this);

        panel.add(button1);
        panel.add(button2);

        Rectangle r = new Rectangle(500, 200, 600, 0);
        this.setBounds(r);

        this.setResizable(false);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
