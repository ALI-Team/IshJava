/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IshJava;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author axemat060
 */
public class UITextView extends UIElement{
    
    public String text = "";
    public Color color = Color.BLACK;
    
    public UITextView(int x, int y) {
        super(x,y);
    }
    
    public UITextView(Point p) {
        super(p);
    }
    
    public UITextView(int x, int y, String text) {
        super(x,y);
        this.text = text;
    }
    
    public UITextView(int x, int y, String text, Color color) {
        this(x,y,text);
        this.color = color;
    }
    
    public UITextView(Point p, String text) {
        super(p);
        this.text = text;
    }
    
    public UITextView(Point p, String text, Color color) {
        this(p, text);
        this.color = color;
    }
    
    public void setColor(Color c) {
        this.color = c;
    }
    
    public void setColor(int r, int g, int b) {
        this.color = new Color(r,g,b);
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawString(text, x, y);
    }
}
