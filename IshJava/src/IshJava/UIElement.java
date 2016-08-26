/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IshJava;

import java.awt.Point;

/**
 *
 * @author axemat060
 */
public class UIElement {
    public int x,y,w,h;
    public boolean visible;
    
    public UIElement(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.visible = true;
    }
    
    public UIElement(Point p, int w, int h) {
        this.x = p.x;
        this.y = p.y;
        this.w = w;
        this.h = h;
        this.visible = true;
    }
    
    public UIElement(int x, int y) {
        this.x = x;
        this.y = y;
        this.w = 32;
        this.h = 16;
        this.visible = true;
    }
    
    public void setVisible(boolean v) {
        this.visible = v;
    }
    
    public void show() {
        this.visible = true;
    }
   
    public void hide() {
        this.visible = false;
    }
    
}
