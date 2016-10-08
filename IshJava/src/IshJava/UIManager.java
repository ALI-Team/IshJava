/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IshJava;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author axemat060
 */
public class UIManager implements ComponentListener{
    
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
     * Lägger till UIElement i UIManager
     * @param id <i>String</i> används för att accessa elementet senare
     * @param e <i>UIElement</i> elementet att lägga till
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
    
    public void packAll() {
        HashMap<String, UIElement> tempMap = new HashMap<>();
        tempMap.putAll(this.UIMap);
        for (UIElement e : tempMap.values()) {
            e.pack();
        }
    }

    @Override
    public void componentResized(ComponentEvent e) {
        packAll();
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        //do nothing
    }

    @Override
    public void componentShown(ComponentEvent e) {
        //do nothing
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        //do nothing
    }
}
