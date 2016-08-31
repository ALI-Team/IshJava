/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IshJava;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;

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
    public boolean outline = false;
    public Color outlineColor = Color.BLACK;
    
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
        this(p);
        this.text = text;
    }
    
    public UITextView(Point p, String text, Color color) {
        this(p, text);
        this.color = color;
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
     * @param text 
     */
    public void setText(String text) {
        this.text = text;
    }
    
    /**
     * Sätter font size i pixlar
     * @param size 
     */
    public void setFontSize(int size) {
        Font old = this.font;
        String family = old.getFamily();
        int style = old.getStyle();
        this.font = new Font(family, style, size);
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
    }
    
    /**
     * Font family, ex "Helvetica" eller UITextView.COMIC_SANS_MS
     * @param family 
     */
    public void setFontFamily(String family) {
        Font old = this.font;
        int style = old.getStyle();
        int size = old.getSize();
        this.font = new Font(family, style, size);
    }
    
    /**
     * Sätter font style till italic
     */
    public void setItalic() {
        Font old = this.font;
        String family = old.getFamily();
        int size = old.getSize();
        this.font = new Font(family, Font.ITALIC, size);
    }
    
    /**
     * Sätter font style till bold
     */
    public void setBold() {
        Font old = this.font;
        String family = old.getFamily();
        int size = old.getSize();
        this.font = new Font(family, Font.BOLD, size);
    }
    
    /**
     * Återställer font style till plain
     */
    public void setPlain() {
        Font old = this.font;
        String family = old.getFamily();
        int size = old.getSize();
        this.font = new Font(family, Font.PLAIN, size);
    }
    
    /**
     * Sätter font till UITextView
     * @param font En instance av Font<br>
     * new Font(String font, int style, int size)<br>
     * UITextView inkluderar konstanter för olika typsnitt, ex
     * UITextView.COMIC_SANS_MS<br>
     * style är Font.BOLD för <b>fet</b> text<br>
     * Font.ITALIC för <i>kursiv</i> text<br>
     * Font.PLAIN för normal text<br>
     * size är textstorleken i pixlar
     */
    public void setFont(Font font) {
        this.font = font;
    }
    
    /**
     * Sätter på eller av outline för UITextView
     * @param outline <i>boolean</i>, <b>true</b> för att sätta på outline, <b>false</b> för att stänga av
     */
    public void setOutline(boolean outline) {
        this.outline = outline;
    }
    
    /**
     * Sätter på och ändrar färgen för text outline
     * @param c <i>Java Color</i> ex Color.GREEN, new Color(r,g,b), new Color(0xRRGGBB)
     * eller new Color(0xAARRGGBB, true)
     */
    public void outlineText(Color c) {
        this.outline = true;
        this.outlineColor = c;
    }
    
    /**
     * Stänger av outline
     */
    public void disableOutline() {
        this.outline = false;
    }
    
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        FontRenderContext frc = g2d.getFontRenderContext();
        
        TextLayout textLayout = new TextLayout(this.text, this.font, frc);
        g2d.setColor(color);
        textLayout.draw(g2d, this.x, this.y);
        
        if (this.outline) {
            System.out.println("outline draw");
            g2d.setColor(this.outlineColor);
            g2d.draw(textLayout.getOutline(AffineTransform.getTranslateInstance((double) x, (double) y)));
            
        }
    }
}
