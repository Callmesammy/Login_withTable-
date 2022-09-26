
package Swing;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;


public class Panel_Transparent extends JPanel{

  
    public float getAlpha() {
        return Alpha;
    }

    /**
     * @param Alpha the Alpha to set
     */
    public void setAlpha(float Alpha) {
        this.Alpha = Alpha;
        repaint();
    }

    private float Alpha =1f;
    public Panel_Transparent() {
        setOpaque(false);
    }

    @Override
    public void paint(Graphics g) {
       Graphics2D g2 = (Graphics2D)g;
       g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, Alpha));
         super.paint(g); 
    }
    
    
}
