/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package IshJava;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ivamat907
 */
public class Main {
    public static Game createGame(int w,int h){
        //int w=512;
        ///int h=512;
        JFrame frame = new JFrame();
        
        frame.setSize(w, h);
        frame.setPreferredSize(new Dimension(w,h));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        Game jpanel = new Game();
        frame.getContentPane().add(jpanel);
        frame.pack();
        frame.setVisible(true);
        return jpanel;
    }
    
}
