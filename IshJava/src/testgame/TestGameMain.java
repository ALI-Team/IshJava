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

        Game game = Main.createGame(512, 512, "test game");

        /*UITextView tw = new UITextView(game, 16, 64, "hello world");
        tw.setColor(new Color(0xFFFFFF));
        tw.setFontFamily(UITextView.IMPACT);
        tw.setFontSize(36);
        tw.drawOutline(Color.BLACK);
        tw.drawBackground(Color.GREEN);
        tw.setPadding(8);
        tw.setBorderRadius(16);
        tw.drawBorder(Color.CYAN);
        tw.setBorderWidth(5);
        game.addUIElement("tw", tw);*/
 /*MyButton button = new MyButton(game, 16, 256);
        button.setText("Press me");
        button.drawBackground(Color.RED);
        button.setFontSize(28);
        button.setFontFamily(UITextButton.MONOSPACE);
        button.setPadding(16);
        button.setBorderRadius(4);
        game.addUIElement("button", button);*/
 /*Ball ball=new Ball(game,200,200);
        game.addObject(ball);
        game.addObject(new boy(game,0,0, tw));*/
        //game.addObject(new boy(game,0,0));
        //Game game=Main.createGame(512,512, "test game");
        /*Ball ball = new Ball(game, 200, 100);
        game.addObject(ball);
        ball.setDirection(30, 60);

        Ball ball2 = new Ball(game, 250, 250);
        game.addObject(ball2);
        ball2.setDirection(200, 60);*/
        
        for (int i = 0; i < 5; i++) {
            Ball ball = new Ball(game, randomWithRange(150, 250), randomWithRange(150, 250));
            game.addObject(ball);
            ball.setDirection(randomWithRange(1, 360), 60);
        }
        //game.addObject(new boy(game,0,0,ball));
        /*UITextView tw = new UITextView(game,16, 64, "hello world");
            tw.setColor(new Color(0xFFFFFF));
            tw.setFontFamily(UITextView.IMPACT);
            tw.setFontSize(36);
            tw.drawOutline(Color.BLACK);
            tw.drawBackground(Color.GREEN);
            tw.setPadding(8);
            tw.setBorderRadius(16);
            tw.drawBorder(Color.CYAN);
            tw.setBorderWidth(5);*/
        //game.uiManager.addElement(tw);
        /*int i=0;
            while (i<300){
                int x=(int)(Math.random()*512.0);
                int y=(int)(Math.random()*512.0);
                game.gameGroupManager.addToGroup("boyz", new boy(game,x,y));
                i++;
            }*/

        Wall wall = new Wall(game, 50, 10);
        game.addObject(wall);

        Wall wall2 = new Wall(game, 50, 400);
        game.addObject(wall2);

        Wallvert wall3 = new Wallvert(game, 400, 50);
        game.addObject(wall3);

        Wallvert wall4 = new Wallvert(game, 0, 50);
        game.addObject(wall4);
    }

    public static int randomWithRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }

}
