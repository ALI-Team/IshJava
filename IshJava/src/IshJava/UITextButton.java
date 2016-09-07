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

    Shape shape;
    boolean hasChanged = true;

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
   
    //Wrap some functions to optimize code, only set <i>this.shape</i> if it has changed
    
    /**
     * Ändrar texten
     * @param text <i>String</i> som innehåller nya texten
     */
    @Override
    public void setText(String text) {
        super.setText(text);
        hasChanged = true;
    }
    
    /**
     * Sätter font family för UITextButton
     * @param family <i>String</i> ex "Helvetica" eller UITextView.COMIC_SANS_MS
     */
    @Override
    public void setFontFamily(String family) {
        super.setFontFamily(family);
        hasChanged = true;
    }
    
    /**
     * Sätter font size för UITextButton
     * @param size <i>int</i> in px
     */
    @Override
    public void setFontSize(int size) {
        super.setFontSize(size);
        hasChanged = true;
    }
    
    /**
     * @param style Font style, använd konstanter i Font:<br>
     * Font.BOLD för <b>fet</b> text<br>
     * Font.ITALIC för <i>kursiv</i> text<br>
     * Font.PLAIN för normal text<br>
     */
    @Override
    public void setFontStyle(int style) {
        super.setFontStyle(style);
        hasChanged = true;
    }
    
    /**
     * Sätter font till UITextView
     * @param font En instance av Font<br>
     * <i>new Font(String font, int style, int size)</i><br>
     * UITextView inkluderar konstanter för olika typsnitt, ex
     * UITextView.COMIC_SANS_MS<br>
     * style är Font.BOLD för <b>fet</b> text<br>
     * Font.ITALIC för <i>kursiv</i> text<br>
     * Font.PLAIN för normal text<br>
     * size är textstorleken i pixlar
     */
    @Override
    public void setFont(Font font) {
        super.setFont(font);
        hasChanged = true;
    }
    
    /**
     * Sätter font style till <i>italic</i>
     */
    @Override
    public void setItalic() {
        super.setItalic();
        hasChanged = true;
    }
    
    /**
     * Sätter font style till <b>bold</b>
     */
    @Override
    public void setBold() {
        super.setBold();
        hasChanged = true;
    }
    
    /**
     * Återställer font style till plain
     */
    @Override
    public void setPlain() {
        super.setPlain();
        hasChanged = true;
    }
    
    /**
     * Sätter på eller av att rita bakgrund för UITextButton
     * @param drawBackground <i>boolean</i>, <b>true</b> för att sätta på background, <b>false</b> för att stänga av
     */
    @Override
    public void setDrawBackground(boolean drawBackground) {
        super.setDrawBackground(drawBackground);
        hasChanged = true;
    }
    
    /**
     * Sätter padding för UITextView
     * @param p 1-4 argument
     * <ul>
     * <li><i>setPadding(25)</i>: alla sidor har 25px padding</li>
     * <li><i>setPadding(25, 50)</i>: Top och bottom har 25px, 
     * right och left har 50px</li>
     * <li><i>setPadding(25, 50, 75)</i>: top har 25px padding, right och left
     * har 50px, bottom har 75px</li>
     * <li><i>setPadding(25,50,75,100)</i>: top har 25px, right har 50px,
     * bottom har 75px och left har 100px
     * </ul>
     */
    @Override
    public void setPadding(int... p) {
        super.setPadding(p);
        hasChanged = true;
    }
    
    /**
     * Sätter hur mycket rundade hörnen är i px
     * @param r Radien för hörnens rundning
     */
    @Override
    public void setBorderRadius(int r) {
        super.setBorderRadius(r);
    }

    
    
    @Override
    public boolean inArea(Point p) {
        return shape.contains(p);
    }

    @Override
    public void handleClick(MouseEvent ev) {
        this.text = "allahu akbar";
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        final Stroke defaultStroke = g2d.getStroke();

        FontRenderContext frc = g2d.getFontRenderContext();

        TextLayout textLayout = new TextLayout(this.text, this.font, frc);

        Rectangle2D bounds = textLayout.getBounds();
        RoundRectangle2D rr = new RoundRectangle2D.Float();
        rr.setRoundRect(bounds.getX() + this.x - this.paddingLeft,
                bounds.getY() + this.y - this.paddingTop,
                bounds.getWidth() + this.paddingLeft + this.paddingRight,
                bounds.getHeight() + this.paddingTop + this.paddingBottom,
                this.borderRadius, this.borderRadius);
        if (this.hasChanged) this.shape = rr;

        if (this.drawBackground) {
            g2d.setColor(this.backgroundColor);
            g2d.fill(rr);
            if (this.drawBorder) {
                g2d.setColor(this.borderColor);
                g2d.setStroke(new BasicStroke(this.borderWidth));
                g2d.draw(rr);
                g2d.setStroke(defaultStroke);
            }
        }

        g2d.setColor(this.color);
        g2d.fill(textLayout.getOutline(AffineTransform
                .getTranslateInstance((double) x, (double) y)));

        if (this.drawOutline) {
            g2d.setColor(this.outlineColor);
            g2d.draw(textLayout.getOutline(AffineTransform
                    .getTranslateInstance((double) x, (double) y)));
        }
    }

}
