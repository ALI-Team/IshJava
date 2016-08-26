/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package IshJava;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author ivamat907
 */
public class Main {
    public static Game createGame(int w,int h, String title){
        JFrame jFrame = new JFrame();
        
        jFrame.setSize(w, h);
        jFrame.setTitle(title);
        jFrame.setPreferredSize(new Dimension(w,h));
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new BorderLayout());
        
        Game game = new Game();
        jFrame.getContentPane().add(game);
        jFrame.pack();
        jFrame.setVisible(true);
        
        return game;
    }
    
}
