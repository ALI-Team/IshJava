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
    public ArrayList<GameObject> mouselisteners = new ArrayList<>();
    
    public void updateObjs(){
        objects.addAll(addlist);
        addlist.clear();
        ArrayList<GameObject> staticobjects = new ArrayList<GameObject>();
        staticobjects.addAll(objects);
        for (GameObject obj : staticobjects) {
            obj.updateObj();
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
    
    public void mousePressed(int x, int y) {
        
        ArrayList<GameObject> staticobjects = new ArrayList<GameObject>();
        staticobjects.addAll(mouselisteners);
        for (GameObject object : staticobjects) {
            
            int height = object.sprite.getHeight(this.game);
            int width = object.sprite.getWidth(this.game);
            
            if ((x > (object.x - (width / 2)) && (x < object.x + (width / 2))) && (y > (object.y - (height / 2)) && (y < object.y + (height / 2)))) {
                object.mousePressed();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        Point mousePosition = e.getPoint();
        int x = mousePosition.x;
        int y = mousePosition.y;
        if(!this.game.uiManager.onClick(e)){
            this.mousePressed(x, y);
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
