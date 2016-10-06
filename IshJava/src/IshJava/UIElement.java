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
    public int x = 0,y = 0;
    public boolean visible;
    private int xAnchor;
    private int yAnchor;
    private int xMargin;
    private int yMargin;
    private int position = POSITION_ABSOLUTE;
    
    public static final int ANCHOR_START = 0;
    public static final int ANCHOR_MIDDLE = 1;
    public static final int ANCHOR_END = 2;
    public static final int POSITION_ABSOLUTE = 0;
    public static final int POSITION_RELATIVE = 1;
    
    public UIElement(Game g) {
        this.game = g;
        this.visible = true;
    }
    
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
    
    
    public void setPosition(Point p) {
        this.position = POSITION_ABSOLUTE;
        this.x = p.x;
        this.y = p.y;
    }
    
    public void setPosition(int x, int y) {
        this.position = POSITION_ABSOLUTE;
        this.x = x;
        this.y = y;
    }
    
    public void setX(int x) {
        this.position = POSITION_ABSOLUTE;
        this.x = x;
    }
    
    public void setY(int y) {
        this.position = POSITION_ABSOLUTE;
        this.y = y;
    }
    
    public void setLayoutAnchor(int xAnchor, int yAnchor) {
        this.position = POSITION_RELATIVE;
        this.xAnchor = xAnchor;
        this.yAnchor = yAnchor;
        this.pack();
    }
    
    public void setLayoutXAnchor(int xAnchor) {
        this.position = POSITION_RELATIVE;
        this.xAnchor = xAnchor;
        this.pack();
    }
    
    public void setLayoutYAnchor(int yAnchor) {
        this.position = POSITION_RELATIVE;
        this.yAnchor = yAnchor;
        this.pack();
    }
    
    public void setLayoutMargin(int xMargin, int yMargin) {
        this.position = POSITION_RELATIVE;
        this.xMargin = xMargin;
        this.yMargin = yMargin;
        this.pack();
    }
    
    public void setLayoutXMargin(int xMargin) {
        this.position = POSITION_RELATIVE;
        this.xMargin = xMargin;
        this.pack();
    }
    
    public void setLayoutYMargin(int yMargin) {
        this.position = POSITION_RELATIVE;
        this.yMargin = yMargin;
        this.pack();
    }
    
    protected void pack() {
        switch (this.position) {
            case POSITION_RELATIVE:
                switch (this.xAnchor) {
                    case UIElement.ANCHOR_START:
                        this.x = this.xMargin;
                        break;
                    case UIElement.ANCHOR_MIDDLE:
                        this.x = (int) ((game.getWidth() / 2) - (this.getWidth() / 2));
                        break;
                    case UIElement.ANCHOR_END:
                        this.x = game.getWidth() - this.xMargin;
                        break;
                }

                switch (this.yAnchor) {
                    case UIElement.ANCHOR_START:
                        this.y = this.yMargin;
                        break;
                    case UIElement.ANCHOR_MIDDLE:
                        this.y = (int) ((game.getHeight() / 2) - (this.getHeight() / 2));
                        break;
                    case UIElement.ANCHOR_END:
                        this.y = game.getHeight() - this.yMargin;
                        break;
                }
            break;
            case POSITION_ABSOLUTE:
                
                break;
        }
        
        StackTraceHelper.printStackTrace();
        System.out.println("yPos " + y);
    }
    
    public abstract void draw(Graphics g); 
    public abstract int getWidth();
    public abstract int getHeight();
    
    public interface Clickable {
        public boolean inArea(Point p);
        public void handleClick(MouseEvent ev);
    }
    
    public interface OnClickListener {
        public abstract void onClick(Game g);
    }
}
