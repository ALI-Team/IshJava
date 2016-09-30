

package testgame;

import IshJava.Game;
import IshJava.Main;
import IshJava.GameObject;
import IshJava.UITextButton;
import IshJava.UIElement;
import IshJava.UITextView;
import java.awt.Color;

public class TestGameMain {

    public static void main(String[] args) {
        Game game=Main.createGame(512,512, "test game");
        Ball ball=new Ball(game,200,200);
        game.addObject(ball);
        game.addObject(new boy(game,0,0));   
        
        UITextView tw = new UITextView(game);
        tw.setText("hello world");
        tw.setLayoutMargin(16, 16);
        tw.setLayoutAnchor(UIElement.ANCHOR_MIDDLE, UIElement.ANCHOR_START);    
        //tw.setPosition(200, 200);
        tw.setColor(new Color(0xFFFFFF));
        tw.setFontFamily(UITextView.IMPACT);
        tw.setFontSize(36);
        tw.drawOutline(Color.BLACK);
        tw.drawBackground(Color.GREEN);
        tw.setPadding(8);
        tw.setBorderRadius(16);
        tw.drawBorder(Color.CYAN);
        tw.setBorderWidth(5);
        game.addUIElement("tw", tw);
        
        /*MyButton button = new MyButton(game, 16, 256);
        button.setText("Press me");
        button.drawBackground(Color.RED);
        button.setFontSize(28);
        button.setFontFamily(UITextButton.MONOSPACE);
        button.setPadding(16);
        button.setBorderRadius(4);
        game.addUIElement("button", button);*/
        
        UITextButton btn = new UITextButton(game);
        btn.setLayoutMargin(16, 16);
        btn.setText("im a button");
        btn.drawBackground(Color.DARK_GRAY);
        btn.setColor(Color.GREEN);
    }
    
}