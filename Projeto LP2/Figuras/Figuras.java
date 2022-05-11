package Figuras;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

import iVisible.iVisible;

public abstract class Figuras implements iVisible, Serializable{
    public int x, y;
    public int w, h;
    public Color corContorno, corFundo;

    public Figuras(int x, int y, int w, int h, Color corContorno, Color corFundo){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.corContorno = corContorno;
        this.corFundo = corFundo;
     }

    public void drag (int dx, int dy){
        this.x += dx;
        this.y += dy;
    }

    public boolean clicked (int x, int y){
        return (this.x<=x && x<=this.x+this.w && this.y<=y && y<=this.y+this.h);
    }

    public void paint (Graphics g, boolean focused){
        if(focused){
    		Rect RectFocus = new Rect(this.x -4, this.y -4, this.w + 8, this.h + 8, Color.red, Color.red);
    		RectFocus.paintFocus(g);
    		Rect MiniRectFocus = new Rect (RectFocus.x + RectFocus.w - 8, RectFocus.y + RectFocus.h - 8, 12, 12, Color.red, Color.white);
    		MiniRectFocus.paint(g, false);
    	}
    }
}