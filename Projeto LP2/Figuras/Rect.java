package Figuras;

import java.awt.*;

public class Rect extends Figuras {
    public Color corFundo;
	
    public Rect (int x, int y, int w, int h, Color corContorno, Color corFundo) {
        super(x, y, w, h, corContorno);
        this.corFundo = corFundo;
    }

	public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(corContorno);
        g2d.drawRect(x,y, w,h);
        g2d.setColor(corFundo);
        g2d.fillRect(x+1, y+1, w-1, h-1);
	}

    public void paintFocus(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(corContorno);
        g2d.drawRect(this.x,this.y, this.w,this.h);	
	}
}