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
public class ButtManager extends GameObject{
    
    public ButtManager(Game g, double x, double y) {
        super(g, x, y);
        game.gameGroupManager.addToGroup("buttmanager", this);
        createButt(100);
    }
    public void createButt(int speed){
        int nx=(int)(Math.random()*(this.game.width-100));
        int ny=10;
        game.addObject(new butt(game,(double)nx,(double)ny,speed));
    }
    
}
