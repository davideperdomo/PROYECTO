/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Character;

import Map.Map;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class Archer extends Person {
    
    public Archer() {
        this.x=200;
        this.y=200;
        this.ytierra=400;
        this.colisionlat = false;
        this.colisiont=false;
        this.falling=true;
        this.right=true;
        this.idplayer=1;
        this.life = 1000;
    }
    public void dibujar(Graphics g,String file){
        ImageIcon icon = new ImageIcon(file);
        Image imagen= icon.getImage();
        if(this.left)g.drawImage(imagen, x, y, x+100,y+100,0,100,100,100+100,null);
    }
    
     public void animationright(Graphics g,String file){
        ImageIcon icon = new ImageIcon(file);
        Image imagen= icon.getImage();
        if(this.right)g.drawImage(imagen, x, y, x+100,y+100,0,0,100,100,null);
    }
    
    public void leftMove(KeyEvent e, Map mapm){
        double dx=200.0;
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT: mapm.left(dx-=1.0);
            left=true;right=false;break;
        }
    }
    public void rightMove(KeyEvent e, Map mapm){
        double dx=200.0;
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT: mapm.right(dx += 1);
            right=true;left=false;break;
        }
    }
    public void up(KeyEvent e){
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP: 
                y -= 100;this.colisionlat=false;this.colisionder=false;
                this.colisiont=false;
                ;
                if(right){x += 5;}
                if(left){x-=5;}
                break;
        }
    }
    public void downMove(KeyEvent e){
        switch (e.getKeyCode()) {case KeyEvent.VK_DOWN:y += 5;break;}
    }
    public boolean atackMove(KeyEvent e){
        boolean atack=false;
        if(e.getKeyCode()==KeyEvent.VK_SPACE){atack=true;}
        return atack;
    }
////
    public void changePlayer(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_W){this.idplayer=2;}
        if(e.getKeyCode()==KeyEvent.VK_A){this.idplayer=1;}
    }
    public void sprintMove(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_S&&right){x+=35;}
        if(e.getKeyCode()==KeyEvent.VK_S&&left){x-=35;}
    }
////
     public Rectangle getRec(){
        return new Rectangle(x+20,y,60,100);  
    }

}
