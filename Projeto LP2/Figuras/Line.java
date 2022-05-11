package Figuras;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class Line extends Figuras {
	
	public Line (int x, int y, int w, int h, Color corContorno, Color corFundo){
		super(x, y, w, h, corContorno, corFundo);
	}

	public void paint(Graphics g, boolean focused){
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(corContorno);
        g2d.drawLine(x, y, x+w, y+h);
		super.paint(g2d, focused);
	}
}