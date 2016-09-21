/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IshJava;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

/**
 * Designed by Apple in California
 * Assembled in China
 * @author ALI-team
 */
public class UITextView extends UIElement{
    
    public static final String TIMES_NEW_ROMAN = "times new roman";
    public static final String COMIC_SANS_MS = "comic sans ms";
    public static final String ARIAL = "arial";
    public static final String IMPACT = "impact";
    public static final String MONOSPACE = Font.MONOSPACED;
    public static final String SERIF = Font.SERIF;
    public static final String SANS_SERIF = Font.SANS_SERIF;
    public static final String COURIER_NEW = "courier new";
    
    public String text = "";
    public Color color = Color.BLACK;
    public Font font = new Font(UITextView.TIMES_NEW_ROMAN, Font.PLAIN, 12);
    public boolean drawOutline = false;
    public Color outlineColor = Color.BLACK;
    public boolean drawBackground = false;
    public Color backgroundColor = Color.BLACK;
    public int paddingTop = 4, paddingLeft = 4, 
            paddingBottom = 4, paddingRight = 4;
    public boolean drawBorder = false;
    public int borderRadius = 0;
    public Color borderColor = Color.BLACK;
    public int borderWidth = 1;
    
    protected boolean hasChanged = true;
    protected Shape shape;
    
    public UITextView(Game g) {
        super(g);
    }
    
    public UITextView(Game g, int x, int y) {
        super(g, x, y);
    }
    
    public UITextView(Game g, Point p) {
        super(g, p);
    }
    
    public UITextView(Game g, int x, int y, String t) {
        super(g, x, y);
        this.text = t;
    }
    
    public UITextView(Game g, Point p, String t) {
        super(g, p);
        this.text = t;
    }
    
    /**
     * Sätter färgen för texten
     * @param c <i>Java Color</i> ex Color.GREEN, new Color(r,g,b), new Color(0xRRGGBB)
     * eller new Color(0xAARRGGBB, true)
     */
    public void setColor(Color c) {
        this.color = c; //Java Color object
    }
    
    /**
     * Sätter färgen för texten
     * @param r Röd komponent 0-255
     * @param g Grön komponent 0-255
     * @param b Blå komponent 0-255
     */
    public void setColor(int r, int g, int b) {
        this.color = new Color(r,g,b);
    }
    
    /**
     * Ändrar texten
     * @param text <i>String</i> som innehåller nya texten
     */
    public void setText(String text) {
        this.text = text;
        this.hasChanged = true;
    }
    
    /**
     * Sätter font size för UITextView
     * @param size <i>int</i> in px
     */
    public void setFontSize(int size) {
        Font old = this.font;
        String family = old.getFamily();
        int style = old.getStyle();
        this.font = new Font(family, style, size);
        this.hasChanged = true;
    }
    
    /**
     * @param style Font style, använd konstanter i Font:<br>
     * Font.BOLD för <b>fet</b> text<br>
     * Font.ITALIC för <i>kursiv</i> text<br>
     * Font.PLAIN för normal text<br>
     */
    public void setFontStyle(int style) {
        Font old = this.font;
        String family = old.getFamily();
        int size = old.getSize();
        this.font = new Font(family, style, size);
        this.hasChanged = true;
    }
    
    /**
     * Sätter font family för UITextView
     * @param family <i>String</i> ex "Helvetica" eller UITextView.COMIC_SANS_MS
     */
    public void setFontFamily(String family) {
        Font old = this.font;
        int style = old.getStyle();
        int size = old.getSize();
        this.font = new Font(family, style, size);
        this.hasChanged = true;
    }
    
    /**
     * Sätter font style till <i>italic</i>
     */
    public void setItalic() {
        Font old = this.font;
        String family = old.getFamily();
        int size = old.getSize();
        this.font = new Font(family, Font.ITALIC, size);
        this.hasChanged = true;
    }
    
    /**
     * Sätter font style till <b>bold</b>
     */
    public void setBold() {
        Font old = this.font;
        String family = old.getFamily();
        int size = old.getSize();
        this.font = new Font(family, Font.BOLD, size);
        this.hasChanged = true;
    }
    
    /**
     * Återställer font style till plain
     */
    public void setPlain() {
        Font old = this.font;
        String family = old.getFamily();
        int size = old.getSize();
        this.font = new Font(family, Font.PLAIN, size);
        this.hasChanged = true;
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
    public void setFont(Font font) {
        this.font = font;
        this.hasChanged = true;
    }
    
    /**
     * Sätter på eller av outline för UITextView
     * @param outline <i>boolean</i>, <b>true</b> för att sätta på outline, <b>false</b> för att stänga av
     */
    public void setOutline(boolean outline) {
        this.drawOutline = outline;
        this.hasChanged = true;
    }
    
    /**
     * Sätter på och ändrar färgen för text outline
     * @param c <i>Java Color</i> ex Color.GREEN, new Color(r,g,b), new Color(0xRRGGBB)
     * eller new Color(0xAARRGGBB, true)
     */
    public void drawOutline(Color c) {
        this.drawOutline = true;
        this.outlineColor = c;
    }
    
    /**
     * Stänger av outline
     */
    public void disableOutline() {
        this.drawOutline = false;
    }
    
    /**
     * Sätter på eller av att rita bakgrund för UITextView
     * @param drawBackground <i>boolean</i>, <b>true</b> för att sätta på background, <b>false</b> för att stänga av
     */
    public void setDrawBackground(boolean drawBackground) {
        this.drawBackground = drawBackground;
    }
    
    /**
     * Sätter på och ändrar färgen för background
     * @param c <i>Java Color</i> ex Color.GREEN, new Color(r,g,b), new Color(0xRRGGBB)
     * eller new Color(0xAARRGGBB, true)
     */
    public void drawBackground(Color c) {
        setDrawBackground(true);
        this.backgroundColor = c;
    }
    
    /**
     * Stänger av att rita background
     */
    public void hideBackground() {
        setDrawBackground(false);
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
    public void setPadding(int... p) {
        switch (p.length) {
            case 1:
                this.paddingTop = p[0];
                this.paddingRight = p[0];
                this.paddingBottom = p[0];
                this.paddingLeft = p[0];
                break;
            case 2:
                this.paddingTop = p[0];
                this.paddingRight = p[1];
                this.paddingBottom = p[0];
                this.paddingLeft = p[1];
                break;
            case 3:
                this.paddingTop = p[0];
                this.paddingRight = p[1];
                this.paddingBottom = p[2];
                this.paddingLeft = p[1];
                break;
            default:
                this.paddingTop = p[0];
                this.paddingRight = p[1];
                this.paddingBottom = p[3];
                this.paddingLeft = p[4];
                break;
        }
        this.hasChanged = true;
    }
    
    /**
     * Sätter hur mycket rundade hörnen är i px
     * @param r Radien för hörnens rundning
     */
    public void setBorderRadius(int r) {
        this.borderRadius = r;
        this.hasChanged = true;
    }
    
    /**
     * Turns on border around background box and sets the color the c
     * @param c <i>Java Color</i> ex Color.GREEN, new Color(r,g,b), new Color(0xRRGGBB)
     * eller new Color(0xAARRGGBB, true)
     */
    public void drawBorder(Color c) {
        this.drawBorder = true;
        this.borderColor = c;
    }
    
    /**
     * Turns on or off border for UITextView
     * @param drawBorder <i>boolean</i>, <b>true</b> för att sätta på outline, <b>false</b> för att stänga av
     */
    public void setDrawBorder(boolean drawBorder) {
        this.drawBorder = drawBorder;
    }
    
    /**
     * Hides border around background box
     */
    public void hideBorder() {
        this.drawBorder = false;
    }
    
    /**
     * Sets the borderWidth of UITextView
     * @param borderWidth </i>int</i> width in px
     */
    public void setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
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
        
        //textLayout.draw(g2d, this.x, this.y);
    }

    @Override
    public int getWidth() {
        if (this.shape != null) {
            return (int) this.shape.getBounds2D().getWidth();
        } else return 0;
    }

    @Override
    public int getHeight() {
        return (int) this.shape.getBounds2D().getHeight();
    }
}