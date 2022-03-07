package figures;

import java.awt.*;

public class Rect extends Figure {
    int x, y;
    int w, h;
    //String corContorno, corFundo;

    Rect (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        //this.corContorno = corContorno;
        //this.corFundo = corFundo;
    }

    public void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        //g2d.setColor(Color.decode(this.corContorno));
        g2d.drawRect(this.x,this.y, this.w,this.h);
        //g2d.setColor(Color.decode(this.corFundo));
        //g2d.fillRect(this.x+1,this.y+1, this.w-1,this.h-1);
    }
}