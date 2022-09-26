
package Swing;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLayeredPane;


public class Panel_Transparent extends JLayeredPane{

  
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
        setOpaque(true);
    }

    @Override
    public void paint(Graphics g) {
       
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, Alpha));
         super.paint(g); 
    }
    
    
}
