
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.ImageIcon;

/**
 *
 * @author ivamat907
 */
public class GameObject extends GamePoint {

    /*
<<<<<<< HEAD
    * @author ALI-Team  
=======
    * @author Luka Jankovic NA15C
>>>>>>> mouse-detection
     */
    public Image sprite;
    public boolean solid;
    public double direction;
    public double speed;
    public GamePoint target;
    public byte movementmode=0;
    public Game game;
    public int width,height;
    //detectHit
    public boolean collide(GameObject obj){
        boolean overlap= x < obj.x + obj.width && x + width > obj.x && y < obj.y + obj.height && y + height > obj.y;
        return overlap;
    }
    
    
    //Init function
    public GameObject(Game g, String imagePath, int x, int y) {
        this.game=g;
        movementmode = 0;
        setSprite(imagePath);

        this.move(x, y);
        this.initobj();
        g.objectManager.objects.add(this);
    }
    public void setDirection(int dir,int v){
        movementmode = 2;
        direction=(double) ((dir/360.0)*Math.PI*2);
        speed=game.pps2ppf(v);
        
        
    }
    public GameObject(Game g, double x, double y) {
        this.game=g;
        movementmode = 0;
        //sprite=null;
        g.objectManager.objects.add(this);
        this.move(x, y);
        this.initobj();
    }
    
    public void onKeyPressed(char c){
        
    }
    public void onKeyTyped(char c){
        
    }
    public void onKeyReleased(char c){
        
    }
    
    public void addKeyboard(){
        this.game.objectManager.keylisteners.add(this);
    }
    public void addOnClick(){
        this.game.objectManager.onclickisteners.add(this);
    }
    
    public void setSprite(String imagePath){
        try {
            sprite = ImageIO.read(new File(imagePath));
            width=sprite.getWidth(game);
            height=sprite.getHeight(game);
            //System.out.println(width);
        } catch (IOException ex) {
            ex.printStackTrace();

            System.out.println("Cant find file " + imagePath);
        }
    } 

    public void moveto(int x, int y,int v) {
        movementmode = 1;
        target = new GamePoint(x, y);
        speed=game.pps2ppf(v);
    }
    public void moveto(GamePoint p,int v) {
        movementmode = 1;
        target = p;
        speed=game.pps2ppf(v);

    }

    public void moveobj() {
        if (movementmode == 1) {
            double dir = this.angleTo(target);
            double movelen = Math.min(speed,this.distance(target));
            this.x += movelen * Math.cos(dir);
            this.y += movelen * Math.sin(dir);
        }else if(movementmode == 2){
            this.x += speed * Math.cos(direction);
            this.y += speed * Math.sin(direction);
            
        }
    }

    public void tick() {

    }

    public void updateObj() {
        moveobj();
        tick();
    }

    //To be overwritten. Called when object is initialized.
    public void initobj() {
    }

    public void draw(Graphics g) {
        if(sprite!=null){
        g.drawImage(sprite, (int)x, (int)y, null);
        }
    }

    //Also to be overwritten. Called when mouse clicks the object
    public void onClick() {
        
    }
    
    public static synchronized void playSound(final String path) {
        
            /*
             * Play sound on separate thread
             */
            new Thread(new Runnable() {
            
                public void run() {
                
                    try {
                    
                        /*
                        * Crate the audioclip
                        */
                        Clip clip = AudioSystem.getClip();
                        AudioInputStream inputStream = AudioSystem.getAudioInputStream(Main.class.getResourceAsStream(path));
                    
                        clip.open(inputStream);
                        clip.start();
                    
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                }
        }).start();
    }
}
