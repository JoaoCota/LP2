import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import figures.*;
import figures.Polygon;

class PackApp {
    public static void main (String[] args) {
        PackFrame frame = new PackFrame();
        frame.setVisible(true);
    }
}

class PackFrame extends JFrame {
    Rect r1, r2;
    Ellipse e1, e2;
    Polygon p1, p2;

    PackFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java Packages - Joao Cota");
        this.setSize(350, 350);
        this.r1 = new Rect(50,50, 100,30,"#8B0000"/*vermelho escuro*/,"#FF7F50"/*coral*/);
        this.r2 = new Rect(60,80, 140,90,"#0000FF"/*azul*/,"#00FFFF"/*ciano*/);
        this.e1 = new Ellipse(50,100, 100,30,"#8B0000"/*vermelho escuro*/,"#FF7F50"/*coral*/);
        this.e2 = new Ellipse(40,60, 120,60,"#0000FF"/*azul*/,"#00FFFF"/*ciano*/);
        this.p1 = new Polygon(new int[] {10,40,70}, new int[] {100, 40, 100}, 3,"#8B0000"/*vermelho escuro*/,"#FF7F50"/*coral*/);
        this.p2 = new Polygon(new int[] {60,90,120}, new int[] {300, 90, 300}, 3,"#0000FF"/*azul*/,"#00FFFF"/*ciano*/);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.r2.paint(g);
        this.e1.paint(g);
        this.e2.paint(g);
        this.p1.paint(g);
        this.p2.paint(g);
    }
}