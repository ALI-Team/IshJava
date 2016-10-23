/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IshJava;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ivamat907
 */
public class ObjectManager implements KeyListener, MouseListener {

    Game game;

    public ObjectManager(Game game) {
        this.game = game;
    }

    public void addObject(GameObject go) {
        addlist.add(go);
    }

    public ArrayList<GameObject> addlist = new ArrayList<>();
    public ArrayList<GameObject> objects = new ArrayList<>();
    public ArrayList<GameObject> keylisteners = new ArrayList<>();
    public ArrayList<GameObject> onclickisteners = new ArrayList<>();
    public ArrayList<GameObject> movementListeners = new ArrayList<>();
    public ArrayList<GameObject> keyMovementListeners = new ArrayList<>();
    public ArrayList<GameMouseEvent> mouseevents = new ArrayList<>();
    public ArrayList<GameKeyEvent> keyevents = new ArrayList<>();
    public HashMap<Character, Boolean> keys = new HashMap<>();

    public void updateObjs() {
        updateKeyMovment();
        objects.addAll(addlist);
        addlist.clear();
        ArrayList<GameObject> staticobjects = new ArrayList<GameObject>();
        staticobjects.addAll(objects);
        for (GameObject obj : staticobjects) {
            for (GameObject obj2 : staticobjects) {
                if (!obj2.equals(obj)) {
                    //System.out.println("1.x:"+obj.x+"\n1.w"+obj.width+"\n2.x"+obj2.x+"\n2.w"+obj2.width);
                    if ((obj.x > obj2.x && obj.x < obj2.x + obj2.width) || (int)obj.x == (int)obj2.x) {
                        if (((int) (obj.y + obj.height) == (int) obj2.y) || ((int) obj.y == (int) (obj2.y + obj2.height))) {
                            if (obj.speed != 0 && !obj2.equals(obj.cooldownObject) && obj2.speed == 0) {
                                System.out.println("1hit");
                                obj.setDirection((int) (360 - Math.toDegrees(obj.direction)), (int)obj.velocity, obj2);
                                obj.cooldownObject = obj2;
                                obj.hit();
                                obj2.hit();
                            }
                            
                            if (obj2.speed != 0 && !obj.equals(obj2.cooldownObject) && obj.speed == 0) {
                                System.out.println("12hit");
                                obj2.setDirection((int) (360 - Math.toDegrees(obj2.direction)), (int)obj2.velocity, obj);
                                obj2.cooldownObject = obj;
                                obj2.hit();
                                obj.hit();
                            }
                            
                            if (obj.speed != 0 && obj2.speed != 0 && !obj.equals(obj2.cooldownObject) && !obj2.equals(obj.cooldownObject)) {
                                System.out.println("13hit");
                                obj.setDirection((int) (360 - Math.toDegrees(obj.direction)), (int)obj.velocity, obj2);
                                obj.cooldownObject = obj2;
                                obj.hit();
                                obj2.setDirection((int) (360 - Math.toDegrees(obj2.direction)), (int)obj2.velocity, obj2);
                                obj2.cooldownObject = obj;
                                obj2.hit();
                                obj.hit();
                            }
                        }
                        
                    }
                    
                    if ((obj.y > obj2.y && obj.y < obj2.y + obj2.height) || (int)obj.y == (int)obj2.y) {
                        if (((int) obj.x == (int) (obj2.x + obj2.width)) || ((int) (obj.x + obj.width) == (int) obj2.x)) {
                            if (obj.speed != 0 && !obj2.equals(obj.cooldownObject) && obj2.speed == 0) {
                                System.out.println("3hit");
                                obj.setDirection((int) (180 - Math.toDegrees(obj.direction)), (int)obj.velocity, obj2);
                                obj.cooldownObject = obj2;
                                obj.hit();
                                obj2.hit();
                            }
                            
                            if (obj2.speed != 0 && !obj.equals(obj2.cooldownObject) && obj.speed == 0) {
                                System.out.println("32hit");
                                obj2.setDirection((int) (180 - Math.toDegrees(obj2.direction)), (int)obj2.velocity, obj);
                                obj2.cooldownObject = obj;
                                obj2.hit();
                                obj.hit();
                            }
                            
                            if (obj.speed != 0 && obj2.speed != 0 && !obj.equals(obj2.cooldownObject) && !obj2.equals(obj.cooldownObject)) {
                                System.out.println("33hit");
                                obj.setDirection((int) (360 - Math.toDegrees(obj.direction)), (int)obj.velocity, obj2);
                                obj.cooldownObject = obj2;
                                obj.hit();
                                obj2.setDirection((int) (360 - Math.toDegrees(obj2.direction)), (int)obj2.velocity, obj2);
                                obj2.cooldownObject = obj;
                                obj2.hit();
                                obj.hit();
                            }
                        }
                    }
                }
            }
            obj.updateObj();
        }
    }

    public void updateKeyMovment() {
        ArrayList<GameObject> staticobjects = new ArrayList<GameObject>();
        staticobjects.addAll(keyMovementListeners);
        for (GameObject obj : staticobjects) {
            if ((keys.get(obj.movementKeys[0]) != null) && (keys.get(obj.movementKeys[0])) && (keys.get(obj.movementKeys[3]) != null) && (keys.get(obj.movementKeys[3]))) {
                obj.movementmode = 2;
                obj.direction = Math.PI * 1.75;
            } else {
                double dirTMP = 0;
                int i = 0;
                boolean keypressed = false;
                int keyspressed = 0;
                while (i < 4) {

                    if (keys.get(obj.movementKeys[i]) != null) {

                        if (keys.get(obj.movementKeys[i])) {
                            //System.out.println(obj.movementKeys[i]);
                            keypressed = true;
                            dirTMP = dirTMP + (i) * 0.5 * Math.PI;
                            keyspressed++;
                        }
                    }
                    i++;
                }
                obj.direction = dirTMP / keyspressed;
                if (keypressed) {
                    obj.movementmode = 2;
                } else {
                    obj.movementmode = 0;
                }
            }
        }
    }

    public void executeEvents() {
        ArrayList<GameMouseEvent> staticobjects = new ArrayList<>();
        staticobjects.addAll(mouseevents);
        mouseevents.clear();
        for (GameMouseEvent gme : staticobjects) {
            gme.execute();
        }
        ArrayList<GameKeyEvent> statickeyobj = new ArrayList<>();
        statickeyobj.addAll(keyevents);
        keyevents.clear();
        for (GameKeyEvent gke : statickeyobj) {
            gke.execute();
        }

    }

    public void drawObjs(Graphics g) {
        ArrayList<GameObject> staticobjects = new ArrayList<GameObject>();
        staticobjects.addAll(objects);
        for (GameObject obj : staticobjects) {
            obj.draw(g);
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        ArrayList<GameObject> staticobjects = new ArrayList<GameObject>();
        staticobjects.addAll(keylisteners);
        for (GameObject obj : staticobjects) {
            keyevents.add(new GameKeyEvent(e, obj, (byte) 2));
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        ArrayList<GameObject> staticobjects = new ArrayList<GameObject>();
        staticobjects.addAll(keylisteners);
        for (GameObject obj : staticobjects) {
            keyevents.add(new GameKeyEvent(e, obj, (byte) 0));
        }
        keys.put(e.getKeyChar(), true);
        System.out.println(keyevents);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        ArrayList<GameObject> staticobjects = new ArrayList<GameObject>();
        staticobjects.addAll(keylisteners);
        for (GameObject obj : staticobjects) {
            keyevents.add(new GameKeyEvent(e, obj, (byte) 1));
        }
        keys.put(e.getKeyChar(), false);

    }

    public void handleMousePress(MouseEvent e) {

        /*
         * Get coordinates from mouseclick
         */
        Point mousePosition = e.getPoint();
        int x = mousePosition.x;
        int y = mousePosition.y;

        /*
         * Get click listeners
         */
        ArrayList<GameObject> staticobjects = new ArrayList<GameObject>();
        staticobjects.addAll(this.onclickisteners);

        for (GameObject object : staticobjects) {

            /*
             * Check if mouseclick occured in the object
             */
            int height = object.sprite.getHeight(this.game);
            int width = object.sprite.getWidth(this.game);

            if ((x > object.x) && (x < (object.x + width)) && (y > object.y) && (y < (object.y + height))) {

                /*
                 * Queue the click event
                 */
                mouseevents.add(new GameMouseEvent(e, object));
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (!this.game.uiManager.onClick(e)) {
            this.handleMousePress(e);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
