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
    protected int x = 0,y = 0;
    protected int drawX = 0, drawY = 0;
    public boolean visible;
    private int xAnchor;
    private int yAnchor;
    private int xMargin;
    private int yMargin;
    private int position = POSITION_ABSOLUTE;
    public int origoX = ORIGO_START;
    public int origoY = ORIGO_START;
    
    public static final int ANCHOR_START = 0;
    public static final int ANCHOR_CENTER = 1;
    public static final int ANCHOR_END = 2;
    
    public static final int POSITION_ABSOLUTE = 0;
    public static final int POSITION_RELATIVE = 1;
    
    public static final int ORIGO_START = 0;
    public static final int ORIGO_CENTER = 1;
    public static final int ORIGO_END = 2;
    
    protected boolean hasChanged = true;
    
    protected UIElement.OnChangeListener onChangeListener;
    
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
     * @param v <i>true</i> for visible, <i>false</i> for hidden
     */
    public void setVisible(boolean v) {
        this.visible = v;
    }
    
    public boolean getVisibility() {
        return this.visible;
    }
    
    /**
     * Shows the element
     */
    public void show() {
        this.visible = true;
        this.change();
    }
   
    /**
     * Hides the element
     */
    public void hide() {
        this.visible = false;
        this.change();
    }
    
    public void setPosition(Point p) {
        this.setPosition(p, true);
    }
    
    public void setPosition(Point p, boolean change) {
        this.position = POSITION_ABSOLUTE;
        this.x = p.x;
        this.y = p.y;
        if (change) this.change();
    }
    
    public void setPosition(int x, int y) {
        this.setPosition(x, y, true);
    }
    
    public void setPosition(int x, int y, boolean change) {
        this.position = POSITION_ABSOLUTE;
        this.x = x;
        this.y = y;
        System.out.println("x: " + this.x);
        System.out.println("y: " + this.y);
        if (change) this.change();
            else this.hasChanged = true;
    }
    
    public Point getPosition() {
        return new Point(x,y);
    }
    
    public int[] getPositionAsArray() {
        return new int[]{x,y};
    }
    
    /**
     * Antagligen inte vad du vill ha. Använd getPosition eller 
     * getPositionAsArray.
     * @return position, UIElement.POSITION_ABSOLUTE eller
     * UIElement.POSITION_RELATIVE
     */
    public int getPositioning() {
        return this.position;
    }
    
    /**
     * Antagligen inte vad du vill ha. Använd setPosition istället
     * @param position UIElement.POSITION_ABSOLUTE eller
     * UIElement.POSITION_RELATIVE
     */
    public void setPositioning(int position) {
        this.position = position;
    }
    
    public void setX(int x) {
        this.position = POSITION_ABSOLUTE;
        this.x = x;
        this.change();
    }
    
    public int getX() {
        return this.x;
    }
    
    public void setY(int y) {
        this.position = POSITION_ABSOLUTE;
        this.y = y;
        this.change();
    }
    
    public int getY() {
        return this.y;
    }
    
    public void setLayoutAnchor(int xAnchor, int yAnchor) {
        this.setLayoutXAnchor(xAnchor, false);
        this.setLayoutYAnchor(yAnchor, false);
        this.pack();
        this.change();
    }
    
    public int[] getLayoutAnchors() {
        return new int[]{this.xAnchor, this.yAnchor};
    }
    
    private void setLayoutXAnchor(int xAnchor, boolean pack) {
        this.position = POSITION_RELATIVE;
        this.xAnchor = xAnchor;
        this.change();
        
        switch (this.xAnchor) {
            case UIElement.ANCHOR_START:
                this.origoX = UIElement.ORIGO_START;
                break;
            case UIElement.ANCHOR_CENTER:
                this.origoX = UIElement.ORIGO_CENTER;
                break;
            case UIElement.ANCHOR_END:
                this.origoX = UIElement.ORIGO_END;
                break;
        }
        
        if (pack) this.pack();
    }
    
    public int getLayoutXAnchor() {
        return this.xAnchor;
    }
    
    private void setLayoutYAnchor(int yAnchor, boolean pack) {
        this.position = POSITION_RELATIVE;
        this.yAnchor = yAnchor;
        this.change();
        
        switch (this.yAnchor) {
            case UIElement.ANCHOR_START:
                this.origoY = UIElement.ORIGO_START;
                break;
            case UIElement.ANCHOR_CENTER:
                this.origoY = UIElement.ORIGO_CENTER;
                break;
            case UIElement.ANCHOR_END:
                this.origoY = UIElement.ORIGO_END;
                break;
        }
        
        if (pack) this.pack();
    }
    
    public int getLayoutYAnchor() {
        return this.yAnchor;
    }
    
    public void setLayoutXAnchor(int XAnchor) {
        this.setLayoutXAnchor(XAnchor, true);
    }
    
    public void setLayoutYAnchor(int YAnchor) {
        this.setLayoutXAnchor(YAnchor, true);
    }
    
    public void setLayoutMargin(int xMargin, int yMargin) {
        this.xMargin = xMargin;
        this.yMargin = yMargin;
        this.pack();
        this.change();
    }
    public int[] getLayoutMarginsAsArray() {
        return new int[]{this.xMargin, this.yMargin};
    }
    
    public void setLayoutXMargin(int xMargin) {
        this.xMargin = xMargin;
        this.pack();
        this.change();
    }
    
    public int getLayoutXMargin() {
        return this.xMargin;
    }
    
    public void setLayoutYMargin(int yMargin) {
        this.yMargin = yMargin;
        this.pack();
        this.change();
    }
    
    public int getLayoutYMargin() {
        return this.yMargin;
    }
    
    public void setOrigo(int origoX, int origoY) {
        this.origoX = origoX;
        this.origoY = origoY;
        this.pack();
        this.change();
    }
    
    public void setOrigoX(int origoX) {
        this.origoX = origoX;
        this.pack();
        this.change();
    }
    
    public void setOrigoY(int origoY) {
        this.origoY = origoY;
        this.pack();
        this.change();
    }
    
    public void build(String key) {
        this.game.addUIElement(key, this);
    }
    
    public void setOnChangeListener(UIElement.OnChangeListener onChangeListener) {
       this.onChangeListener = onChangeListener;
    }
    
    public void removeOnChangeListener() {
        this.onChangeListener = null;
    }
    
    protected void pack() {
        switch (this.position) {
            case POSITION_RELATIVE:
                switch (this.xAnchor) {
                    case UIElement.ANCHOR_START:
                        this.x = this.xMargin;
                        break;
                    case UIElement.ANCHOR_CENTER:
                        this.x = (int) game.getWidth() / 2;
                        break;
                    case UIElement.ANCHOR_END:
                        this.x = game.getWidth() - this.xMargin;
                        break;
                }

                switch (this.yAnchor) {
                    case UIElement.ANCHOR_START:
                        this.y = this.yMargin;
                        break;
                    case UIElement.ANCHOR_CENTER:
                        this.y = (int) game.getHeight() / 2;
                        break;
                    case UIElement.ANCHOR_END:
                        this.y = game.getHeight() - this.yMargin;
                        break;
                }
            break;
            case POSITION_ABSOLUTE:
                
                break;
        }
        
        switch (this.origoX) {
            case ORIGO_START:
                this.drawX = this.x;
                break;
            case ORIGO_CENTER:
                this.drawX = this.x - this.getWidth() / 2;
                break;
            case ORIGO_END:
                this.drawX = this.x - this.getWidth();
                break;
        }
        
        switch (this.origoY) {
            case ORIGO_START:
                this.drawY = this.y;
                break;
            case ORIGO_CENTER:
                this.drawY = this.y - this.getHeight() / 2;
                break;
            case ORIGO_END:
                this.drawY = this.y - this.getHeight();
                break;
        }
        
    }
    
    public void change() {
        this.hasChanged = true;
        if (this.onChangeListener != null) {
            this.onChangeListener.onChange();
        }
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
    
    public interface OnChangeListener {
        public abstract void onChange();
    }
}
