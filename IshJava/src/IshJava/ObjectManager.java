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
    public ArrayList<Object> objects = new ArrayList<Object>();
    public void drawObjs(Graphics g){
        for (Object obj : objects) {
            obj.draw(g);
        }
    
    }
}
