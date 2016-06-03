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
        super.fileboss = "Resources//bossTierra.png";
        super.filebackground="Resources//fondotest.png";
        super.filetileset="Resources//tiletest.png";
        super.filemap="Resources//level2.map";
        super.bossheight=400;
    }
        
}
