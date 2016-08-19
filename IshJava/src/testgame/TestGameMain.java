

package testgame;

import IshJava.Game;
import IshJava.Main;
import IshJava.GameObject;

public class TestGameMain {

    public static void main(String[] args) {
            Game game=Main.createGame(512,512, "test game");
            Ball ball=new Ball(game,0,0);
            game.objectManager.addObject(ball);
            game.objectManager.addObject(new boy(game,0,0,ball));
            
    }
    
}
