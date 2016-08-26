
package testgame;

import IshJava.Game;
import IshJava.GameObject;

public class Ball extends GameObject{
    
    public Ball(Game game, int x, int y) {
        super(game, x, y);
        this.setSprite("src/imgs/ball.png");
        this.setDirection(45, 100);
        this.addKeyboard();
    }
    @Override
    public void onKeyPressed(char c){
        System.out.println(c);
    }
    @Override
    public void tick(){
        
    }  
}
