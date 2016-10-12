/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IshJava;

import java.awt.Graphics;

/**
 *
 * @author axemat060
 */
public class UILinearLayout extends UILayout{
    
    protected int width, height;
    
    public UILinearLayout(Game g) {
        super(g);
    }

    @Override
    public void pack() {
        this.height = 0;
        this.width = 0;
        for (UIElement e : this.children) {
            this.height += e.getHeight() + e.getLayoutYMargin() * 2;
            if ((e.getWidth() + e.getLayoutXMargin() * 2) > this.width) {
                this.width = e.getWidth() + e.getLayoutXMargin() * 2;
            }
        }
        
        for (UIElement e: this.children) {
            //TODO: fix LinearLayout
        }
    }

    @Override
    public void draw(Graphics g) {
        
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
    
}
