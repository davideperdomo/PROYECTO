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
public class BoardLevel3 extends BoardLevel1{
    public BoardLevel3() throws IOException {
        super.fileboss = "bossAire.png";
        super.filebackground="fondoAire.png";
        super.filetileset="tiletestagua.png";
        super.bossheight=400;
    }
}