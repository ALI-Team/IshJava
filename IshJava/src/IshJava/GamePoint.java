/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IshJava;

import java.awt.Point;

/**
 *
 * @author ALI-Team
 */
public class GamePoint{
    public double x,y;
    public GamePoint(double x,double y){
        this.x=x;
        this.y=y;
    }
    public GamePoint(){
        x=0;
        y=0;
    }
    public void move(double x,double y){
        this.x=x;
        this.y=y;
    }
    public double angleTo(GamePoint target){
        double dir = Math.atan2(target.y - this.y, target.x - this.x);
        return dir;
    }
    public double distance(GamePoint target){
        double distance=Math.sqrt(Math.pow(this.x-target.x,2)+Math.pow(this.y-target.y,2));
        return distance; 
    }
}
