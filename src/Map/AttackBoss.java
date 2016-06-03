/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Map;

import Board.BoardLevel1;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Carol
 */
public class AttackBoss extends Map{
    public boolean atack;
    public AttackBoss(int x,int y, int tipo){
        super(x,y,tipo);
    }

    public void dibujar(Graphics g){
        g.setColor(Color.CYAN);
        g.fillOval(x, y+100, 30, 30);
    }
    public void fire(ActionEvent e){
        x-=10;
    }
    public Rectangle getMap(){return new Rectangle(x,y,30,30);}
}
