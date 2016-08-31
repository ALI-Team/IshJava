
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
        if(c=='w'){
            this.setDirection(270, 150);
        }else if(c=='s'){
            this.setDirection(90, 150);
        }else if(c=='a'){
            this.setDirection(180, 150);
        }else if(c=='d'){
            this.setDirection(360, 150);
        }
    }
    @Override
    public void tick(){
        
        
    }  
}
