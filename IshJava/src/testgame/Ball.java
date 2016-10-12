
package testgame;

import IshJava.Game;
import IshJava.GameObject;

public class Ball extends GameObject{
    
    public Ball(Game game, int x, int y) {
        super(game, x, y);
        this.layer=1;
        this.setSprite("src/imgs/ball.png");
        //this.setDirection(45, 100);
        this.addKeyboard();
        this.addOnClick();
        this.addKeyMovment('w', 's', 'a', 'd', 110);
    }
    @Override
    public void onKeyPressed(char c){
              
        
        //this.moveto(game.mousePoint, 200);
    }
   
    @Override
    public void tick(){
        
    }  
    
    @Override
    public void onClick() {
    }
}
