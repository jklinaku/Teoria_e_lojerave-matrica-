package matrica;

import java.awt.Dimension;
import java.awt.Graphics;

/**
 *
 * @author Sead Mejzini && Jon Klinaku
 */
public class GraphicPanel extends AbstractPanel {

    boolean player1, player2;
    private int w, h, delta, x, y;
    private double min, max;
    private double[] y0, y1;
    private boolean both;
    private int count;
    private boolean firstTime = true;

    public GraphicPanel(PanelContent p) {
        super(p);
        count = 0;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.translate(0, 10);
        Dimension size = getSize();
        delta = 15;
        h = size.height;
        w = size.width;
        x = w - 2 * delta;
        y = h - 2 * delta;
        try {
            max = max(y0, y1);
            min = min(y0, y1);
            double distanca;
            if (max < 0) {
                max = 0;
                distanca = Math.abs(min);
                g.translate(delta, delta);
            } else if (min > 0) {
                distanca = max;
                min = 0;
                g.translate(delta, y);
            } else {
                distanca = Math.abs(max - min);
                g.translate(delta, (int) ((y * max) / distanca));
            }
            double njesia = (y) / distanca;

            //vizaton boshtin koordinativ
            g.drawLine(delta, -(int) (max * njesia) - delta, delta, Math.abs((int) (min * njesia)) + delta);
            g.drawLine(x - delta, -(int) (max * njesia) - delta, x - delta, Math.abs((int) (min * njesia)) + delta);
            // g.drawLine(w-delta, delta, w-delta,h-delta);  

            g.drawString("0", delta - 9, 11);
            g.drawString("1", x - 3, 11);
            g.drawLine(0, 0, x, 0);

            //vendosja e numrave anash boshtit
            for (int i = 1; i < (int) max + 1; i++) {
                g.drawString(i + " -", delta - 12, -(int) (njesia * i) + 5);
                g.drawString("-" + i, x - delta - 2, -(int) (njesia * i) + 5);
            }
            for (int i = 1; i < (int) Math.abs(min) + 1; i++) {
                g.drawString("-" + i + " -", delta - 15, (int) (njesia * i) + 5);
                g.drawString("- -" + i, x - delta - 2, (int) (njesia * i) + 5);
            }
            for (int i = 0; i < y0.length; i++) {
                g.drawLine(delta, -(int) (y0[i] * njesia), x - delta, -(int) (y1[i] * njesia));
            }
        } catch (Exception e) {
            g.drawString("Matrica te papershtatshme", 20, 30);
        }
        this.repaint();
    }

    @Override
    public void update(int count) {
        this.count = count;
        Object[] temp = content[count];
        Matrix[] m = new Matrix[2];
        m[0] = (Matrix) (temp[0]);
        m[1] = (Matrix) (temp[1]);
        both = m[0].getCol() == 2 && m[0].getRow() == 2;
        if (firstTime && both) {
            player1 = true;
            player2 = false;
            firstTime = false;
        } else if (!firstTime && both) {
            player1 = false;
            player2 = true;
            firstTime = true;
        } else {
            player1 = m[0].getCol() == 2;
            player2 = m[0].getRow() == 2;
        }
        if (player1 && m[0].getRow() > 0) {
            update1(m[0]);
        } else if (player2 && m[0].getCol() > 0) {
            update1(m[1]);
        } else {
            y0 = new double[0];
            y1 = new double[0];
        }
    }

    private void update1(Matrix m) {
        if (player1) {
            y0 = new double[m.getRow()];
            y1 = new double[m.getRow()];

            for (int i = 0; i < m.getRow(); i++) {
                y0[i] = m.getElement(i, 0);
                y1[i] = m.getElement(i, 1);
            }
        } else {
            y0 = new double[m.getCol()];
            y1 = new double[m.getCol()];

            for (int i = 0; i < m.getCol(); i++) {
                y0[i] = m.getElement(0, i);
                y1[i] = m.getElement(1, i);
            }
        }
    }

    private double max(double[] a, double[] b) {
        double temp1 = a[0], temp2 = b[0];

        for (int i = 1; i < a.length; i++) {
            temp1 = temp1 < a[i] ? a[i] : temp1;
            temp2 = temp2 < b[i] ? b[i] : temp2;
        }

        return Math.max(temp1, temp2);
    }

    private double min(double[] a, double[] b) {
        double temp1 = a[0], temp2 = b[0];

        for (int i = 1; i < a.length; i++) {
            temp1 = temp1 > a[i] ? a[i] : temp1;
            temp2 = temp2 > b[i] ? b[i] : temp2;
        }

        return Math.min(temp1, temp2);
    }

    public boolean isBoth() {
        return both;
    }

    public int getCount() {
        return count;
    }
}
