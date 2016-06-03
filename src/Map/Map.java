/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;


public class Map {
    protected int x;
    protected int y;
    protected int tipo;
    public int life;
    
    protected boolean mapvision;

    public Map(int x, int y, int tipo) {
        this.x = x;
        this.y = y;
        this.tipo = tipo;
    }
    public void dibujar(Graphics g,String file){}
    public void dibujarTile(Graphics g, int tipo,String file){
        ImageIcon icon = new ImageIcon(file);
        Image imagen= icon.getImage();
        switch(tipo){
            case 1:g.drawImage(imagen, x, y, x+50,y+50,50,0,50+50,50,null);break;
            case 2:g.drawImage(imagen, x, y, x+50,y+50,0,50,50,50+50,null);break;
            case 3:g.drawImage(imagen, x, y, x+50,y+50,0,0,50,50,null);break;
            case 4:g.drawImage(imagen, x, y, x+50,y+50,100,50,100+50,50+50,null);break;
            case 5:g.drawImage(imagen, x, y, x+50,y+50,100,0,100+50,50,null);break;
            case 6:g.drawImage(imagen, x, y, x+50,y+50,50,50,50+50,50+50,null);break;
        }
    }
    public void right(double x){this.x -= (x*0.1);}
    public void left(double x){this.x += (x*0.1);}        
    
    public void setX(int x) {this.x = x;}
    public void setY(int y) {this.y = y;}
    public void setMapvision(boolean mapvision) {this.mapvision = mapvision;}
    public void setLife(int life) {this.life -= life;}
    
    public int getX() {return x;}
    public int getY() {return y;}
    public int getTipo() {return tipo;}
    public int getLife() {return life;}
    public boolean isMapvision() {return mapvision;}

    public Rectangle getMap(){return new Rectangle(x,y,50,50);}
    public Rectangle getVision(){return new Rectangle(x,y,50,50);}
}