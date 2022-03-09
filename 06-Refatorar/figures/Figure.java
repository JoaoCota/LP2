package figures;

import java.awt.Graphics;

public abstract class Figure {
    protected int x, y;
    protected int w, h;

    public Figure(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public abstract void paint (Graphics g);
}