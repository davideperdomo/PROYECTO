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
public class LevelManager {
    private BoardLevel1 level1;
    private BoardLevel1 level2;
    private BoardLevel1 level3;
    private BoardLevel1 level4;
    private int idlevel;
    public LevelManager(int id) throws IOException {
        this.level1=new BoardLevel1();
        this.level2=new BoardLevel2();
        this.level3=new BoardLevel3();
        this.level4=new BoardLevel4();
        this.idlevel=id;
    }
    
    
    public BoardLevel1 getLevel() throws IOException{
        BoardLevel1 currentLevel = null ;
        if(idlevel==1){currentLevel=level1;}
        if(idlevel==2){currentLevel=level2;} 
        if(idlevel==3){currentLevel=level3;}
        if(idlevel==4){currentLevel=level4;} 
        return currentLevel;
    }
        
}
