package Figuras;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ellipse extends Figuras {

    public Ellipse (int x, int y, int w, int h) {
    	super(x, y, w, h);
    }

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
        g2d.draw(new Ellipse2D.Double(x,y, w,h));
	}
    
}