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
public class UIButton extends UITextView implements UIElement.Clickable{
    
    public UIButton(int x, int y) {
        super(x,y);
    }
    
    public UIButton(Point p) {
        super(p);
    }

    @Override
    public boolean inArea(Point p) {
        return true;
    }

    @Override
    public void handleClick(Event ev) {
        this.text = "omg we just clicked";
    }
    
}
