/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ButtStuff;

import IshJava.Game;
import IshJava.GameObject;
import IshJava.UITextView;

/**
 *
 * @author Ivar
 */
public class butt extends GameObject{
    boolean dead=false;
    int bs=0;
    public butt(Game g, double x, double y,int speed) {
        super(g, x, y);
        bs=speed;
        System.out.println(speed);
        setSprite("src/imgs/butt.png");
        this.setDirection(90, (int) speed);
        this.game.gameGroupManager.addToGroup("butts", this);
    }
    @Override
    public void tick(){
        Hand hand=(Hand) this.game.gameGroupManager.getGroup("hand").get(0);
        if((this.collide(hand))){
            this.game.objectManager.objects.remove(this);
           
            System.out.println("butt");
            if(!dead){
                UITextView t = (UITextView) game.getUIElement("score");
                int score = game.getInt("score");
                score++;
                game.put("score", score);
                t.setText("score: " + Integer.toString(score));
             ButtManager bm=(ButtManager) this.game.gameGroupManager.getGroup("buttmanager").get(0);
            bm.createButt(bs+10);
                //System.out.println(bs);
            dead=true;
            }
            
        }
        
        if(y>game.height){
            if(!dead){
                
            System.out.println("hi");
            UITextView t = (UITextView) game.getUIElement("hp");
                int hp = game.getInt("hp");
                hp--;
                game.put("hp", hp);
                t.setText("hp: " + Integer.toString(hp));
                this.game.objectManager.objects.remove(this);
                if(hp>0){
                ButtManager bm=(ButtManager) this.game.gameGroupManager.getGroup("buttmanager").get(0);
            bm.createButt(100);
                }else{
                   t.setText("GAME OVER"); 
                }
            dead=true;
                }
        }
    }
    
}
