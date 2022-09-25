
package Component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.GeneralPath;
import javax.swing.JLayeredPane;


public class slider extends JLayeredPane{

    public slider() {
    }
    
//Here we set the color, shape and 2d Graphics 

    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(252, 54, 252));
        int height =getHeight();
        g2.fill(createShape(height, 90, 110,60,150));
        g2.setColor(new Color(88, 11, 88));
        g2.fill(createShape(height, 85, 70,90,57,120));
        g2.dispose();
    }
    
    // In this segment we create the shape with calculations and Cubicurve2d and GeneralPaths
    
    private Shape createShape(int location, int straight, int ...point){
        int width = getWidth();
        int height = getHeight();
        int ss = width/point.length;
        int size = location;
        
        GeneralPath p = new GeneralPath();
        int xs =0;
        int xy =0;
        int baze = location - straight;
        for(int points: point){
            points = size - points;
            int s = xs +ss/2;
            p.append(new CubicCurve2D.Double(xy, baze, s, baze, s, points, xy+ss, points), true);
            xs +=ss;
            xy += ss;
            baze = points;
        }
        p.lineTo(xy, width);
        p.lineTo(width, height);
        p.lineTo(0, height);
        return p;
    }
    
}
