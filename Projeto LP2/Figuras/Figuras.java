package Figuras;

import java.awt.Color;
import java.awt.Graphics;
import iVisible.iVisible;

public abstract class Figuras implements iVisible{
    public int x, y;
    public int w, h;
    public Color corContorno;

    public Figuras(int x, int y, int w, int h, Color corContorno){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.corContorno = corContorno;
    }

    public void drag (int dx, int dy){
        this.x += dx;
        this.y += dy;
    }

    public boolean clicked (int x, int y){
        return (this.x<=x && x<=this.x+this.w && this.y<=y && y<=this.y+this.h);
    }

    public abstract void paint (Graphics g);
}