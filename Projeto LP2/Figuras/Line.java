package Figuras;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class Line extends Figuras {
	
	public Line (int x, int y, int w, int h, Color corContorno){
		super(x, y, w, h, corContorno);
	}

	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(corContorno);
        g2d.drawLine(x, y, x+w, y+h);
	}
}