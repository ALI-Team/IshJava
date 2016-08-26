
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
public class GameObject extends Point {

    /*
    * @author Luka Jankovic NA15C
     */
    public Image sprite;
    public boolean solid;
    public double direction;
    public int speed;
    public Point target;
    public byte movementmode=0;
    public Game game;

    //Init function
    public GameObject(Game g, String imagePath, int x, int y) {
        this.game=g;
        movementmode = 0;
        setSprite(imagePath);
        g.objectManager.objects.add(this);


        this.move(x, y);
        this.initobj();
    }
    public GameObject(Game g, int x, int y) {
        this.game=g;
        movementmode = 0;
        //sprite=null;
        g.objectManager.objects.add(this);
        this.move(x, y);
        this.initobj();
    }


    public void setSprite(String imagePath){
        try {
            sprite = ImageIO.read(new File(imagePath));
        } catch (IOException ex) {
            ex.printStackTrace();

            System.out.println("Cant find file " + imagePath);
        }
    }

    public void moveto(int x, int y,int v) {
        movementmode = 1;
        target = new Point(x, y);
        speed=game.pps2ppf(v);
    }
    public void moveto(Point p,int v) {
        movementmode = 1;
        target = p;
        speed=game.pps2ppf(v);

    }

    public void moveobj() {
        if (movementmode == 1) {
            double dir = Math.atan2(target.y - this.y, target.x - this.x);
            double movelen = Math.min(speed,this.distance(target));
            this.x += movelen * Math.cos(dir);
            this.y += movelen * Math.sin(dir);
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
        g.drawImage(sprite, x, y, null);
        }
    }

    public void mousePressed() {

    }
}
