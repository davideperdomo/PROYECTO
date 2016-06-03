/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Character;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Carol
 */
public class Attack {
    private int x;
    private int y;
    ImageIcon icon;
    public boolean atack;
    public Attack(Person man,String file){
        this.x=man.getX();
        this.y=man.getY();
        this.icon = new ImageIcon(file);
    }

    public void dibujar(Graphics g){
        Image imagen= icon.getImage();
        g.drawImage(imagen, x, y, x+100,y+100,0,0+620,100,100+620,null);
    }
    public void fire(ActionEvent e){
        x+=10;
    }
    public Rectangle getRec(){return new Rectangle(x+20,y+20,60,30);}

}
