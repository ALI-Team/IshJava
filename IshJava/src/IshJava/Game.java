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
 * @author ivamat907
 */
public class Game extends JPanel implements Runnable, MouseListener {

    public ObjectManager objectManager;
    public UIManager uiManager;
    public Thread mainThread;
    public int fps=60;
    public Game() {
        objectManager = new ObjectManager(this);
        uiManager = new UIManager();
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

    @Override
    public void mouseClicked(MouseEvent e) {
        
        System.out.println("sad");
        
        Point mousePosition = e.getPoint();
        int x = mousePosition.x;
        int y = mousePosition.y;
        
        this.objectManager.mousePressed(x, y);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
