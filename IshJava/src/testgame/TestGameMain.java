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
            game.objectManager.objects.add(new Ball(game,"src/imgs/ball.png",0,0));
    }
    
}
