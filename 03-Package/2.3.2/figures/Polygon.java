package figures;

import java.awt.*;

public class Polygon {
    private int[] xP;
    private int[] yP;
    private int p;
    private String PcorContorno, PcorFundo;

    public Polygon (int[] xP, int[] yP, int p, String PcorContorno, String PcorFundo) {
        this.xP = xP;
        this.yP = yP;
        this.p = p;
        this.PcorContorno = PcorContorno;
        this.PcorFundo = PcorFundo;
    }

    public void print () {
        System.out.format("Triangulo de pontos x: (%d,%d,%d) y: (%d,%d,%d) na posicao (%d,%d).\n",
           this.xP[0],  this.xP[1], this.xP[2], this.yP[0], this.yP[1], this.yP[2]);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.decode(this.PcorContorno));
        g2d.drawPolygon(this.xP, this.yP, this.p);
        g2d.setColor(Color.decode(this.PcorFundo));
        g2d.fillPolygon(this.xP, this.yP, this.p);
    }
}