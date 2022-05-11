package Figuras;

import java.awt.*;
import java.awt.geom.Ellipse2D;


public class Ellipse extends Figuras{

    public Ellipse (int x, int y, int w, int h, Color corContorno, Color corFundo){
    	super(x, y, w, h, corContorno, corFundo);
    }

	public void paint(Graphics g, boolean focused){
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(corContorno);
        g2d.draw(new Ellipse2D.Double(x,y, w,h));
		g2d.setColor(corFundo);
		g2d.fillOval(x,y,w,h);
		super.paint(g2d,focused);
	}
    
}