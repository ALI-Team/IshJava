

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
        
        UITextView tw = new UITextView(game);
        tw.setText("hello world");
        tw.setLayoutMargin(16, 16);
        tw.setLayoutAnchor(UIElement.ANCHOR_START, UIElement.ANCHOR_START);
        tw.setColor(Color.BLACK);
        tw.setFontFamily(UITextView.ARIAL);
        tw.drawBorder(Color.BLACK);
        tw.setPadding(16);
        tw.setBorderWidth(1);
        tw.setFontSize(14);
        tw.build("tw");
        
        Ball ball=new Ball(game,200,200);
        game.addObject(ball);
        
        game.put("btnCount", 0);
        
        UITextButton btn = new UITextButton(game);
        btn.setLayoutAnchor(UIElement.ANCHOR_CENTER, UIElement.ANCHOR_END);
        btn.setLayoutMargin(16, 16);
        btn.setText("if apple says im a button...");
        btn.setFontSize(16);
        btn.setFontFamily("Helvetica Neue");
        btn.setColor(new Color(0, 122, 255));
        btn.setOnClickListener(new UIElement.OnClickListener() {

            @Override
            public void onClick(Game g) {
                UITextView t = (UITextView) g.getUIElement("tw");
                int btnCount = g.getInt("btnCount");
                btnCount++;
                g.put("btnCount", btnCount);
                t.setText("count: " + Integer.toString(btnCount));
            }
        });
        btn.build("btn");

    }
    
}