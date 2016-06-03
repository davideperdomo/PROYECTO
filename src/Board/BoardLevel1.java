/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;

import Character.*;
import Map.Background;
import Map.AttackBoss;
import Map.Boss;
import Map.Map;
import Map.TileMap;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class BoardLevel1 extends JPanel implements ActionListener, KeyListener{
    private  Timer timer;
    private TileMap tilemap;
    private Archer man;
    private Map boss;
    private ArrayList<Map> map;
    private int[][] mapas;
    private Background bg;
    private ArrayList<Attack> atack;
    private ArrayList<AttackBoss> attackboss;
    private LifeBar lifebar;
    private LifeBar lifebarboss;
    protected String fileplayer;
    protected String fileplayerw;
    protected String fileboss;
    protected String filebackground;
    protected String filetileset;
    protected String filemap;
    protected int bossheight;
    public BoardLevel1() throws IOException{
        this.setFocusable(true);
        this.addKeyListener(this);
        this.fileplayer = "spriteArcher.png";
        this.fileplayerw="spriteWarrior.png";
        this.fileboss = "bossAgua.png";
        this.filebackground="fondoAgua.png";
        this.filetileset="tiletestagua.png";
        this.filemap="level1-1.map";
        this.bossheight=300;
        this.man = new Archer();
        this.tilemap = new TileMap();
        this.map = new ArrayList<>();
        mapas=tilemap.getMap(filemap);
        
        for(int row=0;row<tilemap.numRows;row++){
            for(int col=0;col<tilemap.numCols;col++){
                if(mapas[row][col]!=0&&mapas[row][col]!=9){
                    map.add(new Map(col*50,row*50,mapas[row][col]));
                }
                if(mapas[row][col]==9){
                    //this.boss = new Boss(col*50,row*50,mapas[row][col]);
                    this.boss = new Boss(col*50,bossheight,mapas[row][col]);
                    map.add(boss);
                    System.out.println("bossfound"+row*50+col*50);
                }
            }
        }
        atack= new ArrayList<>();
        attackboss= new ArrayList<>();
        this.lifebar = new LifeBar();
        this.lifebarboss = new LifeBar();
        this.bg= new Background();
        this.timer = new Timer(20,this);
        this.timer.start();        
    }
     public void validarColision(){
        Rectangle recMan  = man.getMan();
        Rectangle recVisionBoss = boss.getVision();
        Rectangle recBossA = boss.getMap();
        for(Map m: map){
            Rectangle recMap = m.getMap();
            if(recMan.intersects(recMap)){
                if((m.getTipo()==8)){man.setColisiont(false);}
                if((m.getTipo()==4)||(m.getTipo()==5)){
                man.setColisionlat(true);
                }else if(m.getTipo()==1 || m.getTipo()==3 || m.getTipo()==5){
                man.setColisiont(true);
                man.ytierra=(man.getY()+100);
                }else if(m.getTipo()==3 || m.getTipo()==2){
                man.setColisionder(true);
                }
            }
        }
        if(recMan.intersects(recVisionBoss)){
            boss.setMapvision(true);
            attackboss.add(new AttackBoss(boss.getX(),boss.getY(),10));
        }
        for(AttackBoss ab:attackboss){
            Rectangle recABoss= ab.getMap();
            if(recABoss.intersects(recMan)){man.setLife(1);}
        }
        for(Attack a: atack){
            Rectangle recAttack= a.getRec();
            if(recAttack.intersects(recBossA)){boss.setLife(5);
            man.setAttacking(true);}
        }
        if(man.getLife() <= 0 || man.getY()>= 550) end(false);
        if(boss.getLife() <= 0) end(true);
    }
     @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        bg.dibujar(g,filebackground);
        if(man.getIdplayer()==1)this.man.dibujar(g,fileplayer);
        if(man.getIdplayer()==2)this.man.dibujar(g,fileplayerw);
        for(Map m: map){
            if(m.getTipo()!=0){
                m.dibujarTile(g, m.getTipo(),filetileset);
            }
            if(m.getTipo()==9){
                boss.dibujar(g,fileboss);    
            }
        }
        for(AttackBoss ab: attackboss){
            if(boss.isMapvision()){ab.dibujar(g); 
            }
        }
        for(Attack a: atack){a.dibujar(g);}
       if(man.getIdplayer()==1) man.animationright(g,fileplayer);
       if(man.getIdplayer()==2) man.animationright(g,fileplayerw);
        lifebar.dibujar(g, man);
        if(man.isAttacking())lifebarboss.dibujarBoss(g,boss);
        
    }  
    
    @Override
    public void actionPerformed(ActionEvent e) {
            //GRAVITY
            int i=0;
            if(man.falling && !man.colisiont){man.setY(man.getY()+ 3);}
                  
            validarColision();
            for(Attack a: atack){a.fire(e);}
            for(AttackBoss ab: attackboss){ab.fire(e);}
            repaint();
        try {
            Thread.sleep(2);
        } catch (InterruptedException ex) {
            Logger.getLogger(BoardLevel1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(man.isColisionder()||man.isColisionlat()||man.isColisiont()){man.up(e);}
        if(!man.isColisiont()){
        man.downMove(e);
        }
        if(!man.isColisionlat()){
        for(Map m: map){
            man.leftMove(e, m);
        }
        }
        if(!man.isColisionder()){
        for(Map m: map){
            man.rightMove(e, m);
        }
        }
        if(man.atackMove(e)){atack.add(new Attack(man,"spriteArcher.png"));System.out.println("ataque");}
        man.sprintMove(e);
        man.changePlayer(e);
    }
    
    public void end(boolean win){
        System.out.println("FIN");
        timer.stop();
        JFrame perdiste = new JFrame();
        if(!win) perdiste.setTitle("LOSER");
        if(win) perdiste.setTitle("WINER");
        JPanel panel = new JPanel();
        JButton boton = new JButton("SALIR");
        boton.setVisible(true);
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        if(!win)panel.add(new JLabel("Lo sentimos, perdiste"));
        if(win)panel.add(new JLabel("Felicidados, ganaste"));
        panel.add(boton);
        panel.setVisible(true);
        perdiste.add(panel);
        perdiste.setSize(200, 100);
        perdiste.setVisible(true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
