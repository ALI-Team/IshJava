/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package IshJava;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 *
 * @author ivamat907
 */
public class ObjectManager implements KeyListener{
    
    
    
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
}
