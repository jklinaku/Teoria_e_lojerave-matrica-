/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrica;

import java.awt.Dimension;
import java.awt.Graphics;

/**
 *
 * @author Jon
 */
public class GraphicPanel extends AbstractPanel {

    boolean player1 = true;
    private int w, h, delta, x, y, Oy;
    private double min, max;
    private Graphics g;
    private double[] y0, y1;

    public GraphicPanel(PanelContent p) {
        super(p);

    }

    @Override
    public void paintComponent(Graphics g) {
//        g.translate(0, 0);
        Dimension size = getSize();
        delta = 15;
        Oy = h - delta;
        h = size.height;
        w = size.width;
        x = w - 2 * delta;
        y = h - 2 * delta;
        max = max(y0, y1);
        min = min(y0, y1);
        System.out.println(max);
        System.out.println(min);
        double distanca;
        int state;
        if (max < 0) {
            state=1;
            distanca = min;
        } else if (min > 0) {
            state=-1;
            distanca = max;
        } else {
            state=0;
            distanca = Math.abs(max - min);
        }
        double njesia = (y) / distanca;
        Oy = (int) (njesia * max);

        //vizaton boshtin koordinativ
        g.drawLine(delta, 0, delta, h);
        // g.drawLine(w-delta, delta, w-delta,h-delta);  

        g.drawString("O", delta - 9, Oy + 11 + delta);
        g.drawString("1", w - delta - 3, Oy + 11 + delta);
        g.drawLine(0, Oy + delta, w - delta, Oy + delta);
        
        for (int i = 0, j = (int) max; i <= Math.ceil(distanca); i++, j--) {

            int b = (int) (njesia * i);
            if (j > 0) {
                g.drawString(j + "", delta - 11, b + 6 + delta);
            } else if (j < 0) {
                g.drawString(j + "", delta - 15, b + 6 + delta);
            }
            g.drawLine(delta - 3, b + delta, delta + 3, b + delta);

        }
        double[] a = new double[y0.length];
        double[] b = new double[y1.length];
        for(int i=0;i<y0.length;i++){
            switch (state) {
                case 0:
                    a[i]=y0[i]+distanca-min(y0,y1);
                    b[i]=y1[i]+distanca-max(y1,y0);
                    break;
                default:
                    a[i]=y0[i]-max(y1,y0);
                    b[i]=y1[i]-min(y1,y0);
                    break;
            }
            
        }
        for(int i=0;i<y0.length;i++){
            g.drawLine(delta,(int) ((max(a,a)-a[i])*njesia)+delta, x+delta, (int) ((max(b,b)-b[i])*njesia)+delta);
        }
      

        


    }

    @Override
    public void update(int count) {

        Object[] temp = content[count];
        Matrix[] m = new Matrix[2];
        m[0] = (Matrix) (temp[0]);
        y0 = new double[m[0].getRow()];
        y1 = new double[m[0].getRow()];

        for (int i = 0; i < m[0].getRow(); i++) {
            y0[i] = m[0].getElement(i, 0);
            y1[i] = m[0].getElement(i, 1);

        }

    }

    private void update1() {

    }

    private void update2() {

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
}
