
package testgame;

import IshJava.Game;
import IshJava.GameObject;
import IshJava.GamePoint;
import java.awt.BasicStroke;
import java.awt.Color;

public class Ball extends GameObject{
    
    int i;
    
    public Ball(Game game, int x, int y) {
        super(game, x, y);
        this.setSprite("src/imgs/square.png");
        //this.setDirection(45, 100);
        //this.addKeyboard();
        //this.addOnClick();
        //this.addKeyMovment('w', 's', 'a', 'd', 100);
        
        //this.pen = true;
        this.penColor = Color.BLUE;
        this.penStroke = new BasicStroke(2.0f);
        
        //this.moveto(new GamePoint(0, 200), 100);
        //this.setDirection(0, 287);
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
    
    @Override
    public void hit() {
        //System.out.println("hit"+i);
        //i = i + 1;
        //this.penColor = new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));
        this.playSound("src/sounds/bounce.wav");
    }
}
