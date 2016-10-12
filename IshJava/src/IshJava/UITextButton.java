/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IshJava;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

/**
 *
 * @author axemat060
 */
public class UITextButton extends UITextView implements UIElement.Clickable {
    
    UIElement.OnClickListener onClickListener;

    public UITextButton(Game g) {
        super(g);
    }
    
    public UITextButton(Game g, int x, int y) {
        super(g, x, y);
    }

    public UITextButton(Game g, Point p) {
        super(g, p);
    }
    
    public UITextButton(Game g, int x, int y, String t) {
        super(g, x, y, t);
    }
    
    public UITextButton(Game g, Point p, String t) {
        super(g, p, t);
    }
   
    public void setOnClickListener(UIElement.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
    
    public void removeOnClickListener() {
        this.onClickListener = null;
    }
    
    @Override
    public boolean inArea(Point p) {
        return shape.contains(p);
    }

    @Override
    public void handleClick(MouseEvent ev) {
       if (this.onClickListener != null) {
           this.onClickListener.onClick(game);
       }
    }
}
