/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IshJava;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author axemat060
 */
public class UIManager {
    
    ArrayList<UIElement> UIElements;
    HashMap<String, UIElement> UIMap;
    
    public UIManager() {
        this.UIMap = new HashMap<>();
    }
    
    //TODO: fix mouse release sending event and triggering buttons on more types
    //of events and let Clickables handle events how they want.
    public boolean onClick(MouseEvent ev){
        Point p = ev.getPoint();
        for (UIElement e : this.UIMap.values()) {
            if (e instanceof UIElement.Clickable) {
                UIElement.Clickable c = ((UIElement.Clickable) e);
                if (c.inArea(p)) {
                    c.handleClick(ev);
                    return true;
                }
            }
        }
        return false;
    }
    
    
    /**
     * Adds an element to UIManager
     * @param e UIElement 
     */
    public void addElement(String id, UIElement e) {
        this.UIMap.put(id, e);
    }
    
    public UIElement getElement(String id) {
        return UIMap.get(id);
    }
    
    public void removeElement(String id) {
        UIMap.remove(id);
    }
    
    public void drawUI(Graphics g) {
        HashMap<String, UIElement> tempMap = new HashMap<>();
        tempMap.putAll(this.UIMap);
        for (UIElement e : tempMap.values()) {
            if (e.visible) {
                e.draw(g);
            } 
        }
    }
}
