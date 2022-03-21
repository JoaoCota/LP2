package Figuras;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class Line extends Figuras {
	
	public Line (int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
        g2d.drawLine(x, y, x+w, y+h);
	}
}