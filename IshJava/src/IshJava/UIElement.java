/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IshJava;

import java.awt.Event;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

/**
 *
 * @author axemat060
 */
public abstract class UIElement {
    protected Game game;
    public int x,y;
    public boolean visible;
    
    public UIElement(Game g, int x, int y) {
        this.game = g;
        this.x = x;
        this.y = y;
        this.visible = true;
    }
    
    public UIElement(Game g, Point p) {
        this.game = g;
        this.x = p.x;
        this.y = p.y;
        this.visible = true;
    }
    
    public interface Clickable {
        public boolean inArea(Point p);
        public void handleClick(MouseEvent ev);
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
