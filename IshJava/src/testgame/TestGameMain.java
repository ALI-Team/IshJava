

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
            Ball ball=new Ball(game,0,0);
            game.objectManager.addObject(ball);
            game.objectManager.addObject(new boy(game,0,0,ball));
            UITextView tw = new UITextView(16, 64, "dzien dobry kurwa");
            tw.setColor(Color.green);
            tw.setFontFamily(UITextView.IMPACT);
            tw.setFontSize(36);
            game.uiManager.addElement(tw);
    }
    
}
