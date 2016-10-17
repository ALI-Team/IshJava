
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
        //this.addKeyboard();
        //this.addOnClick();
        //this.addKeyMovment('w', 's', 'a', 'd', 110);
        
        this.pen = true;
        this.penColor = Color.BLUE;
        this.penStroke = new BasicStroke(1.0f);
        
        this.setDirection(300, 100);
    }
    @Override
    public void onKeyPressed(char c){
              
        System.out.println(c);
        
        if (c == ' ') {
            this.pen = !this.pen;
        }
        
        if (Character.isDigit(c)) {
            this.penStroke = new BasicStroke(Float.parseFloat(Character.toString(c)));
        }
        
        else if (c == 'c') {
            this.penColor = new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));
            this.playSound("src/sounds/test.wav");
        }
    }
   
    @Override
    public void tick(){
        
    }  
    
    @Override
    public void onClick() {
    }
}
