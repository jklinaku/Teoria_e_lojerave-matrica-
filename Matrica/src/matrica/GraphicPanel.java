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
public class GraphicPanel extends AbstractPanel{

    public GraphicPanel(PanelContent p) {
        super(p);
    }

    @Override
     public void  paintComponent(Graphics g){
        Dimension size = getSize();
        int y= size.height;
        int x= size.width;
        g.drawLine(0, 0, x, y);
        
    }
    @Override
    public void update(int count) {
        
    }
    
}
