

package testgame;

import IshJava.Game;
import IshJava.Main;
import IshJava.GameObject;
import IshJava.UITextButton;
import IshJava.UIElement;
import IshJava.UILinearLayout;
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
                UILinearLayout lin = (UILinearLayout) g.getUIElement("lin");
                lin.pack();
            }
        });
        btn.build("btn");
        
        UITextButton btn1 = new UITextButton(game);
        btn1.setLayoutMargin(16, 16);
        btn1.setText("i am button 1");
        btn1.drawBackground(Color.BLACK);
        btn1.setColor(Color.WHITE);
        btn1.build("btn1");
        
        UITextButton btn2 = new UITextButton(game);
        btn2.setLayoutMargin(16, 16);
        btn2.setText("i am button 2");
        btn2.drawBackground(Color.BLACK);
        btn2.setColor(Color.WHITE);
        btn2.build("btn2");
        
        UITextButton btn3 = new UITextButton(game);
        btn3.setLayoutMargin(16, 16);
        btn3.setText("i am button 3");
        btn3.drawBackground(Color.BLACK);
        btn3.setColor(Color.WHITE);
        btn3.build("btn3");
        
        UILinearLayout lin = new UILinearLayout(game);
        lin.setOrientation(UILinearLayout.VERTICAL);
        lin.setAlignment(UILinearLayout.ALIGN_CENTER);
        lin.setLayoutAnchor(UIElement.ANCHOR_CENTER, UIElement.ANCHOR_CENTER);
        lin.setLayoutMargin(16, 16);
        lin.build("lin");
        
        lin.addUIElement(btn1);
        lin.addUIElement(btn2);
        lin.addUIElement(btn3);

    }
    
}