/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package IshJava;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author ivamat907
 */
public class Game extends JPanel{
        public Game(){
            this.setBackground(new java.awt.Color(255, 255, 255));
            repaint();
        
        }
    
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.drawString("BLAH", 20, 20);
            g.drawRect(200, 200, 200, 200);
        }
}
