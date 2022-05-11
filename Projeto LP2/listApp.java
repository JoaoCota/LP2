// ***********************************************************************************************
// PROJETO LP2 - ALUNO JOÃO COTA

// PARA INSTRUÇÕES DE USO, VISITE O README.
// BREVES COMENTARIOS PARA ENTENDER PARTES DO CÓDIGO ESTÃO ANTES DE CADA FUNCIONALIDADE.
// ***********************************************************************************************

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Figuras.*;
import buttons.*;

import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;
import java.io.*;
import buttons.Botao;

class listApp {
    public static void main (String[] args){
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    private ArrayList<Figuras> figs = new ArrayList<Figuras>();
    private ArrayList<Rect> cores = new ArrayList<Rect>();
    private ArrayList<Botao> botoes = new ArrayList<Botao>();
    private Botao botaoFocus = null;
    private Random rand = new Random();
    private Point posMouse = null;
    private Figuras focus = null;
    private Rect rectFocus = null;
    private Rect miniRectFocus = new Rect (0, 0, 12, 12, Color.red, Color.white);
    private boolean quadradinhoFocus = false;
    private boolean coresFocus = false;

    ListFrame(){
        setFocusTraversalKeysEnabled(false);
        this.setTitle("Projeto 1/2 - Joao Cota");
        this.setSize(700, 700);
        setLocationRelativeTo(null);
        
        //Abrir arquivo
        try{
        	FileInputStream f = new FileInputStream("projeto.bin");
        	ObjectInputStream o = new ObjectInputStream(f);
        	this.figs = (ArrayList<Figuras>) o.readObject();
        	o.close();
        }
        catch (Exception x){
        	System.out.println("Erro ao tentar abrir o arquivo.");
        }
        //Salvar arquivo
        this.addWindowListener(
            new WindowAdapter(){
                public void windowClosing (WindowEvent e){
                	try{
                		FileOutputStream f = new FileOutputStream("projeto.bin");
                		ObjectOutputStream o = new ObjectOutputStream(f);
                		o.writeObject(figs);
                		o.flush();
                		o.close();
                	}
                    catch (Exception x){
                		System.out.println("Erro ao tentar gravar o arquivo.");
                	}
                    System.exit(0);
                }
            }
        );

        //Criando botões
        botoes.add(new Botao(1, new Line(15, 500, 35, 35, Color.black, Color.black)));
        botoes.add(new Botao(2, new Rect(15, 545, 35, 35, Color.black, Color.black)));
        botoes.add(new Botao(3, new Ellipse(15, 590, 35, 35, Color.black, Color.black)));
        botoes.add(new Botao(4, new Pentagon(15, 635, 35, 35, Color.black, Color.black)));

        // Manipulações de clique
        this.addMouseListener(new MouseAdapter(){
        	public void mousePressed (MouseEvent evt){
        		posMouse = getMousePosition();

                if((10<=posMouse.x && posMouse.x<=55) && (495<=posMouse.y && posMouse.y<=675)){
                    System.out.println("1");
                    quadradinhoFocus = false;
                    coresFocus = false;
                    focus = null;
                    for(Botao botao: botoes){
                        if(botao.clicked(posMouse.x, posMouse.y)){
                            botaoFocus = botao;
                        }
                    }
                    repaint();
                }
                
                // Teste do clique na paleta
                else if(focus != null && (cores.get(0).x <= posMouse.x && posMouse.x <= (cores.get(21).x + cores.get(21).w)) &&
                  (cores.get(0).y <= posMouse.y && posMouse.y <= (cores.get(21).y + cores.get(21).h))){
                    coresFocus = true;
                    quadradinhoFocus = false;
                    figs.remove(focus);
                    int i = 0;
                    for(Rect cor: cores){
                        if(cor.clicked(posMouse.x, posMouse.y)){                            
        		        	// Teste do clique na parte de cima ou baixo da paleta (cima corContorno, baixo corFundo).
         		        	if(i <= 10){                      
                        		focus.corContorno = cor.corFundo;
                        		figs.add(focus);	
                        	} 
                            else{   
                        		if(focus.getClass().getSimpleName().equals("Line")){
                        			focus.corContorno = cor.corFundo;                        			
                        		} 
                                else{
                                    focus.corFundo = cor.corFundo;
                                }            		
                        		figs.add(focus);
                        	}
         		        	repaint();
                            break;
                        }
                        i++;
                    }
                }
        		// Teste de clique no mini quadrado de foco.
                 
                else if(miniRectFocus.clicked(posMouse.x, posMouse.y)){
        			quadradinhoFocus = true;
        			coresFocus = false;
                }
            	// Teste de clique em uma figura ou em espaço vazio.
            	// Clique em figura, informações alocadas em focus.
            	// Senão, focus null.
                else {
                	quadradinhoFocus = false;
                	coresFocus = false;
                	focus = null;

                    if (botaoFocus != null) {
                        int idx = botaoFocus.getIdx();
                        if (idx == 1) {                  			
                            figs.add(new Line(posMouse.x, posMouse.y, 50, 0, Color.black, Color.white));                           
                        } else if (idx == 2) {
                            figs.add(new Rect(posMouse.x, posMouse.y, 50, 50, Color.black, Color.white));
                        } else if (idx == 3) {
                            figs.add(new Ellipse(posMouse.x, posMouse.y, 50, 50, Color.black, Color.white));
                        } else {
                            figs.add(new Pentagon(posMouse.x, posMouse.y, 50, 50, Color.black, Color.white));
                        }
                        focus = figs.get(figs.size()-1);
                        botaoFocus = null;
                    }
                    else{
                        for(Figuras fig: figs){
                            if(fig.clicked(posMouse.x, posMouse.y)){
                                focus = fig;                            	
                            }
                        }
                    }
                	
                	// Clique em figura, ela vai para o final da lista.
            		if(focus != null){
            			figs.remove(focus);       	
                    	figs.add(focus);
            		}
                    else{
                        rectFocus.x = -10;
                        rectFocus.y = -10;
                    }
            		repaint();
                }
        	}
        });

        // Mover e Redimensionar figuras.
        this.addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent evt){
                Point newMousePos = getMousePosition();
                // Redimensionar.
                if(quadradinhoFocus){   
                    if(newMousePos.x>=focus.x+10 && newMousePos.y>=focus.y+10){ 
                        figs.remove(focus);
                        focus.w += newMousePos.x - posMouse.x;
                        focus.h += newMousePos.y - posMouse.y;
                        if(focus.getClass().getSimpleName().equals("Pentagon")){
                            Pentagon p = (Pentagon) focus;
                            focus = new Pentagon(focus.x, focus.y, focus.w, focus.h, focus.corContorno, p.corFundo);
                        }
                        figs.add(focus);
                        repaint();
                        posMouse.x = newMousePos.x;
                        posMouse.y = newMousePos.y;
                    }
                }
                // Mover com mouse.
                else{
                    if(!coresFocus){
                        if(focus!= null){
                            figs.remove(focus);
                            focus.drag(newMousePos.x - posMouse.x, newMousePos.y - posMouse.y);
                            if(focus.getClass().getSimpleName().equals("Pentagon")){
                                Pentagon p = (Pentagon) focus;
                                focus = new Pentagon(focus.x, focus.y, focus.w, focus.h, focus.corContorno, p.corFundo);
                            }
                            figs.add(focus);
                            repaint();
                            posMouse.x = newMousePos.x;
                            posMouse.y = newMousePos.y;
                        }
                    }
                }
            }
        });

        // Criação e remoção de figura com teclas do teclado.
        this.addKeyListener(new KeyAdapter(){
        	public void keyPressed (KeyEvent evt){

        		posMouse = getMousePosition();
                int x = posMouse.x;
                int y = posMouse.y;
                int w = 50;
                int h = 50;
                Color corContorno = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
                Color corFundo = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));

                if(evt.getKeyCode() == 8){
                    figs.remove(focus);
                    focus = null;
                    rectFocus = null;
                } 
                else if(evt.getKeyCode() == 127){
                    figs.removeAll(figs);
                    focus = null;
                    rectFocus = null;
                    miniRectFocus.x = -10;
                    miniRectFocus.y = -10;
                }
                //mover com teclado
                else if(evt.getKeyChar() == 'w'){
                    focus.y -= 5;
                    if(focus.getClass().getSimpleName().equals("Pentagon")){
                        figs.remove(focus);
                        Pentagon p = (Pentagon) focus;
                        focus = new Pentagon(focus.x, focus.y, focus.w, focus.h, focus.corContorno, p.corFundo);
                        figs.add(focus);
                        repaint();
                    }
                }
                else if(evt.getKeyChar() == 's'){
                    focus.y += 5;
                    if(focus.getClass().getSimpleName().equals("Pentagon")){
                        figs.remove(focus);
                        Pentagon p = (Pentagon) focus;
                        focus = new Pentagon(focus.x, focus.y, focus.w, focus.h, focus.corContorno, p.corFundo);
                        figs.add(focus);
                        repaint();
                    }
                }
                else if(evt.getKeyChar() == 'a'){
                    focus.x -= 5;
                    if(focus.getClass().getSimpleName().equals("Pentagon")){
                        figs.remove(focus);
                        Pentagon p = (Pentagon) focus;
                        focus = new Pentagon(focus.x, focus.y, focus.w, focus.h, focus.corContorno, p.corFundo);
                        figs.add(focus);
                        repaint();
                    }
                }
                else if(evt.getKeyChar() == 'd'){
                    focus.x += 5;
                    if(focus.getClass().getSimpleName().equals("Pentagon")){
                        figs.remove(focus);
                        Pentagon p = (Pentagon) focus;
                        focus = new Pentagon(focus.x, focus.y, focus.w, focus.h, focus.corContorno, p.corFundo);
                        figs.add(focus);
                        repaint();
                    }
                }
                // Alterando foco por tab.
                else if(evt.getKeyCode() == 9){
                    focus = figs.get(0);
                    figs.remove(figs.get(0));
                    figs.add(focus);
                }
                // Exceção para não criar fora da tela
                else if((posMouse.x >= 645 || posMouse.y >= 645)){
                    if(evt.getKeyChar() == 'l'){
                        figs.add(new Line(x-50, y-50, w, 0, corContorno, corFundo));
                        focus = figs.get(figs.size()-1);
                    } 
                    else if(evt.getKeyChar() == 'r'){
                        figs.add(new Rect(x-50, y-50, w, h, corContorno, corFundo));
                        focus = figs.get(figs.size()-1);             	
                    } 
                    else if(evt.getKeyChar() == 'e'){
                        figs.add(new Ellipse(x-50, y-50, w, h, corContorno, corFundo));
                        focus = figs.get(figs.size()-1);          	
                    } 
                    else if(evt.getKeyChar() == 'p'){
                        figs.add(new Pentagon(x-50, y-50, w, h, corContorno, corFundo));
                        focus = figs.get(figs.size()-1);              	
                    }
                }
                else{
                    if(evt.getKeyChar() == 'l'){
                        figs.add(new Line(x, y, w, 0, corContorno, corFundo));
                        focus = figs.get(figs.size()-1);
                    } 
                    else if(evt.getKeyChar() == 'r'){
                        figs.add(new Rect(x, y, w, h, corContorno, corFundo));
                        focus = figs.get(figs.size()-1);             	
                    } 
                    else if(evt.getKeyChar() == 'e'){
                        figs.add(new Ellipse(x, y, w, h, corContorno, corFundo));
                        focus = figs.get(figs.size()-1);          	
                    } 
                    else if(evt.getKeyChar() == 'p'){
                        figs.add(new Pentagon(x, y, w, h, corContorno, corFundo));
                        focus = figs.get(figs.size()-1);              	
                    }
                } 
                repaint();
            }
		});

    }
    
    public void paint (Graphics g){
        super.paint(g);

        for(Figuras fig: this.figs){
            if(fig == focus){
                fig.paint(g, true);
                miniRectFocus.x = focus.x + focus.w - 8;
        	    miniRectFocus.y = focus.y + focus.h - 8;
            }
            else{
                fig.paint(g, false);
            }
        }

        for (Botao botao: botoes) {
        	botao.paint(g, botao == botaoFocus);
        }

        // Teste figura em foco.
        // Caso sim pinta as figuras de foco (quadrado maior e menor).
        // Pinta paleta de cores.
        if(focus != null){
        	paleta(this);
        	for(Rect cor: cores){
                cor.paint(g, false);
            }
        }
    }

    // Cria array de retangulos para corContorno e corFundo.
    void paleta(JFrame janela){
    	cores.clear();

        // Palete de cores pastel.
    	cores.add(new Rect(10, 30, 30, 30, Color.black, Color.black));
        cores.add(new Rect(40, 30, 30, 30, Color.black, Color.decode("#5B5B5B")));
        cores.add(new Rect(70, 30, 30, 30, Color.black, Color.decode("#999999")));
    	cores.add(new Rect(100, 30, 30, 30, Color.black, Color.white));
    	cores.add(new Rect(130, 30, 30, 30, Color.black, Color.decode("#E69138")));
        cores.add(new Rect(160, 30, 30, 30, Color.black, Color.decode("#F1C232")));
    	cores.add(new Rect(190, 30, 30, 30, Color.black, Color.decode("#6AA84F")));
    	cores.add(new Rect(220, 30, 30, 30, Color.black, Color.decode("#45818E")));
    	cores.add(new Rect(250, 30, 30, 30, Color.black, Color.decode("#3D85C6")));
    	cores.add(new Rect(280, 30, 30, 30, Color.black, Color.decode("#674EA7")));
    	cores.add(new Rect(310, 30, 30, 30, Color.black, Color.decode(("#A64D79"))));
    	
    	cores.add(new Rect(10, 60, 30, 30, Color.black, Color.black));
        cores.add(new Rect(40, 60, 30, 30, Color.black, Color.decode("#5B5B5B")));
        cores.add(new Rect(70, 60, 30, 30, Color.black, Color.decode("#999999")));
    	cores.add(new Rect(100, 60, 30, 30, Color.black, Color.white));
    	cores.add(new Rect(130, 60, 30, 30, Color.black, Color.decode("#E69138")));
        cores.add(new Rect(160, 60, 30, 30, Color.black, Color.decode("#F1C232")));
    	cores.add(new Rect(190, 60, 30, 30, Color.black, Color.decode("#6AA84F")));
    	cores.add(new Rect(220, 60, 30, 30, Color.black, Color.decode("#45818E")));
    	cores.add(new Rect(250, 60, 30, 30, Color.black, Color.decode("#3D85C6")));
    	cores.add(new Rect(280, 60, 30, 30, Color.black, Color.decode("#674EA7")));
    	cores.add(new Rect(310, 60, 30, 30, Color.black, Color.decode(("#A64D79"))));
    }
}