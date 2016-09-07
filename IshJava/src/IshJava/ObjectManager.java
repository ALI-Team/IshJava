/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package IshJava;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

/**
 *
 * @author ivamat907
 */
public class ObjectManager implements KeyListener, MouseListener{
    
    Game game;
    
    public ObjectManager(Game game) {
        this.game = game;
    }
    
    public void addObject(GameObject go){
        addlist.add(go);
    }
    
    
    public ArrayList<GameObject> addlist = new ArrayList<>();
    public ArrayList<GameObject> objects = new ArrayList<>();
    public ArrayList<GameObject> keylisteners = new ArrayList<>();
    public ArrayList<GameObject> onclickisteners = new ArrayList<>();
    public ArrayList<GameMouseEvent> mouseevents = new ArrayList<>();
    
    public void updateObjs(){
        objects.addAll(addlist);
        addlist.clear();
        ArrayList<GameObject> staticobjects = new ArrayList<GameObject>();
        staticobjects.addAll(objects);
        for (GameObject obj : staticobjects) {
            obj.updateObj();
        }
    
    }
    public void executeMouseEvents(){
        ArrayList<GameMouseEvent> staticobjects = new ArrayList<>();
        staticobjects.addAll(mouseevents);
        mouseevents.clear();
        for (GameMouseEvent gme : staticobjects) {
            gme.execute();
        }
        
    }
    
    public void drawObjs(Graphics g){
        ArrayList<GameObject> staticobjects = new ArrayList<GameObject>();
        staticobjects.addAll(objects);
        for (GameObject obj : staticobjects) {
            obj.draw(g);
        }
    
    }

    @Override
    public void keyTyped(KeyEvent e) {
        ArrayList<GameObject> staticobjects = new ArrayList<GameObject>();
        staticobjects.addAll(objects);
        for (GameObject obj : staticobjects) {
            obj.onKeyTyped(e.getKeyChar());
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        ArrayList<GameObject> staticobjects = new ArrayList<GameObject>();
        staticobjects.addAll(objects);
        for (GameObject obj : staticobjects) {
            obj.onKeyPressed(e.getKeyChar());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
       ArrayList<GameObject> staticobjects = new ArrayList<GameObject>();
        staticobjects.addAll(objects);
        for (GameObject obj : staticobjects) {
            obj.onKeyReleased(e.getKeyChar());
        }
    }
    
    public void handleMousePress(MouseEvent e) {
        
        /*
         * Get coordinates from mouseclick
         */
        Point mousePosition = e.getPoint();
        int x = mousePosition.x;
        int y = mousePosition.y;
        
        /*
         * Get click listeners
         */
        ArrayList<GameObject> staticobjects = new ArrayList<GameObject>();
        staticobjects.addAll(this.onclickisteners);
        
        for (GameObject object : staticobjects) {
            
            /*
             * Check if mouseclick occured in the object
             */
            int height = object.sprite.getHeight(this.game);
            int width = object.sprite.getWidth(this.game);
            
            if ((x > (object.x - (width / 2)) && (x < object.x + (width / 2))) && (y > (object.y - (height / 2)) && (y < object.y + (height / 2)))) {
                
                /*
                 * Send onClick event to the object
                 */
                object.onClick();
                
                /*
                 * Queue the click event
                 */
                mouseevents.add(new GameMouseEvent(e,object));
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(!this.game.uiManager.onClick(e)){
            this.handleMousePress(e);
        } 
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
