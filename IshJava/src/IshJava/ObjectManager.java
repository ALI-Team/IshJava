/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package IshJava;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

/**
 *
 * @author ivamat907
 */
public class ObjectManager {
    /*
    Doing shit with addlist cuz if a ArrayList is edited @ the same time as its used shit goes to hell
    */
    
    Game game;
    
    public ObjectManager(Game game) {
        this.game = game;
    }
    
    public void addObject(GameObject go){
        addlist.add(go);
    }
    
    public ArrayList<GameObject> addlist = new ArrayList<GameObject>();
    public ArrayList<GameObject> objects = new ArrayList<GameObject>();
    
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
    
    public void mousePressed(int x, int y) {
        
        for (GameObject object : this.objects) {
            
            int height = object.sprite.getHeight(this.game);
            int width = object.sprite.getWidth(this.game);
            
            if ((x > (object.x - (width / 2)) && (x < object.x + (width / 2))) && (y > (object.y - (height / 2)) && (y < object.y + (height / 2)))) {
                object.mousePressed();
            }
        }
    }
}
