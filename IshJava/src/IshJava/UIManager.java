/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IshJava;

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
}
