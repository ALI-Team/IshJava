
package testgame;

import IshJava.Game;
import IshJava.GameObject;
import java.awt.BasicStroke;
import java.awt.Color;

public class Ball extends GameObject{
    
    public Ball(Game game, int x, int y) {
        super(game, x, y);
        this.setSprite("src/imgs/ball.png");
        //this.setDirection(45, 100);
        this.addKeyboard();
        this.addOnClick();
        this.addKeyMovment('w', 's', 'a', 'd', 110);
        
        this.pen = true;
        this.penColor = Color.BLUE;
        this.penStroke = new BasicStroke(1.0f);
    }
    @Override
    public void onKeyPressed(char c){
              
        if (c == ' ') {
            this.pen = !this.pen;
        }
        
        //this.moveto(game.mousePoint, 200);
    }
   
    @Override
    public void tick(){
        
    }  
    
    @Override
    public void onClick() {
    }
}
