/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Map;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Carol
 */
public class Boss extends Map{
    
        
    public Boss(int x, int y, int tipo) {
        super(x, y, tipo);
        this.mapvision=false;
        super.life=1500;
    }
    
    @Override
    public void dibujar(Graphics g,String file){
        ImageIcon icon = new ImageIcon(file);
        Image imagen= icon.getImage();
        g.drawImage(imagen, x, y, x+200,y+150,0,0,200,150,null);
    }
    
    @Override
    public Rectangle getMap(){
        return new Rectangle(x,y,200,70);
    }
    @Override
    public Rectangle getVision(){
        return new Rectangle(x-400,y-100,1000,150);
    }
    
    
    
}
