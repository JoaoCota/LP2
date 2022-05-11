package Figuras;

import java.awt.*;

public class Pentagon extends Figuras {
	private Polygon p = new Polygon();

	public Pentagon (int x, int y, int w, int h, Color corContorno, Color corFundo){
		super(x, y, w, h, corContorno, corFundo);
        
        p.npoints = 4;
        p.xpoints[0] = (int) (x + w/2);
        p.xpoints[1] = x + w;
        p.xpoints[2] = (int) (x + w*0.75);
        p.xpoints[3] = (int) (x + w*0.25);
        
        p.ypoints[0] = y;
        p.ypoints[1] = (int) (y + h*0.40);
        p.ypoints[2] = y+h;
        p.ypoints[3] = y+h;
        
        p.addPoint(x, (int) (y + h*0.40));
    }

	public void paint(Graphics g, boolean focused){
		Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(corContorno);
        g2d.drawPolygon(p.xpoints, p.ypoints, p.npoints);
        g2d.setColor(corFundo);
        g2d.fillPolygon(p);
        super.paint(g2d, focused);
	}
}