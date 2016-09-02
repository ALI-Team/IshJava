

package testgame;

import IshJava.Game;
import IshJava.Main;
import IshJava.GameObject;
import IshJava.UIElement;
import IshJava.UITextView;
import java.awt.Color;

public class TestGameMain {

    public static void main(String[] args) {
            Game game=Main.createGame(512,512, "test game");
            Ball ball=new Ball(game,200,200);
            game.addObject(ball);
            game.addObject(new boy(game,0,0,ball));   
            UITextView tw = new UITextView(16, 64, "hello world");
            tw.setColor(new Color(0xFFFFFF));
            tw.setFontFamily(UITextView.IMPACT);
            tw.setFontSize(36);
            tw.drawOutline(Color.BLACK);
            tw.drawBackground(Color.GREEN);
            tw.setPadding(8);
            tw.setBorderRadius(16);
            tw.drawBorder(Color.CYAN);
            tw.setBorderWidth(5);
            game.uiManager.addElement(tw);
    }
    
}