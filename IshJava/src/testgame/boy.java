/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgame;

import IshJava.Game;
import IshJava.GameObject;

/**
 *
 * @author Ivar
 */
public class boy extends GameObject{
    public Ball ball;
    public boy(Game game, int x, int y,Ball b) {
        super(game, x, y);
        
        ball=b;
        this.setSprite("src/imgs/boy.png");
        moveto(b,100);
        addOnClick();
    }
     @Override
    public void tick(){
        if(this.collide(ball)){ 
            
        }
    } 
    
    @Override
    public void onClick() {
        
        System.out.println("stop touching me!");
        moveto(10, 10, 1);
    }
}
