import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

class PaintEllipseApp {
    public static void main (String[] args) {
        RectEllipseFrame frame = new RectEllipseFrame();
        frame.setVisible(true);
    }
}

class RectEllipseFrame extends JFrame {
    //Rect r1, r2, r3, r4, r5;
    Ellipse e1, e2, e3, e4, e5;

    RectEllipseFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Rect + Ellipse");
        this.setSize(350, 350);
        //this.r1 = new Rect(20,40,100,30,"#8B0000"/*vermelho escuro*/,"#FF7F50"/*coral*/);
        //this.r2 = new Rect(40,60,120,60,"#0000FF"/*azul*/,"#00FFFF"/*ciano*/);
        //this.r3 = new Rect(60,80,140,90,"#4B0082"/*indigo*/,"#EE82EE"/*violeta*/);
        //this.r4 = new Rect(80,100,160,120,"#FF8C00"/*laranja escuro*/,"#FFA500"/*laranja*/);
        //this.r5 = new Rect(100,120,180,140,"#006400"/*verde escuro*/,"#90EE90"/*verde claro*/);
        this.e1 = new Ellipse(20,40,100,30,"#8B0000"/*vermelho escuro*/,"#FF7F50"/*coral*/);
        this.e2 = new Ellipse(40,60,120,60,"#0000FF"/*azul*/,"#00FFFF"/*ciano*/);
        this.e3 = new Ellipse(60,80,140,90,"#4B0082"/*indigo*/,"#EE82EE"/*violeta*/);
        this.e4 = new Ellipse(80,100,160,120,"#FF8C00"/*laranja escuro*/,"#FFA500"/*laranja*/);
        this.e5 = new Ellipse(100,120,180,140,"#006400"/*verde escuro*/,"#90EE90"/*verde claro*/);
    }

    public void paint (Graphics g) {
        super.paint(g);
        /*this.r1.paint(g);
        this.r2.paint(g);
        this.r3.paint(g);
        this.r4.paint(g);
        this.r5.paint(g);*/
        this.e1.paint(g);
        this.e2.paint(g);
        this.e3.paint(g);
        this.e4.paint(g);
        this.e5.paint(g);
    }
}

class Rect {
    int x, y;
    int w, h;
    String RcorContorno, RcorFundo;

    Rect (int x, int y, int w, int h, String RcorContorno, String RcorFundo) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.RcorContorno = RcorContorno;
        this.RcorFundo = RcorFundo;
    }

    void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.decode(this.RcorContorno));
        g.drawRect(this.x,this.y, this.w,this.h);
        g.setColor(Color.decode(this.RcorFundo));
        g.fillRect(this.x+1,this.y+1, this.w-1,this.h-1);
    }
}

class Ellipse {
    int x, y;
    int w, h;
    String EcorContorno, EcorFundo;

    Ellipse (int x, int y, int w, int h, String EcorContorno, String EcorFundo) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.EcorContorno = EcorContorno;
        this.EcorFundo = EcorFundo;
    }

    void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.decode(this.EcorContorno));
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
        g2d.setColor(Color.decode(this.EcorFundo));
        g2d.fillOval(this.x, this.y, this.w, this.h);
    }
}