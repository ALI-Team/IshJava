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
