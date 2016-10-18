/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ButtStuff;

import IshJava.Game;
import IshJava.Main;
import IshJava.UIElement;
import IshJava.UITextView;
import java.awt.Color;

/**
 *
 * @author Ivar
 */
public class GameMain {
    
    /*
    replica of a game made by a friend of mine. Dont ask!

*/
    public static void main(String[] args) {
         
        Game game=Main.createGame(512,512, "Butt stuff");
        Hand hand=new Hand(game,50,400);
         UITextView tw = new UITextView(game);
        tw.setText("score:0");
        tw.setLayoutMargin(16, 16);
        tw.setLayoutAnchor(UIElement.ANCHOR_MIDDLE, UIElement.ANCHOR_START);
        game.put("score", 0);
        tw.setColor(Color.green);
        tw.setFontFamily(UITextView.IMPACT);
        tw.setFontSize(46);
        tw.drawOutline(Color.BLACK);
        tw.setPadding(8);
        tw.setBorderRadius(16);
        tw.drawBorder(Color.CYAN);
        tw.setBorderWidth(5);
        game.addUIElement("score", tw);
        
        
        UITextView tw2 = new UITextView(game);
        tw2.setText("hp:3");
        tw2.setLayoutMargin(16, 64);
        tw2.setLayoutAnchor(UIElement.ANCHOR_MIDDLE, UIElement.ANCHOR_END);
        game.put("hp", 3);
        tw2.setColor(Color.red);
        tw2.setFontFamily(UITextView.IMPACT);
        tw2.setFontSize(46);
        tw2.drawOutline(Color.BLACK);
        tw2.setPadding(8);
        tw2.setBorderRadius(16);
        tw2.drawBorder(Color.CYAN);
        tw2.setBorderWidth(5);
        game.addUIElement("hp", tw2);
        
        game.addObject(new ButtManager(game,0,0));
        game.addObject(hand);
        
        
    }
}
