/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IshJava;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ivamat907
 */
public class GameLayersManager {
    public GameLayer[] layers=new GameLayer[20];
    public int maxLayer=20;
    public Game game;
    
    public GameLayersManager(Game game){
        this.game=game;
    }
    
    public GameLayersManager(){
        
    }
    public void setMaxLayer(int maxLayer){
        this.maxLayer=maxLayer;
        layers=new GameLayer[maxLayer];
        
    }
    
    public void drawLayers(Graphics g){
        int i=0;
        while (i<maxLayer){
            if(layers[i]!=null){
                g.drawImage(layers[i].canvas, 0, 0, null);
            }
            i++;
        }
    }
    public void clearLayers(){
        int i=0;
        while (i<maxLayer){
            if(layers[i]!=null){
                BufferedImage image=layers[i].canvas;
                Graphics2D g2d = image.createGraphics();
                g2d.setBackground(new Color(0, 0, 0, 0));
                g2d.clearRect(0, 0, image.getWidth(), image.getHeight());
                
            }
            i++;
        }
    }
    
    public BufferedImage getLayerCanvas(int layer){
        if(layers[layer]==null){
            initCanvas(layer);
        }
        return layers[layer].canvas;
    }
    public void initCanvas(int layer){
        layers[layer]=new GameLayer();
        layers[layer].canvas=new BufferedImage(game.width, game.height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = layers[layer].canvas.createGraphics();
        g2d.setBackground(new Color(0, 0, 0, 0));
    }
    
}
