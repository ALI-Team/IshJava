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
 * @author axemat060
 */
public abstract class UILayout extends UIElement{

    protected ArrayList<UIElement> children;
    
    public UILayout(Game g) {
        super(g);
        this.children = new ArrayList<>();
    }
    
    public void addUIElement(UIElement e) {
        e.setPositioning(UIElement.POSITION_ABSOLUTE);
        children.add(e);
        this.pack();
    }
    
    public void addUIElement(UIElement e, int index) {
        e.setPositioning(UIElement.POSITION_ABSOLUTE);
        children.add(index, e);
        this.pack();
    }
    
    public void removeUIElement(UIElement e) {
        children.remove(e);
        this.pack();
    }
    
    public void removeUIElement(int index) {
        children.remove(index);
        this.pack();
    }
    
}
