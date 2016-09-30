/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IshJava;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author ivamat907
 */
public class GameKeyEvent {
        public KeyEvent ev;
    public GameObject obj;
    public byte type;
    public GameKeyEvent(KeyEvent ev,GameObject obj,byte type){
        this.ev=ev;
        this.obj=obj;
        this.type=type;
    }
    public void execute(){
        if(type==0){
        obj.onKeyPressed(ev.getKeyChar());
        }else if(type==1){
        obj.onKeyReleased(ev.getKeyChar());
        }else if(type==1){
        obj.onKeyTyped(ev.getKeyChar());
        }
    }
}
