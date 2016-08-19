/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package IshJava;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author ivamat907
 */
public class Object extends Point{
    
    /*
    * @author Luka Jankovic NA15C 
    */
    public Image    sprite;
    public boolean  solid;
    public double   direction;
    
    //Init function
    public Object(Game game,String imagePath, int x, int y){
        try {                
          sprite = ImageIO.read(new File(imagePath));
       } catch (IOException ex) {
           System.out.println("Cant find file " + imagePath);
       }
        game.objectManager.objects.add(this);
        this.move(x,y);
        this.initobj();
    }
    
    //To be overwritten. Called when object is initialized.
    public void initobj(){
    }
    public void draw(Graphics g){
        g.drawRect(0, 0, 100, 100);
    }
}
