/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IshJava;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author axemat060
 */
public class UILinearLayout extends UILayout{
    
    private int width, height;
    private int alignment = UILinearLayout.ALIGN_CENTER;
    private int orientation = UILinearLayout.VERTICAL;
    
    public static final int VERTICAL = 0;
    public static final int HORIZONTAL = 1;
    
    public static final int ALIGN_START = 0;
    public static final int ALIGN_CENTER = 1;
    public static final int ALIGN_END = 2;
    
    public UILinearLayout(Game g) {
        super(g);
    }
    
    public void setAlignment(int alignment) {
        this.alignment = alignment;
    }
    
    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }
    
    public void addUIElement(UIElement e) {
        super.addUIElement(e);
        e.setOnChangeListener(new UIElement.OnChangeListener() {
            @Override
            public void onChange() {
                pack();
            }
        });
        this.pack();
    }
    
    public void addUIElement(UIElement e, int index) {
        super.addUIElement(e, index);
        e.setOnChangeListener(new UIElement.OnChangeListener() {
            @Override
            public void onChange() {
                pack();
            }
        });
        this.pack();
    }
    
    @Override
    public void pack() {
        System.out.println("----PACK START----");
        this.height = 0;
        this.width = 0;
        for (UIElement e : this.children) {
            this.height += e.getHeight() + e.getLayoutYMargin() * 2;
            if ((e.getWidth() + e.getLayoutXMargin() * 2) > this.width) {
                this.width = e.getWidth() + e.getLayoutXMargin() * 2;
            }
        }
        int currentY = this.y;
        int centerX = this.x + this.width / 2;
        for (UIElement e: this.children) {;
            int elX = 0, elY = 0;
            switch (this.orientation) {
                case UILinearLayout.VERTICAL:
                    switch (this.alignment) {
                        case UILinearLayout.ALIGN_START:
                            elX = this.x + e.getLayoutXMargin();
                            break;
                        case UILinearLayout.ALIGN_CENTER:
                            elX = centerX - e.getWidth() / 2;
                            break;
                        case UILinearLayout.ALIGN_END:
                            elX = this.x + width - e.getLayoutXMargin();
                            break;
                    }
                    System.out.println("currentY: " + currentY);
                    System.out.println("margin: " + e.getLayoutYMargin());
                    elY = currentY + e.getLayoutYMargin();
                    System.out.println("elY: " + elY);
                    System.out.println("e.getHeight(): " + e.getHeight());
                    currentY += elY + e.getHeight() + e.getLayoutYMargin();
                    break;
                case UILinearLayout.HORIZONTAL:
                    
                    break;
            }
            e.setPosition(elX, elY, false);
        }
        super.pack();
        System.out.println("----PACK END----");
    }

    @Override
    public void draw(Graphics g) {
        if (this.hasChanged) {
            this.pack();
            this.hasChanged = false;
        }
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
