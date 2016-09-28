/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgame;

import IshJava.Game;
import IshJava.GameObject;
import IshJava.UITextView;
import java.awt.BasicStroke;
import java.awt.Color;
import java.util.Random;

/**
 *
 * @author Ivar
 */
public class boy extends GameObject{
    public Ball ball;
    public UITextView tw;
    int count;
    public boy(Game game, int x, int y) {
        super(game, x, y);
        this.tw = null;
        this.pen = true;
        
        //ball=b;
        this.setSprite("src/imgs/ball.png");
        //moveto(b,100);
        addOnClick();
    }
     @Override
    public void tick(){
    } 
    
    @Override
    public void onClick() {
                    
        this.playSound("sounds/test.wav");
        
        Random rand = new Random();

        this.penColor = new Color(rand.nextInt(254) + 1, rand.nextInt(254) + 1, rand.nextInt(254) + 1);
        this.penStroke = new BasicStroke(rand.nextInt(10) + 1);
        
        int  n = rand.nextInt(460) + 1;
        int n2 = rand.nextInt(460) + 1;
        
        moveto(n, n2, rand.nextInt(3) * 100);
        
        //tw.setText("clicked: "+this.count);
        System.out.println("Clicked");
        this.count += 1;
    }
}
