
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IshJava;

import java.awt.AlphaComposite;
import static java.awt.AlphaComposite.CLEAR;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
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
import java.net.URL;
import javax.swing.*;
import javax.sound.sampled.*;


/**
 *
 * @author ivamat907
 */
public class GameObject extends GamePoint {

    /*
    * @author ALI-Team
     */
    public Image sprite;
    public boolean solid;
    public double direction;
    public double speed;
    public GamePoint target;
    public byte movementmode = 0;
    public Game game;
    public int width, height;
    public boolean pen;
    public Graphics g;
    public BufferedImage canvas;
    public Paint penColor;
    public Stroke penStroke;
    public int layer=0;
    public boolean rotate=false;
    public double rotation;

    public char[] movementKeys;
    //detectHit
    public boolean collide(GameObject obj) {
        boolean overlap = x < obj.x + obj.width && x + width > obj.x && y < obj.y + obj.height && y + height > obj.y;
        return overlap;
    }

    //Init function
    public GameObject(Game g, String imagePath, int x, int y) {
        this.game = g;
        movementmode = 0;
        setSprite(imagePath);

        this.move(x, y);
        this.initobj();
        g.objectManager.objects.add(this);
    }

    public void setDirection(int dir, int v) {
        movementmode = 2;
        direction = (double) ((dir / 360.0) * Math.PI * 2);
        speed = game.pps2ppf(v);

    }

    public void rotate(int deg){
        rotate=true;
        this.rotation=Math.toRadians(deg);
    }


    public void addKeyMovment(char up,char down,char left,char right,int speed){
        movementKeys=new char[4];
        movementKeys[0]=right;
        movementKeys[1]=down;
        movementKeys[2]=left;
        movementKeys[3]=up;
        setSpeed(speed);
        game.objectManager.keyMovementListeners.add(this);
    }

    public GameObject(Game g, double x, double y) {
        this.game = g;
        movementmode = 0;
        //sprite=null;
        g.objectManager.objects.add(this);
        this.move(x, y);
        this.initobj();
    }

    public void onKeyPressed(char c) {


    }

    public void onKeyTyped(char c) {

    }

    public void onKeyReleased(char c) {

    }

    public void addKeyboard() {
        this.game.objectManager.keylisteners.add(this);
    }

    public void addOnClick() {
        this.game.objectManager.onclickisteners.add(this);
    }

    public void setSprite(String imagePath) {
        try {
            sprite = ImageIO.read(new File(imagePath));
            width = sprite.getWidth(game);
            height = sprite.getHeight(game);
            //System.out.println(width);
        } catch (IOException ex) {
            ex.printStackTrace();

            System.out.println("Cant find file " + imagePath);
        }
    }

    public void moveto(int x, int y, int v) {
        movementmode = 1;
        target = new GamePoint(x, y);
        speed = game.pps2ppf(v);
    }

    public void moveto(GamePoint p, int v) {
        movementmode = 1;
        target = p;
        speed = game.pps2ppf(v);
    }
    public void setSpeed(int speed){
        this.speed=game.pps2ppf(speed);
    }

    public void moveobj() {

        int oldX = (int) this.x;
        int oldY = (int) this.y;
        if (pen) {

                //if (canvas == null) {
                //    canvas = new BufferedImage(game.width, game.height, BufferedImage.TYPE_INT_ARGB);
                //}

                Graphics2D g2 = game.canvas.createGraphics();
                g2.setStroke(this.penStroke);
                g2.setPaint(this.penColor);

                g2.drawLine((int)oldX + this.width / 2, (int)oldY + this.height / 2, (int)this.x + this.width / 2, (int)this.y + this.height / 2);

                }
        if (movementmode == 1) {
            double dir = this.angleTo(target);
            double movelen = Math.min(speed, this.distance(target));
            this.x += movelen * Math.cos(dir);
            this.y += movelen * Math.sin(dir);


        } else if (movementmode == 2) {
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
        if (canvas != null) {
            //g.drawImage(canvas, 0, 0, null);
        }

        if (sprite != null) {
            if(!rotate){
            g.drawImage(sprite, (int) x, (int) y, null);
            }else{
              //TACK NIKLAS FÖR KODEN XXXDDD
              AffineTransform xform = new AffineTransform();
                xform.translate((int) (x+0.5*width), (int) (y+0.5*height));
                xform.rotate(this.rotation);
                xform.translate(-width / 2, -height / 2);
                ((Graphics2D) g).drawImage(sprite, xform, null);

                        }
        }
        this.g = g;
    }

    //Also to be overwritten. Called when mouse clicks the object
    public void onClick() {

    }

    public synchronized void playSound(final String path) {

        /*
         * Play sound on separate thread
         */
        new Thread(new Runnable() {

            public void run() {

                try {
                    System.out.println(path);
                    URL url = getClass().getClassLoader().getResource(path);
                    System.out.println(url);
                    Clip clip = AudioSystem.getClip();
                    //AudioInputStream inputStream =
                    //        AudioSystem.getAudioInputStream(new File(url.toURI()));
                    AudioInputStream inputStream =
                           AudioSystem.getAudioInputStream(new File("src/sounds/test.wav"));
                    clip.open(inputStream);
                    clip.start();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void clearPen() {
        if (canvas != null) {
            Graphics2D g2 = canvas.createGraphics();
            g2.setBackground(new Color(0, 0, 0, 0));
            g2.clearRect(0, 0, 512, 512);
        }
    }
}
