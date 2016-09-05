/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgame;

import IshJava.UITextButton;
import java.awt.Point;
import java.awt.event.MouseEvent;

/**
 *
 * @author Axel
 */
public class MyButton extends UITextButton{
    int clicks = 0;
    
    public MyButton(int x, int y) {
        super(x, y);
    }
    
    public MyButton(Point p) {
        super(p);
    }
    
    @Override
    public void handleClick(MouseEvent ev) {
        clicks++;
        this.text = "allahu akbar " + Integer.toString(clicks);
    }
    
}
