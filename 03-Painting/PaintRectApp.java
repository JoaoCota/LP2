import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.AttributeSet.ColorAttribute;

class PaintRectApp {
    public static void main (String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}

class PaintFrame extends JFrame {
    Rect r1, r2, r3, r4, r5;

    PaintFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Painting Figures - Joao Cota");
        this.setSize(350, 350);
        this.r1 = new Rect(20,40,100,30,"#8B0000"/*vermelho escuro*/,"#FF7F50"/*coral*/);
        this.r2 = new Rect(40,60,120,60,"#0000FF"/*azul*/,"#00FFFF"/*ciano*/);
        this.r3 = new Rect(60,80,140,90,"#4B0082"/*indigo*/,"#EE82EE"/*violeta*/);
        this.r4 = new Rect(80,100,160,120,"#FF8C00"/*laranja escuro*/,"#FFA500"/*laranja*/);
        this.r5 = new Rect(100,120,180,140,"#006400"/*verde escuro*/,"#90EE90"/*verde claro*/);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.r2.paint(g);
        this.r3.paint(g);
        this.r4.paint(g);
        this.r5.paint(g);
    }
}

class Rect {
    int x, y;
    int w, h;
    String corContorno, corFundo;

    Rect (int x, int y, int w, int h, String corContorno, String corFundo) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.corContorno = corContorno;
        this.corFundo = corFundo;
    }

    void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void area(){
        if(this.w<0 || this.h<0){
            System.out.format("Valor inserido invalido.\n");
        }
        else{
            System.out.format("A area da figura eh (%d).\n", this.w*this.h);
        }
    }

    void drag(int dx, int dy){
        if(this.w<0 || this.h<0){
            System.out.format("Valor inserido invalido.\n");
        }
        else{
            System.out.format("A figura foi arrastada para (%d,%d)\n", dx+this.x, dy+this.y);
        }
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.decode(this.corContorno));
        g.drawRect(this.x,this.y, this.w,this.h);
        g.setColor(Color.decode(this.corFundo));
        g.fillRect(this.x+1,this.y+1, this.w-1,this.h-1);
    }
}