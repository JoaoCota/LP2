package Figuras;

import java.awt.*;

public class Pentagon extends Figuras {
	private Polygon p = new Polygon();

	public Pentagon (int x, int y, int w, int h) {
		super(x, y, w, h);
        
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

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
        g2d.drawPolygon(p.xpoints, p.ypoints, p.npoints);
	}
}