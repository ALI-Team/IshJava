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
 * @author Luka
 */
public class Wallvert extends GameObject {
    
    public Wallvert(Game g, int x, int y) {
        super(g, x, y);
        this.setSprite("src/imgs/brick-vert.jpg");
    }
}
