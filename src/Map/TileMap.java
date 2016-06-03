/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Map;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Carol
 */
public class TileMap {
    public int x;
    public int y;
    public int numCols;
    public int numRows;
    int[][]map;
    int width;
    int height;
    public TileMap() {
        this.x = 0;
        this.y = 0;
    }
    public int[][] getMap(String file) throws FileNotFoundException, IOException{
        File archivo = new File (file);
        FileReader fr = new FileReader (archivo);
        String input;
        BufferedReader bin = new BufferedReader(fr);
        
        this.numCols = Integer.parseInt(bin.readLine());
        this.numRows = Integer.parseInt(bin.readLine());
        map = new int[numRows][numCols];
        width = numCols * 50;
	height = numRows * 50;
	String delims = "\\s+";
        for(int row=0;row<numRows;row++){
            String line = bin.readLine();
            String[] filas = line.split(delims);
            for(int col=0;col<numCols;col++){
                map[row][col]=Integer.parseInt(filas[col]);
            }
        }
        return map;
    }
}