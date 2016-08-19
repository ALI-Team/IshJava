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
    
    public Ball(Game game, String imagePath, int x, int y) {
        super(game, imagePath, x, y);
    }
    
    @Override
    public void updateObj(){
        this.x+=10;
        this.y+=10;
    } 
    
}
