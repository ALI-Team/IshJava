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

/**
 * Designed by Apple in Caligornia
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
    
    public void setColor(Color c) {
        this.color = c; //Java Color object
    }
    
    /**
     * 
     * @param r Red
     * @param g Green
     * @param b Blue
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
     * Font style, använd konstanter i Font, ex Font.BOLD
     * @param style 
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
     * @param font En instance av Font
     */
    public void setFont(Font font) {
        this.font = font;
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.setFont(font);
        g.drawString(text, x, y);
    }
}
