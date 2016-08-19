/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package IshJava;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author ivamat907
 */
public class ObjectManager {
    public ArrayList<GameObject> objects = new ArrayList<GameObject>();
    
    public void updateObjs(){
        for (GameObject obj : objects) {
            obj.updateObj();
        }
    
    }
    
    public void drawObjs(Graphics g){
        for (GameObject obj : objects) {
            obj.draw(g);
        }
    
    }
}
