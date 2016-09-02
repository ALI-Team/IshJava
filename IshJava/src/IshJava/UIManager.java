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

/**
 *
 * @author axemat060
 */
public class UIManager {
    
    ArrayList<UIElement> UIElements;
    public UIManager() {
        this.UIElements = new ArrayList<>();
    }
    
    public boolean onClick(MouseEvent ev){
        Point p = ev.getPoint();
        for (UIElement e : this.UIElements) {
            if (e instanceof UIElement.Clickable) {
                UIElement.Clickable c = ((UIElement.Clickable) e);
                if (c.inArea(p)) {
                    c.handleClick(ev);
                }
            }
        }
        return false;
    }
    
    public void addElement(UIElement e) {
        this.UIElements.add(e);
    }
    
    public void drawUI(Graphics g) {
        ArrayList<UIElement> tempElements = new ArrayList<>();
        tempElements.addAll(this.UIElements);
        for (UIElement e : tempElements) {
            if (e.visible) {
                e.draw(g);
            } 
        }
    }
}
