package Figuras;

import java.awt.Graphics;

public abstract class Figuras {
    public int x, y;
    public int w, h;

    public Figuras(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public abstract void paint (Graphics g);
}