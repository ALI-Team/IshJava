/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgame;

import IshJava.Game;
import IshJava.GameObject;
import java.util.Random;

/**
 *
 * @author Ivar
 */
public class boy extends GameObject{
    public Ball ball;
    public boy(Game game, int x, int y) {
        super(game, x, y);
        
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

        int  n = rand.nextInt(460) + 1;
        int n2 = rand.nextInt(460) + 1;
        
        moveto(n, n2, 500);
    }
}
