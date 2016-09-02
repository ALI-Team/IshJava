/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IshJava;

import java.awt.Event;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author axemat060
 */
public abstract class UIElement {
    public int x,y;
    public boolean visible;
    
    public UIElement(int x, int y) {
        this.x = x;
        this.y = y;
        this.visible = true;
    }
    
    public UIElement(Point p) {
        this.x = p.x;
        this.y = p.y;
        this.visible = true;
    }
    
    public interface Clickable {
        public boolean inArea(Point p);
        public void handleClick(Event ev);
    }
    
    /**
     * 
     * @param v <i>true</i> for visible, </i>false</i> for hidden
     */
    public void setVisible(boolean v) {
        this.visible = v;
    }
    
    /**
     * Shows the element
     */
    public void show() {
        this.visible = true;
    }
   
    /**
     * Hides the element
     */
    public void hide() {
        this.visible = false;
    }
    
    public abstract void draw(Graphics g); 
    
}
