/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;

import java.io.IOException;

/**
 *
 * @author Carol
 */
public class BoardLevel2 extends BoardLevel1 {

    public BoardLevel2() throws IOException {
        super.fileboss = "bossTierra.png";
        super.filebackground="fondotest.png";
        super.filetileset="tiletest.png";
        super.filemap="level2.map";
        super.bossheight=400;
    }
        
}
