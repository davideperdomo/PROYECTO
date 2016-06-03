/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Board.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class Game {
    
    public static void main(String[] args) throws IOException { 
        JFrame inicio = new JFrame("VENTANA INICIO");
        JFrame tablero = new JFrame("VENTANA JUEGO");
        JButton nivel1 = new JButton("Level 1");
        nivel1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    inicio.setVisible(false);
                    tablero.add(new LevelManager(1).getLevel());
                    tablero.setVisible(true);
                    tablero.setSize(new Dimension(400*2, 550));
                    tablero.setResizable(true);
                } catch (IOException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        });
        nivel1.setVisible(true);
        JButton nivel2 = new JButton("Level 2");
        nivel2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    inicio.setVisible(false);
                    tablero.add(new LevelManager(2).getLevel());
                    tablero.setVisible(false);
                    tablero.setSize(new Dimension(400*2, 550));
                    tablero.setResizable(false);
                } catch (IOException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        nivel2.setVisible(true);
        JButton nivel3 = new JButton("Level 3");
        nivel3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    inicio.setVisible(false);
                    tablero.add(new LevelManager(3).getLevel());
                    tablero.setVisible(true);
                    tablero.setSize(new Dimension(400*2, 550));
                    tablero.setResizable(false);
                } catch (IOException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        nivel3.setVisible(true);
        JButton nivel4 = new JButton("Level 4");
        nivel4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    inicio.setVisible(false);
                    tablero.add(new LevelManager(4).getLevel());
                    tablero.setVisible(true);
                    tablero.setSize(new Dimension(400*2, 550));
                    tablero.setResizable(false);
                } catch (IOException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        nivel4.setVisible(true);
        JPanel panel = new JPanel();
        panel.add(new JLabel("Seleccione un nivel"));
        panel.add(nivel1);
        panel.add(nivel2);
        panel.add(nivel3);
        panel.add(nivel4);
        panel.setVisible(true);
        inicio.setSize(new Dimension(300, 250));
        inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tablero.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicio.setResizable(false);
        inicio.add(panel);
        inicio.setVisible(true);
    } 
    
}