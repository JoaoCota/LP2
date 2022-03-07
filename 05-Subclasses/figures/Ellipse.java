package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Ellipse extends Figure {
    int x, y;
    int w, h;
    //String EcorContorno, EcorFundo;

    public Ellipse (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        //this.EcorContorno = EcorContorno;
        //this.EcorFundo = EcorFundo;
    }

    public void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        //g2d.setColor(Color.decode(this.EcorContorno));
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
        //g2d.setColor(Color.decode(this.EcorFundo));
        //g2d.fillOval(this.x, this.y, this.w, this.h);
    }
}