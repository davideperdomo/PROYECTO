
package Character;

import Map.Map;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Person {
    protected int x;
    protected int y;
    public boolean right;
    public boolean left;   
    public boolean falling;
    public boolean colisionlat;
    public boolean colisiont;
    public boolean colisionder;
    public boolean attacking;
    public int ytierra;
    protected int life;
    protected int idplayer;
    public int getIdplayer() {return idplayer;}
    public int getX() {return x;}
    public int getY() {return y;}
    public int getLife() {return life;}
    public boolean isColisionlat() {return colisionlat;}
    public boolean isColisionder() {return colisionder;}
    public boolean isColisiont() {return colisiont;}
    public boolean isAttacking() {return attacking;}
    public void setIdplayer(int idplayer) {this.idplayer = idplayer;}
    public void setX(int x) { this.x = x;}
    public void setY(int y) {this.y = y;}
    public void setLife(int life) {this.life -= life;}
    public void setColisionlat(boolean colision) {this.colisionlat = colision;}
    public void setColisionder(boolean colision) {this.colisionder = colision;}
    public void setColisiont(boolean colide) {this.colisiont = colide;}
    public void setAttacking(boolean attacking) {this.attacking = attacking;}
    
    public void right(double x){}
    public void left(double x){} 

    

    
  
    
    public Rectangle getMan(){
        return new Rectangle(x,y,100,100);  
    }

    public void dibujar(Graphics g) {
    }
}
