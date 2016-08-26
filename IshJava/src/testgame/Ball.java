
package testgame;

import IshJava.Game;
import IshJava.GameObject;

public class Ball extends GameObject{
    
    public Ball(Game game, int x, int y) {
        super(game, x, y);
        this.setSprite("src/imgs/ball.png");
        moveto(600, 200,200);
    }
    @Override
    public void tick(){
        
    }  
}
