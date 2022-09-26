
package Component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.GeneralPath;
import javax.swing.JComponent;
import javax.swing.JPanel;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;


public class slider extends JComponent{

    private float minate = 1f;
    private boolean isLoading;
    private int header =45;
    
    private final Animator animate;
    
    
    public slider() {
   
        TimingTarget target = new TimingTargetAdapter(){
            @Override
            public void timingEvent(float fraction) {
               minate = fraction;
               repaint();
            }
            
        
        };
    animate = new Animator(3000, target);
    animate.setResolution(0);
    animate.setAcceleration(0.5f);
    animate.setDeceleration(0.5f);
    }

    public void start(boolean strt){
        isLoading = strt;
        
            
       
        animate.start();
    }
// easing maths for the animations 
    private float easeInElastic(float x){
         double v;
         v= 1 - Math.pow(1 - x, 3);
          return (float)v;
    }
    
  private float easeOutElastic(float x){
      double v;
    v = 1 - Math.sqrt(1 - Math.pow(x, 2));
    return (float)v;
  }
//Here we set the color, shape and 2d Graphics 
    @Override
    public void paint(Graphics g) {
             
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
       
            g2.setColor(new Color(252, 54, 252));
        int height =(int) (getHeight()*(1f-easeInElastic(minate)) );
        g2.fill(createShape(height, 90, 110,60,150));
        g2.setColor(new Color(88, 11, 88));
        g2.fill(createShape(height, 85, 70,90,57,120));
        int hightt = (int) (getHeight() * (1f-easeOutElastic(minate)));
        hightt +=header;
        g2.setColor(new Color(255,255,255));
        g2.fillRect(0, hightt, getWidth(), getHeight());
            super.paint(g); 
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
