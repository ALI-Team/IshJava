/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IshJava;

import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author ivamat907
 */
public class Game extends JPanel implements Runnable {

    public ObjectManager objectManager;
    public Thread mainThread;
    public int fps=60;
    public Game() {
        objectManager = new ObjectManager();
        this.setBackground(new java.awt.Color(255, 255, 255));
        mainThread = new Thread(this);
        mainThread.start();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("BLAH", 20, 20);
        g.drawRect(200, 200, 200, 200);
        this.objectManager.drawObjs(g);
    }
    
    public int pps2ppf(int pixels){
        return (int)(pixels/fps);
    }
    @Override
    public void run() {
        while (true) {
            this.objectManager.updateObjs();
            repaint();
            try {
                synchronized (mainThread) {
                    mainThread.wait(1000/fps);
                }

            } catch (InterruptedException ex) {

            }
        }
    }

}
