/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testgame;

import IshJava.Game;
import IshJava.Main;
import IshJava.GameObject;
/**
 *
 * @author ivamat907
 */
public class TestGameMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            Game game=Main.createGame(512,512, "test game");
            Ball ball=new Ball(game,0,0);
            game.objectManager.addObject(ball);
            game.objectManager.addObject(new boy(game,0,0,ball));
            
    }
    
}
