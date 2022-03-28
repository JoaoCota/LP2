import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Figuras.*;

import java.util.ArrayList;
import java.util.Random;

class listApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figuras> figs = new ArrayList<Figuras>();
    Random rand = new Random();
    Point posMouse = null;

    ListFrame () {
        this.setTitle("Projeto 1/2 - Joao Cota");
        this.setSize(700, 700);
        setLocationRelativeTo(null);
        
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        
        this.addKeyListener(new KeyAdapter() {
        	public void keyPressed (KeyEvent evt) {
        		
        		posMouse = getMousePosition();
        		int x = posMouse.x;
                int y = posMouse.y;
                int w = 50;
                int h = 50;
                
                if (evt.getKeyChar() == 'l') {
                    figs.add(new Line(x, y, w, 0));
                } else if (evt.getKeyChar() == 'r') {
                	figs.add(new Rect(x, y, w, h));             	
                } else if (evt.getKeyChar() == 'e') {
                	figs.add(new Ellipse(x, y, w, h));               	
                } else if (evt.getKeyChar() == 'p') {
                	figs.add(new Pentagon(x, y, w, h));              	
                }
                repaint();
        	}
		});

    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figuras fig: this.figs) {
            fig.paint(g);
        }
        
    }
}