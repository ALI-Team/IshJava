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
    public Image Sprite;
    public Object(Game game,String Imagepath){
        try {                
          Sprite = ImageIO.read(new File(Imagepath));
       } catch (IOException ex) {
           System.out.println("Cant find file " + Imagepath);
       }
        game.objectManager.objects.add(this);
        initobj();
    }
    public void initobj(){
        
        
    }
    public void draw(Graphics g){
        g.drawRect(0, 0, 100, 100);
        
    }
    
}
