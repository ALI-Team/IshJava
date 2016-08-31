/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package IshJava;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

/**
 *
 * @author ivamat907
 */
public class ObjectManager implements KeyListener{
    
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
        
        for (int i = 0; i < this.objects.size(); i++) {
            
            GameObject object = this.objects.get(i);
            
            int height = object.sprite.getHeight(this.game);
            int width = object.sprite.getWidth(this.game);
            
            if ((x > (object.x - (width / 1)) && (x < object.x + (width / 1))) && (y > (object.y - (height / 1)) && (y < object.y + (height / 1)))) {
                object.mousePressed();
            }
        }
    }
}
