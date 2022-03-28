package Figuras;

import java.awt.*;

public class Rect extends Figuras {
	
    public Rect (int x, int y, int w, int h) {
        super(x, y, w, h);
    }

	public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRect(x,y, w,h);
	}
}