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
public class UIManager {
    ArrayList<UIElement> UIElements;
    public UIManager() {
        this.UIElements = new ArrayList<>();
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
