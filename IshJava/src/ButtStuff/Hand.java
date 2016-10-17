/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ButtStuff;

import IshJava.Game;
import IshJava.GameObject;

/**
 *
 * @author Ivar
 */
public class Hand extends GameObject{
    
    public Hand(Game g, double x, double y) {
        super(g, x, y);
        this.setSprite("src/imgs/hand.png");
        this.addKeyMovment('w', 's', 'a', 'd',200);
        this.game.gameGroupManager.addToGroup("hand", this);
        
    }
    @Override
    public void tick(){
        
    }
    
}
