/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Map;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Carol
 */
public class Background {
    public int x;
    public int y;

    public Background() {
        this.x=0;
        this.y=0;
    }
    
    public void dibujar(Graphics g,String file){
        ImageIcon icon = new ImageIcon(file);
        Image imagen= icon.getImage();
        g.drawImage(imagen, x, y, x+800,y+600,0,0,800,600,null);
    }
}
