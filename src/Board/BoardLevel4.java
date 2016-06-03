/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;

import java.io.IOException;

/**
 *
 * @author Usuario11
 */
public class BoardLevel4 extends BoardLevel1{
    public BoardLevel4() throws IOException {
        super.fileboss = "bossFuego.png";
        super.filebackground="fondoFuego.png";
        super.filetileset="tiletestfuego.png";
        super.bossheight=400;
    }    
}
