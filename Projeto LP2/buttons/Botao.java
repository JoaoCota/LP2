package buttons;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import Figuras.Figuras;
import iVisible.iVisible;

public class Botao implements iVisible{
	private int idx;
	private Figuras fig;
	
	public Botao (int idx, Figuras fig){
		this.idx = idx;
		this.fig = fig;
	}
	
	public boolean clicked(int x, int y){
	    return (fig.x-5<=x && x<=fig.x+fig.w+10 && fig.y-5<=y && y<=fig.y+fig.h+10);
	}

	public void paint(Graphics g, boolean focused){
		Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        g2d.drawRect(fig.x-5, fig.y-5, fig.w+10, fig.h+10);
        
        if (focused) {
        	g2d.setColor(Color.gray);
        } else {
        	g2d.setColor(Color.LIGHT_GRAY);
        }
        g2d.fillRect(fig.x-4, fig.y-4, fig.w+9, fig.h+9);
        fig.paint(g2d, false);
	}

	public int getIdx(){
		return idx;
	}

}