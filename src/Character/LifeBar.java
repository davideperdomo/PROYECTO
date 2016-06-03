/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Character;

import Map.Map;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Carol
 */
public class LifeBar {
    public int x;
    public int y;
    public int xb;
    public int yb;
    public LifeBar(){
        this.x=25;
        this.y=25;
        this.xb=500;
        this.yb=25;
    }
    public void dibujar(Graphics g, Person man){
       g.setColor(Color.red);
       g.fillRect(x, y, x+(man.getLife()/5), y+10);
    }
    public void dibujarBoss(Graphics g, Map boss){
       g.setColor(Color.red);
       g.fillRect(xb, yb, 0+(boss.getLife()/5), y+10);System.out.println(boss.getLife()/5);
    }

}
