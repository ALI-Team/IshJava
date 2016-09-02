/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IshJava;

import java.awt.event.MouseEvent;

/**
 *
 * @author ivamat907
 */
public class GameMouseEvent {
    public MouseEvent ev;
    public GameObject obj;
    public GameMouseEvent(MouseEvent ev,GameObject obj){
        this.ev=ev;
        this.obj=obj;
    }
    public void execute(){
        obj.onClick();
    }
    
}
