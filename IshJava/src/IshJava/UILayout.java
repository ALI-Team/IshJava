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
    
    /**
     * Lägger till UIElement i layout på sista positionen i layouten
     * @param e UIElement att lägga till
     */
    public void addUIElement(UIElement e) {
        e.setPositioning(UIElement.POSITION_ABSOLUTE);
        children.add(e);
        this.pack();
    }
    
    /**
     * @param e UIElement att lägga till
     * @param index Positionen att lägga till på
     */
    public void addUIElement(UIElement e, int index) {
        e.setPositioning(UIElement.POSITION_ABSOLUTE);
        children.add(index, e);
        this.pack();
    }
    
    /**
     * Tar bort ett UIElement från layouten
     * @param e UIElement att ta bort
     */
    public void removeUIElement(UIElement e) {
        children.remove(e);
        e.removeOnChangeListener();
        this.pack();
    }
    
    /**
     * Tar bort ett UIElement från en position
     * @param index index för UIElement att ta bort
     */
    public void removeUIElement(int index) {
        children.get(index).removeOnChangeListener();
        children.remove(index);
        this.pack();
    }
    
    public void empty() {
        children.forEach(e -> e.removeOnChangeListener());
        children.clear();
        this.pack();
    }
    
}
