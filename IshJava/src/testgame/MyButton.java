/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgame;

import IshJava.Game;
import IshJava.UITextButton;
import IshJava.UITextView;
import java.awt.Point;
import java.awt.event.MouseEvent;

/**
 *
 * @author Axel
 */
public class MyButton extends UITextButton{
    int clicks = 0;
    
    public MyButton(Game g) {
        super(g);
    }
    
    public MyButton(Game g, int x, int y) {
        super(g, x, y);
    }
    
    public MyButton(Game g, Point p) {
        super(g, p);
    }
    
    public MyButton(Game g, int x, int y, String t) {
        super(g, x, y, t);
    }
    
    public MyButton(Game g, Point p, String t) {
        super(g, p, t);
    }
    
    @Override
    public void handleClick(MouseEvent ev) {
        clicks++;
        UITextView tw = (UITextView) game.getUIElement("tw");
        int i = game.getInt("number");
        tw.setText(Integer.toString(i));
        
    }
    
}