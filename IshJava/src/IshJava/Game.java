/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IshJava;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author ALI team
 */
public class Game extends JPanel implements Runnable{

    public ObjectManager objectManager;
    public UIManager uiManager;
    public Thread mainThread;
    public int fps = 60;

    public Game() {
        objectManager = new ObjectManager(this);
        uiManager = new UIManager();
        this.setBackground(new java.awt.Color(255, 255, 255));
        addKeyListener(objectManager);
        addMouseListener(objectManager);
        mainThread = new Thread(this);
        mainThread.start();

    }

    public void addObject(GameObject obj) {
        this.objectManager.addObject(obj);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.objectManager.drawObjs(g);
        this.uiManager.drawUI(g);
    }
    
    public int pps2ppf(int pixels) {
        return (int) (pixels / fps);
    }

    @Override
    public void run() {
        while (true) {
            long tick=System.currentTimeMillis();
            this.objectManager.executeMouseEvents();
            this.objectManager.updateObjs();
            repaint();
            try {
                long tock=System.currentTimeMillis();
                synchronized (mainThread) {
                    mainThread.wait(Math.max(0,(1000 / fps)-(tock-tick)));
                }

            } catch (InterruptedException ex) {

            }
        }
    }

}
