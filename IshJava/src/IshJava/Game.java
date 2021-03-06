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
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author ALI team
 */
public class Game extends JPanel implements Runnable,MouseMotionListener{

    public ObjectManager objectManager;
    public UIManager uiManager;
    public Thread mainThread;
    public GameVariables gVars;
    public int fps = 60;
    public Graphics g;
    public int width, height;

    public GamePoint mousePoint;
    public GameGroupManager gameGroupManager;
    public BufferedImage canvas;
    public GameLayersManager gameLayersManager;
    public boolean paused;
    public Game(int width,int height) {
        paused=false;
        gameLayersManager=new GameLayersManager(this);
        mousePoint=new GamePoint();
        objectManager = new ObjectManager(this);
        gameGroupManager=new GameGroupManager();
        uiManager = new UIManager();
        gVars = new GameVariables();
        this.setBackground(new java.awt.Color(255, 255, 255));
        addKeyListener(objectManager);
        addMouseListener(objectManager);
        addMouseMotionListener(this);
        mainThread = new Thread(this);
        mainThread.start();
        canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

    }
    public void pauseGame(){
        paused=true;
    }
    public void unpauseGame(){
        paused=true;
    }
    public void pauseToggle(){
        paused=!paused;
    }

    public void addObject(GameObject obj) {
        this.objectManager.addObject(obj);

    }
    
    public void addUIElement(String id, UIElement e) {
        this.uiManager.addElement(id, e);
    }
    
    public UIElement getUIElement(String id) {
        return this.uiManager.getElement(id);
    }
    
    /**
     * Sparar ett Object i Game så att det kan kommas åt i andra kontexts
     * @param key <i>String</i> unikt id som används för att komma åt <b>o</b>
     * vid senare tillfälle.
     * @param o <i>Object</i> värde, kan vara vad som helst t.ex en int, float
     * eller String
     */
    public void put(String key, Object o) {
        this.gVars.put(key, o);
    }
    
    /**
     * Laddar object indexerat av key
     * @param key <i>String</i> unikt id, samma som när värder lagrades
     * @return <i>Object</i> generik Object, casta eller använd getInt, 
     * getString mm
     */
    public Object get(String key) {
        return this.gVars.get(key);
    }
    
    public int getInt(String key) {
        return (int) this.gVars.get(key);
    }
    
    public long getLong(String key) {
        return (long) this.gVars.get(key);
    }
    
    public short getShort(String key) {
        return (short) this.gVars.get(key);
    }
    
    public byte getByte(String key) {
        return (byte) this.gVars.get(key);
    }
    
    public char getChar(String key) {
        return (char) this.gVars.get(key);
    }
    
    public float getFloat(String key) {
        return (float) this.gVars.get(key);
    }
    
    public double getDouble(String key) {
        return (double) this.gVars.get(key);
    }
    
    public boolean getBoolean(String key) {
        return (boolean) this.gVars.get(key);
    }
    
    public String getString(String key) {
        return (String) this.gVars.get(key);
    }
    
    @Override
    public void paintComponent(Graphics g) { 
        super.paintComponent(g);
        g.drawImage(canvas, 0, 0, null);
        this.objectManager.drawObjs(g);
        
        this.uiManager.drawUI(g);
        this.g = g;
    }
    
    public int pps2ppf(int pixels) {
        return (int) (pixels / fps);
    }

    @Override
    public void run() {
        while (true) {
            long tick=System.currentTimeMillis();
            if(!this.paused){
            this.objectManager.executeEvents();
            this.objectManager.updateObjs();
            }
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

    @Override
    public void mouseDragged(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        mousePoint.x=e.getX();
        mousePoint.y=e.getY();
    }
}
